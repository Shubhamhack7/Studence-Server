// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: contactDetailsPb.proto

package com.tiwari.studence.proto.contactDetails;

/**
 * Protobuf type {@code com.tiwari.studence.proto.contactDetails.ContactDetailsPb}
 */
public final class ContactDetailsPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.contactDetails.ContactDetailsPb)
    ContactDetailsPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ContactDetailsPb.newBuilder() to construct.
  private ContactDetailsPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ContactDetailsPb() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ContactDetailsPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.internal_static_com_tiwari_studence_proto_contactDetails_ContactDetailsPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.internal_static_com_tiwari_studence_proto_contactDetails_ContactDetailsPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.contactDetails.ContactDetailsPb.class, com.tiwari.studence.proto.contactDetails.ContactDetailsPb.Builder.class);
  }

  public static final int MOBILENUMBERS_FIELD_NUMBER = 1;
  private com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers_;
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
   * @return Whether the mobileNumbers field is set.
   */
  @java.lang.Override
  public boolean hasMobileNumbers() {
    return mobileNumbers_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
   * @return The mobileNumbers.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.contactDetails.MobileNumbersPb getMobileNumbers() {
    return mobileNumbers_ == null ? com.tiwari.studence.proto.contactDetails.MobileNumbersPb.getDefaultInstance() : mobileNumbers_;
  }
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.contactDetails.MobileNumbersPbOrBuilder getMobileNumbersOrBuilder() {
    return mobileNumbers_ == null ? com.tiwari.studence.proto.contactDetails.MobileNumbersPb.getDefaultInstance() : mobileNumbers_;
  }

  public static final int EMAILS_FIELD_NUMBER = 2;
  private com.tiwari.studence.proto.contactDetails.EmailsPb emails_;
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
   * @return Whether the emails field is set.
   */
  @java.lang.Override
  public boolean hasEmails() {
    return emails_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
   * @return The emails.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.contactDetails.EmailsPb getEmails() {
    return emails_ == null ? com.tiwari.studence.proto.contactDetails.EmailsPb.getDefaultInstance() : emails_;
  }
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.contactDetails.EmailsPbOrBuilder getEmailsOrBuilder() {
    return emails_ == null ? com.tiwari.studence.proto.contactDetails.EmailsPb.getDefaultInstance() : emails_;
  }

  public static final int ADDRESS_FIELD_NUMBER = 3;
  private com.tiwari.studence.proto.contactDetails.AddressesPb address_;
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
   * @return Whether the address field is set.
   */
  @java.lang.Override
  public boolean hasAddress() {
    return address_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
   * @return The address.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.contactDetails.AddressesPb getAddress() {
    return address_ == null ? com.tiwari.studence.proto.contactDetails.AddressesPb.getDefaultInstance() : address_;
  }
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.contactDetails.AddressesPbOrBuilder getAddressOrBuilder() {
    return address_ == null ? com.tiwari.studence.proto.contactDetails.AddressesPb.getDefaultInstance() : address_;
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
    if (mobileNumbers_ != null) {
      output.writeMessage(1, getMobileNumbers());
    }
    if (emails_ != null) {
      output.writeMessage(2, getEmails());
    }
    if (address_ != null) {
      output.writeMessage(3, getAddress());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (mobileNumbers_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getMobileNumbers());
    }
    if (emails_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getEmails());
    }
    if (address_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getAddress());
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
    if (!(obj instanceof com.tiwari.studence.proto.contactDetails.ContactDetailsPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.contactDetails.ContactDetailsPb other = (com.tiwari.studence.proto.contactDetails.ContactDetailsPb) obj;

    if (hasMobileNumbers() != other.hasMobileNumbers()) return false;
    if (hasMobileNumbers()) {
      if (!getMobileNumbers()
          .equals(other.getMobileNumbers())) return false;
    }
    if (hasEmails() != other.hasEmails()) return false;
    if (hasEmails()) {
      if (!getEmails()
          .equals(other.getEmails())) return false;
    }
    if (hasAddress() != other.hasAddress()) return false;
    if (hasAddress()) {
      if (!getAddress()
          .equals(other.getAddress())) return false;
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
    if (hasMobileNumbers()) {
      hash = (37 * hash) + MOBILENUMBERS_FIELD_NUMBER;
      hash = (53 * hash) + getMobileNumbers().hashCode();
    }
    if (hasEmails()) {
      hash = (37 * hash) + EMAILS_FIELD_NUMBER;
      hash = (53 * hash) + getEmails().hashCode();
    }
    if (hasAddress()) {
      hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getAddress().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.contactDetails.ContactDetailsPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.contactDetails.ContactDetailsPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.contactDetails.ContactDetailsPb)
      com.tiwari.studence.proto.contactDetails.ContactDetailsPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.internal_static_com_tiwari_studence_proto_contactDetails_ContactDetailsPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.internal_static_com_tiwari_studence_proto_contactDetails_ContactDetailsPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.contactDetails.ContactDetailsPb.class, com.tiwari.studence.proto.contactDetails.ContactDetailsPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.contactDetails.ContactDetailsPb.newBuilder()
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
      mobileNumbers_ = null;
      if (mobileNumbersBuilder_ != null) {
        mobileNumbersBuilder_.dispose();
        mobileNumbersBuilder_ = null;
      }
      emails_ = null;
      if (emailsBuilder_ != null) {
        emailsBuilder_.dispose();
        emailsBuilder_ = null;
      }
      address_ = null;
      if (addressBuilder_ != null) {
        addressBuilder_.dispose();
        addressBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.internal_static_com_tiwari_studence_proto_contactDetails_ContactDetailsPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.contactDetails.ContactDetailsPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.contactDetails.ContactDetailsPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.contactDetails.ContactDetailsPb build() {
      com.tiwari.studence.proto.contactDetails.ContactDetailsPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.contactDetails.ContactDetailsPb buildPartial() {
      com.tiwari.studence.proto.contactDetails.ContactDetailsPb result = new com.tiwari.studence.proto.contactDetails.ContactDetailsPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.contactDetails.ContactDetailsPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.mobileNumbers_ = mobileNumbersBuilder_ == null
            ? mobileNumbers_
            : mobileNumbersBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.emails_ = emailsBuilder_ == null
            ? emails_
            : emailsBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.address_ = addressBuilder_ == null
            ? address_
            : addressBuilder_.build();
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
      if (other instanceof com.tiwari.studence.proto.contactDetails.ContactDetailsPb) {
        return mergeFrom((com.tiwari.studence.proto.contactDetails.ContactDetailsPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.contactDetails.ContactDetailsPb other) {
      if (other == com.tiwari.studence.proto.contactDetails.ContactDetailsPb.getDefaultInstance()) return this;
      if (other.hasMobileNumbers()) {
        mergeMobileNumbers(other.getMobileNumbers());
      }
      if (other.hasEmails()) {
        mergeEmails(other.getEmails());
      }
      if (other.hasAddress()) {
        mergeAddress(other.getAddress());
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
                  getMobileNumbersFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getEmailsFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getAddressFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
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

    private com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.contactDetails.MobileNumbersPb, com.tiwari.studence.proto.contactDetails.MobileNumbersPb.Builder, com.tiwari.studence.proto.contactDetails.MobileNumbersPbOrBuilder> mobileNumbersBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     * @return Whether the mobileNumbers field is set.
     */
    public boolean hasMobileNumbers() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     * @return The mobileNumbers.
     */
    public com.tiwari.studence.proto.contactDetails.MobileNumbersPb getMobileNumbers() {
      if (mobileNumbersBuilder_ == null) {
        return mobileNumbers_ == null ? com.tiwari.studence.proto.contactDetails.MobileNumbersPb.getDefaultInstance() : mobileNumbers_;
      } else {
        return mobileNumbersBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     */
    public Builder setMobileNumbers(com.tiwari.studence.proto.contactDetails.MobileNumbersPb value) {
      if (mobileNumbersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        mobileNumbers_ = value;
      } else {
        mobileNumbersBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     */
    public Builder setMobileNumbers(
        com.tiwari.studence.proto.contactDetails.MobileNumbersPb.Builder builderForValue) {
      if (mobileNumbersBuilder_ == null) {
        mobileNumbers_ = builderForValue.build();
      } else {
        mobileNumbersBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     */
    public Builder mergeMobileNumbers(com.tiwari.studence.proto.contactDetails.MobileNumbersPb value) {
      if (mobileNumbersBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          mobileNumbers_ != null &&
          mobileNumbers_ != com.tiwari.studence.proto.contactDetails.MobileNumbersPb.getDefaultInstance()) {
          getMobileNumbersBuilder().mergeFrom(value);
        } else {
          mobileNumbers_ = value;
        }
      } else {
        mobileNumbersBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     */
    public Builder clearMobileNumbers() {
      bitField0_ = (bitField0_ & ~0x00000001);
      mobileNumbers_ = null;
      if (mobileNumbersBuilder_ != null) {
        mobileNumbersBuilder_.dispose();
        mobileNumbersBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     */
    public com.tiwari.studence.proto.contactDetails.MobileNumbersPb.Builder getMobileNumbersBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getMobileNumbersFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     */
    public com.tiwari.studence.proto.contactDetails.MobileNumbersPbOrBuilder getMobileNumbersOrBuilder() {
      if (mobileNumbersBuilder_ != null) {
        return mobileNumbersBuilder_.getMessageOrBuilder();
      } else {
        return mobileNumbers_ == null ?
            com.tiwari.studence.proto.contactDetails.MobileNumbersPb.getDefaultInstance() : mobileNumbers_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.MobileNumbersPb mobileNumbers = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.contactDetails.MobileNumbersPb, com.tiwari.studence.proto.contactDetails.MobileNumbersPb.Builder, com.tiwari.studence.proto.contactDetails.MobileNumbersPbOrBuilder> 
        getMobileNumbersFieldBuilder() {
      if (mobileNumbersBuilder_ == null) {
        mobileNumbersBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.contactDetails.MobileNumbersPb, com.tiwari.studence.proto.contactDetails.MobileNumbersPb.Builder, com.tiwari.studence.proto.contactDetails.MobileNumbersPbOrBuilder>(
                getMobileNumbers(),
                getParentForChildren(),
                isClean());
        mobileNumbers_ = null;
      }
      return mobileNumbersBuilder_;
    }

    private com.tiwari.studence.proto.contactDetails.EmailsPb emails_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.contactDetails.EmailsPb, com.tiwari.studence.proto.contactDetails.EmailsPb.Builder, com.tiwari.studence.proto.contactDetails.EmailsPbOrBuilder> emailsBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     * @return Whether the emails field is set.
     */
    public boolean hasEmails() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     * @return The emails.
     */
    public com.tiwari.studence.proto.contactDetails.EmailsPb getEmails() {
      if (emailsBuilder_ == null) {
        return emails_ == null ? com.tiwari.studence.proto.contactDetails.EmailsPb.getDefaultInstance() : emails_;
      } else {
        return emailsBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     */
    public Builder setEmails(com.tiwari.studence.proto.contactDetails.EmailsPb value) {
      if (emailsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        emails_ = value;
      } else {
        emailsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     */
    public Builder setEmails(
        com.tiwari.studence.proto.contactDetails.EmailsPb.Builder builderForValue) {
      if (emailsBuilder_ == null) {
        emails_ = builderForValue.build();
      } else {
        emailsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     */
    public Builder mergeEmails(com.tiwari.studence.proto.contactDetails.EmailsPb value) {
      if (emailsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          emails_ != null &&
          emails_ != com.tiwari.studence.proto.contactDetails.EmailsPb.getDefaultInstance()) {
          getEmailsBuilder().mergeFrom(value);
        } else {
          emails_ = value;
        }
      } else {
        emailsBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     */
    public Builder clearEmails() {
      bitField0_ = (bitField0_ & ~0x00000002);
      emails_ = null;
      if (emailsBuilder_ != null) {
        emailsBuilder_.dispose();
        emailsBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     */
    public com.tiwari.studence.proto.contactDetails.EmailsPb.Builder getEmailsBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getEmailsFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     */
    public com.tiwari.studence.proto.contactDetails.EmailsPbOrBuilder getEmailsOrBuilder() {
      if (emailsBuilder_ != null) {
        return emailsBuilder_.getMessageOrBuilder();
      } else {
        return emails_ == null ?
            com.tiwari.studence.proto.contactDetails.EmailsPb.getDefaultInstance() : emails_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.EmailsPb emails = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.contactDetails.EmailsPb, com.tiwari.studence.proto.contactDetails.EmailsPb.Builder, com.tiwari.studence.proto.contactDetails.EmailsPbOrBuilder> 
        getEmailsFieldBuilder() {
      if (emailsBuilder_ == null) {
        emailsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.contactDetails.EmailsPb, com.tiwari.studence.proto.contactDetails.EmailsPb.Builder, com.tiwari.studence.proto.contactDetails.EmailsPbOrBuilder>(
                getEmails(),
                getParentForChildren(),
                isClean());
        emails_ = null;
      }
      return emailsBuilder_;
    }

    private com.tiwari.studence.proto.contactDetails.AddressesPb address_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.contactDetails.AddressesPb, com.tiwari.studence.proto.contactDetails.AddressesPb.Builder, com.tiwari.studence.proto.contactDetails.AddressesPbOrBuilder> addressBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     * @return Whether the address field is set.
     */
    public boolean hasAddress() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     * @return The address.
     */
    public com.tiwari.studence.proto.contactDetails.AddressesPb getAddress() {
      if (addressBuilder_ == null) {
        return address_ == null ? com.tiwari.studence.proto.contactDetails.AddressesPb.getDefaultInstance() : address_;
      } else {
        return addressBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     */
    public Builder setAddress(com.tiwari.studence.proto.contactDetails.AddressesPb value) {
      if (addressBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        address_ = value;
      } else {
        addressBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     */
    public Builder setAddress(
        com.tiwari.studence.proto.contactDetails.AddressesPb.Builder builderForValue) {
      if (addressBuilder_ == null) {
        address_ = builderForValue.build();
      } else {
        addressBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     */
    public Builder mergeAddress(com.tiwari.studence.proto.contactDetails.AddressesPb value) {
      if (addressBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          address_ != null &&
          address_ != com.tiwari.studence.proto.contactDetails.AddressesPb.getDefaultInstance()) {
          getAddressBuilder().mergeFrom(value);
        } else {
          address_ = value;
        }
      } else {
        addressBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     */
    public Builder clearAddress() {
      bitField0_ = (bitField0_ & ~0x00000004);
      address_ = null;
      if (addressBuilder_ != null) {
        addressBuilder_.dispose();
        addressBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     */
    public com.tiwari.studence.proto.contactDetails.AddressesPb.Builder getAddressBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getAddressFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     */
    public com.tiwari.studence.proto.contactDetails.AddressesPbOrBuilder getAddressOrBuilder() {
      if (addressBuilder_ != null) {
        return addressBuilder_.getMessageOrBuilder();
      } else {
        return address_ == null ?
            com.tiwari.studence.proto.contactDetails.AddressesPb.getDefaultInstance() : address_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.contactDetails.AddressesPb address = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.contactDetails.AddressesPb, com.tiwari.studence.proto.contactDetails.AddressesPb.Builder, com.tiwari.studence.proto.contactDetails.AddressesPbOrBuilder> 
        getAddressFieldBuilder() {
      if (addressBuilder_ == null) {
        addressBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.contactDetails.AddressesPb, com.tiwari.studence.proto.contactDetails.AddressesPb.Builder, com.tiwari.studence.proto.contactDetails.AddressesPbOrBuilder>(
                getAddress(),
                getParentForChildren(),
                isClean());
        address_ = null;
      }
      return addressBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.contactDetails.ContactDetailsPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.contactDetails.ContactDetailsPb)
  private static final com.tiwari.studence.proto.contactDetails.ContactDetailsPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.contactDetails.ContactDetailsPb();
  }

  public static com.tiwari.studence.proto.contactDetails.ContactDetailsPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ContactDetailsPb>
      PARSER = new com.google.protobuf.AbstractParser<ContactDetailsPb>() {
    @java.lang.Override
    public ContactDetailsPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<ContactDetailsPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ContactDetailsPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.contactDetails.ContactDetailsPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
