// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: keyValue.proto

package com.tiwari.studence.proto.keyValue;

/**
 * Protobuf type {@code com.tiwari.studence.proto.keyValue.KeyValuePb}
 */
public final class KeyValuePb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.keyValue.KeyValuePb)
    KeyValuePbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use KeyValuePb.newBuilder() to construct.
  private KeyValuePb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private KeyValuePb() {
    key_ = "";
    value_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new KeyValuePb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.keyValue.KeyValue.internal_static_com_tiwari_studence_proto_keyValue_KeyValuePb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.keyValue.KeyValue.internal_static_com_tiwari_studence_proto_keyValue_KeyValuePb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.keyValue.KeyValuePb.class, com.tiwari.studence.proto.keyValue.KeyValuePb.Builder.class);
  }

  private int bitField0_;
  public static final int KEY_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object key_ = "";
  /**
   * <code>optional string key = 1;</code>
   * @return Whether the key field is set.
   */
  @java.lang.Override
  public boolean hasKey() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string key = 1;</code>
   * @return The key.
   */
  @java.lang.Override
  public java.lang.String getKey() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      key_ = s;
      return s;
    }
  }
  /**
   * <code>optional string key = 1;</code>
   * @return The bytes for key.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getKeyBytes() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      key_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VALUE_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object value_ = "";
  /**
   * <code>optional string value = 2;</code>
   * @return Whether the value field is set.
   */
  @java.lang.Override
  public boolean hasValue() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional string value = 2;</code>
   * @return The value.
   */
  @java.lang.Override
  public java.lang.String getValue() {
    java.lang.Object ref = value_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      value_ = s;
      return s;
    }
  }
  /**
   * <code>optional string value = 2;</code>
   * @return The bytes for value.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getValueBytes() {
    java.lang.Object ref = value_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      value_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, value_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, value_);
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
    if (!(obj instanceof com.tiwari.studence.proto.keyValue.KeyValuePb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.keyValue.KeyValuePb other = (com.tiwari.studence.proto.keyValue.KeyValuePb) obj;

    if (hasKey() != other.hasKey()) return false;
    if (hasKey()) {
      if (!getKey()
          .equals(other.getKey())) return false;
    }
    if (hasValue() != other.hasValue()) return false;
    if (hasValue()) {
      if (!getValue()
          .equals(other.getValue())) return false;
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
    if (hasKey()) {
      hash = (37 * hash) + KEY_FIELD_NUMBER;
      hash = (53 * hash) + getKey().hashCode();
    }
    if (hasValue()) {
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.keyValue.KeyValuePb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.keyValue.KeyValuePb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.keyValue.KeyValuePb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.keyValue.KeyValuePb)
      com.tiwari.studence.proto.keyValue.KeyValuePbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.keyValue.KeyValue.internal_static_com_tiwari_studence_proto_keyValue_KeyValuePb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.keyValue.KeyValue.internal_static_com_tiwari_studence_proto_keyValue_KeyValuePb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.keyValue.KeyValuePb.class, com.tiwari.studence.proto.keyValue.KeyValuePb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.keyValue.KeyValuePb.newBuilder()
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
      key_ = "";
      value_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.keyValue.KeyValue.internal_static_com_tiwari_studence_proto_keyValue_KeyValuePb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.keyValue.KeyValuePb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.keyValue.KeyValuePb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.keyValue.KeyValuePb build() {
      com.tiwari.studence.proto.keyValue.KeyValuePb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.keyValue.KeyValuePb buildPartial() {
      com.tiwari.studence.proto.keyValue.KeyValuePb result = new com.tiwari.studence.proto.keyValue.KeyValuePb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.keyValue.KeyValuePb result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.key_ = key_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.value_ = value_;
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof com.tiwari.studence.proto.keyValue.KeyValuePb) {
        return mergeFrom((com.tiwari.studence.proto.keyValue.KeyValuePb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.keyValue.KeyValuePb other) {
      if (other == com.tiwari.studence.proto.keyValue.KeyValuePb.getDefaultInstance()) return this;
      if (other.hasKey()) {
        key_ = other.key_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasValue()) {
        value_ = other.value_;
        bitField0_ |= 0x00000002;
        onChanged();
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
            case 10: {
              key_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              value_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private java.lang.Object key_ = "";
    /**
     * <code>optional string key = 1;</code>
     * @return Whether the key field is set.
     */
    public boolean hasKey() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional string key = 1;</code>
     * @return The key.
     */
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        key_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string key = 1;</code>
     * @return The bytes for key.
     */
    public com.google.protobuf.ByteString
        getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string key = 1;</code>
     * @param value The key to set.
     * @return This builder for chaining.
     */
    public Builder setKey(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      key_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>optional string key = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearKey() {
      key_ = getDefaultInstance().getKey();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>optional string key = 1;</code>
     * @param value The bytes for key to set.
     * @return This builder for chaining.
     */
    public Builder setKeyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      key_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object value_ = "";
    /**
     * <code>optional string value = 2;</code>
     * @return Whether the value field is set.
     */
    public boolean hasValue() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional string value = 2;</code>
     * @return The value.
     */
    public java.lang.String getValue() {
      java.lang.Object ref = value_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        value_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string value = 2;</code>
     * @return The bytes for value.
     */
    public com.google.protobuf.ByteString
        getValueBytes() {
      java.lang.Object ref = value_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        value_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string value = 2;</code>
     * @param value The value to set.
     * @return This builder for chaining.
     */
    public Builder setValue(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      value_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional string value = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearValue() {
      value_ = getDefaultInstance().getValue();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>optional string value = 2;</code>
     * @param value The bytes for value to set.
     * @return This builder for chaining.
     */
    public Builder setValueBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      value_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.keyValue.KeyValuePb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.keyValue.KeyValuePb)
  private static final com.tiwari.studence.proto.keyValue.KeyValuePb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.keyValue.KeyValuePb();
  }

  public static com.tiwari.studence.proto.keyValue.KeyValuePb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<KeyValuePb>
      PARSER = new com.google.protobuf.AbstractParser<KeyValuePb>() {
    @java.lang.Override
    public KeyValuePb parsePartialFrom(
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

  public static com.google.protobuf.Parser<KeyValuePb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<KeyValuePb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.keyValue.KeyValuePb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

