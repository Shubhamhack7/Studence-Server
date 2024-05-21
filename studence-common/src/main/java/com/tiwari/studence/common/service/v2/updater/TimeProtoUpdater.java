package com.tiwari.studence.common.service.v2.updater;

import com.tiwari.studence.common.util.TimeFormatUtility;
import com.tiwari.studence.proto.time.TimePb;
import com.tiwari.studence.proto.time.TimeUiPb;
import com.tiwari.studence.proto.time.TimezoneEnum;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.time.DateTimePatterns;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TimeProtoUpdater {
  private final TimeFormatUtility m_timeFormatUtility;

  @Inject
  public TimeProtoUpdater(TimeFormatUtility timeFormatUtility) {
    m_timeFormatUtility = timeFormatUtility;
  }

  public TimePb toTimePb(TimeUiPb timeUi) {
    TimePb.Builder timePbBuilder = TimePb.newBuilder();
    /*if (Strings.notEmpty(timeUi.getFormattedDate())
            && m_timeFormatUtility.isValidTimeWithGivenFormat(
            DateTimePatterns.FORMATTED_DATE.getPattern(), timeUi.getFormattedDate())) {
      timePbBuilder.set(timeUi.getFormattedDate());
    }
    if (Strings.notEmpty(timeUi.getFormattedDateTime())) {
      timePbBuilder.setFormattedDateTime(timeUi.getFormattedDateTime());
    }*/
    if (timeUi.getMilliSeconds() > 0) {
      timePbBuilder.setUnixTimestampMs(timeUi.getMilliSeconds());
      Preconditions.validate(timeUi.getTimeZone() != TimezoneEnum.UNKNOWN_TIMEZONE,
              "TimeZone is unknown");
    }
    if (Strings.notEmpty(timeUi.getFormattedHour())) {
      timePbBuilder.setTime12H(timeUi.getFormattedHour());
    }
    timePbBuilder.setTimezone(timeUi.getTimeZone());
    return timePbBuilder.build();
  }

  /*public TimeRangePb toTimeRangePb(TimeRangeUiPb timeRangeUi) {
    TimeRangePb.Builder timeRangePbBuilder = TimeRangePb.newBuilder();
    timeRangePbBuilder.setTimeStart(toTimePb(timeRangeUi.getTimeStart()));
    timeRangePbBuilder.setTimeEnd(toTimePb(timeRangeUi.getTimeEnd()));
    return timeRangePbBuilder.build();
  }*/
}
