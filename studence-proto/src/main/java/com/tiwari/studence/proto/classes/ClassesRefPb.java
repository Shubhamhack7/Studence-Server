// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: classesPb.proto

package com.tiwari.studence.proto.classes;

/**
 * Protobuf type {@code com.tiwari.studence.proto.classes.ClassesRefPb}
 */
public final class ClassesRefPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.classes.ClassesRefPb)
    ClassesRefPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ClassesRefPb.newBuilder() to construct.
  private ClassesRefPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ClassesRefPb() {
    dbInfoId_ = "";
    classType_ = 0;
    sectionType_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ClassesRefPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.classes.ClassesPbOuterClass.internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.classes.ClassesPbOuterClass.internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.classes.ClassesRefPb.class, com.tiwari.studence.proto.classes.ClassesRefPb.Builder.class);
  }

  public static final int DBINFOID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object dbInfoId_ = "";
  /**
   * <code>string dbInfoId = 1;</code>
   * @return The dbInfoId.
   */
  @java.lang.Override
  public java.lang.String getDbInfoId() {
    java.lang.Object ref = dbInfoId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dbInfoId_ = s;
      return s;
    }
  }
  /**
   * <code>string dbInfoId = 1;</code>
   * @return The bytes for dbInfoId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDbInfoIdBytes() {
    java.lang.Object ref = dbInfoId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dbInfoId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CLASSTYPE_FIELD_NUMBER = 2;
  private int classType_ = 0;
  /**
   * <code>.com.tiwari.studence.proto.classes.ClassType classType = 2;</code>
   * @return The enum numeric value on the wire for classType.
   */
  @java.lang.Override public int getClassTypeValue() {
    return classType_;
  }
  /**
   * <code>.com.tiwari.studence.proto.classes.ClassType classType = 2;</code>
   * @return The classType.
   */
  @java.lang.Override public com.tiwari.studence.proto.classes.ClassType getClassType() {
    com.tiwari.studence.proto.classes.ClassType result = com.tiwari.studence.proto.classes.ClassType.forNumber(classType_);
    return result == null ? com.tiwari.studence.proto.classes.ClassType.UNRECOGNIZED : result;
  }

  public static final int SECTIONTYPE_FIELD_NUMBER = 3;
  private int sectionType_ = 0;
  /**
   * <code>.com.tiwari.studence.proto.classes.SectionType sectionType = 3;</code>
   * @return The enum numeric value on the wire for sectionType.
   */
  @java.lang.Override public int getSectionTypeValue() {
    return sectionType_;
  }
  /**
   * <code>.com.tiwari.studence.proto.classes.SectionType sectionType = 3;</code>
   * @return The sectionType.
   */
  @java.lang.Override public com.tiwari.studence.proto.classes.SectionType getSectionType() {
    com.tiwari.studence.proto.classes.SectionType result = com.tiwari.studence.proto.classes.SectionType.forNumber(sectionType_);
    return result == null ? com.tiwari.studence.proto.classes.SectionType.UNRECOGNIZED : result;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(dbInfoId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, dbInfoId_);
    }
    if (classType_ != com.tiwari.studence.proto.classes.ClassType.CLASS_UNKNOWN.getNumber()) {
      output.writeEnum(2, classType_);
    }
    if (sectionType_ != com.tiwari.studence.proto.classes.SectionType.SECTION_UNKNOWN.getNumber()) {
      output.writeEnum(3, sectionType_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(dbInfoId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, dbInfoId_);
    }
    if (classType_ != com.tiwari.studence.proto.classes.ClassType.CLASS_UNKNOWN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, classType_);
    }
    if (sectionType_ != com.tiwari.studence.proto.classes.SectionType.SECTION_UNKNOWN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, sectionType_);
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
    if (!(obj instanceof com.tiwari.studence.proto.classes.ClassesRefPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.classes.ClassesRefPb other = (com.tiwari.studence.proto.classes.ClassesRefPb) obj;

    if (!getDbInfoId()
        .equals(other.getDbInfoId())) return false;
    if (classType_ != other.classType_) return false;
    if (sectionType_ != other.sectionType_) return false;
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
    hash = (37 * hash) + DBINFOID_FIELD_NUMBER;
    hash = (53 * hash) + getDbInfoId().hashCode();
    hash = (37 * hash) + CLASSTYPE_FIELD_NUMBER;
    hash = (53 * hash) + classType_;
    hash = (37 * hash) + SECTIONTYPE_FIELD_NUMBER;
    hash = (53 * hash) + sectionType_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.classes.ClassesRefPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.classes.ClassesRefPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.classes.ClassesRefPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.classes.ClassesRefPb)
      com.tiwari.studence.proto.classes.ClassesRefPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.classes.ClassesPbOuterClass.internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.classes.ClassesPbOuterClass.internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.classes.ClassesRefPb.class, com.tiwari.studence.proto.classes.ClassesRefPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.classes.ClassesRefPb.newBuilder()
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
      dbInfoId_ = "";
      classType_ = 0;
      sectionType_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.classes.ClassesPbOuterClass.internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.classes.ClassesRefPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.classes.ClassesRefPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.classes.ClassesRefPb build() {
      com.tiwari.studence.proto.classes.ClassesRefPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.classes.ClassesRefPb buildPartial() {
      com.tiwari.studence.proto.classes.ClassesRefPb result = new com.tiwari.studence.proto.classes.ClassesRefPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.classes.ClassesRefPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.dbInfoId_ = dbInfoId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.classType_ = classType_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.sectionType_ = sectionType_;
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
      if (other instanceof com.tiwari.studence.proto.classes.ClassesRefPb) {
        return mergeFrom((com.tiwari.studence.proto.classes.ClassesRefPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.classes.ClassesRefPb other) {
      if (other == com.tiwari.studence.proto.classes.ClassesRefPb.getDefaultInstance()) return this;
      if (!other.getDbInfoId().isEmpty()) {
        dbInfoId_ = other.dbInfoId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.classType_ != 0) {
        setClassTypeValue(other.getClassTypeValue());
      }
      if (other.sectionType_ != 0) {
        setSectionTypeValue(other.getSectionTypeValue());
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
              dbInfoId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              classType_ = input.readEnum();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              sectionType_ = input.readEnum();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
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

    private java.lang.Object dbInfoId_ = "";
    /**
     * <code>string dbInfoId = 1;</code>
     * @return The dbInfoId.
     */
    public java.lang.String getDbInfoId() {
      java.lang.Object ref = dbInfoId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dbInfoId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dbInfoId = 1;</code>
     * @return The bytes for dbInfoId.
     */
    public com.google.protobuf.ByteString
        getDbInfoIdBytes() {
      java.lang.Object ref = dbInfoId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dbInfoId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dbInfoId = 1;</code>
     * @param value The dbInfoId to set.
     * @return This builder for chaining.
     */
    public Builder setDbInfoId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      dbInfoId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string dbInfoId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDbInfoId() {
      dbInfoId_ = getDefaultInstance().getDbInfoId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string dbInfoId = 1;</code>
     * @param value The bytes for dbInfoId to set.
     * @return This builder for chaining.
     */
    public Builder setDbInfoIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      dbInfoId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private int classType_ = 0;
    /**
     * <code>.com.tiwari.studence.proto.classes.ClassType classType = 2;</code>
     * @return The enum numeric value on the wire for classType.
     */
    @java.lang.Override public int getClassTypeValue() {
      return classType_;
    }
    /**
     * <code>.com.tiwari.studence.proto.classes.ClassType classType = 2;</code>
     * @param value The enum numeric value on the wire for classType to set.
     * @return This builder for chaining.
     */
    public Builder setClassTypeValue(int value) {
      classType_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.classes.ClassType classType = 2;</code>
     * @return The classType.
     */
    @java.lang.Override
    public com.tiwari.studence.proto.classes.ClassType getClassType() {
      com.tiwari.studence.proto.classes.ClassType result = com.tiwari.studence.proto.classes.ClassType.forNumber(classType_);
      return result == null ? com.tiwari.studence.proto.classes.ClassType.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.tiwari.studence.proto.classes.ClassType classType = 2;</code>
     * @param value The classType to set.
     * @return This builder for chaining.
     */
    public Builder setClassType(com.tiwari.studence.proto.classes.ClassType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      classType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.classes.ClassType classType = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearClassType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      classType_ = 0;
      onChanged();
      return this;
    }

    private int sectionType_ = 0;
    /**
     * <code>.com.tiwari.studence.proto.classes.SectionType sectionType = 3;</code>
     * @return The enum numeric value on the wire for sectionType.
     */
    @java.lang.Override public int getSectionTypeValue() {
      return sectionType_;
    }
    /**
     * <code>.com.tiwari.studence.proto.classes.SectionType sectionType = 3;</code>
     * @param value The enum numeric value on the wire for sectionType to set.
     * @return This builder for chaining.
     */
    public Builder setSectionTypeValue(int value) {
      sectionType_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.classes.SectionType sectionType = 3;</code>
     * @return The sectionType.
     */
    @java.lang.Override
    public com.tiwari.studence.proto.classes.SectionType getSectionType() {
      com.tiwari.studence.proto.classes.SectionType result = com.tiwari.studence.proto.classes.SectionType.forNumber(sectionType_);
      return result == null ? com.tiwari.studence.proto.classes.SectionType.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.tiwari.studence.proto.classes.SectionType sectionType = 3;</code>
     * @param value The sectionType to set.
     * @return This builder for chaining.
     */
    public Builder setSectionType(com.tiwari.studence.proto.classes.SectionType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      sectionType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.classes.SectionType sectionType = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSectionType() {
      bitField0_ = (bitField0_ & ~0x00000004);
      sectionType_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.classes.ClassesRefPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.classes.ClassesRefPb)
  private static final com.tiwari.studence.proto.classes.ClassesRefPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.classes.ClassesRefPb();
  }

  public static com.tiwari.studence.proto.classes.ClassesRefPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ClassesRefPb>
      PARSER = new com.google.protobuf.AbstractParser<ClassesRefPb>() {
    @java.lang.Override
    public ClassesRefPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<ClassesRefPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ClassesRefPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.classes.ClassesRefPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

