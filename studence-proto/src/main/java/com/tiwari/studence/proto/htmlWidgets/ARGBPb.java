// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: htmlWidgets.proto

package com.tiwari.studence.proto.htmlWidgets;

/**
 * Protobuf type {@code com.tiwari.studence.proto.htmlWidgets.ARGBPb}
 */
public final class ARGBPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.htmlWidgets.ARGBPb)
    ARGBPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ARGBPb.newBuilder() to construct.
  private ARGBPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ARGBPb() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ARGBPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_ARGBPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_ARGBPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.htmlWidgets.ARGBPb.class, com.tiwari.studence.proto.htmlWidgets.ARGBPb.Builder.class);
  }

  public static final int R_FIELD_NUMBER = 1;
  private int r_ = 0;
  /**
   * <code>int32 r = 1;</code>
   * @return The r.
   */
  @java.lang.Override
  public int getR() {
    return r_;
  }

  public static final int G_FIELD_NUMBER = 2;
  private int g_ = 0;
  /**
   * <code>int32 g = 2;</code>
   * @return The g.
   */
  @java.lang.Override
  public int getG() {
    return g_;
  }

  public static final int B_FIELD_NUMBER = 3;
  private int b_ = 0;
  /**
   * <code>int32 b = 3;</code>
   * @return The b.
   */
  @java.lang.Override
  public int getB() {
    return b_;
  }

  public static final int O_FIELD_NUMBER = 4;
  private int o_ = 0;
  /**
   * <code>int32 o = 4;</code>
   * @return The o.
   */
  @java.lang.Override
  public int getO() {
    return o_;
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
    if (r_ != 0) {
      output.writeInt32(1, r_);
    }
    if (g_ != 0) {
      output.writeInt32(2, g_);
    }
    if (b_ != 0) {
      output.writeInt32(3, b_);
    }
    if (o_ != 0) {
      output.writeInt32(4, o_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (r_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, r_);
    }
    if (g_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, g_);
    }
    if (b_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, b_);
    }
    if (o_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, o_);
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
    if (!(obj instanceof com.tiwari.studence.proto.htmlWidgets.ARGBPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.htmlWidgets.ARGBPb other = (com.tiwari.studence.proto.htmlWidgets.ARGBPb) obj;

    if (getR()
        != other.getR()) return false;
    if (getG()
        != other.getG()) return false;
    if (getB()
        != other.getB()) return false;
    if (getO()
        != other.getO()) return false;
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
    hash = (37 * hash) + R_FIELD_NUMBER;
    hash = (53 * hash) + getR();
    hash = (37 * hash) + G_FIELD_NUMBER;
    hash = (53 * hash) + getG();
    hash = (37 * hash) + B_FIELD_NUMBER;
    hash = (53 * hash) + getB();
    hash = (37 * hash) + O_FIELD_NUMBER;
    hash = (53 * hash) + getO();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.htmlWidgets.ARGBPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.htmlWidgets.ARGBPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.htmlWidgets.ARGBPb)
      com.tiwari.studence.proto.htmlWidgets.ARGBPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_ARGBPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_ARGBPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.htmlWidgets.ARGBPb.class, com.tiwari.studence.proto.htmlWidgets.ARGBPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.htmlWidgets.ARGBPb.newBuilder()
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
      r_ = 0;
      g_ = 0;
      b_ = 0;
      o_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.htmlWidgets.HtmlWidgets.internal_static_com_tiwari_studence_proto_htmlWidgets_ARGBPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.htmlWidgets.ARGBPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.htmlWidgets.ARGBPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.htmlWidgets.ARGBPb build() {
      com.tiwari.studence.proto.htmlWidgets.ARGBPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.htmlWidgets.ARGBPb buildPartial() {
      com.tiwari.studence.proto.htmlWidgets.ARGBPb result = new com.tiwari.studence.proto.htmlWidgets.ARGBPb(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.tiwari.studence.proto.htmlWidgets.ARGBPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.r_ = r_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.g_ = g_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.b_ = b_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.o_ = o_;
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
      if (other instanceof com.tiwari.studence.proto.htmlWidgets.ARGBPb) {
        return mergeFrom((com.tiwari.studence.proto.htmlWidgets.ARGBPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.htmlWidgets.ARGBPb other) {
      if (other == com.tiwari.studence.proto.htmlWidgets.ARGBPb.getDefaultInstance()) return this;
      if (other.getR() != 0) {
        setR(other.getR());
      }
      if (other.getG() != 0) {
        setG(other.getG());
      }
      if (other.getB() != 0) {
        setB(other.getB());
      }
      if (other.getO() != 0) {
        setO(other.getO());
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
              r_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              g_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              b_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            case 32: {
              o_ = input.readInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
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

    private int r_ ;
    /**
     * <code>int32 r = 1;</code>
     * @return The r.
     */
    @java.lang.Override
    public int getR() {
      return r_;
    }
    /**
     * <code>int32 r = 1;</code>
     * @param value The r to set.
     * @return This builder for chaining.
     */
    public Builder setR(int value) {
      
      r_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 r = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearR() {
      bitField0_ = (bitField0_ & ~0x00000001);
      r_ = 0;
      onChanged();
      return this;
    }

    private int g_ ;
    /**
     * <code>int32 g = 2;</code>
     * @return The g.
     */
    @java.lang.Override
    public int getG() {
      return g_;
    }
    /**
     * <code>int32 g = 2;</code>
     * @param value The g to set.
     * @return This builder for chaining.
     */
    public Builder setG(int value) {
      
      g_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 g = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearG() {
      bitField0_ = (bitField0_ & ~0x00000002);
      g_ = 0;
      onChanged();
      return this;
    }

    private int b_ ;
    /**
     * <code>int32 b = 3;</code>
     * @return The b.
     */
    @java.lang.Override
    public int getB() {
      return b_;
    }
    /**
     * <code>int32 b = 3;</code>
     * @param value The b to set.
     * @return This builder for chaining.
     */
    public Builder setB(int value) {
      
      b_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int32 b = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearB() {
      bitField0_ = (bitField0_ & ~0x00000004);
      b_ = 0;
      onChanged();
      return this;
    }

    private int o_ ;
    /**
     * <code>int32 o = 4;</code>
     * @return The o.
     */
    @java.lang.Override
    public int getO() {
      return o_;
    }
    /**
     * <code>int32 o = 4;</code>
     * @param value The o to set.
     * @return This builder for chaining.
     */
    public Builder setO(int value) {
      
      o_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>int32 o = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearO() {
      bitField0_ = (bitField0_ & ~0x00000008);
      o_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.htmlWidgets.ARGBPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.htmlWidgets.ARGBPb)
  private static final com.tiwari.studence.proto.htmlWidgets.ARGBPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.htmlWidgets.ARGBPb();
  }

  public static com.tiwari.studence.proto.htmlWidgets.ARGBPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ARGBPb>
      PARSER = new com.google.protobuf.AbstractParser<ARGBPb>() {
    @java.lang.Override
    public ARGBPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<ARGBPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ARGBPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.htmlWidgets.ARGBPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

