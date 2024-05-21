package com.tiwari.studence.common.util;

import com.tiwari.studence.proto.time.TimezoneEnum;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.time.TimeZoneUtility;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.inject.Singleton;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Singleton
public class TimeFormatUtility {

  // year = y
  // month = M
  // date = d
  // hour(24) = H
  // min = m
  // second = s
  // milli = S
  // timeZone = Z

  // eg. yyyyMMddHHmmssSSS

  public String getTimeWithGivenFormat(String format, long milliseconds, TimezoneEnum timeZone) {
    DateTimeZone jodaDTZ = TimeZoneUtility.getJodaDTZ(timeZone);
    DateTimeFormatter formatter = DateTimeFormat.forPattern(format).withZone(jodaDTZ);
    return formatter.print(milliseconds);
  }

  /**
   * @param timeZone
   *          will be ignored in case of timezone available in format string
   */
  public long getMillisWithGivenFormat(String format, String time, TimezoneEnum timeZone) {
    DateTimeZone jodaDTZ = TimeZoneUtility.getJodaDTZ(timeZone);
    org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern(format).withZone(jodaDTZ);
    return formatter.parseMillis(time);
  }

  /**
   * @param timeZone
   *          will be ignored in case of timezone available in format string
   */
  public long getMillisWithGivenFormatWithoutStrictParse(String format, String time,
          TimezoneEnum timeZone) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    formatter.setTimeZone(TimeZoneUtility.getTZ(timeZone));
    try {
      return formatter.parse(time).getTime();
    } catch (ParseException e) {
      throw Exceptions.handleThrowable(e);
    }
  }

  public boolean isValidTimeWithGivenFormat(String format, String time) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
    try {
      formatter.parseMillis(time);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  public boolean isValidTimeWithGivenFormatWithoutStrictParse(String format, String time) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    try {
      formatter.parse(time);
      return true;
    } catch (ParseException e) {
      return false;
    }
  }

}
