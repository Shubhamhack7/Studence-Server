// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: index.proto

package com.tiwari.studence.proto.index;

/**
 * Protobuf enum {@code com.tiwari.studence.proto.index.DataType}
 */
public enum DataType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNKNOW_DATA_TYPE = 0;</code>
   */
  UNKNOW_DATA_TYPE(0),
  /**
   * <code>LONG = 1;</code>
   */
  LONG(1),
  /**
   * <code>STRING = 2;</code>
   */
  STRING(2),
  /**
   * <code>DOUBLE = 3;</code>
   */
  DOUBLE(3),
  /**
   * <code>ISO_DATE_TIME = 4;</code>
   */
  ISO_DATE_TIME(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOW_DATA_TYPE = 0;</code>
   */
  public static final int UNKNOW_DATA_TYPE_VALUE = 0;
  /**
   * <code>LONG = 1;</code>
   */
  public static final int LONG_VALUE = 1;
  /**
   * <code>STRING = 2;</code>
   */
  public static final int STRING_VALUE = 2;
  /**
   * <code>DOUBLE = 3;</code>
   */
  public static final int DOUBLE_VALUE = 3;
  /**
   * <code>ISO_DATE_TIME = 4;</code>
   */
  public static final int ISO_DATE_TIME_VALUE = 4;


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
  public static DataType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static DataType forNumber(int value) {
    switch (value) {
      case 0: return UNKNOW_DATA_TYPE;
      case 1: return LONG;
      case 2: return STRING;
      case 3: return DOUBLE;
      case 4: return ISO_DATE_TIME;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<DataType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      DataType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<DataType>() {
          public DataType findValueByNumber(int number) {
            return DataType.forNumber(number);
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
    return com.tiwari.studence.proto.index.Index.getDescriptor().getEnumTypes().get(0);
  }

  private static final DataType[] VALUES = values();

  public static DataType valueOf(
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

  private DataType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.tiwari.studence.proto.index.DataType)
}

