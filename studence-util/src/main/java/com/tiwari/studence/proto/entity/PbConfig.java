// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: entityPb.proto

package com.tiwari.studence.proto.entity;

/**
 * Protobuf type {@code com.tiwari.studence.proto.entity.PbConfig}
 */
public final class PbConfig extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.entity.PbConfig)
    PbConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PbConfig.newBuilder() to construct.
  private PbConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PbConfig() {
    updatedBy_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PbConfig();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.entity.EntityPbOuterClass.internal_static_com_tiwari_studence_proto_entity_PbConfig_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.entity.EntityPbOuterClass.internal_static_com_tiwari_studence_proto_entity_PbConfig_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.entity.PbConfig.class, com.tiwari.studence.proto.entity.PbConfig.Builder.class);
  }

  public static final int VERSION_FIELD_NUMBER = 1;
  private int version_ = 0;
  /**
   * <code>int32 version = 1;</code>
   * @return The version.
   */
  @java.lang.Override
  public int getVersion() {
    return version_;
  }

  public static final int CREATEDAT_FIELD_NUMBER = 2;
  private com.tiwari.studence.proto.time.TimePb createdAt_;
  /**
   * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
   * @return Whether the createdAt field is set.
   */
  @java.lang.Override
  public boolean hasCreatedAt() {
    return createdAt_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
   * @return The createdAt.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.time.TimePb getCreatedAt() {
    return createdAt_ == null ? com.tiwari.studence.proto.time.TimePb.getDefaultInstance() : createdAt_;
  }
  /**
   * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.time.TimePbOrBuilder getCreatedAtOrBuilder() {
    return createdAt_ == null ? com.tiwari.studence.proto.time.TimePb.getDefaultInstance() : createdAt_;
  }

  public static final int UPDATEDAT_FIELD_NUMBER = 3;
  private com.tiwari.studence.proto.time.TimePb updatedAt_;
  /**
   * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
   * @return Whether the updatedAt field is set.
   */
  @java.lang.Override
  public boolean hasUpdatedAt() {
    return updatedAt_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
   * @return The updatedAt.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.time.TimePb getUpdatedAt() {
    return updatedAt_ == null ? com.tiwari.studence.proto.time.TimePb.getDefaultInstance() : updatedAt_;
  }
  /**
   * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.time.TimePbOrBuilder getUpdatedAtOrBuilder() {
    return updatedAt_ == null ? com.tiwari.studence.proto.time.TimePb.getDefaultInstance() : updatedAt_;
  }

  public static final int UPDATEDBY_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object updatedBy_ = "";
  /**
   * <code>string updatedBy = 4;</code>
   * @return The updatedBy.
   */
  @java.lang.Override
  public java.lang.String getUpdatedBy() {
    java.lang.Object ref = updatedBy_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      updatedBy_ = s;
      return s;
    }
  }
  /**
   * <code>string updatedBy = 4;</code>
   * @return The bytes for updatedBy.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getUpdatedByBytes() {
    java.lang.Object ref = updatedBy_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      updatedBy_ = b;
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
    if (version_ != 0) {
      output.writeInt32(1, version_);
    }
    if (createdAt_ != null) {
      output.writeMessage(2, getCreatedAt());
    }
    if (updatedAt_ != null) {
      output.writeMessage(3, getUpdatedAt());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(updatedBy_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, updatedBy_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (version_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, version_);
    }
    if (createdAt_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getCreatedAt());
    }
    if (updatedAt_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getUpdatedAt());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(updatedBy_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, updatedBy_);
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
    if (!(obj instanceof com.tiwari.studence.proto.entity.PbConfig)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.entity.PbConfig other = (com.tiwari.studence.proto.entity.PbConfig) obj;

    if (getVersion()
        != other.getVersion()) return false;
    if (hasCreatedAt() != other.hasCreatedAt()) return false;
    if (hasCreatedAt()) {
      if (!getCreatedAt()
          .equals(other.getCreatedAt())) return false;
    }
    if (hasUpdatedAt() != other.hasUpdatedAt()) return false;
    if (hasUpdatedAt()) {
      if (!getUpdatedAt()
          .equals(other.getUpdatedAt())) return false;
    }
    if (!getUpdatedBy()
        .equals(other.getUpdatedBy())) return false;
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
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + getVersion();
    if (hasCreatedAt()) {
      hash = (37 * hash) + CREATEDAT_FIELD_NUMBER;
      hash = (53 * hash) + getCreatedAt().hashCode();
    }
    if (hasUpdatedAt()) {
      hash = (37 * hash) + UPDATEDAT_FIELD_NUMBER;
      hash = (53 * hash) + getUpdatedAt().hashCode();
    }
    hash = (37 * hash) + UPDATEDBY_FIELD_NUMBER;
    hash = (53 * hash) + getUpdatedBy().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.entity.PbConfig parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.entity.PbConfig prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.entity.PbConfig}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.entity.PbConfig)
      com.tiwari.studence.proto.entity.PbConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.entity.EntityPbOuterClass.internal_static_com_tiwari_studence_proto_entity_PbConfig_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.entity.EntityPbOuterClass.internal_static_com_tiwari_studence_proto_entity_PbConfig_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.entity.PbConfig.class, com.tiwari.studence.proto.entity.PbConfig.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.entity.PbConfig.newBuilder()
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
      version_ = 0;
      createdAt_ = null;
      if (createdAtBuilder_ != null) {
        createdAtBuilder_.dispose();
        createdAtBuilder_ = null;
      }
      updatedAt_ = null;
      if (updatedAtBuilder_ != null) {
        updatedAtBuilder_.dispose();
        updatedAtBuilder_ = null;
      }
      updatedBy_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.entity.EntityPbOuterClass.internal_static_com_tiwari_studence_proto_entity_PbConfig_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.entity.PbConfig getDefaultInstanceForType() {
      return com.tiwari.studence.proto.entity.PbConfig.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.entity.PbConfig build() {
      com.tiwari.studence.proto.entity.PbConfig result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.entity.PbConfig buildPartial() {
      com.tiwari.studence.proto.entity.PbConfig result = new com.tiwari.studence.proto.entity.PbConfig(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.entity.PbConfig result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.version_ = version_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.createdAt_ = createdAtBuilder_ == null
            ? createdAt_
            : createdAtBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.updatedAt_ = updatedAtBuilder_ == null
            ? updatedAt_
            : updatedAtBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.updatedBy_ = updatedBy_;
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
      if (other instanceof com.tiwari.studence.proto.entity.PbConfig) {
        return mergeFrom((com.tiwari.studence.proto.entity.PbConfig)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.entity.PbConfig other) {
      if (other == com.tiwari.studence.proto.entity.PbConfig.getDefaultInstance()) return this;
      if (other.getVersion() != 0) {
        setVersion(other.getVersion());
      }
      if (other.hasCreatedAt()) {
        mergeCreatedAt(other.getCreatedAt());
      }
      if (other.hasUpdatedAt()) {
        mergeUpdatedAt(other.getUpdatedAt());
      }
      if (!other.getUpdatedBy().isEmpty()) {
        updatedBy_ = other.updatedBy_;
        bitField0_ |= 0x00000008;
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
            case 8: {
              version_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              input.readMessage(
                  getCreatedAtFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getUpdatedAtFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              updatedBy_ = input.readStringRequireUtf8();
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

    private int version_ ;
    /**
     * <code>int32 version = 1;</code>
     * @return The version.
     */
    @java.lang.Override
    public int getVersion() {
      return version_;
    }
    /**
     * <code>int32 version = 1;</code>
     * @param value The version to set.
     * @return This builder for chaining.
     */
    public Builder setVersion(int value) {
      
      version_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 version = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearVersion() {
      bitField0_ = (bitField0_ & ~0x00000001);
      version_ = 0;
      onChanged();
      return this;
    }

    private com.tiwari.studence.proto.time.TimePb createdAt_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.time.TimePb, com.tiwari.studence.proto.time.TimePb.Builder, com.tiwari.studence.proto.time.TimePbOrBuilder> createdAtBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     * @return Whether the createdAt field is set.
     */
    public boolean hasCreatedAt() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     * @return The createdAt.
     */
    public com.tiwari.studence.proto.time.TimePb getCreatedAt() {
      if (createdAtBuilder_ == null) {
        return createdAt_ == null ? com.tiwari.studence.proto.time.TimePb.getDefaultInstance() : createdAt_;
      } else {
        return createdAtBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     */
    public Builder setCreatedAt(com.tiwari.studence.proto.time.TimePb value) {
      if (createdAtBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        createdAt_ = value;
      } else {
        createdAtBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     */
    public Builder setCreatedAt(
        com.tiwari.studence.proto.time.TimePb.Builder builderForValue) {
      if (createdAtBuilder_ == null) {
        createdAt_ = builderForValue.build();
      } else {
        createdAtBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     */
    public Builder mergeCreatedAt(com.tiwari.studence.proto.time.TimePb value) {
      if (createdAtBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          createdAt_ != null &&
          createdAt_ != com.tiwari.studence.proto.time.TimePb.getDefaultInstance()) {
          getCreatedAtBuilder().mergeFrom(value);
        } else {
          createdAt_ = value;
        }
      } else {
        createdAtBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     */
    public Builder clearCreatedAt() {
      bitField0_ = (bitField0_ & ~0x00000002);
      createdAt_ = null;
      if (createdAtBuilder_ != null) {
        createdAtBuilder_.dispose();
        createdAtBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     */
    public com.tiwari.studence.proto.time.TimePb.Builder getCreatedAtBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getCreatedAtFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     */
    public com.tiwari.studence.proto.time.TimePbOrBuilder getCreatedAtOrBuilder() {
      if (createdAtBuilder_ != null) {
        return createdAtBuilder_.getMessageOrBuilder();
      } else {
        return createdAt_ == null ?
            com.tiwari.studence.proto.time.TimePb.getDefaultInstance() : createdAt_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb createdAt = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.time.TimePb, com.tiwari.studence.proto.time.TimePb.Builder, com.tiwari.studence.proto.time.TimePbOrBuilder> 
        getCreatedAtFieldBuilder() {
      if (createdAtBuilder_ == null) {
        createdAtBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.time.TimePb, com.tiwari.studence.proto.time.TimePb.Builder, com.tiwari.studence.proto.time.TimePbOrBuilder>(
                getCreatedAt(),
                getParentForChildren(),
                isClean());
        createdAt_ = null;
      }
      return createdAtBuilder_;
    }

    private com.tiwari.studence.proto.time.TimePb updatedAt_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.time.TimePb, com.tiwari.studence.proto.time.TimePb.Builder, com.tiwari.studence.proto.time.TimePbOrBuilder> updatedAtBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     * @return Whether the updatedAt field is set.
     */
    public boolean hasUpdatedAt() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     * @return The updatedAt.
     */
    public com.tiwari.studence.proto.time.TimePb getUpdatedAt() {
      if (updatedAtBuilder_ == null) {
        return updatedAt_ == null ? com.tiwari.studence.proto.time.TimePb.getDefaultInstance() : updatedAt_;
      } else {
        return updatedAtBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     */
    public Builder setUpdatedAt(com.tiwari.studence.proto.time.TimePb value) {
      if (updatedAtBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        updatedAt_ = value;
      } else {
        updatedAtBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     */
    public Builder setUpdatedAt(
        com.tiwari.studence.proto.time.TimePb.Builder builderForValue) {
      if (updatedAtBuilder_ == null) {
        updatedAt_ = builderForValue.build();
      } else {
        updatedAtBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     */
    public Builder mergeUpdatedAt(com.tiwari.studence.proto.time.TimePb value) {
      if (updatedAtBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          updatedAt_ != null &&
          updatedAt_ != com.tiwari.studence.proto.time.TimePb.getDefaultInstance()) {
          getUpdatedAtBuilder().mergeFrom(value);
        } else {
          updatedAt_ = value;
        }
      } else {
        updatedAtBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     */
    public Builder clearUpdatedAt() {
      bitField0_ = (bitField0_ & ~0x00000004);
      updatedAt_ = null;
      if (updatedAtBuilder_ != null) {
        updatedAtBuilder_.dispose();
        updatedAtBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     */
    public com.tiwari.studence.proto.time.TimePb.Builder getUpdatedAtBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getUpdatedAtFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     */
    public com.tiwari.studence.proto.time.TimePbOrBuilder getUpdatedAtOrBuilder() {
      if (updatedAtBuilder_ != null) {
        return updatedAtBuilder_.getMessageOrBuilder();
      } else {
        return updatedAt_ == null ?
            com.tiwari.studence.proto.time.TimePb.getDefaultInstance() : updatedAt_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.time.TimePb updatedAt = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.time.TimePb, com.tiwari.studence.proto.time.TimePb.Builder, com.tiwari.studence.proto.time.TimePbOrBuilder> 
        getUpdatedAtFieldBuilder() {
      if (updatedAtBuilder_ == null) {
        updatedAtBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.time.TimePb, com.tiwari.studence.proto.time.TimePb.Builder, com.tiwari.studence.proto.time.TimePbOrBuilder>(
                getUpdatedAt(),
                getParentForChildren(),
                isClean());
        updatedAt_ = null;
      }
      return updatedAtBuilder_;
    }

    private java.lang.Object updatedBy_ = "";
    /**
     * <code>string updatedBy = 4;</code>
     * @return The updatedBy.
     */
    public java.lang.String getUpdatedBy() {
      java.lang.Object ref = updatedBy_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        updatedBy_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string updatedBy = 4;</code>
     * @return The bytes for updatedBy.
     */
    public com.google.protobuf.ByteString
        getUpdatedByBytes() {
      java.lang.Object ref = updatedBy_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        updatedBy_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string updatedBy = 4;</code>
     * @param value The updatedBy to set.
     * @return This builder for chaining.
     */
    public Builder setUpdatedBy(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      updatedBy_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string updatedBy = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearUpdatedBy() {
      updatedBy_ = getDefaultInstance().getUpdatedBy();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string updatedBy = 4;</code>
     * @param value The bytes for updatedBy to set.
     * @return This builder for chaining.
     */
    public Builder setUpdatedByBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      updatedBy_ = value;
      bitField0_ |= 0x00000008;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.entity.PbConfig)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.entity.PbConfig)
  private static final com.tiwari.studence.proto.entity.PbConfig DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.entity.PbConfig();
  }

  public static com.tiwari.studence.proto.entity.PbConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PbConfig>
      PARSER = new com.google.protobuf.AbstractParser<PbConfig>() {
    @java.lang.Override
    public PbConfig parsePartialFrom(
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

  public static com.google.protobuf.Parser<PbConfig> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PbConfig> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.entity.PbConfig getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

