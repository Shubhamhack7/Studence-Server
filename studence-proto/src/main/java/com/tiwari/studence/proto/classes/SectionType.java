// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: classesPb.proto

package com.tiwari.studence.proto.classes;

/**
 * Protobuf enum {@code com.tiwari.studence.proto.classes.SectionType}
 */
public enum SectionType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SECTION_UNKNOWN = 0;</code>
   */
  SECTION_UNKNOWN(0),
  /**
   * <code>SECTION_A = 1;</code>
   */
  SECTION_A(1),
  /**
   * <code>SECTION_B = 2;</code>
   */
  SECTION_B(2),
  /**
   * <code>SECTION_C = 3;</code>
   */
  SECTION_C(3),
  /**
   * <code>SECTION_D = 4;</code>
   */
  SECTION_D(4),
  /**
   * <code>SECTION_E = 5;</code>
   */
  SECTION_E(5),
  /**
   * <code>SECTION_F = 6;</code>
   */
  SECTION_F(6),
  /**
   * <code>SECTION_G = 7;</code>
   */
  SECTION_G(7),
  /**
   * <code>SECTION_H = 8;</code>
   */
  SECTION_H(8),
  /**
   * <code>SECTION_I = 9;</code>
   */
  SECTION_I(9),
  /**
   * <code>SECTION_J = 10;</code>
   */
  SECTION_J(10),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SECTION_UNKNOWN = 0;</code>
   */
  public static final int SECTION_UNKNOWN_VALUE = 0;
  /**
   * <code>SECTION_A = 1;</code>
   */
  public static final int SECTION_A_VALUE = 1;
  /**
   * <code>SECTION_B = 2;</code>
   */
  public static final int SECTION_B_VALUE = 2;
  /**
   * <code>SECTION_C = 3;</code>
   */
  public static final int SECTION_C_VALUE = 3;
  /**
   * <code>SECTION_D = 4;</code>
   */
  public static final int SECTION_D_VALUE = 4;
  /**
   * <code>SECTION_E = 5;</code>
   */
  public static final int SECTION_E_VALUE = 5;
  /**
   * <code>SECTION_F = 6;</code>
   */
  public static final int SECTION_F_VALUE = 6;
  /**
   * <code>SECTION_G = 7;</code>
   */
  public static final int SECTION_G_VALUE = 7;
  /**
   * <code>SECTION_H = 8;</code>
   */
  public static final int SECTION_H_VALUE = 8;
  /**
   * <code>SECTION_I = 9;</code>
   */
  public static final int SECTION_I_VALUE = 9;
  /**
   * <code>SECTION_J = 10;</code>
   */
  public static final int SECTION_J_VALUE = 10;


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
  public static SectionType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static SectionType forNumber(int value) {
    switch (value) {
      case 0: return SECTION_UNKNOWN;
      case 1: return SECTION_A;
      case 2: return SECTION_B;
      case 3: return SECTION_C;
      case 4: return SECTION_D;
      case 5: return SECTION_E;
      case 6: return SECTION_F;
      case 7: return SECTION_G;
      case 8: return SECTION_H;
      case 9: return SECTION_I;
      case 10: return SECTION_J;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<SectionType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      SectionType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<SectionType>() {
          public SectionType findValueByNumber(int number) {
            return SectionType.forNumber(number);
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
    return com.tiwari.studence.proto.classes.ClassesPbOuterClass.getDescriptor().getEnumTypes().get(1);
  }

  private static final SectionType[] VALUES = values();

  public static SectionType valueOf(
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

  private SectionType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tiwari.studence.proto.classes.SectionType)
}

