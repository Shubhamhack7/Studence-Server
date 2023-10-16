// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: classPb.proto

package com.tiwari.studence.proto.classes;

/**
 * Protobuf enum {@code com.tiwari.studence.proto.classes.ClassType}
 */
public enum ClassType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>CLASS_UNKNOWN = 0;</code>
   */
  CLASS_UNKNOWN(0),
  /**
   * <code>CLASS_ONE = 1;</code>
   */
  CLASS_ONE(1),
  /**
   * <code>CLASS_TWO = 2;</code>
   */
  CLASS_TWO(2),
  /**
   * <code>CLASS_THREE = 3;</code>
   */
  CLASS_THREE(3),
  /**
   * <code>CLASS_FOUR = 4;</code>
   */
  CLASS_FOUR(4),
  /**
   * <code>CLASS_FIVE = 5;</code>
   */
  CLASS_FIVE(5),
  /**
   * <code>CLASS_SIX = 6;</code>
   */
  CLASS_SIX(6),
  /**
   * <code>CLASS_SEVEN = 7;</code>
   */
  CLASS_SEVEN(7),
  /**
   * <code>CLASS_EIGHT = 8;</code>
   */
  CLASS_EIGHT(8),
  /**
   * <code>CLASS_NINE = 9;</code>
   */
  CLASS_NINE(9),
  /**
   * <code>CLASS_TEN = 10;</code>
   */
  CLASS_TEN(10),
  /**
   * <code>CLASS_ELEVEN = 11;</code>
   */
  CLASS_ELEVEN(11),
  /**
   * <code>CLASS_TWELVE = 12;</code>
   */
  CLASS_TWELVE(12),
  /**
   * <code>CLASS_NURSERY = 13;</code>
   */
  CLASS_NURSERY(13),
  /**
   * <code>CLASS_LKG = 14;</code>
   */
  CLASS_LKG(14),
  /**
   * <code>CLASS_UKG = 15;</code>
   */
  CLASS_UKG(15),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>CLASS_UNKNOWN = 0;</code>
   */
  public static final int CLASS_UNKNOWN_VALUE = 0;
  /**
   * <code>CLASS_ONE = 1;</code>
   */
  public static final int CLASS_ONE_VALUE = 1;
  /**
   * <code>CLASS_TWO = 2;</code>
   */
  public static final int CLASS_TWO_VALUE = 2;
  /**
   * <code>CLASS_THREE = 3;</code>
   */
  public static final int CLASS_THREE_VALUE = 3;
  /**
   * <code>CLASS_FOUR = 4;</code>
   */
  public static final int CLASS_FOUR_VALUE = 4;
  /**
   * <code>CLASS_FIVE = 5;</code>
   */
  public static final int CLASS_FIVE_VALUE = 5;
  /**
   * <code>CLASS_SIX = 6;</code>
   */
  public static final int CLASS_SIX_VALUE = 6;
  /**
   * <code>CLASS_SEVEN = 7;</code>
   */
  public static final int CLASS_SEVEN_VALUE = 7;
  /**
   * <code>CLASS_EIGHT = 8;</code>
   */
  public static final int CLASS_EIGHT_VALUE = 8;
  /**
   * <code>CLASS_NINE = 9;</code>
   */
  public static final int CLASS_NINE_VALUE = 9;
  /**
   * <code>CLASS_TEN = 10;</code>
   */
  public static final int CLASS_TEN_VALUE = 10;
  /**
   * <code>CLASS_ELEVEN = 11;</code>
   */
  public static final int CLASS_ELEVEN_VALUE = 11;
  /**
   * <code>CLASS_TWELVE = 12;</code>
   */
  public static final int CLASS_TWELVE_VALUE = 12;
  /**
   * <code>CLASS_NURSERY = 13;</code>
   */
  public static final int CLASS_NURSERY_VALUE = 13;
  /**
   * <code>CLASS_LKG = 14;</code>
   */
  public static final int CLASS_LKG_VALUE = 14;
  /**
   * <code>CLASS_UKG = 15;</code>
   */
  public static final int CLASS_UKG_VALUE = 15;


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
  public static ClassType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ClassType forNumber(int value) {
    switch (value) {
      case 0: return CLASS_UNKNOWN;
      case 1: return CLASS_ONE;
      case 2: return CLASS_TWO;
      case 3: return CLASS_THREE;
      case 4: return CLASS_FOUR;
      case 5: return CLASS_FIVE;
      case 6: return CLASS_SIX;
      case 7: return CLASS_SEVEN;
      case 8: return CLASS_EIGHT;
      case 9: return CLASS_NINE;
      case 10: return CLASS_TEN;
      case 11: return CLASS_ELEVEN;
      case 12: return CLASS_TWELVE;
      case 13: return CLASS_NURSERY;
      case 14: return CLASS_LKG;
      case 15: return CLASS_UKG;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ClassType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ClassType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ClassType>() {
          public ClassType findValueByNumber(int number) {
            return ClassType.forNumber(number);
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
    return com.tiwari.studence.proto.classes.ClassPb.getDescriptor().getEnumTypes().get(0);
  }

  private static final ClassType[] VALUES = values();

  public static ClassType valueOf(
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

  private ClassType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tiwari.studence.proto.classes.ClassType)
}

