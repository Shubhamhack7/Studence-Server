// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: organisationPb.proto

package com.tiwari.studence.proto.organisation;

/**
 * Protobuf type {@code com.tiwari.studence.proto.organisation.OrganisationSearchReqPb}
 */
public final class OrganisationSearchReqPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.organisation.OrganisationSearchReqPb)
    OrganisationSearchReqPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OrganisationSearchReqPb.newBuilder() to construct.
  private OrganisationSearchReqPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OrganisationSearchReqPb() {
    name_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new OrganisationSearchReqPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.organisation.OrganisationPbOuterClass.internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.organisation.OrganisationPbOuterClass.internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.organisation.OrganisationSearchReqPb.class, com.tiwari.studence.proto.organisation.OrganisationSearchReqPb.Builder.class);
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

  public static final int NAME_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object name_ = "";
  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
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
    if (!(obj instanceof com.tiwari.studence.proto.organisation.OrganisationSearchReqPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.organisation.OrganisationSearchReqPb other = (com.tiwari.studence.proto.organisation.OrganisationSearchReqPb) obj;

    if (hasDbInfo() != other.hasDbInfo()) return false;
    if (hasDbInfo()) {
      if (!getDbInfo()
          .equals(other.getDbInfo())) return false;
    }
    if (!getName()
        .equals(other.getName())) return false;
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
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.organisation.OrganisationSearchReqPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.organisation.OrganisationSearchReqPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.organisation.OrganisationSearchReqPb)
      com.tiwari.studence.proto.organisation.OrganisationSearchReqPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.organisation.OrganisationPbOuterClass.internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.organisation.OrganisationPbOuterClass.internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.organisation.OrganisationSearchReqPb.class, com.tiwari.studence.proto.organisation.OrganisationSearchReqPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.organisation.OrganisationSearchReqPb.newBuilder()
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
      name_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.organisation.OrganisationPbOuterClass.internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.organisation.OrganisationSearchReqPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.organisation.OrganisationSearchReqPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.organisation.OrganisationSearchReqPb build() {
      com.tiwari.studence.proto.organisation.OrganisationSearchReqPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.organisation.OrganisationSearchReqPb buildPartial() {
      com.tiwari.studence.proto.organisation.OrganisationSearchReqPb result = new com.tiwari.studence.proto.organisation.OrganisationSearchReqPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.organisation.OrganisationSearchReqPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.dbInfo_ = dbInfoBuilder_ == null
            ? dbInfo_
            : dbInfoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.name_ = name_;
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
      if (other instanceof com.tiwari.studence.proto.organisation.OrganisationSearchReqPb) {
        return mergeFrom((com.tiwari.studence.proto.organisation.OrganisationSearchReqPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.organisation.OrganisationSearchReqPb other) {
      if (other == com.tiwari.studence.proto.organisation.OrganisationSearchReqPb.getDefaultInstance()) return this;
      if (other.hasDbInfo()) {
        mergeDbInfo(other.getDbInfo());
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
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
              name_ = input.readStringRequireUtf8();
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

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 2;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      name_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      name_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.organisation.OrganisationSearchReqPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.organisation.OrganisationSearchReqPb)
  private static final com.tiwari.studence.proto.organisation.OrganisationSearchReqPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.organisation.OrganisationSearchReqPb();
  }

  public static com.tiwari.studence.proto.organisation.OrganisationSearchReqPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OrganisationSearchReqPb>
      PARSER = new com.google.protobuf.AbstractParser<OrganisationSearchReqPb>() {
    @java.lang.Override
    public OrganisationSearchReqPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<OrganisationSearchReqPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OrganisationSearchReqPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.organisation.OrganisationSearchReqPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

