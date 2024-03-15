// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subjectPb.proto

package com.tiwari.studence.proto.subject;

/**
 * Protobuf enum {@code com.tiwari.studence.proto.subject.SubjectTypeEnum}
 */
public enum SubjectTypeEnum
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNKNOWN_SUBJECT = 0;</code>
   */
  UNKNOWN_SUBJECT(0),
  /**
   * <code>ENGLISH = 1;</code>
   */
  ENGLISH(1),
  /**
   * <code>HINDI = 2;</code>
   */
  HINDI(2),
  /**
   * <code>MATHS = 3;</code>
   */
  MATHS(3),
  /**
   * <code>SCIENCE = 4;</code>
   */
  SCIENCE(4),
  /**
   * <code>SOCIAL_SCIENCE = 5;</code>
   */
  SOCIAL_SCIENCE(5),
  /**
   * <code>ART_AND_CRAFT = 6;</code>
   */
  ART_AND_CRAFT(6),
  /**
   * <code>COMPUTER = 7;</code>
   */
  COMPUTER(7),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN_SUBJECT = 0;</code>
   */
  public static final int UNKNOWN_SUBJECT_VALUE = 0;
  /**
   * <code>ENGLISH = 1;</code>
   */
  public static final int ENGLISH_VALUE = 1;
  /**
   * <code>HINDI = 2;</code>
   */
  public static final int HINDI_VALUE = 2;
  /**
   * <code>MATHS = 3;</code>
   */
  public static final int MATHS_VALUE = 3;
  /**
   * <code>SCIENCE = 4;</code>
   */
  public static final int SCIENCE_VALUE = 4;
  /**
   * <code>SOCIAL_SCIENCE = 5;</code>
   */
  public static final int SOCIAL_SCIENCE_VALUE = 5;
  /**
   * <code>ART_AND_CRAFT = 6;</code>
   */
  public static final int ART_AND_CRAFT_VALUE = 6;
  /**
   * <code>COMPUTER = 7;</code>
   */
  public static final int COMPUTER_VALUE = 7;


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
  public static SubjectTypeEnum valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static SubjectTypeEnum forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_SUBJECT;
      case 1: return ENGLISH;
      case 2: return HINDI;
      case 3: return MATHS;
      case 4: return SCIENCE;
      case 5: return SOCIAL_SCIENCE;
      case 6: return ART_AND_CRAFT;
      case 7: return COMPUTER;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<SubjectTypeEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      SubjectTypeEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<SubjectTypeEnum>() {
          public SubjectTypeEnum findValueByNumber(int number) {
            return SubjectTypeEnum.forNumber(number);
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
    return com.tiwari.studence.proto.subject.SubjectPb.getDescriptor().getEnumTypes().get(0);
  }

  private static final SubjectTypeEnum[] VALUES = values();

  public static SubjectTypeEnum valueOf(
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

  private SubjectTypeEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tiwari.studence.proto.subject.SubjectTypeEnum)
}
