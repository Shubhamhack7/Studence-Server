package com.tiwari.studence.util.time;

import com.tiwari.studence.proto.time.TimezoneEnum;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import javax.inject.Singleton;

@Singleton
public class TZIndependentDateTimeUtil {

  public String addSeconds(String formattedDateTime, int seconds) {
    return dateTimeFormatted(parseLocalDateTime(formattedDateTime).plusSeconds(seconds));
  }

  public String addMinutes(String formattedDateTime, int minutes) {
    return dateTimeFormatted(parseLocalDateTime(formattedDateTime).plusMinutes(minutes));
  }

  public String addHours(String formattedDateTime, int hours) {
    return dateTimeFormatted(parseLocalDateTime(formattedDateTime).plusHours(hours));
  }

  public String addDays(String formattedDateTime, int days) {
    return dateTimeFormatted(parseLocalDateTime(formattedDateTime).plusDays(days));
  }

  public String addMonths(String formattedDateTime, int months) {
    return dateTimeFormatted(parseLocalDateTime(formattedDateTime).plusMonths(months));
  }

  public String addYears(String formattedDateTime, int years) {
    return dateTimeFormatted(parseLocalDateTime(formattedDateTime).plusYears(years));
  }

  private String dateTimeFormatted(LocalDateTime localDateTime) {
    return localDateTime.toString(DateTimePatterns.FORMATTED_DATE_TIME.getPattern());
  }

  private LocalDateTime parseLocalDateTime(String date) {
    return DateTimePatterns.FORMATTED_DATE_TIME.getFormatter(TimezoneEnum.ASIA_KOLKATA)
            .parseLocalDateTime(date);
  }

  private LocalDate parseLocalDate(String date) {
    return DateTimePatterns.FORMATTED_DATE.getFormatter(TimezoneEnum.ASIA_KOLKATA).parseLocalDate(date);
  }

  public String addMonthsToDate(String formattedDate, int months) {
    return parseLocalDate(formattedDate).plusMonths(months)
            .toString(DateTimePatterns.FORMATTED_DATE.getPattern());
  }

}
