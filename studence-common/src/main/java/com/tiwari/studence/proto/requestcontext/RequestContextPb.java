// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: requestContextPb.proto

package com.tiwari.studence.proto.requestcontext;

/**
 * Protobuf type {@code com.tiwari.studence.proto.requestcontext.RequestContextPb}
 */
public final class RequestContextPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.requestcontext.RequestContextPb)
    RequestContextPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestContextPb.newBuilder() to construct.
  private RequestContextPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestContextPb() {
    reqClass_ = "";
    reqMethod_ = "";
    priority_ = 0;
    reqId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RequestContextPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestContextPb(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            reqClass_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            reqMethod_ = s;
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            priority_ = rawValue;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            reqId_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.requestcontext.RequestContextPbOuterClass.internal_static_com_tiwari_studence_proto_requestcontext_RequestContextPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.requestcontext.RequestContextPbOuterClass.internal_static_com_tiwari_studence_proto_requestcontext_RequestContextPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.requestcontext.RequestContextPb.class, com.tiwari.studence.proto.requestcontext.RequestContextPb.Builder.class);
  }

  public static final int REQCLASS_FIELD_NUMBER = 1;
  private volatile java.lang.Object reqClass_;
  /**
   * <code>string reqClass = 1;</code>
   * @return The reqClass.
   */
  @java.lang.Override
  public java.lang.String getReqClass() {
    java.lang.Object ref = reqClass_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      reqClass_ = s;
      return s;
    }
  }
  /**
   * <code>string reqClass = 1;</code>
   * @return The bytes for reqClass.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getReqClassBytes() {
    java.lang.Object ref = reqClass_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      reqClass_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int REQMETHOD_FIELD_NUMBER = 2;
  private volatile java.lang.Object reqMethod_;
  /**
   * <code>string reqMethod = 2;</code>
   * @return The reqMethod.
   */
  @java.lang.Override
  public java.lang.String getReqMethod() {
    java.lang.Object ref = reqMethod_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      reqMethod_ = s;
      return s;
    }
  }
  /**
   * <code>string reqMethod = 2;</code>
   * @return The bytes for reqMethod.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getReqMethodBytes() {
    java.lang.Object ref = reqMethod_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      reqMethod_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRIORITY_FIELD_NUMBER = 3;
  private int priority_;
  /**
   * <code>.com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum priority = 3;</code>
   * @return The enum numeric value on the wire for priority.
   */
  @java.lang.Override public int getPriorityValue() {
    return priority_;
  }
  /**
   * <code>.com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum priority = 3;</code>
   * @return The priority.
   */
  @java.lang.Override public com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum getPriority() {
    @SuppressWarnings("deprecation")
    com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum result = com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum.valueOf(priority_);
    return result == null ? com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum.UNRECOGNIZED : result;
  }

  public static final int REQID_FIELD_NUMBER = 4;
  private volatile java.lang.Object reqId_;
  /**
   * <code>string reqId = 4;</code>
   * @return The reqId.
   */
  @java.lang.Override
  public java.lang.String getReqId() {
    java.lang.Object ref = reqId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      reqId_ = s;
      return s;
    }
  }
  /**
   * <code>string reqId = 4;</code>
   * @return The bytes for reqId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getReqIdBytes() {
    java.lang.Object ref = reqId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      reqId_ = b;
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
    if (!getReqClassBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, reqClass_);
    }
    if (!getReqMethodBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, reqMethod_);
    }
    if (priority_ != com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum.UNKNOWN_REQ_PRIORITY.getNumber()) {
      output.writeEnum(3, priority_);
    }
    if (!getReqIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, reqId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getReqClassBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, reqClass_);
    }
    if (!getReqMethodBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, reqMethod_);
    }
    if (priority_ != com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum.UNKNOWN_REQ_PRIORITY.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, priority_);
    }
    if (!getReqIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, reqId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.tiwari.studence.proto.requestcontext.RequestContextPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.requestcontext.RequestContextPb other = (com.tiwari.studence.proto.requestcontext.RequestContextPb) obj;

    if (!getReqClass()
        .equals(other.getReqClass())) return false;
    if (!getReqMethod()
        .equals(other.getReqMethod())) return false;
    if (priority_ != other.priority_) return false;
    if (!getReqId()
        .equals(other.getReqId())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + REQCLASS_FIELD_NUMBER;
    hash = (53 * hash) + getReqClass().hashCode();
    hash = (37 * hash) + REQMETHOD_FIELD_NUMBER;
    hash = (53 * hash) + getReqMethod().hashCode();
    hash = (37 * hash) + PRIORITY_FIELD_NUMBER;
    hash = (53 * hash) + priority_;
    hash = (37 * hash) + REQID_FIELD_NUMBER;
    hash = (53 * hash) + getReqId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.requestcontext.RequestContextPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.requestcontext.RequestContextPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.requestcontext.RequestContextPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.requestcontext.RequestContextPb)
      com.tiwari.studence.proto.requestcontext.RequestContextPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.requestcontext.RequestContextPbOuterClass.internal_static_com_tiwari_studence_proto_requestcontext_RequestContextPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.requestcontext.RequestContextPbOuterClass.internal_static_com_tiwari_studence_proto_requestcontext_RequestContextPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.requestcontext.RequestContextPb.class, com.tiwari.studence.proto.requestcontext.RequestContextPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.requestcontext.RequestContextPb.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      reqClass_ = "";

      reqMethod_ = "";

      priority_ = 0;

      reqId_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.requestcontext.RequestContextPbOuterClass.internal_static_com_tiwari_studence_proto_requestcontext_RequestContextPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.requestcontext.RequestContextPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.requestcontext.RequestContextPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.requestcontext.RequestContextPb build() {
      com.tiwari.studence.proto.requestcontext.RequestContextPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.requestcontext.RequestContextPb buildPartial() {
      com.tiwari.studence.proto.requestcontext.RequestContextPb result = new com.tiwari.studence.proto.requestcontext.RequestContextPb(this);
      result.reqClass_ = reqClass_;
      result.reqMethod_ = reqMethod_;
      result.priority_ = priority_;
      result.reqId_ = reqId_;
      onBuilt();
      return result;
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
      if (other instanceof com.tiwari.studence.proto.requestcontext.RequestContextPb) {
        return mergeFrom((com.tiwari.studence.proto.requestcontext.RequestContextPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.requestcontext.RequestContextPb other) {
      if (other == com.tiwari.studence.proto.requestcontext.RequestContextPb.getDefaultInstance()) return this;
      if (!other.getReqClass().isEmpty()) {
        reqClass_ = other.reqClass_;
        onChanged();
      }
      if (!other.getReqMethod().isEmpty()) {
        reqMethod_ = other.reqMethod_;
        onChanged();
      }
      if (other.priority_ != 0) {
        setPriorityValue(other.getPriorityValue());
      }
      if (!other.getReqId().isEmpty()) {
        reqId_ = other.reqId_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.tiwari.studence.proto.requestcontext.RequestContextPb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.tiwari.studence.proto.requestcontext.RequestContextPb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object reqClass_ = "";
    /**
     * <code>string reqClass = 1;</code>
     * @return The reqClass.
     */
    public java.lang.String getReqClass() {
      java.lang.Object ref = reqClass_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        reqClass_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string reqClass = 1;</code>
     * @return The bytes for reqClass.
     */
    public com.google.protobuf.ByteString
        getReqClassBytes() {
      java.lang.Object ref = reqClass_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reqClass_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string reqClass = 1;</code>
     * @param value The reqClass to set.
     * @return This builder for chaining.
     */
    public Builder setReqClass(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      reqClass_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string reqClass = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearReqClass() {
      
      reqClass_ = getDefaultInstance().getReqClass();
      onChanged();
      return this;
    }
    /**
     * <code>string reqClass = 1;</code>
     * @param value The bytes for reqClass to set.
     * @return This builder for chaining.
     */
    public Builder setReqClassBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      reqClass_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object reqMethod_ = "";
    /**
     * <code>string reqMethod = 2;</code>
     * @return The reqMethod.
     */
    public java.lang.String getReqMethod() {
      java.lang.Object ref = reqMethod_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        reqMethod_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string reqMethod = 2;</code>
     * @return The bytes for reqMethod.
     */
    public com.google.protobuf.ByteString
        getReqMethodBytes() {
      java.lang.Object ref = reqMethod_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reqMethod_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string reqMethod = 2;</code>
     * @param value The reqMethod to set.
     * @return This builder for chaining.
     */
    public Builder setReqMethod(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      reqMethod_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string reqMethod = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearReqMethod() {
      
      reqMethod_ = getDefaultInstance().getReqMethod();
      onChanged();
      return this;
    }
    /**
     * <code>string reqMethod = 2;</code>
     * @param value The bytes for reqMethod to set.
     * @return This builder for chaining.
     */
    public Builder setReqMethodBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      reqMethod_ = value;
      onChanged();
      return this;
    }

    private int priority_ = 0;
    /**
     * <code>.com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum priority = 3;</code>
     * @return The enum numeric value on the wire for priority.
     */
    @java.lang.Override public int getPriorityValue() {
      return priority_;
    }
    /**
     * <code>.com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum priority = 3;</code>
     * @param value The enum numeric value on the wire for priority to set.
     * @return This builder for chaining.
     */
    public Builder setPriorityValue(int value) {
      
      priority_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum priority = 3;</code>
     * @return The priority.
     */
    @java.lang.Override
    public com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum getPriority() {
      @SuppressWarnings("deprecation")
      com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum result = com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum.valueOf(priority_);
      return result == null ? com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum priority = 3;</code>
     * @param value The priority to set.
     * @return This builder for chaining.
     */
    public Builder setPriority(com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      priority_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum priority = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPriority() {
      
      priority_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object reqId_ = "";
    /**
     * <code>string reqId = 4;</code>
     * @return The reqId.
     */
    public java.lang.String getReqId() {
      java.lang.Object ref = reqId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        reqId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string reqId = 4;</code>
     * @return The bytes for reqId.
     */
    public com.google.protobuf.ByteString
        getReqIdBytes() {
      java.lang.Object ref = reqId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reqId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string reqId = 4;</code>
     * @param value The reqId to set.
     * @return This builder for chaining.
     */
    public Builder setReqId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      reqId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string reqId = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearReqId() {
      
      reqId_ = getDefaultInstance().getReqId();
      onChanged();
      return this;
    }
    /**
     * <code>string reqId = 4;</code>
     * @param value The bytes for reqId to set.
     * @return This builder for chaining.
     */
    public Builder setReqIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      reqId_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.requestcontext.RequestContextPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.requestcontext.RequestContextPb)
  private static final com.tiwari.studence.proto.requestcontext.RequestContextPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.requestcontext.RequestContextPb();
  }

  public static com.tiwari.studence.proto.requestcontext.RequestContextPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestContextPb>
      PARSER = new com.google.protobuf.AbstractParser<RequestContextPb>() {
    @java.lang.Override
    public RequestContextPb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RequestContextPb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestContextPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RequestContextPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.requestcontext.RequestContextPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

