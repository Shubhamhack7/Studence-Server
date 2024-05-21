package com.tiwari.studence.util.time;

import com.tiwari.studence.proto.time.TimePb;
import com.tiwari.studence.proto.time.TimezoneEnum;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public enum DateTimePatterns {
  FORMATTED_YEAR("yyyy"),
  FORMATTED_MONTH("yyyyMM"),
  FORMATTED_DATE("yyyyMMdd"),
  FORMATTED_DATE_TIME("yyyyMMdd HH:mm:ss"),
  FORMATTED_TIMESTAMP("yyyy-MM-dd HH:mm:ss"),
  FORMATTED_DASHED_DATE("yyyy-MM-dd"),
  FORMATTED_DATE_TIME_TILL_MINS("yyyyMMdd HH:mm"),
  FORMATTED_DATE_HOUR("yyyyMMdd HH"),
  FORMATTED_TIME("HH:mm:ss"),
  DATE_MONTH_YEAR("dd MMM yyyy"),
  DATE_MONTH_YEAR_HOURS_MINUTES_SECONDS("dd MMM yyyy HH:mm:ss"),
  DATE_MONTH_YEAR_HOURS_MINUTES_SECONDS_ZONE("dd MMM yyyy HH:mm:ss Z"),
  SLASHED_DATE_MONTH_YEAR("dd/MM/yyyy"),
  SLASHED_YEAR_MONTH_DATE("yyyy/MM/dd"),
  HOURS_MINUTES_SECONDS("HH:mm:ss");

  private final String m_pattern;
  private final DateTimeFormatter m_formatter;

  private DateTimePatterns(String pattern) {
    m_pattern = pattern;
    m_formatter = DateTimeFormat.forPattern(pattern);
  }

  public DateTimeFormatter getFormatter(TimezoneEnum timeZone) {
    return m_formatter.withZone(TimeZoneUtility.getJodaDTZ(timeZone));
  }

  public String format(TimezoneEnum timeZone, long time) {
    return m_formatter.withZone(TimeZoneUtility.getJodaDTZ(timeZone)).print(time);
  }

  public String format(TimePb time) {
    return m_formatter.withZone(TimeZoneUtility.getJodaDTZ(time.getTimezone()))
            .print(time.getUnixTimestampMs());
  }

  public String getPattern() {
    return m_pattern;
  }

}
