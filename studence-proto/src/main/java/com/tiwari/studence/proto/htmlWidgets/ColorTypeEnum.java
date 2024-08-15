// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: htmlWidgets.proto

package com.tiwari.studence.proto.htmlWidgets;

/**
 * Protobuf enum {@code com.tiwari.studence.proto.htmlWidgets.ColorTypeEnum}
 */
public enum ColorTypeEnum
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNKNOWN_COLOR_TYPE = 0;</code>
   */
  UNKNOWN_COLOR_TYPE(0),
  /**
   * <code>HEXCODE = 1;</code>
   */
  HEXCODE(1),
  /**
   * <code>RGBO = 2;</code>
   */
  RGBO(2),
  /**
   * <code>ARGB = 3;</code>
   */
  ARGB(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN_COLOR_TYPE = 0;</code>
   */
  public static final int UNKNOWN_COLOR_TYPE_VALUE = 0;
  /**
   * <code>HEXCODE = 1;</code>
   */
  public static final int HEXCODE_VALUE = 1;
  /**
   * <code>RGBO = 2;</code>
   */
  public static final int RGBO_VALUE = 2;
  /**
   * <code>ARGB = 3;</code>
   */
  public static final int ARGB_VALUE = 3;


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
  public static ColorTypeEnum valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ColorTypeEnum forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_COLOR_TYPE;
      case 1: return HEXCODE;
      case 2: return RGBO;
      case 3: return ARGB;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ColorTypeEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ColorTypeEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ColorTypeEnum>() {
          public ColorTypeEnum findValueByNumber(int number) {
            return ColorTypeEnum.forNumber(number);
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
    return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.getDescriptor().getEnumTypes().get(9);
  }

  private static final ColorTypeEnum[] VALUES = values();

  public static ColorTypeEnum valueOf(
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

  private ColorTypeEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tiwari.studence.proto.htmlWidgets.ColorTypeEnum)
}

