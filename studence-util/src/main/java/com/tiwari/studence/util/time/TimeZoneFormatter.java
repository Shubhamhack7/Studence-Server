package com.tiwari.studence.util.time;

import com.tiwari.studence.proto.time.TimezoneEnum;
import com.tiwari.studence.util.formatter.IFormatterEnum;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TimeZoneFormatter implements IFormatterEnum<TimezoneEnum> {

  @Inject
  TimeZoneFormatter(){}
  @Override
  public String getStringValue(TimezoneEnum timezoneEnum) {
    switch (timezoneEnum) {
    case AMERICA_NEW_YORK:
      return "America/New_York";
    case AMERICA_LOS_ANGELES:
      return "America/Los_Angeles";
    case AMERICA_CHICAGO:
      return "America/Chicago";
    case AMERICA_DENVER:
      return "America/Denver";
    case EUROPE_LONDON:
      return "Europe/London";
    case EUROPE_PARIS:
      return "Europe/Paris";
    case EUROPE_BERLIN:
      return "Europe/Berlin";
    case EUROPE_ROME:
      return "Europe/Rome";
    case ASIA_TOKYO:
      return "Asia/Tokyo";
    case ASIA_SHANGHAI:
      return "Asia/Shanghai";
    case ASIA_DUBAI:
      return "Asia/Dubai";
    case ASIA_KOLKATA:
      return "Asia/Kolkata";
    case AUSTRALIA_SYDNEY:
      return "Australia/Sydney";
    case AUSTRALIA_MELBOURNE:
      return "Australia/Melbourne";
    case PACIFIC_AUCKLAND:
      return "Pacific/Auckland";
    case UNKNOWN_TIMEZONE:
    default:
      throw new IllegalArgumentException("Unknown TimezoneEnum value: " + timezoneEnum);
    }
  }

  @Override
  public TimezoneEnum getEnum(String S) {
    return null;
  }
}
