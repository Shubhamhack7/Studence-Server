// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: timePb.proto

package com.tiwari.studence.proto.time;

public interface TimeUiPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.time.TimeUiPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 milliSeconds = 1;</code>
   * @return Whether the milliSeconds field is set.
   */
  boolean hasMilliSeconds();
  /**
   * <code>optional int64 milliSeconds = 1;</code>
   * @return The milliSeconds.
   */
  long getMilliSeconds();

  /**
   * <code>optional .com.tiwari.studence.proto.time.TimePrecisionUiEnum precision = 2;</code>
   * @return Whether the precision field is set.
   */
  boolean hasPrecision();
  /**
   * <code>optional .com.tiwari.studence.proto.time.TimePrecisionUiEnum precision = 2;</code>
   * @return The enum numeric value on the wire for precision.
   */
  int getPrecisionValue();
  /**
   * <code>optional .com.tiwari.studence.proto.time.TimePrecisionUiEnum precision = 2;</code>
   * @return The precision.
   */
  com.tiwari.studence.proto.time.TimePrecisionUiEnum getPrecision();

  /**
   * <pre>
   * YYYYMMDD
   * </pre>
   *
   * <code>optional string formattedDate = 3;</code>
   * @return Whether the formattedDate field is set.
   */
  boolean hasFormattedDate();
  /**
   * <pre>
   * YYYYMMDD
   * </pre>
   *
   * <code>optional string formattedDate = 3;</code>
   * @return The formattedDate.
   */
  java.lang.String getFormattedDate();
  /**
   * <pre>
   * YYYYMMDD
   * </pre>
   *
   * <code>optional string formattedDate = 3;</code>
   * @return The bytes for formattedDate.
   */
  com.google.protobuf.ByteString
      getFormattedDateBytes();

  /**
   * <pre>
   * "YYYYMMDD HH:MM:SS"
   * </pre>
   *
   * <code>optional string formattedDateTime = 4;</code>
   * @return Whether the formattedDateTime field is set.
   */
  boolean hasFormattedDateTime();
  /**
   * <pre>
   * "YYYYMMDD HH:MM:SS"
   * </pre>
   *
   * <code>optional string formattedDateTime = 4;</code>
   * @return The formattedDateTime.
   */
  java.lang.String getFormattedDateTime();
  /**
   * <pre>
   * "YYYYMMDD HH:MM:SS"
   * </pre>
   *
   * <code>optional string formattedDateTime = 4;</code>
   * @return The bytes for formattedDateTime.
   */
  com.google.protobuf.ByteString
      getFormattedDateTimeBytes();

  /**
   * <code>optional .com.tiwari.studence.proto.time.TimezoneEnum timeZone = 5;</code>
   * @return Whether the timeZone field is set.
   */
  boolean hasTimeZone();
  /**
   * <code>optional .com.tiwari.studence.proto.time.TimezoneEnum timeZone = 5;</code>
   * @return The enum numeric value on the wire for timeZone.
   */
  int getTimeZoneValue();
  /**
   * <code>optional .com.tiwari.studence.proto.time.TimezoneEnum timeZone = 5;</code>
   * @return The timeZone.
   */
  com.tiwari.studence.proto.time.TimezoneEnum getTimeZone();

  /**
   * <pre>
   * "YYYYMM"
   * </pre>
   *
   * <code>optional string formattedMonth = 6;</code>
   * @return Whether the formattedMonth field is set.
   */
  boolean hasFormattedMonth();
  /**
   * <pre>
   * "YYYYMM"
   * </pre>
   *
   * <code>optional string formattedMonth = 6;</code>
   * @return The formattedMonth.
   */
  java.lang.String getFormattedMonth();
  /**
   * <pre>
   * "YYYYMM"
   * </pre>
   *
   * <code>optional string formattedMonth = 6;</code>
   * @return The bytes for formattedMonth.
   */
  com.google.protobuf.ByteString
      getFormattedMonthBytes();

  /**
   * <pre>
   * "YYYYMMDD HH"
   * </pre>
   *
   * <code>optional string formattedHour = 7;</code>
   * @return Whether the formattedHour field is set.
   */
  boolean hasFormattedHour();
  /**
   * <pre>
   * "YYYYMMDD HH"
   * </pre>
   *
   * <code>optional string formattedHour = 7;</code>
   * @return The formattedHour.
   */
  java.lang.String getFormattedHour();
  /**
   * <pre>
   * "YYYYMMDD HH"
   * </pre>
   *
   * <code>optional string formattedHour = 7;</code>
   * @return The bytes for formattedHour.
   */
  com.google.protobuf.ByteString
      getFormattedHourBytes();

  /**
   * <pre>
   * "YYYY"
   * </pre>
   *
   * <code>optional string formattedYear = 8;</code>
   * @return Whether the formattedYear field is set.
   */
  boolean hasFormattedYear();
  /**
   * <pre>
   * "YYYY"
   * </pre>
   *
   * <code>optional string formattedYear = 8;</code>
   * @return The formattedYear.
   */
  java.lang.String getFormattedYear();
  /**
   * <pre>
   * "YYYY"
   * </pre>
   *
   * <code>optional string formattedYear = 8;</code>
   * @return The bytes for formattedYear.
   */
  com.google.protobuf.ByteString
      getFormattedYearBytes();

  /**
   * <code>optional string formattedTimestamp = 9;</code>
   * @return Whether the formattedTimestamp field is set.
   */
  boolean hasFormattedTimestamp();
  /**
   * <code>optional string formattedTimestamp = 9;</code>
   * @return The formattedTimestamp.
   */
  java.lang.String getFormattedTimestamp();
  /**
   * <code>optional string formattedTimestamp = 9;</code>
   * @return The bytes for formattedTimestamp.
   */
  com.google.protobuf.ByteString
      getFormattedTimestampBytes();
}
