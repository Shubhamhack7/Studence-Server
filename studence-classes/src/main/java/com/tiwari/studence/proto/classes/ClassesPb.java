// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: classPb.proto

package com.tiwari.studence.proto.classes;

/**
 * Protobuf type {@code com.tiwari.studence.proto.classes.ClassesPb}
 */
public final class ClassesPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.classes.ClassesPb)
    ClassesPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ClassesPb.newBuilder() to construct.
  private ClassesPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ClassesPb() {
    classType_ = 0;
    sectionType_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ClassesPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.classes.ClassPb.internal_static_com_tiwari_studence_proto_classes_ClassesPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.classes.ClassPb.internal_static_com_tiwari_studence_proto_classes_ClassesPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.classes.ClassesPb.class, com.tiwari.studence.proto.classes.ClassesPb.Builder.class);
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

  public static final int CAMPUSREF_FIELD_NUMBER = 4;
  private com.tiwari.studence.proto.campus.CampusRefPb campusRef_;
  /**
   * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
   * @return Whether the campusRef field is set.
   */
  @java.lang.Override
  public boolean hasCampusRef() {
    return campusRef_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
   * @return The campusRef.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.campus.CampusRefPb getCampusRef() {
    return campusRef_ == null ? com.tiwari.studence.proto.campus.CampusRefPb.getDefaultInstance() : campusRef_;
  }
  /**
   * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.campus.CampusRefPbOrBuilder getCampusRefOrBuilder() {
    return campusRef_ == null ? com.tiwari.studence.proto.campus.CampusRefPb.getDefaultInstance() : campusRef_;
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
    if (classType_ != com.tiwari.studence.proto.classes.ClassType.CLASS_UNKNOWN.getNumber()) {
      output.writeEnum(2, classType_);
    }
    if (sectionType_ != com.tiwari.studence.proto.classes.SectionType.SECTION_UNKNOWN.getNumber()) {
      output.writeEnum(3, sectionType_);
    }
    if (campusRef_ != null) {
      output.writeMessage(4, getCampusRef());
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
    if (classType_ != com.tiwari.studence.proto.classes.ClassType.CLASS_UNKNOWN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, classType_);
    }
    if (sectionType_ != com.tiwari.studence.proto.classes.SectionType.SECTION_UNKNOWN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, sectionType_);
    }
    if (campusRef_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getCampusRef());
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
    if (!(obj instanceof com.tiwari.studence.proto.classes.ClassesPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.classes.ClassesPb other = (com.tiwari.studence.proto.classes.ClassesPb) obj;

    if (hasDbInfo() != other.hasDbInfo()) return false;
    if (hasDbInfo()) {
      if (!getDbInfo()
          .equals(other.getDbInfo())) return false;
    }
    if (classType_ != other.classType_) return false;
    if (sectionType_ != other.sectionType_) return false;
    if (hasCampusRef() != other.hasCampusRef()) return false;
    if (hasCampusRef()) {
      if (!getCampusRef()
          .equals(other.getCampusRef())) return false;
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
    if (hasDbInfo()) {
      hash = (37 * hash) + DBINFO_FIELD_NUMBER;
      hash = (53 * hash) + getDbInfo().hashCode();
    }
    hash = (37 * hash) + CLASSTYPE_FIELD_NUMBER;
    hash = (53 * hash) + classType_;
    hash = (37 * hash) + SECTIONTYPE_FIELD_NUMBER;
    hash = (53 * hash) + sectionType_;
    if (hasCampusRef()) {
      hash = (37 * hash) + CAMPUSREF_FIELD_NUMBER;
      hash = (53 * hash) + getCampusRef().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.classes.ClassesPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.classes.ClassesPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.classes.ClassesPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.classes.ClassesPb)
      com.tiwari.studence.proto.classes.ClassesPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.classes.ClassPb.internal_static_com_tiwari_studence_proto_classes_ClassesPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.classes.ClassPb.internal_static_com_tiwari_studence_proto_classes_ClassesPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.classes.ClassesPb.class, com.tiwari.studence.proto.classes.ClassesPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.classes.ClassesPb.newBuilder()
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
      classType_ = 0;
      sectionType_ = 0;
      campusRef_ = null;
      if (campusRefBuilder_ != null) {
        campusRefBuilder_.dispose();
        campusRefBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.classes.ClassPb.internal_static_com_tiwari_studence_proto_classes_ClassesPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.classes.ClassesPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.classes.ClassesPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.classes.ClassesPb build() {
      com.tiwari.studence.proto.classes.ClassesPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.classes.ClassesPb buildPartial() {
      com.tiwari.studence.proto.classes.ClassesPb result = new com.tiwari.studence.proto.classes.ClassesPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.classes.ClassesPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.dbInfo_ = dbInfoBuilder_ == null
            ? dbInfo_
            : dbInfoBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.classType_ = classType_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.sectionType_ = sectionType_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.campusRef_ = campusRefBuilder_ == null
            ? campusRef_
            : campusRefBuilder_.build();
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
      if (other instanceof com.tiwari.studence.proto.classes.ClassesPb) {
        return mergeFrom((com.tiwari.studence.proto.classes.ClassesPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.classes.ClassesPb other) {
      if (other == com.tiwari.studence.proto.classes.ClassesPb.getDefaultInstance()) return this;
      if (other.hasDbInfo()) {
        mergeDbInfo(other.getDbInfo());
      }
      if (other.classType_ != 0) {
        setClassTypeValue(other.getClassTypeValue());
      }
      if (other.sectionType_ != 0) {
        setSectionTypeValue(other.getSectionTypeValue());
      }
      if (other.hasCampusRef()) {
        mergeCampusRef(other.getCampusRef());
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
            case 34: {
              input.readMessage(
                  getCampusRefFieldBuilder().getBuilder(),
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

    private com.tiwari.studence.proto.campus.CampusRefPb campusRef_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.campus.CampusRefPb, com.tiwari.studence.proto.campus.CampusRefPb.Builder, com.tiwari.studence.proto.campus.CampusRefPbOrBuilder> campusRefBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     * @return Whether the campusRef field is set.
     */
    public boolean hasCampusRef() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     * @return The campusRef.
     */
    public com.tiwari.studence.proto.campus.CampusRefPb getCampusRef() {
      if (campusRefBuilder_ == null) {
        return campusRef_ == null ? com.tiwari.studence.proto.campus.CampusRefPb.getDefaultInstance() : campusRef_;
      } else {
        return campusRefBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     */
    public Builder setCampusRef(com.tiwari.studence.proto.campus.CampusRefPb value) {
      if (campusRefBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        campusRef_ = value;
      } else {
        campusRefBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     */
    public Builder setCampusRef(
        com.tiwari.studence.proto.campus.CampusRefPb.Builder builderForValue) {
      if (campusRefBuilder_ == null) {
        campusRef_ = builderForValue.build();
      } else {
        campusRefBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     */
    public Builder mergeCampusRef(com.tiwari.studence.proto.campus.CampusRefPb value) {
      if (campusRefBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0) &&
          campusRef_ != null &&
          campusRef_ != com.tiwari.studence.proto.campus.CampusRefPb.getDefaultInstance()) {
          getCampusRefBuilder().mergeFrom(value);
        } else {
          campusRef_ = value;
        }
      } else {
        campusRefBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     */
    public Builder clearCampusRef() {
      bitField0_ = (bitField0_ & ~0x00000008);
      campusRef_ = null;
      if (campusRefBuilder_ != null) {
        campusRefBuilder_.dispose();
        campusRefBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     */
    public com.tiwari.studence.proto.campus.CampusRefPb.Builder getCampusRefBuilder() {
      bitField0_ |= 0x00000008;
      onChanged();
      return getCampusRefFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     */
    public com.tiwari.studence.proto.campus.CampusRefPbOrBuilder getCampusRefOrBuilder() {
      if (campusRefBuilder_ != null) {
        return campusRefBuilder_.getMessageOrBuilder();
      } else {
        return campusRef_ == null ?
            com.tiwari.studence.proto.campus.CampusRefPb.getDefaultInstance() : campusRef_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.campus.CampusRefPb, com.tiwari.studence.proto.campus.CampusRefPb.Builder, com.tiwari.studence.proto.campus.CampusRefPbOrBuilder> 
        getCampusRefFieldBuilder() {
      if (campusRefBuilder_ == null) {
        campusRefBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.campus.CampusRefPb, com.tiwari.studence.proto.campus.CampusRefPb.Builder, com.tiwari.studence.proto.campus.CampusRefPbOrBuilder>(
                getCampusRef(),
                getParentForChildren(),
                isClean());
        campusRef_ = null;
      }
      return campusRefBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.classes.ClassesPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.classes.ClassesPb)
  private static final com.tiwari.studence.proto.classes.ClassesPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.classes.ClassesPb();
  }

  public static com.tiwari.studence.proto.classes.ClassesPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ClassesPb>
      PARSER = new com.google.protobuf.AbstractParser<ClassesPb>() {
    @java.lang.Override
    public ClassesPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<ClassesPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ClassesPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.classes.ClassesPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

