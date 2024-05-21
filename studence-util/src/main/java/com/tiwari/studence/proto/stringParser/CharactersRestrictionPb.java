// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stringParserConfig.proto

package com.tiwari.studence.proto.stringParser;

/**
 * Protobuf type {@code com.tiwari.studence.proto.stringParser.CharactersRestrictionPb}
 */
public final class CharactersRestrictionPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.stringParser.CharactersRestrictionPb)
    CharactersRestrictionPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CharactersRestrictionPb.newBuilder() to construct.
  private CharactersRestrictionPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CharactersRestrictionPb() {
    allowedSpecialChars_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CharactersRestrictionPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.stringParser.StringParserConfig.internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.stringParser.StringParserConfig.internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.stringParser.CharactersRestrictionPb.class, com.tiwari.studence.proto.stringParser.CharactersRestrictionPb.Builder.class);
  }

  private int bitField0_;
  public static final int ISENABLED_FIELD_NUMBER = 1;
  private boolean isEnabled_ = false;
  /**
   * <code>optional bool isEnabled = 1;</code>
   * @return Whether the isEnabled field is set.
   */
  @java.lang.Override
  public boolean hasIsEnabled() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional bool isEnabled = 1;</code>
   * @return The isEnabled.
   */
  @java.lang.Override
  public boolean getIsEnabled() {
    return isEnabled_;
  }

  public static final int ALLOWNUMERIC_FIELD_NUMBER = 2;
  private boolean allowNumeric_ = false;
  /**
   * <code>optional bool allowNumeric = 2;</code>
   * @return Whether the allowNumeric field is set.
   */
  @java.lang.Override
  public boolean hasAllowNumeric() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional bool allowNumeric = 2;</code>
   * @return The allowNumeric.
   */
  @java.lang.Override
  public boolean getAllowNumeric() {
    return allowNumeric_;
  }

  public static final int ALLOWALPHABET_FIELD_NUMBER = 3;
  private boolean allowAlphabet_ = false;
  /**
   * <code>optional bool allowAlphabet = 3;</code>
   * @return Whether the allowAlphabet field is set.
   */
  @java.lang.Override
  public boolean hasAllowAlphabet() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional bool allowAlphabet = 3;</code>
   * @return The allowAlphabet.
   */
  @java.lang.Override
  public boolean getAllowAlphabet() {
    return allowAlphabet_;
  }

  public static final int ALLOWEDSPECIALCHARS_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringList allowedSpecialChars_;
  /**
   * <code>repeated string allowedSpecialChars = 4;</code>
   * @return A list containing the allowedSpecialChars.
   */
  public com.google.protobuf.ProtocolStringList
      getAllowedSpecialCharsList() {
    return allowedSpecialChars_;
  }
  /**
   * <code>repeated string allowedSpecialChars = 4;</code>
   * @return The count of allowedSpecialChars.
   */
  public int getAllowedSpecialCharsCount() {
    return allowedSpecialChars_.size();
  }
  /**
   * <code>repeated string allowedSpecialChars = 4;</code>
   * @param index The index of the element to return.
   * @return The allowedSpecialChars at the given index.
   */
  public java.lang.String getAllowedSpecialChars(int index) {
    return allowedSpecialChars_.get(index);
  }
  /**
   * <code>repeated string allowedSpecialChars = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the allowedSpecialChars at the given index.
   */
  public com.google.protobuf.ByteString
      getAllowedSpecialCharsBytes(int index) {
    return allowedSpecialChars_.getByteString(index);
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
      output.writeBool(1, isEnabled_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeBool(2, allowNumeric_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeBool(3, allowAlphabet_);
    }
    for (int i = 0; i < allowedSpecialChars_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, allowedSpecialChars_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, isEnabled_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, allowNumeric_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, allowAlphabet_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < allowedSpecialChars_.size(); i++) {
        dataSize += computeStringSizeNoTag(allowedSpecialChars_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getAllowedSpecialCharsList().size();
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
    if (!(obj instanceof com.tiwari.studence.proto.stringParser.CharactersRestrictionPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.stringParser.CharactersRestrictionPb other = (com.tiwari.studence.proto.stringParser.CharactersRestrictionPb) obj;

    if (hasIsEnabled() != other.hasIsEnabled()) return false;
    if (hasIsEnabled()) {
      if (getIsEnabled()
          != other.getIsEnabled()) return false;
    }
    if (hasAllowNumeric() != other.hasAllowNumeric()) return false;
    if (hasAllowNumeric()) {
      if (getAllowNumeric()
          != other.getAllowNumeric()) return false;
    }
    if (hasAllowAlphabet() != other.hasAllowAlphabet()) return false;
    if (hasAllowAlphabet()) {
      if (getAllowAlphabet()
          != other.getAllowAlphabet()) return false;
    }
    if (!getAllowedSpecialCharsList()
        .equals(other.getAllowedSpecialCharsList())) return false;
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
    if (hasIsEnabled()) {
      hash = (37 * hash) + ISENABLED_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsEnabled());
    }
    if (hasAllowNumeric()) {
      hash = (37 * hash) + ALLOWNUMERIC_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getAllowNumeric());
    }
    if (hasAllowAlphabet()) {
      hash = (37 * hash) + ALLOWALPHABET_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getAllowAlphabet());
    }
    if (getAllowedSpecialCharsCount() > 0) {
      hash = (37 * hash) + ALLOWEDSPECIALCHARS_FIELD_NUMBER;
      hash = (53 * hash) + getAllowedSpecialCharsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.stringParser.CharactersRestrictionPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.stringParser.CharactersRestrictionPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.stringParser.CharactersRestrictionPb)
      com.tiwari.studence.proto.stringParser.CharactersRestrictionPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.stringParser.StringParserConfig.internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.stringParser.StringParserConfig.internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.stringParser.CharactersRestrictionPb.class, com.tiwari.studence.proto.stringParser.CharactersRestrictionPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.stringParser.CharactersRestrictionPb.newBuilder()
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
      isEnabled_ = false;
      allowNumeric_ = false;
      allowAlphabet_ = false;
      allowedSpecialChars_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.stringParser.StringParserConfig.internal_static_com_tiwari_studence_proto_stringParser_CharactersRestrictionPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.stringParser.CharactersRestrictionPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.stringParser.CharactersRestrictionPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.stringParser.CharactersRestrictionPb build() {
      com.tiwari.studence.proto.stringParser.CharactersRestrictionPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.stringParser.CharactersRestrictionPb buildPartial() {
      com.tiwari.studence.proto.stringParser.CharactersRestrictionPb result = new com.tiwari.studence.proto.stringParser.CharactersRestrictionPb(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.tiwari.studence.proto.stringParser.CharactersRestrictionPb result) {
      if (((bitField0_ & 0x00000008) != 0)) {
        allowedSpecialChars_ = allowedSpecialChars_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000008);
      }
      result.allowedSpecialChars_ = allowedSpecialChars_;
    }

    private void buildPartial0(com.tiwari.studence.proto.stringParser.CharactersRestrictionPb result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.isEnabled_ = isEnabled_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.allowNumeric_ = allowNumeric_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.allowAlphabet_ = allowAlphabet_;
        to_bitField0_ |= 0x00000004;
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
      if (other instanceof com.tiwari.studence.proto.stringParser.CharactersRestrictionPb) {
        return mergeFrom((com.tiwari.studence.proto.stringParser.CharactersRestrictionPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.stringParser.CharactersRestrictionPb other) {
      if (other == com.tiwari.studence.proto.stringParser.CharactersRestrictionPb.getDefaultInstance()) return this;
      if (other.hasIsEnabled()) {
        setIsEnabled(other.getIsEnabled());
      }
      if (other.hasAllowNumeric()) {
        setAllowNumeric(other.getAllowNumeric());
      }
      if (other.hasAllowAlphabet()) {
        setAllowAlphabet(other.getAllowAlphabet());
      }
      if (!other.allowedSpecialChars_.isEmpty()) {
        if (allowedSpecialChars_.isEmpty()) {
          allowedSpecialChars_ = other.allowedSpecialChars_;
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          ensureAllowedSpecialCharsIsMutable();
          allowedSpecialChars_.addAll(other.allowedSpecialChars_);
        }
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
              isEnabled_ = input.readBool();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              allowNumeric_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              allowAlphabet_ = input.readBool();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();
              ensureAllowedSpecialCharsIsMutable();
              allowedSpecialChars_.add(s);
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

    private boolean isEnabled_ ;
    /**
     * <code>optional bool isEnabled = 1;</code>
     * @return Whether the isEnabled field is set.
     */
    @java.lang.Override
    public boolean hasIsEnabled() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional bool isEnabled = 1;</code>
     * @return The isEnabled.
     */
    @java.lang.Override
    public boolean getIsEnabled() {
      return isEnabled_;
    }
    /**
     * <code>optional bool isEnabled = 1;</code>
     * @param value The isEnabled to set.
     * @return This builder for chaining.
     */
    public Builder setIsEnabled(boolean value) {
      
      isEnabled_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool isEnabled = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsEnabled() {
      bitField0_ = (bitField0_ & ~0x00000001);
      isEnabled_ = false;
      onChanged();
      return this;
    }

    private boolean allowNumeric_ ;
    /**
     * <code>optional bool allowNumeric = 2;</code>
     * @return Whether the allowNumeric field is set.
     */
    @java.lang.Override
    public boolean hasAllowNumeric() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional bool allowNumeric = 2;</code>
     * @return The allowNumeric.
     */
    @java.lang.Override
    public boolean getAllowNumeric() {
      return allowNumeric_;
    }
    /**
     * <code>optional bool allowNumeric = 2;</code>
     * @param value The allowNumeric to set.
     * @return This builder for chaining.
     */
    public Builder setAllowNumeric(boolean value) {
      
      allowNumeric_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool allowNumeric = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAllowNumeric() {
      bitField0_ = (bitField0_ & ~0x00000002);
      allowNumeric_ = false;
      onChanged();
      return this;
    }

    private boolean allowAlphabet_ ;
    /**
     * <code>optional bool allowAlphabet = 3;</code>
     * @return Whether the allowAlphabet field is set.
     */
    @java.lang.Override
    public boolean hasAllowAlphabet() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional bool allowAlphabet = 3;</code>
     * @return The allowAlphabet.
     */
    @java.lang.Override
    public boolean getAllowAlphabet() {
      return allowAlphabet_;
    }
    /**
     * <code>optional bool allowAlphabet = 3;</code>
     * @param value The allowAlphabet to set.
     * @return This builder for chaining.
     */
    public Builder setAllowAlphabet(boolean value) {
      
      allowAlphabet_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool allowAlphabet = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAllowAlphabet() {
      bitField0_ = (bitField0_ & ~0x00000004);
      allowAlphabet_ = false;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList allowedSpecialChars_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureAllowedSpecialCharsIsMutable() {
      if (!((bitField0_ & 0x00000008) != 0)) {
        allowedSpecialChars_ = new com.google.protobuf.LazyStringArrayList(allowedSpecialChars_);
        bitField0_ |= 0x00000008;
       }
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @return A list containing the allowedSpecialChars.
     */
    public com.google.protobuf.ProtocolStringList
        getAllowedSpecialCharsList() {
      return allowedSpecialChars_.getUnmodifiableView();
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @return The count of allowedSpecialChars.
     */
    public int getAllowedSpecialCharsCount() {
      return allowedSpecialChars_.size();
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @param index The index of the element to return.
     * @return The allowedSpecialChars at the given index.
     */
    public java.lang.String getAllowedSpecialChars(int index) {
      return allowedSpecialChars_.get(index);
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @param index The index of the value to return.
     * @return The bytes of the allowedSpecialChars at the given index.
     */
    public com.google.protobuf.ByteString
        getAllowedSpecialCharsBytes(int index) {
      return allowedSpecialChars_.getByteString(index);
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @param index The index to set the value at.
     * @param value The allowedSpecialChars to set.
     * @return This builder for chaining.
     */
    public Builder setAllowedSpecialChars(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureAllowedSpecialCharsIsMutable();
      allowedSpecialChars_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @param value The allowedSpecialChars to add.
     * @return This builder for chaining.
     */
    public Builder addAllowedSpecialChars(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureAllowedSpecialCharsIsMutable();
      allowedSpecialChars_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @param values The allowedSpecialChars to add.
     * @return This builder for chaining.
     */
    public Builder addAllAllowedSpecialChars(
        java.lang.Iterable<java.lang.String> values) {
      ensureAllowedSpecialCharsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, allowedSpecialChars_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearAllowedSpecialChars() {
      allowedSpecialChars_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string allowedSpecialChars = 4;</code>
     * @param value The bytes of the allowedSpecialChars to add.
     * @return This builder for chaining.
     */
    public Builder addAllowedSpecialCharsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensureAllowedSpecialCharsIsMutable();
      allowedSpecialChars_.add(value);
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.stringParser.CharactersRestrictionPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.stringParser.CharactersRestrictionPb)
  private static final com.tiwari.studence.proto.stringParser.CharactersRestrictionPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.stringParser.CharactersRestrictionPb();
  }

  public static com.tiwari.studence.proto.stringParser.CharactersRestrictionPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CharactersRestrictionPb>
      PARSER = new com.google.protobuf.AbstractParser<CharactersRestrictionPb>() {
    @java.lang.Override
    public CharactersRestrictionPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<CharactersRestrictionPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CharactersRestrictionPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.stringParser.CharactersRestrictionPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

