package com.tiwari.studence.util.time;

import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.proto.time.TimeUiPb;
import com.tiwari.studence.proto.time.TimezoneEnum;
import com.tiwari.studence.util.collect.Sets;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.Preconditions;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Singleton
public class TimeUiPbDateTimeUtility {
  private final TZIndependentDateTimeComparator m_dateTimeComparator;
  private final TZIndependentDateTimeUtil m_dateTimeUtil;

  @Inject
  public TimeUiPbDateTimeUtility(TZIndependentDateTimeComparator dateTimeComparator,
          TZIndependentDateTimeUtil dateTimeUtil) {
    m_dateTimeComparator = dateTimeComparator;
    m_dateTimeUtil = dateTimeUtil;
  }

  public TimeUiPb getCurrentDate(TimezoneEnum timeZone) {
    TimeUiPb.Builder resp = TimeUiPb.newBuilder();
    LocalDateTime date = new LocalDateTime(TimeZoneUtility.getJodaDTZ(timeZone));
    String formattedDate = DateTimePatterns.FORMATTED_DATE.getFormatter(timeZone).print(date);
    // resp.setHours(date.getHourOfDay());
    resp.setFormattedDate(formattedDate);
    resp.setTimeZone(timeZone);
    return resp.build();
  }

  public String getCurrentHourMinTime(TimezoneEnum timeZone) {
    LocalTime date = new LocalTime(TimeZoneUtility.getJodaDTZ(timeZone));
    String formattedTime = DateTimePatterns.FORMATTED_TIME.getFormatter(timeZone).print(date);
    return formattedTime;
  }

  public TimeUiPb getCurrentDateTime(TimezoneEnum timeZone) {
    TimeUiPb.Builder resp = TimeUiPb.newBuilder();
    LocalDateTime date = new LocalDateTime(TimeZoneUtility.getJodaDTZ(timeZone));
    String formattedDateTime = DateTimePatterns.FORMATTED_DATE_TIME.getFormatter(timeZone)
            .print(date);
    resp.setFormattedDateTime(formattedDateTime);
    resp.setTimeZone(timeZone);
    return resp.build();
  }

  public int comare(TimeUiPb time1, TimeUiPb time2) {
    if (isEqual(time1, time2)) {
      return 0;
    }
    return isBefore(time1, time2) ? -1 : 1;
  }

  public boolean isEqual(TimeUiPb date1, TimeUiPb date2) {
    return m_dateTimeComparator.isEqual(getFormattedDateTime(date1), getFormattedDateTime(date2));
  }

  public boolean isBefore(TimeUiPb date1, TimeUiPb date2) {
    return m_dateTimeComparator.isBefore(getFormattedDateTime(date1), getFormattedDateTime(date2));
  }

  public boolean isBeforeOrEqual(TimeUiPb date1, TimeUiPb date2) {
    return m_dateTimeComparator.isBeforeOrEqual(getFormattedDateTime(date1),
            getFormattedDateTime(date2));
  }

  public boolean isAfter(TimeUiPb date1, TimeUiPb date2) {
    return m_dateTimeComparator.isAfter(getFormattedDateTime(date1), getFormattedDateTime(date2));
  }

  public boolean isAfterOrEqual(TimeUiPb date1, TimeUiPb date2) {
    return m_dateTimeComparator.isAfterOrEqual(getFormattedDateTime(date1),
            getFormattedDateTime(date2));
  }

  public TimeUiPb addSeconds(TimeUiPb date, int seconds) {
    String formattedDateTime = m_dateTimeUtil.addSeconds(getFormattedDateTime(date), seconds);
    return getTimeUiPb(formattedDateTime);
  }

  public TimeUiPb addMinutes(TimeUiPb date, int minutes) {
    String formattedDateTime = m_dateTimeUtil.addMinutes(getFormattedDateTime(date), minutes);
    return getTimeUiPb(formattedDateTime);
  }

  public TimeUiPb addHours(TimeUiPb date, int hours) {
    String formattedDateTime = m_dateTimeUtil.addHours(getFormattedDateTime(date), hours);
    return getTimeUiPb(formattedDateTime);
  }

