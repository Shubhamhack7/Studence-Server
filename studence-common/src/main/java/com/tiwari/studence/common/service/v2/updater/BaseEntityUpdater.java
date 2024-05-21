package com.tiwari.studence.common.service.v2.updater;

import com.tiwari.studence.common.service.v2.convertor.TimeBiConverter;
import com.tiwari.studence.proto.entity.*;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.proto.locale.*;
import com.tiwari.studence.proto.time.TimezoneEnum;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BaseEntityUpdater {
  private final TimeBiConverter m_timeUpdater;

  @Inject
  public BaseEntityUpdater(TimeBiConverter timeUpdater) {
    m_timeUpdater = timeUpdater;
  }

  public void setDefaultTimeZoneToPb(EntityProtoPb.Builder pbBuilder, TimezoneEnum timeZone,
          boolean isForUpdate) {
    // backwards compatibility - start
    if (timeZone == TimezoneEnum.UNKNOWN_TIMEZONE) {
      timeZone = TimezoneEnum.ASIA_KOLKATA;
    }
    // backwards compatibility - end

    if (!isForUpdate) {
      Preconditions.validate(timeZone != TimezoneEnum.UNKNOWN_TIMEZONE,
              "Cannot set default timeZone to unknown", pbBuilder.build());
      pbBuilder.getLocaleBuilder().setDefaultTimeZone(timeZone);
    }
  }

  public void convertToPb(EntityProtoPb.Builder pbBuilder, EntityProtoUiPb uiPb,
          boolean isForUpdate) throws ErrorException {
    convertToPb(pbBuilder, uiPb, isForUpdate, false);
  }

  public void convertToPb(EntityProtoPb.Builder pbBuilder, EntityProtoUiPb uiPb,
          boolean isForUpdate, boolean isProfileSelfCreate) throws ErrorException {
    if (uiPb.hasId() && !isForUpdate) {
      Preconditions.validate(Strings.notEmpty(uiPb.getId()), ErrorTypePbEnum.VALIDATION_FAILED,
              uiPb);
      pbBuilder.setId(uiPb.getId());
    }

    if (uiPb.getVersion() > 0 && pbBuilder.getVersion() > 0) {
      Preconditions.validateWithUiErrorString(uiPb.getVersion() == pbBuilder.getVersion(),
              "Please retry or refresh", "VERSION_MISMATCHED", uiPb.getVersion(),
              pbBuilder.getVersion(), uiPb);
    }

    if (uiPb.hasLifeTime()) {
      pbBuilder.setLifetimeState(uiPb.getLifeTime());
    }
    if (pbBuilder.getLocale().getDefaultTimeZone() != TimezoneEnum.UNKNOWN_TIMEZONE) {
      pbBuilder.setLastModifiedTime(
              m_timeUpdater.getCurrentTime(pbBuilder.getLocale().getDefaultTimeZone()));
    } else {
      pbBuilder.setLastModifiedTime(m_timeUpdater.getCurrentTime(TimezoneEnum.ASIA_KOLKATA));
    }
    convertToLocalePb(pbBuilder.getLocaleBuilder(), uiPb.getLocale(), isForUpdate);
    convertLastChangeTrackToPb(uiPb.getLastChangeTrack(), pbBuilder.getLastChangeTrackBuilder(),
            isProfileSelfCreate, isForUpdate, pbBuilder.getLocale().getDefaultTimeZone());
    convertAccessLogToPb(uiPb.getAccessLogInfo(), pbBuilder.getLastChangeAccessInfoBuilder());
  }

  private void convertLastChangeTrackToPb(ChangeTrackUiPb uiPb, ChangeTrackPb.Builder builder,
          boolean isProfileSelfCreate, boolean isForUpdate, TimezoneEnum timeZone) {
    builder.clear();
    if (uiPb.hasTeamType()) {
      builder.setTeamType(uiPb.getTeamType());
    }
    if (uiPb.getSourceInfo().hasTeamId()) {
      builder.getSourceTeamBuilder().setTeamId(uiPb.getSourceInfo().getTeamId());
    }
    if (uiPb.getSourceInfo().hasTeamPersonId()) {
      builder.getSourceTeamBuilder().setTeamPersonId(uiPb.getSourceInfo().getTeamPersonId());
    }
    if (uiPb.getSourceSupportInfo().hasTeamId()) {
      builder.getSourceSupportTeamBuilder().setTeamId(uiPb.getSourceSupportInfo().getTeamId());
    }
    if (uiPb.getSourceSupportInfo().hasTeamPersonId()) {
      builder.getSourceSupportTeamBuilder()
              .setTeamPersonId(uiPb.getSourceSupportInfo().getTeamPersonId());
    }

    builder.getTimeBuilder().setUnixTimestampMs(uiPb.getTime().getMilliSeconds());
    builder.setSourceRefId(uiPb.getSourceRefId());
    if (uiPb.getMatchedTime().getMilliSeconds() > 0) {
      builder.setMatchedTime(m_timeUpdater.reverseConvert(uiPb.getMatchedTime()));
    }
    if (isProfileSelfCreate) {
      builder.setIsSelfProfileCreate(true);
    }
    if ((builder.getIsSelfProfileCreate() || Strings.notEmpty(builder.getSourceTeam().getTeamId()))
            && builder.getTime().getUnixTimestampMs() == 0) {
      builder.getTimeBuilder().setUnixTimestampMs(System.currentTimeMillis());
    }
    builder.getTimeBuilder().setTimezone(timeZone);
  }

  private void convertAccessLogToPb(AccessLogUiPb uiPb, AccessLogPb.Builder builder) {
    builder.clear();
    if (uiPb.hasNetworkInfo()) {
      if (uiPb.getNetworkInfo().hasNetwork()) {
        builder.getNetworkInfoBuilder().setNetwork(uiPb.getNetworkInfo().getNetwork());
      }
      if (uiPb.getNetworkInfo().hasIpAddress()) {
        builder.getNetworkInfoBuilder().setIpAddress(uiPb.getNetworkInfo().getIpAddress());
      }
    }
    if (uiPb.hasLocationInfo()) {
      if (uiPb.getLocationInfo().hasLatitude()) {
        builder.getLocationInfoBuilder().setLatitude(uiPb.getLocationInfo().getLatitude());
      }
      if (uiPb.getLocationInfo().hasLongitude()) {
        builder.getLocationInfoBuilder().setLongitude(uiPb.getLocationInfo().getLongitude());
      }
    }
  }

  private void convertToLocalePb(LocalePb.Builder builder, LocaleUiPb uiPb, boolean isForUpdate) {
    if (uiPb.getLocalesInfoCount() > 0) {
      Preconditions.validate(uiPb.getDefaultLocaleInfo().getLocale() != LocaleUiEnum.UNKNOWN_LOCALE,
              "DefaultLocale is unknown", uiPb);
      Preconditions.validate(validateLocale(uiPb.getLocalesInfoList(), uiPb.getDefaultLocaleInfo()),
              "DefaultLocale is not in locales list", uiPb);
    }
    builder.clearLocalesInfo();
    for (LocaleInfoUiPb locale : uiPb.getLocalesInfoList()) {
      convertToLocaleInfoPb(builder.addLocalesInfoBuilder(), locale);
    }
    convertToLocaleInfoPb(builder.getDefaultLocaleInfoBuilder(), uiPb.getDefaultLocaleInfo());
    if (builder.getDefaultTimeZone() == TimezoneEnum.UNKNOWN_TIMEZONE) {
      if (!isForUpdate) {
        builder.setDefaultTimeZone(uiPb.getDefaultTimeZone());
      } else {
        // backwards compatibility - only for update / old data
        builder.setDefaultTimeZone(TimezoneEnum.ASIA_KOLKATA);
      }

    } /*
     * else { if (isForUpdate) {
     * builder.setDefaultTimeZone(uiPb.getDefaultTimeZone()); } }
     */

    // backwards compatibility - start
    if (builder.getDefaultTimeZone() == TimezoneEnum.UNKNOWN_TIMEZONE) {
      builder.setDefaultTimeZone(TimezoneEnum.ASIA_KOLKATA);
    }
    // backwards compatibility - end

    Preconditions.validate(builder.getDefaultTimeZone() != TimezoneEnum.UNKNOWN_TIMEZONE,
            "Default timeZone is unknown", uiPb);
  }

  private void convertToLocaleInfoPb(LocaleInfoPb.Builder builder, LocaleInfoUiPb uiPb) {
    builder.setLocale(uiPb.getLocale());
  }

  private boolean validateLocale(List<LocaleInfoUiPb> locales, LocaleInfoUiPb defaultLocale) {
    for (LocaleInfoUiPb locale : locales) {
      if (locale.getLocale() == defaultLocale.getLocale()) {
        return true;
      }
    }
    return false;
  }

}
