// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: htmlWidgets.proto

package com.tiwari.studence.proto.htmlWidgets;

/**
 * Protobuf enum {@code com.tiwari.studence.proto.htmlWidgets.ContainerTypeEnum}
 */
public enum ContainerTypeEnum
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNKNOWN_CONTAINER_TYPE = 0;</code>
   */
  UNKNOWN_CONTAINER_TYPE(0),
  /**
   * <code>CONTAINER = 1;</code>
   */
  CONTAINER(1),
  /**
   * <code>FORM = 2;</code>
   */
  FORM(2),
  /**
   * <code>ROW = 3;</code>
   */
  ROW(3),
  /**
   * <code>COLUMN = 4;</code>
   */
  COLUMN(4),
  /**
   * <code>STACK = 5;</code>
   */
  STACK(5),
  /**
   * <code>EXTENDED = 6;</code>
   */
  EXTENDED(6),
  /**
   * <code>FLEXIBLE = 7;</code>
   */
  FLEXIBLE(7),
  /**
   * <code>SIZED_BOX = 8;</code>
   */
  SIZED_BOX(8),
  /**
   * <code>FITTED_BOX = 9;</code>
   */
  FITTED_BOX(9),
  /**
   * <code>OVERFLOW_BOX = 10;</code>
   */
  OVERFLOW_BOX(10),
  /**
   * <code>CENTER = 11;</code>
   */
  CENTER(11),
  /**
   * <code>ALIGN = 12;</code>
   */
  ALIGN(12),
  /**
   * <code>BODY = 13;</code>
   */
  BODY(13),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN_CONTAINER_TYPE = 0;</code>
   */
  public static final int UNKNOWN_CONTAINER_TYPE_VALUE = 0;
  /**
   * <code>CONTAINER = 1;</code>
   */
  public static final int CONTAINER_VALUE = 1;
  /**
   * <code>FORM = 2;</code>
   */
  public static final int FORM_VALUE = 2;
  /**
   * <code>ROW = 3;</code>
   */
  public static final int ROW_VALUE = 3;
  /**
   * <code>COLUMN = 4;</code>
   */
  public static final int COLUMN_VALUE = 4;
  /**
   * <code>STACK = 5;</code>
   */
  public static final int STACK_VALUE = 5;
  /**
   * <code>EXTENDED = 6;</code>
   */
  public static final int EXTENDED_VALUE = 6;
  /**
   * <code>FLEXIBLE = 7;</code>
   */
  public static final int FLEXIBLE_VALUE = 7;
  /**
   * <code>SIZED_BOX = 8;</code>
   */
  public static final int SIZED_BOX_VALUE = 8;
  /**
   * <code>FITTED_BOX = 9;</code>
   */
  public static final int FITTED_BOX_VALUE = 9;
  /**
   * <code>OVERFLOW_BOX = 10;</code>
   */
  public static final int OVERFLOW_BOX_VALUE = 10;
  /**
   * <code>CENTER = 11;</code>
   */
  public static final int CENTER_VALUE = 11;
  /**
   * <code>ALIGN = 12;</code>
   */
  public static final int ALIGN_VALUE = 12;
  /**
   * <code>BODY = 13;</code>
   */
  public static final int BODY_VALUE = 13;


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
  public static ContainerTypeEnum valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ContainerTypeEnum forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN_CONTAINER_TYPE;
      case 1: return CONTAINER;
      case 2: return FORM;
      case 3: return ROW;
      case 4: return COLUMN;
      case 5: return STACK;
      case 6: return EXTENDED;
      case 7: return FLEXIBLE;
      case 8: return SIZED_BOX;
      case 9: return FITTED_BOX;
      case 10: return OVERFLOW_BOX;
      case 11: return CENTER;
      case 12: return ALIGN;
      case 13: return BODY;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ContainerTypeEnum>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ContainerTypeEnum> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ContainerTypeEnum>() {
          public ContainerTypeEnum findValueByNumber(int number) {
            return ContainerTypeEnum.forNumber(number);
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
    return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.getDescriptor().getEnumTypes().get(4);
  }

  private static final ContainerTypeEnum[] VALUES = values();

  public static ContainerTypeEnum valueOf(
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

  private ContainerTypeEnum(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tiwari.studence.proto.htmlWidgets.ContainerTypeEnum)
}

