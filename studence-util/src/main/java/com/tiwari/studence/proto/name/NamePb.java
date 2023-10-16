// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: namePb.proto

package com.tiwari.studence.proto.name;

/**
 * Protobuf type {@code com.tiwari.studence.proto.name.NamePb}
 */
public final class NamePb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.name.NamePb)
    NamePbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NamePb.newBuilder() to construct.
  private NamePb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NamePb() {
    firstName_ = "";
    middleName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    lastName_ = "";
    canonicalName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new NamePb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.name.NamePbOuterClass.internal_static_com_tiwari_studence_proto_name_NamePb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.name.NamePbOuterClass.internal_static_com_tiwari_studence_proto_name_NamePb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.name.NamePb.class, com.tiwari.studence.proto.name.NamePb.Builder.class);
  }

  public static final int FIRSTNAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object firstName_ = "";
  /**
   * <code>string firstName = 1;</code>
   * @return The firstName.
   */
  @java.lang.Override
  public java.lang.String getFirstName() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      firstName_ = s;
      return s;
    }
  }
  /**
   * <code>string firstName = 1;</code>
   * @return The bytes for firstName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFirstNameBytes() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      firstName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MIDDLENAME_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringList middleName_;
  /**
   * <code>repeated string middleName = 2;</code>
   * @return A list containing the middleName.
   */
  public com.google.protobuf.ProtocolStringList
      getMiddleNameList() {
    return middleName_;
  }
  /**
   * <code>repeated string middleName = 2;</code>
   * @return The count of middleName.
   */
  public int getMiddleNameCount() {
    return middleName_.size();
  }
  /**
   * <code>repeated string middleName = 2;</code>
   * @param index The index of the element to return.
   * @return The middleName at the given index.
   */
  public java.lang.String getMiddleName(int index) {
    return middleName_.get(index);
  }
  /**
   * <code>repeated string middleName = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the middleName at the given index.
   */
  public com.google.protobuf.ByteString
      getMiddleNameBytes(int index) {
    return middleName_.getByteString(index);
  }

  public static final int LASTNAME_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object lastName_ = "";
  /**
   * <code>string lastName = 3;</code>
   * @return The lastName.
   */
  @java.lang.Override
  public java.lang.String getLastName() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      lastName_ = s;
      return s;
    }
  }
  /**
   * <code>string lastName = 3;</code>
   * @return The bytes for lastName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getLastNameBytes() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      lastName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CANONICALNAME_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object canonicalName_ = "";
  /**
   * <code>string canonicalName = 4;</code>
   * @return The canonicalName.
   */
  @java.lang.Override
  public java.lang.String getCanonicalName() {
    java.lang.Object ref = canonicalName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      canonicalName_ = s;
      return s;
    }
  }
  /**
   * <code>string canonicalName = 4;</code>
   * @return The bytes for canonicalName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCanonicalNameBytes() {
    java.lang.Object ref = canonicalName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      canonicalName_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(firstName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, firstName_);
    }
    for (int i = 0; i < middleName_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, middleName_.getRaw(i));
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(lastName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, lastName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(canonicalName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, canonicalName_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(firstName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, firstName_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < middleName_.size(); i++) {
        dataSize += computeStringSizeNoTag(middleName_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getMiddleNameList().size();
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(lastName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, lastName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(canonicalName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, canonicalName_);
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
    if (!(obj instanceof com.tiwari.studence.proto.name.NamePb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.name.NamePb other = (com.tiwari.studence.proto.name.NamePb) obj;

    if (!getFirstName()
        .equals(other.getFirstName())) return false;
    if (!getMiddleNameList()
        .equals(other.getMiddleNameList())) return false;
    if (!getLastName()
        .equals(other.getLastName())) return false;
    if (!getCanonicalName()
        .equals(other.getCanonicalName())) return false;
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
    hash = (37 * hash) + FIRSTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getFirstName().hashCode();
    if (getMiddleNameCount() > 0) {
      hash = (37 * hash) + MIDDLENAME_FIELD_NUMBER;
      hash = (53 * hash) + getMiddleNameList().hashCode();
    }
    hash = (37 * hash) + LASTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getLastName().hashCode();
    hash = (37 * hash) + CANONICALNAME_FIELD_NUMBER;
    hash = (53 * hash) + getCanonicalName().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.name.NamePb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.name.NamePb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.name.NamePb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.name.NamePb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.name.NamePb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.name.NamePb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.name.NamePb)
      com.tiwari.studence.proto.name.NamePbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.name.NamePbOuterClass.internal_static_com_tiwari_studence_proto_name_NamePb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.name.NamePbOuterClass.internal_static_com_tiwari_studence_proto_name_NamePb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.name.NamePb.class, com.tiwari.studence.proto.name.NamePb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.name.NamePb.newBuilder()
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
      firstName_ = "";
      middleName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      lastName_ = "";
      canonicalName_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.name.NamePbOuterClass.internal_static_com_tiwari_studence_proto_name_NamePb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.name.NamePb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.name.NamePb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.name.NamePb build() {
      com.tiwari.studence.proto.name.NamePb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.name.NamePb buildPartial() {
      com.tiwari.studence.proto.name.NamePb result = new com.tiwari.studence.proto.name.NamePb(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.tiwari.studence.proto.name.NamePb result) {
      if (((bitField0_ & 0x00000002) != 0)) {
        middleName_ = middleName_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.middleName_ = middleName_;
    }

    private void buildPartial0(com.tiwari.studence.proto.name.NamePb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.firstName_ = firstName_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.lastName_ = lastName_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.canonicalName_ = canonicalName_;
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
      if (other instanceof com.tiwari.studence.proto.name.NamePb) {
        return mergeFrom((com.tiwari.studence.proto.name.NamePb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.name.NamePb other) {
      if (other == com.tiwari.studence.proto.name.NamePb.getDefaultInstance()) return this;
      if (!other.getFirstName().isEmpty()) {
        firstName_ = other.firstName_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.middleName_.isEmpty()) {
        if (middleName_.isEmpty()) {
          middleName_ = other.middleName_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureMiddleNameIsMutable();
          middleName_.addAll(other.middleName_);
        }
        onChanged();
      }
      if (!other.getLastName().isEmpty()) {
        lastName_ = other.lastName_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.getCanonicalName().isEmpty()) {
        canonicalName_ = other.canonicalName_;
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
            case 10: {
              firstName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureMiddleNameIsMutable();
              middleName_.add(s);
              break;
            } // case 18
            case 26: {
              lastName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              canonicalName_ = input.readStringRequireUtf8();
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

    private java.lang.Object firstName_ = "";
    /**
     * <code>string firstName = 1;</code>
     * @return The firstName.
     */
    public java.lang.String getFirstName() {
      java.lang.Object ref = firstName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        firstName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string firstName = 1;</code>
     * @return The bytes for firstName.
     */
    public com.google.protobuf.ByteString
        getFirstNameBytes() {
      java.lang.Object ref = firstName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firstName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string firstName = 1;</code>
     * @param value The firstName to set.
     * @return This builder for chaining.
     */
    public Builder setFirstName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      firstName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string firstName = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFirstName() {
      firstName_ = getDefaultInstance().getFirstName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string firstName = 1;</code>
     * @param value The bytes for firstName to set.
     * @return This builder for chaining.
     */
    public Builder setFirstNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      firstName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList middleName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureMiddleNameIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        middleName_ = new com.google.protobuf.LazyStringArrayList(middleName_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @return A list containing the middleName.
     */
    public com.google.protobuf.ProtocolStringList
        getMiddleNameList() {
      return middleName_.getUnmodifiableView();
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @return The count of middleName.
     */
    public int getMiddleNameCount() {
      return middleName_.size();
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @param index The index of the element to return.
     * @return The middleName at the given index.
     */
    public java.lang.String getMiddleName(int index) {
      return middleName_.get(index);
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the middleName at the given index.
     */
    public com.google.protobuf.ByteString
        getMiddleNameBytes(int index) {
      return middleName_.getByteString(index);
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @param index The index to set the value at.
     * @param value The middleName to set.
     * @return This builder for chaining.
     */
    public Builder setMiddleName(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureMiddleNameIsMutable();
      middleName_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @param value The middleName to add.
     * @return This builder for chaining.
     */
    public Builder addMiddleName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureMiddleNameIsMutable();
      middleName_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @param values The middleName to add.
     * @return This builder for chaining.
     */
    public Builder addAllMiddleName(
        java.lang.Iterable<java.lang.String> values) {
      ensureMiddleNameIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, middleName_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMiddleName() {
      middleName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string middleName = 2;</code>
     * @param value The bytes of the middleName to add.
     * @return This builder for chaining.
     */
    public Builder addMiddleNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensureMiddleNameIsMutable();
      middleName_.add(value);
      onChanged();
      return this;
    }

    private java.lang.Object lastName_ = "";
    /**
     * <code>string lastName = 3;</code>
     * @return The lastName.
     */
    public java.lang.String getLastName() {
      java.lang.Object ref = lastName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lastName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string lastName = 3;</code>
     * @return The bytes for lastName.
     */
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      java.lang.Object ref = lastName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string lastName = 3;</code>
     * @param value The lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      lastName_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string lastName = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastName() {
      lastName_ = getDefaultInstance().getLastName();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string lastName = 3;</code>
     * @param value The bytes for lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      lastName_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private java.lang.Object canonicalName_ = "";
    /**
     * <code>string canonicalName = 4;</code>
     * @return The canonicalName.
     */
    public java.lang.String getCanonicalName() {
      java.lang.Object ref = canonicalName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        canonicalName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string canonicalName = 4;</code>
     * @return The bytes for canonicalName.
     */
    public com.google.protobuf.ByteString
        getCanonicalNameBytes() {
      java.lang.Object ref = canonicalName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        canonicalName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string canonicalName = 4;</code>
     * @param value The canonicalName to set.
     * @return This builder for chaining.
     */
    public Builder setCanonicalName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      canonicalName_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string canonicalName = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearCanonicalName() {
      canonicalName_ = getDefaultInstance().getCanonicalName();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string canonicalName = 4;</code>
     * @param value The bytes for canonicalName to set.
     * @return This builder for chaining.
     */
    public Builder setCanonicalNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      canonicalName_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.name.NamePb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.name.NamePb)
  private static final com.tiwari.studence.proto.name.NamePb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.name.NamePb();
  }

  public static com.tiwari.studence.proto.name.NamePb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NamePb>
      PARSER = new com.google.protobuf.AbstractParser<NamePb>() {
    @java.lang.Override
    public NamePb parsePartialFrom(
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

  public static com.google.protobuf.Parser<NamePb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NamePb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.name.NamePb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

