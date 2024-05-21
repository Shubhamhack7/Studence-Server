package com.tiwari.studence.common.service.v2.convertor;

import com.tiwari.studence.common.service.v2.updater.TimeProtoUpdater;
import com.tiwari.studence.proto.time.*;
import com.tiwari.studence.util.encoder.IBiConverter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TimeBiConverter implements IBiConverter<TimePb, TimeUiPb> {
  private final TimeProtoUpdater m_timeProtoUpdater;
  private final TimeProtoConverter m_TimePbToUi;

  @Inject
  public TimeBiConverter(TimeProtoConverter TimePbToUi, TimeProtoUpdater timeRangeUiToPb) {
    m_TimePbToUi = TimePbToUi;
    m_timeProtoUpdater = timeRangeUiToPb;
  }

  @Override
  public TimeUiPb convert(TimePb value) {
    return m_TimePbToUi.toTimeUiPb(value);
  }

  @Override
  public TimePb reverseConvert(TimeUiPb value) {
    return m_timeProtoUpdater.toTimePb(value);
  }

  public TimePb getCurrentTime(TimezoneEnum timeZone) {
    TimePb.Builder builder = TimePb.newBuilder();
    builder.setTimezone(timeZone);
    builder.setUnixTimestampMs(System.currentTimeMillis());
    return builder.build();
  }
  public TimePb getTime(long milies,TimezoneEnum timeZone) {
    TimePb.Builder builder = TimePb.newBuilder();
    builder.setTimezone(timeZone);
    builder.setUnixTimestampMs(milies);
    return builder.build();
  }

  public TimeDurationPb convert(TimeDurationUiPb  value){
    TimeDurationPb.Builder builder=TimeDurationPb.newBuilder();
    builder.setDays(value.getDays());
    builder.setHours(value.getHours());
    builder.setMins(value.getMins());
    builder.setSecs(value.getSecs());
    return builder.build();

  }

  public TimeDurationUiPb reversConvert(TimeDurationPb value){
    TimeDurationUiPb.Builder builder=TimeDurationUiPb.newBuilder();
    builder.setDays(value.getDays());
    builder.setHours(value.getHours());
    builder.setMins(value.getMins());
    builder.setSecs(value.getSecs());
    return builder.build();

  }

}
