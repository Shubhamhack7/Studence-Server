// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: htmlWidgets.proto

package com.tiwari.studence.proto.htmlWidgets;

/**
 * Protobuf type {@code com.tiwari.studence.proto.htmlWidgets.HeightPb}
 */
public final class HeightPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.htmlWidgets.HeightPb)
    HeightPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use HeightPb.newBuilder() to construct.
  private HeightPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HeightPb() {
    widthType_ = 0;
    unit_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new HeightPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_HeightPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_HeightPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.htmlWidgets.HeightPb.class, com.tiwari.studence.proto.htmlWidgets.HeightPb.Builder.class);
  }

  public static final int WIDTHTYPE_FIELD_NUMBER = 1;
  private int widthType_ = 0;
  /**
   * <code>.com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum widthType = 1;</code>
   * @return The enum numeric value on the wire for widthType.
   */
  @java.lang.Override public int getWidthTypeValue() {
    return widthType_;
  }
  /**
   * <code>.com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum widthType = 1;</code>
   * @return The widthType.
   */
  @java.lang.Override public com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum getWidthType() {
    com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum result = com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum.forNumber(widthType_);
    return result == null ? com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum.UNRECOGNIZED : result;
  }

  public static final int UNIT_FIELD_NUMBER = 2;
  private int unit_ = 0;
  /**
   * <code>.com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum unit = 2;</code>
   * @return The enum numeric value on the wire for unit.
   */
  @java.lang.Override public int getUnitValue() {
    return unit_;
  }
  /**
   * <code>.com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum unit = 2;</code>
   * @return The unit.
   */
  @java.lang.Override public com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum getUnit() {
    com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum result = com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum.forNumber(unit_);
    return result == null ? com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum.UNRECOGNIZED : result;
  }

  public static final int VALUE_FIELD_NUMBER = 3;
  private double value_ = 0D;
  /**
   * <code>double value = 3;</code>
   * @return The value.
   */
  @java.lang.Override
  public double getValue() {
    return value_;
  }

  public static final int MULTIPLEVALUES_FIELD_NUMBER = 4;
  private com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues_;
  /**
   * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
   * @return Whether the multipleValues field is set.
   */
  @java.lang.Override
  public boolean hasMultipleValues() {
    return multipleValues_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
   * @return The multipleValues.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.htmlWidgets.DirectionConfig getMultipleValues() {
    return multipleValues_ == null ? com.tiwari.studence.proto.htmlWidgets.DirectionConfig.getDefaultInstance() : multipleValues_;
  }
  /**
   * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.htmlWidgets.DirectionConfigOrBuilder getMultipleValuesOrBuilder() {
    return multipleValues_ == null ? com.tiwari.studence.proto.htmlWidgets.DirectionConfig.getDefaultInstance() : multipleValues_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (widthType_ != com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum.UNKNOWN_PADDING_TYPE.getNumber()) {
      output.writeEnum(1, widthType_);
    }
    if (unit_ != com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum.UNKNOWN_UNIT_TYPE.getNumber()) {
      output.writeEnum(2, unit_);
    }
    if (java.lang.Double.doubleToRawLongBits(value_) != 0) {
      output.writeDouble(3, value_);
    }
    if (multipleValues_ != null) {
      output.writeMessage(4, getMultipleValues());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (widthType_ != com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum.UNKNOWN_PADDING_TYPE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, widthType_);
    }
    if (unit_ != com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum.UNKNOWN_UNIT_TYPE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, unit_);
    }
    if (java.lang.Double.doubleToRawLongBits(value_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, value_);
    }
    if (multipleValues_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getMultipleValues());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.tiwari.studence.proto.htmlWidgets.HeightPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.htmlWidgets.HeightPb other = (com.tiwari.studence.proto.htmlWidgets.HeightPb) obj;

    if (widthType_ != other.widthType_) return false;
    if (unit_ != other.unit_) return false;
    if (java.lang.Double.doubleToLongBits(getValue())
        != java.lang.Double.doubleToLongBits(
            other.getValue())) return false;
    if (hasMultipleValues() != other.hasMultipleValues()) return false;
    if (hasMultipleValues()) {
      if (!getMultipleValues()
          .equals(other.getMultipleValues())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + WIDTHTYPE_FIELD_NUMBER;
    hash = (53 * hash) + widthType_;
    hash = (37 * hash) + UNIT_FIELD_NUMBER;
    hash = (53 * hash) + unit_;
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getValue()));
    if (hasMultipleValues()) {
      hash = (37 * hash) + MULTIPLEVALUES_FIELD_NUMBER;
      hash = (53 * hash) + getMultipleValues().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.htmlWidgets.HeightPb parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.tiwari.studence.proto.htmlWidgets.HeightPb prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.tiwari.studence.proto.htmlWidgets.HeightPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.htmlWidgets.HeightPb)
      com.tiwari.studence.proto.htmlWidgets.HeightPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_HeightPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_HeightPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.htmlWidgets.HeightPb.class, com.tiwari.studence.proto.htmlWidgets.HeightPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.htmlWidgets.HeightPb.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      widthType_ = 0;
      unit_ = 0;
      value_ = 0D;
      multipleValues_ = null;
      if (multipleValuesBuilder_ != null) {
        multipleValuesBuilder_.dispose();
        multipleValuesBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_HeightPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.htmlWidgets.HeightPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.htmlWidgets.HeightPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.htmlWidgets.HeightPb build() {
      com.tiwari.studence.proto.htmlWidgets.HeightPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.htmlWidgets.HeightPb buildPartial() {
      com.tiwari.studence.proto.htmlWidgets.HeightPb result = new com.tiwari.studence.proto.htmlWidgets.HeightPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.htmlWidgets.HeightPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.widthType_ = widthType_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.unit_ = unit_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.value_ = value_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.multipleValues_ = multipleValuesBuilder_ == null
            ? multipleValues_
            : multipleValuesBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.tiwari.studence.proto.htmlWidgets.HeightPb) {
        return mergeFrom((com.tiwari.studence.proto.htmlWidgets.HeightPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.htmlWidgets.HeightPb other) {
      if (other == com.tiwari.studence.proto.htmlWidgets.HeightPb.getDefaultInstance()) return this;
      if (other.widthType_ != 0) {
        setWidthTypeValue(other.getWidthTypeValue());
      }
      if (other.unit_ != 0) {
        setUnitValue(other.getUnitValue());
      }
      if (other.getValue() != 0D) {
        setValue(other.getValue());
      }
      if (other.hasMultipleValues()) {
        mergeMultipleValues(other.getMultipleValues());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              widthType_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              unit_ = input.readEnum();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 25: {
              value_ = input.readDouble();
              bitField0_ |= 0x00000004;
              break;
            } // case 25
            case 34: {
              input.readMessage(
                  getMultipleValuesFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int widthType_ = 0;
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum widthType = 1;</code>
     * @return The enum numeric value on the wire for widthType.
     */
    @java.lang.Override public int getWidthTypeValue() {
      return widthType_;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum widthType = 1;</code>
     * @param value The enum numeric value on the wire for widthType to set.
     * @return This builder for chaining.
     */
    public Builder setWidthTypeValue(int value) {
      widthType_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum widthType = 1;</code>
     * @return The widthType.
     */
    @java.lang.Override
    public com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum getWidthType() {
      com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum result = com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum.forNumber(widthType_);
      return result == null ? com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum widthType = 1;</code>
     * @param value The widthType to set.
     * @return This builder for chaining.
     */
    public Builder setWidthType(com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      widthType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueTypeEnum widthType = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearWidthType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      widthType_ = 0;
      onChanged();
      return this;
    }

    private int unit_ = 0;
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum unit = 2;</code>
     * @return The enum numeric value on the wire for unit.
     */
    @java.lang.Override public int getUnitValue() {
      return unit_;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum unit = 2;</code>
     * @param value The enum numeric value on the wire for unit to set.
     * @return This builder for chaining.
     */
    public Builder setUnitValue(int value) {
      unit_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum unit = 2;</code>
     * @return The unit.
     */
    @java.lang.Override
    public com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum getUnit() {
      com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum result = com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum.forNumber(unit_);
      return result == null ? com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum unit = 2;</code>
     * @param value The unit to set.
     * @return This builder for chaining.
     */
    public Builder setUnit(com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      unit_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.ValueUnitTypeEnum unit = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearUnit() {
      bitField0_ = (bitField0_ & ~0x00000002);
      unit_ = 0;
      onChanged();
      return this;
    }

    private double value_ ;
    /**
     * <code>double value = 3;</code>
     * @return The value.
     */
    @java.lang.Override
    public double getValue() {
      return value_;
    }
    /**
     * <code>double value = 3;</code>
     * @param value The value to set.
     * @return This builder for chaining.
     */
    public Builder setValue(double value) {
      
      value_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>double value = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearValue() {
      bitField0_ = (bitField0_ & ~0x00000004);
      value_ = 0D;
      onChanged();
      return this;
    }

    private com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.htmlWidgets.DirectionConfig, com.tiwari.studence.proto.htmlWidgets.DirectionConfig.Builder, com.tiwari.studence.proto.htmlWidgets.DirectionConfigOrBuilder> multipleValuesBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     * @return Whether the multipleValues field is set.
     */
    public boolean hasMultipleValues() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     * @return The multipleValues.
     */
    public com.tiwari.studence.proto.htmlWidgets.DirectionConfig getMultipleValues() {
      if (multipleValuesBuilder_ == null) {
        return multipleValues_ == null ? com.tiwari.studence.proto.htmlWidgets.DirectionConfig.getDefaultInstance() : multipleValues_;
      } else {
        return multipleValuesBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     */
    public Builder setMultipleValues(com.tiwari.studence.proto.htmlWidgets.DirectionConfig value) {
      if (multipleValuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        multipleValues_ = value;
      } else {
        multipleValuesBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     */
    public Builder setMultipleValues(
        com.tiwari.studence.proto.htmlWidgets.DirectionConfig.Builder builderForValue) {
      if (multipleValuesBuilder_ == null) {
        multipleValues_ = builderForValue.build();
      } else {
        multipleValuesBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     */
    public Builder mergeMultipleValues(com.tiwari.studence.proto.htmlWidgets.DirectionConfig value) {
      if (multipleValuesBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0) &&
          multipleValues_ != null &&
          multipleValues_ != com.tiwari.studence.proto.htmlWidgets.DirectionConfig.getDefaultInstance()) {
          getMultipleValuesBuilder().mergeFrom(value);
        } else {
          multipleValues_ = value;
        }
      } else {
        multipleValuesBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     */
    public Builder clearMultipleValues() {
      bitField0_ = (bitField0_ & ~0x00000008);
      multipleValues_ = null;
      if (multipleValuesBuilder_ != null) {
        multipleValuesBuilder_.dispose();
        multipleValuesBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     */
    public com.tiwari.studence.proto.htmlWidgets.DirectionConfig.Builder getMultipleValuesBuilder() {
      bitField0_ |= 0x00000008;
      onChanged();
      return getMultipleValuesFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     */
    public com.tiwari.studence.proto.htmlWidgets.DirectionConfigOrBuilder getMultipleValuesOrBuilder() {
      if (multipleValuesBuilder_ != null) {
        return multipleValuesBuilder_.getMessageOrBuilder();
      } else {
        return multipleValues_ == null ?
            com.tiwari.studence.proto.htmlWidgets.DirectionConfig.getDefaultInstance() : multipleValues_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.htmlWidgets.DirectionConfig multipleValues = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.htmlWidgets.DirectionConfig, com.tiwari.studence.proto.htmlWidgets.DirectionConfig.Builder, com.tiwari.studence.proto.htmlWidgets.DirectionConfigOrBuilder> 
        getMultipleValuesFieldBuilder() {
      if (multipleValuesBuilder_ == null) {
        multipleValuesBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.htmlWidgets.DirectionConfig, com.tiwari.studence.proto.htmlWidgets.DirectionConfig.Builder, com.tiwari.studence.proto.htmlWidgets.DirectionConfigOrBuilder>(
                getMultipleValues(),
                getParentForChildren(),
                isClean());
        multipleValues_ = null;
      }
      return multipleValuesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.htmlWidgets.HeightPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.htmlWidgets.HeightPb)
  private static final com.tiwari.studence.proto.htmlWidgets.HeightPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.htmlWidgets.HeightPb();
  }

  public static com.tiwari.studence.proto.htmlWidgets.HeightPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HeightPb>
      PARSER = new com.google.protobuf.AbstractParser<HeightPb>() {
    @java.lang.Override
    public HeightPb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<HeightPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HeightPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.htmlWidgets.HeightPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

