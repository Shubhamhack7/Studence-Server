package com.tiwari.studence.util.time;

import com.tiwari.studence.proto.time.WeekDay;
import com.tiwari.studence.util.formatter.IFormatterEnum;

public class WeekDayEnumFormatter implements IFormatterEnum<WeekDay> {
  @Override
  public String getStringValue(WeekDay weekDay) {
    return null;
  }

  @Override
  public WeekDay getEnum(String S) {
    switch (S) {
    case "SUNDAY":
      return WeekDay.SUNDAY;
    case "MONDAY":
      return WeekDay.MONDAY;
    case "TUESDAY":
      return WeekDay.TUESDAY;
    case "WEDNESDAY":
      return WeekDay.WEDNESDAY;
    case "THURSDAY":
      return WeekDay.THURSDAY;
    case "FRIDAY":
      return WeekDay.FRIDAY;
    case "SATURDAY":
      return WeekDay.SATURDAY;
    case "UNKNOWN_WEEKDAY":
    default:
      throw new IllegalArgumentException("Invalid WeekDay string: " + S);
    }
  }
}
