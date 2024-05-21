package com.tiwari.studence.util.time;

import com.tiwari.studence.proto.time.TimezoneEnum;
import com.tiwari.studence.util.exception.Preconditions;
import org.joda.time.DateTimeZone;

import javax.inject.Singleton;
import java.util.TimeZone;

@Singleton
public class TimeZoneUtility {
  private enum TimeZoneOffset {
    UTC("UTC"),
    IST("Asia/Kolkata"),
    ASIA_DUBAI("Asia/Dubai");

    private final String m_timeZoneId;

    private TimeZoneOffset(String timeZoneId) {
      m_timeZoneId = timeZoneId;
    }

    public DateTimeZone createJodaDTZ() {
      return DateTimeZone.forID(m_timeZoneId);
    }

    public TimeZone createTZ() {
      return TimeZone.getTimeZone(m_timeZoneId);
    }
  }

  private static final TimeZoneOffset UTC_ZONE = TimeZoneOffset.UTC;
  private static final TimeZoneOffset IST_ZONE = TimeZoneOffset.IST;
  private static final TimeZoneOffset ASIA_DUBAI = TimeZoneOffset.ASIA_DUBAI;

  public static DateTimeZone getJodaDTZ(TimezoneEnum tz) {
    switch (tz) {
    case AMERICA_NEW_YORK:
      return UTC_ZONE.createJodaDTZ();
    case ASIA_KOLKATA:
      return IST_ZONE.createJodaDTZ();
    case ASIA_DUBAI:
      return ASIA_DUBAI.createJodaDTZ();

    default:
      Preconditions.validate(false, "Unsupported TimeZoneUiEnum", tz);
      return null;
    }
  }

  public static TimeZone getTZ(TimezoneEnum tz) {
    switch (tz) {
    case AMERICA_NEW_YORK:
      return UTC_ZONE.createTZ();

    case ASIA_KOLKATA:
      return IST_ZONE.createTZ();
    case ASIA_DUBAI:
      return ASIA_DUBAI.createTZ();

    default:
      Preconditions.validate(false, "Unsupported TimeZoneUiEnum", tz);
      return null;
    }
  }
}
