package com.tiwari.studence.util.time;

import com.tiwari.studence.proto.time.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

  public static String getCurrenTimeInyyyyMMddHHmmssSSS(){
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    return now.format(formatter);

  }


 public static TimePb getCurrentTime(TimezoneEnum timezoneEnum) {

    TimeZoneFormatter formatter  = new TimeZoneFormatter();
    WeekDayEnumFormatter weekDayEnumFormatter = new WeekDayEnumFormatter();
   // Get the current date and time in the system timezone
   // Get the timezone string from the provided input
   String timeZoneString =formatter.getStringValue(timezoneEnum);

   // Create a ZoneId using the provided timezone string
   ZoneId zoneId = ZoneId.of(timeZoneString);

   // Get the current date and time in the specified timezone
   ZonedDateTime currentDateTime = ZonedDateTime.now(zoneId);

   // Create a TimePb builder
   TimePb.Builder timePbBuilder = TimePb.newBuilder();

   // Fill the time-related parameters based on the current system time and timezone
   timePbBuilder.setDate(currentDateTime.toLocalDate().toString());
   timePbBuilder.setTime24H(currentDateTime.toLocalTime().toString());
   timePbBuilder.setTime12H(currentDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("h:mm:ss a")));
   timePbBuilder.setDayOfWeek(weekDayEnumFormatter.getEnum(currentDateTime.getDayOfWeek().name()));
   timePbBuilder.setYear(currentDateTime.getYear());
   timePbBuilder.setMonth(getMonthEnum(currentDateTime.getMonthValue()));
   timePbBuilder.setMonthOfYear(currentDateTime.getMonthValue());
   timePbBuilder.setDay(getDayEnum(currentDateTime.getDayOfMonth()));
   timePbBuilder.setDayOfMonth(currentDateTime.getDayOfMonth());
   timePbBuilder.setUnixTimestamp(currentDateTime.toEpochSecond());
   timePbBuilder.setUnixTimestampMs(System.currentTimeMillis());
   timePbBuilder.setUnixTimestampUs(System.nanoTime() / 1000);
   timePbBuilder.setUnixTimestampNs(System.nanoTime());

   // Fill the canonical_datetime parameter
   String canonicalDateTime = String.format("%02d-%s-%04d %02d:%02d:%02d.%03d",
           currentDateTime.getDayOfMonth(),
           currentDateTime.getMonth().name().substring(0, 3),
           currentDateTime.getYear(),
           currentDateTime.getHour(),
           currentDateTime.getMinute(),
           currentDateTime.getSecond(),
           currentDateTime.getNano() / 1_000_000);
   timePbBuilder.setCanonicalDatetime(canonicalDateTime);

   // Build the TimePb object
   TimePb timePb = timePbBuilder.build();
   return timePb;
 }

  private static Month getMonthEnum(int monthValue) {
    for (Month month : Month.values()) {
      if (month.getNumber() == monthValue) {
        return month;
      }
    }
    throw new IllegalArgumentException("Invalid month value: " + monthValue);
  }

  private static Day getDayEnum(int dayValue) {
    for (Day day : Day.values()) {
      if (day.getNumber() == dayValue) {
        return day;
      }
    }
    throw new IllegalArgumentException("Invalid day value: " + dayValue);
  }
 }