  public TimeUiPb addDays(TimeUiPb date, int days) {
    String formattedDateTime = m_dateTimeUtil.addDays(getFormattedDateTime(date), days);
    return getTimeUiPb(formattedDateTime);
  }

  public TimeUiPb addMonths(TimeUiPb date, int months) {
    String formattedDateTime = m_dateTimeUtil.addMonths(getFormattedDateTime(date), months);
    return getTimeUiPb(formattedDateTime);
  }

  public TimeUiPb addMonthsToDate(TimeUiPb date, int months) {
    String formattedDate = m_dateTimeUtil.addMonthsToDate(getFormattedDate(date), months);
    return TimeUiPb.newBuilder().setFormattedDate(formattedDate).build();
  }

  public TimeUiPb addYears(TimeUiPb date, int years) {
    String formattedDateTime = m_dateTimeUtil.addYears(getFormattedDateTime(date), years);
    return getTimeUiPb(formattedDateTime);
  }

  private TimeUiPb getTimeUiPb(String formattedDateTime) {
    return TimeUiPb.newBuilder().setFormattedDateTime(formattedDateTime).build();
  }

  private String getFormattedDateTime(TimeUiPb date) {
    Preconditions.check(date.hasFormattedDateTime(), "Formatted datetime is not set: " + date);
    return date.getFormattedDateTime();
  }

  private String getFormattedDate(TimeUiPb date) {
    Preconditions.check(Strings.notEmpty(date.getFormattedDate()),
            "Formatted datet is not set: " + date);
    return date.getFormattedDate();
  }

  public Set<TimeUiPb> getHoursInInterval(TimeUiPb from, TimeUiPb to) {
    Preconditions.check(from.getTimeZone() == to.getTimeZone());
    Preconditions.check(to.getMilliSeconds() >= from.getMilliSeconds());
    // This should include the hour of the start time and not the end time.
    Set<TimeUiPb> hours = Sets.newHashSet();
    if (to.getMilliSeconds() == from.getMilliSeconds()) {
      return hours;
    }
    DateTimeZone timeZone = TimeZoneUtility.getJodaDTZ(from.getTimeZone());
    // TODO: Make it work for all type of TimeUiPb data.
    DateTime startTime = new DateTime(from.getMilliSeconds(), timeZone);
    DateTime startHour = startTime.hourOfDay().roundFloorCopy();
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE_HOUR
            .getFormatter(from.getTimeZone());
    hours.add(createForHour(formatter.print(startHour), from.getTimeZone()));
    DateTime nextHour = startHour.plusHours(1);
    while (nextHour.isBefore(to.getMilliSeconds())) {
      hours.add(createForHour(formatter.print(nextHour), from.getTimeZone()));
      nextHour = nextHour.plusHours(1);
    }
    return hours;
  }

  private TimeUiPb createForHour(String hour, TimezoneEnum timeZone) {
    TimeUiPb.Builder timeBuilder = TimeUiPb.newBuilder();
    timeBuilder.setTimeZone(timeZone);
    timeBuilder.setFormattedHour(hour);
    return timeBuilder.build();
  }

