// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: timePb.proto

package com.tiwari.studence.proto.time;

public final class TimePbOuterClass {
  private TimePbOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_time_TimePb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_time_TimePb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014timePb.proto\022\036com.tiwari.studence.prot" +
      "o.time\"\334\003\n\006TimePb\022\014\n\004date\030\001 \001(\t\022\020\n\010time_" +
      "24h\030\002 \001(\t\022\020\n\010time_12h\030\003 \001(\t\022>\n\010timezone\030" +
      "\004 \001(\0162,.com.tiwari.studence.proto.time.T" +
      "imezoneEnum\022<\n\013day_of_week\030\005 \001(\0162\'.com.t" +
      "iwari.studence.proto.time.WeekDay\022\014\n\004yea" +
      "r\030\006 \001(\005\022\023\n\013monthOfYear\030\007 \001(\005\022\022\n\ndayOfMon" +
      "th\030\010 \001(\005\0224\n\005month\030\t \001(\0162%.com.tiwari.stu" +
      "dence.proto.time.Month\0220\n\003day\030\n \001(\0162#.co" +
      "m.tiwari.studence.proto.time.Day\022\026\n\016unix" +
      "_timestamp\030\013 \001(\003\022\031\n\021unix_timestamp_ms\030\014 " +
      "\001(\003\022\031\n\021unix_timestamp_us\030\r \001(\003\022\031\n\021unix_t" +
      "imestamp_ns\030\016 \001(\003\022\032\n\022canonical_datetime\030" +
      "\017 \001(\t*\317\002\n\014TimezoneEnum\022\024\n\020UNKNOWN_TIMEZO" +
      "NE\020\000\022\024\n\020AMERICA_NEW_YORK\020\001\022\027\n\023AMERICA_LO" +
      "S_ANGELES\020\002\022\023\n\017AMERICA_CHICAGO\020\003\022\022\n\016AMER" +
      "ICA_DENVER\020\004\022\021\n\rEUROPE_LONDON\020\005\022\020\n\014EUROP" +
      "E_PARIS\020\006\022\021\n\rEUROPE_BERLIN\020\007\022\017\n\013EUROPE_R" +
      "OME\020\010\022\016\n\nASIA_TOKYO\020\t\022\021\n\rASIA_SHANGHAI\020\n" +
      "\022\016\n\nASIA_DUBAI\020\013\022\020\n\014ASIA_KOLKATA\020\014\022\024\n\020AU" +
      "STRALIA_SYDNEY\020\r\022\027\n\023AUSTRALIA_MELBOURNE\020" +
      "\016\022\024\n\020PACIFIC_AUCKLAND\020\017*\246\001\n\005Month\022\013\n\007UNK" +
      "NOWN\020\000\022\013\n\007JANUARY\020\001\022\014\n\010FEBRUARY\020\002\022\t\n\005MAR" +
      "CH\020\003\022\t\n\005APRIL\020\004\022\007\n\003MAY\020\005\022\010\n\004JUNE\020\006\022\010\n\004JU" +
      "LY\020\007\022\n\n\006AUGUST\020\010\022\r\n\tSEPTEMBER\020\t\022\013\n\007OCTOB" +
      "ER\020\n\022\014\n\010NOVEMBER\020\013\022\014\n\010DECEMBER\020\014*\263\003\n\003Day" +
      "\022\017\n\013UNKNOWN_DAY\020\000\022\007\n\003ONE\020\001\022\007\n\003TWO\020\002\022\t\n\005T" +
      "HREE\020\003\022\010\n\004FOUR\020\004\022\010\n\004FIVE\020\005\022\007\n\003SIX\020\006\022\t\n\005S" +
      "EVEN\020\007\022\t\n\005EIGHT\020\010\022\010\n\004NINE\020\t\022\007\n\003TEN\020\n\022\n\n\006" +
      "ELEVEN\020\013\022\n\n\006TWELVE\020\014\022\014\n\010THIRTEEN\020\r\022\014\n\010FO" +
      "URTEEN\020\016\022\013\n\007FIFTEEN\020\017\022\013\n\007SIXTEEN\020\020\022\r\n\tSE" +
      "VENTEEN\020\021\022\014\n\010EIGHTEEN\020\022\022\014\n\010NINETEEN\020\023\022\n\n" +
      "\006TWENTY\020\024\022\016\n\nTWENTY_ONE\020\025\022\016\n\nTWENTY_TWO\020" +
      "\026\022\020\n\014TWENTY_THREE\020\027\022\017\n\013TWENTY_FOUR\020\030\022\017\n\013" +
      "TWENTY_FIVE\020\031\022\016\n\nTWENTY_SIX\020\032\022\020\n\014TWENTY_" +
      "SEVEN\020\033\022\020\n\014TWENTY_EIGHT\020\034\022\017\n\013TWENTY_NINE" +
      "\020\035\022\n\n\006THIRTY\020\036\022\016\n\nTHIRTY_ONE\020\037*z\n\007WeekDa" +
      "y\022\023\n\017UNKNOWN_WEEKDAY\020\000\022\n\n\006SUNDAY\020\001\022\n\n\006MO" +
      "NDAY\020\002\022\013\n\007TUESDAY\020\003\022\r\n\tWEDNESDAY\020\004\022\014\n\010TH" +
      "URSDAY\020\005\022\n\n\006FRIDAY\020\006\022\014\n\010SATURDAY\020\007B\005P\001\240\001" +
      "\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_tiwari_studence_proto_time_TimePb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_time_TimePb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_time_TimePb_descriptor,
        new java.lang.String[] { "Date", "Time24H", "Time12H", "Timezone", "DayOfWeek", "Year", "MonthOfYear", "DayOfMonth", "Month", "Day", "UnixTimestamp", "UnixTimestampMs", "UnixTimestampUs", "UnixTimestampNs", "CanonicalDatetime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
