package com.tiwari.studence.common.service.v2.convertor;

import com.tiwari.studence.proto.time.TimePb;
import com.tiwari.studence.proto.time.TimeRangePb;
import com.tiwari.studence.proto.time.TimeRangeUiPb;
import com.tiwari.studence.proto.time.TimeUiPb;
import com.tiwari.studence.util.time.TimeUiPbDateTimeUtility;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TimeProtoConverter {
  private final TimeUiPbDateTimeUtility m_dateTimeUtility;

  @Inject
  public TimeProtoConverter(TimeUiPbDateTimeUtility dateTimeUtility) {
    m_dateTimeUtility = dateTimeUtility;
  }

  public TimeUiPb toTimeUiPb(TimePb time) {
    TimeUiPb.Builder timeUiPbBuilder = TimeUiPb.newBuilder();
    /*if (time.hasFormattedDate()) {
      timeUiPbBuilder.setFormattedDate(time.getFormattedDate());
    }
    if (time.hasFormattedDateTime()) {
      timeUiPbBuilder.setFormattedDateTime(time.getFormattedDateTime());
    }*/
   /* if (time.hasMilliSeconds()) {
      timeUiPbBuilder.setMilliSeconds(time.getMilliSeconds());
      timeUiPbBuilder.setFormattedTimestamp(
              m_dateTimeUtility.getTimestamp(time.getMilliSeconds(), time.getTimeZone()));
    }*/
    // if (time.hasFormattedTime()) {
    // timeUiPbBuilder.setFormattedTime(time.getFormattedTime());
    // }

   /* if (time.hasFormattedHour()) {
      timeUiPbBuilder.setFormattedHour(time.getFormattedHour());
    }*/

    // if (time.hasHours()) {
    // timeUiPbBuilder.setHours(time.getHours());
    // }
    //
    // if(time.hasMinutes()){
    // timeUiPbBuilder.setMinutes(time.getMinutes());
    // }
    //
    // if(time.hasSeconds()){
    // timeUiPbBuilder.setSeconds(time.getSeconds());
    // }
    timeUiPbBuilder.setTimeZone(time.getTimezone());

    return timeUiPbBuilder.build();
  }

  public TimeRangeUiPb toTimeRangeUiPb(TimeRangePb timeRange) {
    TimeRangeUiPb.Builder timeRangeUiPbBuilder = TimeRangeUiPb.newBuilder();
    timeRangeUiPbBuilder.setTimeStart(toTimeUiPb(timeRange.getTimeStart()));
    timeRangeUiPbBuilder.setTimeEnd(toTimeUiPb(timeRange.getTimeEnd()));
    return timeRangeUiPbBuilder.build();
  }
}
