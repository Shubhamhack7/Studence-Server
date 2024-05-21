package com.tiwari.studence.util.time;

import com.tiwari.studence.proto.time.TimezoneEnum;
import org.joda.time.LocalDateTime;

import javax.inject.Singleton;

@Singleton
public class TZIndependentDateTimeComparator extends ATZIndependentComparators {
  @Override
  public boolean isBefore(String formattedDateTime1, String formattedDateTime2) {
    return compare(parseLocalDateTime(formattedDateTime1),
            parseLocalDateTime(formattedDateTime2)) < 0;
  }

  @Override
  public boolean isEqual(String formattedDateTime1, String formattedDateTime2) {
    return compare(parseLocalDateTime(formattedDateTime1),
            parseLocalDateTime(formattedDateTime2)) == 0;
  }

  private int compare(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
    return localDateTime1.compareTo(localDateTime2);
  }

  private LocalDateTime parseLocalDateTime(String date) {
    return DateTimePatterns.FORMATTED_DATE_TIME.getFormatter(TimezoneEnum.AMERICA_NEW_YORK)
            .parseLocalDateTime(date);
  }

  public boolean isEqualDate(String formattedDate1, String formattedDate2) {
    return compare(parseLocalDate(formattedDate1), parseLocalDate(formattedDate2)) == 0;
  }

  private LocalDateTime parseLocalDate(String date) {
    return DateTimePatterns.FORMATTED_DATE.getFormatter(TimezoneEnum.AMERICA_NEW_YORK)
            .parseLocalDateTime(date);
  }

}
