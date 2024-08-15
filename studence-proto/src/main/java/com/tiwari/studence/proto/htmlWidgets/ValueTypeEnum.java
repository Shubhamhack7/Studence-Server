// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: htmlWidgets.proto

package com.tiwari.studence.proto.htmlWidgets;

/**
 * Protobuf enum {@code com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum}
 */
public enum ValueTypeEnum
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNKNOWN_PADDING_TYPE = 0;</code>
   */
  UNKNOWN_PADDING_TYPE(0),
  /**
   * <code>SINGLE_VALUE = 1;</code>
   */
  SINGLE_VALUE(1),
  /**
   * <code>MULTIPLE_VALUE = 2;</code>
   */
  MULTIPLE_VALUE(2),
  /**
   * <code>AUTO_VALUE = 3;</code>
   */
  AUTO_VALUE(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN_PADDING_TYPE = 0;</code>
   */
  public static final int UNKNOWN_PADDING_TYPE_VALUE = 0;
  /**
   * <code>SINGLE_VALUE = 1;</code>
   */
  public static final int SINGLE_VALUE_VALUE = 1;
  /**
   * <code>MULTIPLE_VALUE = 2;</code>
   */
  public static final int MULTIPLE_VALUE_VALUE = 2;
  /**
   * <code>AUTO_VALUE = 3;</code>
   */
  public static final int AUTO_VALUE_VALUE = 3;


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
  public static ValueTypeEnum valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ValueTypeEnum forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_PADDING_TYPE;
      case 1: return SINGLE_VALUE;
      case 2: return MULTIPLE_VALUE;
      case 3: return AUTO_VALUE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ValueTypeEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ValueTypeEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ValueTypeEnum>() {
          public ValueTypeEnum findValueByNumber(int number) {
            return ValueTypeEnum.forNumber(number);
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
    return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.getDescriptor().getEnumTypes().get(7);
  }

  private static final ValueTypeEnum[] VALUES = values();

  public static ValueTypeEnum valueOf(
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

  private ValueTypeEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum)
}

