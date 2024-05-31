// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: timePb.proto

package com.tiwari.studence.proto.time;

/**
 * Protobuf enum {@code com.tiwari.studence.proto.time.WeekDay}
 */
public enum WeekDay
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNKNOWN_WEEKDAY = 0;</code>
   */
  UNKNOWN_WEEKDAY(0),
  /**
   * <code>SUNDAY = 1;</code>
   */
  SUNDAY(1),
  /**
   * <code>MONDAY = 2;</code>
   */
  MONDAY(2),
  /**
   * <code>TUESDAY = 3;</code>
   */
  TUESDAY(3),
  /**
   * <code>WEDNESDAY = 4;</code>
   */
  WEDNESDAY(4),
  /**
   * <code>THURSDAY = 5;</code>
   */
  THURSDAY(5),
  /**
   * <code>FRIDAY = 6;</code>
   */
  FRIDAY(6),
  /**
   * <code>SATURDAY = 7;</code>
   */
  SATURDAY(7),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN_WEEKDAY = 0;</code>
   */
  public static final int UNKNOWN_WEEKDAY_VALUE = 0;
  /**
   * <code>SUNDAY = 1;</code>
   */
  public static final int SUNDAY_VALUE = 1;
  /**
   * <code>MONDAY = 2;</code>
   */
  public static final int MONDAY_VALUE = 2;
  /**
   * <code>TUESDAY = 3;</code>
   */
  public static final int TUESDAY_VALUE = 3;
  /**
   * <code>WEDNESDAY = 4;</code>
   */
  public static final int WEDNESDAY_VALUE = 4;
  /**
   * <code>THURSDAY = 5;</code>
   */
  public static final int THURSDAY_VALUE = 5;
  /**
   * <code>FRIDAY = 6;</code>
   */
  public static final int FRIDAY_VALUE = 6;
  /**
   * <code>SATURDAY = 7;</code>
   */
  public static final int SATURDAY_VALUE = 7;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static WeekDay valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static WeekDay forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_WEEKDAY;
      case 1: return SUNDAY;
      case 2: return MONDAY;
      case 3: return TUESDAY;
      case 4: return WEDNESDAY;
      case 5: return THURSDAY;
      case 6: return FRIDAY;
      case 7: return SATURDAY;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<WeekDay>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      WeekDay> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<WeekDay>() {
          public WeekDay findValueByNumber(int number) {
            return WeekDay.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.tiwari.studence.proto.time.TimePbOuterClass.getDescriptor().getEnumTypes().get(3);
  }

  private static final WeekDay[] VALUES = values();

  public static WeekDay valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private WeekDay(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tiwari.studence.proto.time.WeekDay)
}