  public TimeUiPb getNextHour(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE_HOUR
            .getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedHour(), formatter);
    TimeUiPb.Builder nextHourBuilder = TimeUiPb.newBuilder();
    nextHourBuilder.setTimeZone(from.getTimeZone());
    nextHourBuilder.setFormattedHour(formatter.print(time.plusHours(1)));
    return nextHourBuilder.build();
  }

  public TimeUiPb getNextDay(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE.getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedDate(), formatter);
    TimeUiPb.Builder nextHourBuilder = TimeUiPb.newBuilder();
    nextHourBuilder.setTimeZone(from.getTimeZone());
    nextHourBuilder.setFormattedDate(formatter.print(time.plusDays(1)));
    return nextHourBuilder.build();
  }

  public TimeUiPb getPreviousDay(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE.getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedDate(), formatter);
    TimeUiPb.Builder nextHourBuilder = TimeUiPb.newBuilder();
    nextHourBuilder.setTimeZone(from.getTimeZone());
    nextHourBuilder.setFormattedDate(formatter.print(time.minusDays(1)));
    return nextHourBuilder.build();
  }

  public TimeUiPb getPreviousMonth(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_MONTH.getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedMonth(), formatter);
    TimeUiPb.Builder nextHourBuilder = TimeUiPb.newBuilder();
    nextHourBuilder.setTimeZone(from.getTimeZone());
    nextHourBuilder.setFormattedMonth(formatter.print(time.minusMonths(1)));
    return nextHourBuilder.build();
  }

  public TimeUiPb getNextMonth(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_MONTH.getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedMonth(), formatter);
    TimeUiPb.Builder nextHourBuilder = TimeUiPb.newBuilder();
    nextHourBuilder.setTimeZone(from.getTimeZone());
    nextHourBuilder.setFormattedMonth(formatter.print(time.plusMonths(1)));
    return nextHourBuilder.build();
  }

  public TimeUiPb getNextYear(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_YEAR.getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedYear(), formatter);
    TimeUiPb.Builder nextYearBuilder = TimeUiPb.newBuilder();
    nextYearBuilder.setTimeZone(from.getTimeZone());
    nextYearBuilder.setFormattedYear(formatter.print(time.plusYears(1)));
    return nextYearBuilder.build();
  }

  public TimeUiPb getNext(TimeUiPb from) {
    if (from.hasFormattedHour()) {
      return getNextHour(from);
    }
    if (from.hasFormattedDate()) {
      return getNextDay(from);
    }
    if (from.hasFormattedMonth()) {
      return getNextMonth(from);
    }
    Preconditions.check(false);
    return null;
  }

  public int getDaysInMonth(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_MONTH.getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedMonth(), formatter);
    return (time.dayOfMonth().getMaximumValue() - time.dayOfMonth().getMinimumValue()) + 1;
  }

  public int getHoursInDay(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE.getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedDate(), formatter);
    return (time.hourOfDay().getMaximumValue() - time.hourOfDay().getMinimumValue()) + 1;
  }

  public TimeUiPb getDateForHour(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE_HOUR
            .getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedHour(), formatter);

    org.joda.time.format.DateTimeFormatter dateFormatter = DateTimePatterns.FORMATTED_DATE
            .getFormatter(from.getTimeZone());
    TimeUiPb.Builder date = TimeUiPb.newBuilder();
    date.setTimeZone(from.getTimeZone());
    date.setFormattedDate(dateFormatter.print(time.dayOfMonth().getDateTime()));
    return date.build();
  }

  public TimeUiPb getMonthForDate(TimeUiPb from) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE.getFormatter(from.getTimeZone());
    DateTime time = DateTime.parse(from.getFormattedDate(), formatter);

    org.joda.time.format.DateTimeFormatter monthFormatter = DateTimePatterns.FORMATTED_MONTH
            .getFormatter(from.getTimeZone());
    TimeUiPb.Builder date = TimeUiPb.newBuilder();
    date.setTimeZone(from.getTimeZone());
    date.setFormattedMonth(monthFormatter.print(time.monthOfYear().getDateTime()));
    return date.build();
  }

  public String getTime(TimeUiPb from) {
    if (from.hasFormattedHour()) {
      return from.getFormattedHour();
    }
    if (from.hasFormattedDate()) {
      return from.getFormattedDate();
    }
    if (from.hasFormattedDateTime()) {
      return from.getFormattedDateTime();
    }
    if (from.hasFormattedMonth()) {
      return from.getFormattedMonth();
    }
    // if (from.hasFormattedTime()) {
    // return from.getFormattedTime();
    // }
    return null;
  }

  public boolean equals(TimeUiPb time1, TimeUiPb time2) {
    if (getTime(time1).equals(getTime(time2))) {
      return true;
    } else {
      return false;
    }
  }

  public TimeUiPb getFirstMonthOfYear(TimeUiPb year) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_YEAR.getFormatter(year.getTimeZone());
    DateTime yearDT = DateTime.parse(year.getFormattedYear(), formatter);
    DateTime firstMonth = yearDT.monthOfYear().withMinimumValue();

    org.joda.time.format.DateTimeFormatter monthFormatter = DateTimePatterns.FORMATTED_MONTH
            .getFormatter(year.getTimeZone());
    TimeUiPb.Builder date = TimeUiPb.newBuilder();
    date.setTimeZone(year.getTimeZone());
    date.setFormattedMonth(monthFormatter.print(firstMonth));
    return date.build();
  }

  public TimeUiPb getLastMonthOfYear(TimeUiPb year) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_YEAR.getFormatter(year.getTimeZone());
    DateTime yearDT = DateTime.parse(year.getFormattedYear(), formatter);
    DateTime lastMonth = yearDT.monthOfYear().withMaximumValue();

    org.joda.time.format.DateTimeFormatter monthFormatter = DateTimePatterns.FORMATTED_MONTH
            .getFormatter(year.getTimeZone());
    TimeUiPb.Builder date = TimeUiPb.newBuilder();
    date.setTimeZone(year.getTimeZone());
    date.setFormattedMonth(monthFormatter.print(lastMonth));
    return date.build();
  }

  public TimeUiPb getFirstDayOfMonth(TimeUiPb month) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_MONTH
            .getFormatter(month.getTimeZone());
    DateTime monthDT = DateTime.parse(month.getFormattedMonth(), formatter);
    DateTime firstDay = monthDT.dayOfMonth().withMinimumValue();

    org.joda.time.format.DateTimeFormatter dateFormatter = DateTimePatterns.FORMATTED_DATE
            .getFormatter(month.getTimeZone());
    TimeUiPb.Builder date = TimeUiPb.newBuilder();
    date.setTimeZone(month.getTimeZone());
    date.setFormattedDate(dateFormatter.print(firstDay));
    return date.build();
  }

  public TimeUiPb getLastDayOfMonth(TimeUiPb month) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_MONTH
            .getFormatter(month.getTimeZone());
    DateTime monthDT = DateTime.parse(month.getFormattedMonth(), formatter);
    DateTime lastDay = monthDT.dayOfMonth().withMaximumValue();

    org.joda.time.format.DateTimeFormatter dateFormatter = DateTimePatterns.FORMATTED_DATE
            .getFormatter(month.getTimeZone());
    TimeUiPb.Builder date = TimeUiPb.newBuilder();
    date.setTimeZone(month.getTimeZone());
    date.setFormattedDate(dateFormatter.print(lastDay));
    return date.build();
  }

  public TimeUiPb getFirstHourOfDay(TimeUiPb day) {
    DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE.getFormatter(day.getTimeZone());
    DateTime dayDT = DateTime.parse(day.getFormattedDate(), formatter);
    DateTime firstHour = dayDT.hourOfDay().withMinimumValue();

    org.joda.time.format.DateTimeFormatter dateFormatter = DateTimePatterns.FORMATTED_DATE_HOUR
            .getFormatter(day.getTimeZone());
    TimeUiPb.Builder date = TimeUiPb.newBuilder();
    date.setTimeZone(day.getTimeZone());
    date.setFormattedHour(dateFormatter.print(firstHour));
    return date.build();
  }

  public TimeUiPb getLastHourOfDay(TimeUiPb day) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_DATE.getFormatter(day.getTimeZone());
    DateTime dayDT = DateTime.parse(day.getFormattedDate(), formatter);
    DateTime firstHour = dayDT.hourOfDay().withMaximumValue();

    org.joda.time.format.DateTimeFormatter dateFormatter = DateTimePatterns.FORMATTED_DATE_HOUR
            .getFormatter(day.getTimeZone());
    TimeUiPb.Builder date = TimeUiPb.newBuilder();
    date.setTimeZone(day.getTimeZone());
    date.setFormattedHour(dateFormatter.print(firstHour));
    return date.build();
  }

  public int getYears(TimeUiPb t1, TimeUiPb t2) {
    Preconditions.check(t1.hasFormattedDate(), "Formatted datetime is not set: " + t1);
    Preconditions.check(t2.hasFormattedDate(), "Formatted datetime is not set: " + t2);
    String y1 = t1.getFormattedDate().substring(0, 4);
    String y2 = t2.getFormattedDate().substring(0, 4);
    int year1 = Integer.parseInt(y1);
    int year2 = Integer.parseInt(y2);
    int diff;
    if (year1 > year2) {
      diff = year1 - year2;
    } else {
      diff = year2 - year1;
    }
    return diff;

  }

  public TimeUiPb add(TimeUiPb time1, TimeUiPb time2) {
    Preconditions.check(time1.getTimeZone() == time2.getTimeZone());
    TimeUiPb.Builder time = TimeUiPb.newBuilder();
    time.setMilliSeconds(time1.getMilliSeconds() + time2.getMilliSeconds());
    // TODO: others fields to be set
    time.setTimeZone(time1.getTimeZone());
    return time.build();
  }

  public TimeUiPb getFormattedDateFromMillis(long millisec, TimezoneEnum timeZone) {
    org.joda.time.format.DateTimeFormatter dateFormatter = DateTimePatterns.FORMATTED_DATE.getFormatter(timeZone);
    TimeUiPb.Builder time = TimeUiPb.newBuilder();
    time.setFormattedDate(dateFormatter.print(millisec));
    time.setTimeZone(timeZone);
    return time.build();
  }

  public String getTimestamp(long mills, TimezoneEnum timezone) {
    org.joda.time.format.DateTimeFormatter formatter = DateTimePatterns.FORMATTED_TIMESTAMP.getFormatter(timezone);
    return formatter.print(mills);
  }

  public Set<TimeUiPb> getHalfHoursInIntervalsWithMillis(TimeUiPb from, TimeUiPb to) {

    Preconditions.check(from.getTimeZone() == to.getTimeZone(), "from Time: " + from,
            ErrorCategoryUiEnum.INPUT_VALIDATION_ERROR);
    Preconditions.check(to.getMilliSeconds() >= from.getMilliSeconds(), "to" + to, "from " + from,
            ErrorCategoryUiEnum.INPUT_VALIDATION_ERROR);
    Set<TimeUiPb> thirtyMinsInterval = Sets.newLinkedHashSet();
    if (to.getMilliSeconds() == from.getMilliSeconds()) {
      return thirtyMinsInterval;
    }
    DateTime startTime = new DateTime(from.getMilliSeconds(),
            TimeZoneUtility.getJodaDTZ(from.getTimeZone()));
    DateTime endTime = new DateTime(to.getMilliSeconds(),
            TimeZoneUtility.getJodaDTZ(from.getTimeZone()));
    long startMins = TimeUnit.MILLISECONDS.toMinutes(from.getMilliSeconds());
    long endMins = TimeUnit.MILLISECONDS.toMinutes(to.getMilliSeconds());
    int startMinAdjust = startTime.getMinuteOfHour();
    int endMinAdjust = endTime.getMinuteOfHour();

    if (startMinAdjust > 30) {
      startMinAdjust -= 30;
    }
    startMins -= startMinAdjust;
    if (endMinAdjust > 30) {
      endMinAdjust -= 2;
    }
    endMins -= endMinAdjust;
    while (startMins < endMins) {
      startMins = startMins + 30;
      long mills = TimeUnit.MINUTES.toMillis(startMins);
      thirtyMinsInterval.add(createThirtyMins(mills, from.getTimeZone()));
    }

    return thirtyMinsInterval;
  }

  private static TimeUiPb createThirtyMins(long hourMills, TimezoneEnum timeZone) {
    TimeUiPb.Builder time = TimeUiPb.newBuilder();
    time.setMilliSeconds(hourMills);
    time.setTimeZone(timeZone);
    return time.build();
  }

  public TimeUiPb getNextHourWithMills(TimeUiPb from) {
    DateTime time = new DateTime(from.getMilliSeconds(),
            TimeZoneUtility.getJodaDTZ(from.getTimeZone()));
    TimeUiPb.Builder nextHourBuilder = TimeUiPb.newBuilder();
    nextHourBuilder.setTimeZone(from.getTimeZone());
    nextHourBuilder.setMilliSeconds(time.plusHours(1).getMillis());
    return nextHourBuilder.build();
  }

  private TimeUiPb createForHour(long hourMills, TimezoneEnum timeZone) {
    TimeUiPb.Builder time = TimeUiPb.newBuilder();
    time.setMilliSeconds(hourMills);
    time.setTimeZone(timeZone);
    return time.build();
  }

}

