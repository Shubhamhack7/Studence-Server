// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pushNotificationPb.proto

package com.tiwari.studence.proto.pushNotification;

/**
 * Protobuf type {@code com.tiwari.studence.proto.pushNotification.PushNotificationPb}
 */
public final class PushNotificationPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.pushNotification.PushNotificationPb)
    PushNotificationPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PushNotificationPb.newBuilder() to construct.
  private PushNotificationPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PushNotificationPb() {
    token_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PushNotificationPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.pushNotification.PushNotificationPbOuterClass.internal_static_com_tiwari_studence_proto_pushNotification_PushNotificationPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.pushNotification.PushNotificationPbOuterClass.internal_static_com_tiwari_studence_proto_pushNotification_PushNotificationPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.pushNotification.PushNotificationPb.class, com.tiwari.studence.proto.pushNotification.PushNotificationPb.Builder.class);
  }

  public static final int DBINFO_FIELD_NUMBER = 1;
  private com.tiwari.studence.proto.entity.EntityPb dbInfo_;
  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   * @return Whether the dbInfo field is set.
   */
  @java.lang.Override
  public boolean hasDbInfo() {
    return dbInfo_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   * @return The dbInfo.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.entity.EntityPb getDbInfo() {
    return dbInfo_ == null ? com.tiwari.studence.proto.entity.EntityPb.getDefaultInstance() : dbInfo_;
  }
  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.entity.EntityPbOrBuilder getDbInfoOrBuilder() {
    return dbInfo_ == null ? com.tiwari.studence.proto.entity.EntityPb.getDefaultInstance() : dbInfo_;
  }

  public static final int TOKEN_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object token_ = "";
  /**
   * <code>string token = 2;</code>
   * @return The token.
   */
  @java.lang.Override
  public java.lang.String getToken() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      token_ = s;
      return s;
    }
  }
  /**
   * <code>string token = 2;</code>
   * @return The bytes for token.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTokenBytes() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      token_ = b;
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
    if (dbInfo_ != null) {
      output.writeMessage(1, getDbInfo());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(token_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, token_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (dbInfo_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getDbInfo());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(token_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, token_);
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
    if (!(obj instanceof com.tiwari.studence.proto.pushNotification.PushNotificationPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.pushNotification.PushNotificationPb other = (com.tiwari.studence.proto.pushNotification.PushNotificationPb) obj;

    if (hasDbInfo() != other.hasDbInfo()) return false;
    if (hasDbInfo()) {
      if (!getDbInfo()
          .equals(other.getDbInfo())) return false;
    }
    if (!getToken()
        .equals(other.getToken())) return false;
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
    if (hasDbInfo()) {
      hash = (37 * hash) + DBINFO_FIELD_NUMBER;
      hash = (53 * hash) + getDbInfo().hashCode();
    }
    hash = (37 * hash) + TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getToken().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.pushNotification.PushNotificationPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.pushNotification.PushNotificationPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.pushNotification.PushNotificationPb)
      com.tiwari.studence.proto.pushNotification.PushNotificationPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.pushNotification.PushNotificationPbOuterClass.internal_static_com_tiwari_studence_proto_pushNotification_PushNotificationPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.pushNotification.PushNotificationPbOuterClass.internal_static_com_tiwari_studence_proto_pushNotification_PushNotificationPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.pushNotification.PushNotificationPb.class, com.tiwari.studence.proto.pushNotification.PushNotificationPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.pushNotification.PushNotificationPb.newBuilder()
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
      dbInfo_ = null;
      if (dbInfoBuilder_ != null) {
        dbInfoBuilder_.dispose();
        dbInfoBuilder_ = null;
      }
      token_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.pushNotification.PushNotificationPbOuterClass.internal_static_com_tiwari_studence_proto_pushNotification_PushNotificationPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.pushNotification.PushNotificationPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.pushNotification.PushNotificationPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.pushNotification.PushNotificationPb build() {
      com.tiwari.studence.proto.pushNotification.PushNotificationPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.pushNotification.PushNotificationPb buildPartial() {
      com.tiwari.studence.proto.pushNotification.PushNotificationPb result = new com.tiwari.studence.proto.pushNotification.PushNotificationPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.pushNotification.PushNotificationPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.dbInfo_ = dbInfoBuilder_ == null
            ? dbInfo_
            : dbInfoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.token_ = token_;
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
      if (other instanceof com.tiwari.studence.proto.pushNotification.PushNotificationPb) {
        return mergeFrom((com.tiwari.studence.proto.pushNotification.PushNotificationPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.pushNotification.PushNotificationPb other) {
      if (other == com.tiwari.studence.proto.pushNotification.PushNotificationPb.getDefaultInstance()) return this;
      if (other.hasDbInfo()) {
        mergeDbInfo(other.getDbInfo());
      }
      if (!other.getToken().isEmpty()) {
        token_ = other.token_;
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
              input.readMessage(
                  getDbInfoFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              token_ = input.readStringRequireUtf8();
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

    private com.tiwari.studence.proto.entity.EntityPb dbInfo_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.entity.EntityPb, com.tiwari.studence.proto.entity.EntityPb.Builder, com.tiwari.studence.proto.entity.EntityPbOrBuilder> dbInfoBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     * @return Whether the dbInfo field is set.
     */
    public boolean hasDbInfo() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     * @return The dbInfo.
     */
    public com.tiwari.studence.proto.entity.EntityPb getDbInfo() {
      if (dbInfoBuilder_ == null) {
        return dbInfo_ == null ? com.tiwari.studence.proto.entity.EntityPb.getDefaultInstance() : dbInfo_;
      } else {
        return dbInfoBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     */
    public Builder setDbInfo(com.tiwari.studence.proto.entity.EntityPb value) {
      if (dbInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        dbInfo_ = value;
      } else {
        dbInfoBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     */
    public Builder setDbInfo(
        com.tiwari.studence.proto.entity.EntityPb.Builder builderForValue) {
      if (dbInfoBuilder_ == null) {
        dbInfo_ = builderForValue.build();
      } else {
        dbInfoBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     */
    public Builder mergeDbInfo(com.tiwari.studence.proto.entity.EntityPb value) {
      if (dbInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          dbInfo_ != null &&
          dbInfo_ != com.tiwari.studence.proto.entity.EntityPb.getDefaultInstance()) {
          getDbInfoBuilder().mergeFrom(value);
        } else {
          dbInfo_ = value;
        }
      } else {
        dbInfoBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     */
    public Builder clearDbInfo() {
      bitField0_ = (bitField0_ & ~0x00000001);
      dbInfo_ = null;
      if (dbInfoBuilder_ != null) {
        dbInfoBuilder_.dispose();
        dbInfoBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     */
    public com.tiwari.studence.proto.entity.EntityPb.Builder getDbInfoBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getDbInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     */
    public com.tiwari.studence.proto.entity.EntityPbOrBuilder getDbInfoOrBuilder() {
      if (dbInfoBuilder_ != null) {
        return dbInfoBuilder_.getMessageOrBuilder();
      } else {
        return dbInfo_ == null ?
            com.tiwari.studence.proto.entity.EntityPb.getDefaultInstance() : dbInfo_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.entity.EntityPb, com.tiwari.studence.proto.entity.EntityPb.Builder, com.tiwari.studence.proto.entity.EntityPbOrBuilder> 
        getDbInfoFieldBuilder() {
      if (dbInfoBuilder_ == null) {
        dbInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.entity.EntityPb, com.tiwari.studence.proto.entity.EntityPb.Builder, com.tiwari.studence.proto.entity.EntityPbOrBuilder>(
                getDbInfo(),
                getParentForChildren(),
                isClean());
        dbInfo_ = null;
      }
      return dbInfoBuilder_;
    }

    private java.lang.Object token_ = "";
    /**
     * <code>string token = 2;</code>
     * @return The token.
     */
    public java.lang.String getToken() {
      java.lang.Object ref = token_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        token_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string token = 2;</code>
     * @return The bytes for token.
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      java.lang.Object ref = token_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string token = 2;</code>
     * @param value The token to set.
     * @return This builder for chaining.
     */
    public Builder setToken(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      token_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string token = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearToken() {
      token_ = getDefaultInstance().getToken();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string token = 2;</code>
     * @param value The bytes for token to set.
     * @return This builder for chaining.
     */
    public Builder setTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      token_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.pushNotification.PushNotificationPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.pushNotification.PushNotificationPb)
  private static final com.tiwari.studence.proto.pushNotification.PushNotificationPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.pushNotification.PushNotificationPb();
  }

  public static com.tiwari.studence.proto.pushNotification.PushNotificationPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PushNotificationPb>
      PARSER = new com.google.protobuf.AbstractParser<PushNotificationPb>() {
    @java.lang.Override
    public PushNotificationPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<PushNotificationPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PushNotificationPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.pushNotification.PushNotificationPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
