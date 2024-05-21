// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: match.proto

package com.tiwari.studence.proto.match;

/**
 * Protobuf type {@code com.tiwari.studence.proto.match.MetaInfoPb}
 */
public final class MetaInfoPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.match.MetaInfoPb)
    MetaInfoPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MetaInfoPb.newBuilder() to construct.
  private MetaInfoPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MetaInfoPb() {
    matchInfo_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MetaInfoPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.match.Match.internal_static_com_tiwari_studence_proto_match_MetaInfoPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.match.Match.internal_static_com_tiwari_studence_proto_match_MetaInfoPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.match.MetaInfoPb.class, com.tiwari.studence.proto.match.MetaInfoPb.Builder.class);
  }

  public static final int MATCHINFO_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.tiwari.studence.proto.match.MatchInfoPb> matchInfo_;
  /**
   * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.tiwari.studence.proto.match.MatchInfoPb> getMatchInfoList() {
    return matchInfo_;
  }
  /**
   * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.tiwari.studence.proto.match.MatchInfoPbOrBuilder> 
      getMatchInfoOrBuilderList() {
    return matchInfo_;
  }
  /**
   * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
   */
  @java.lang.Override
  public int getMatchInfoCount() {
    return matchInfo_.size();
  }
  /**
   * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.match.MatchInfoPb getMatchInfo(int index) {
    return matchInfo_.get(index);
  }
  /**
   * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.match.MatchInfoPbOrBuilder getMatchInfoOrBuilder(
      int index) {
    return matchInfo_.get(index);
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
    for (int i = 0; i < matchInfo_.size(); i++) {
      output.writeMessage(1, matchInfo_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < matchInfo_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, matchInfo_.get(i));
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
    if (!(obj instanceof com.tiwari.studence.proto.match.MetaInfoPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.match.MetaInfoPb other = (com.tiwari.studence.proto.match.MetaInfoPb) obj;

    if (!getMatchInfoList()
        .equals(other.getMatchInfoList())) return false;
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
    if (getMatchInfoCount() > 0) {
      hash = (37 * hash) + MATCHINFO_FIELD_NUMBER;
      hash = (53 * hash) + getMatchInfoList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.match.MetaInfoPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.match.MetaInfoPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.match.MetaInfoPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.match.MetaInfoPb)
      com.tiwari.studence.proto.match.MetaInfoPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.match.Match.internal_static_com_tiwari_studence_proto_match_MetaInfoPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.match.Match.internal_static_com_tiwari_studence_proto_match_MetaInfoPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.match.MetaInfoPb.class, com.tiwari.studence.proto.match.MetaInfoPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.match.MetaInfoPb.newBuilder()
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
      if (matchInfoBuilder_ == null) {
        matchInfo_ = java.util.Collections.emptyList();
      } else {
        matchInfo_ = null;
        matchInfoBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.match.Match.internal_static_com_tiwari_studence_proto_match_MetaInfoPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.match.MetaInfoPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.match.MetaInfoPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.match.MetaInfoPb build() {
      com.tiwari.studence.proto.match.MetaInfoPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.match.MetaInfoPb buildPartial() {
      com.tiwari.studence.proto.match.MetaInfoPb result = new com.tiwari.studence.proto.match.MetaInfoPb(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.tiwari.studence.proto.match.MetaInfoPb result) {
      if (matchInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          matchInfo_ = java.util.Collections.unmodifiableList(matchInfo_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.matchInfo_ = matchInfo_;
      } else {
        result.matchInfo_ = matchInfoBuilder_.build();
      }
    }

    private void buildPartial0(com.tiwari.studence.proto.match.MetaInfoPb result) {
      int from_bitField0_ = bitField0_;
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
      if (other instanceof com.tiwari.studence.proto.match.MetaInfoPb) {
        return mergeFrom((com.tiwari.studence.proto.match.MetaInfoPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.match.MetaInfoPb other) {
      if (other == com.tiwari.studence.proto.match.MetaInfoPb.getDefaultInstance()) return this;
      if (matchInfoBuilder_ == null) {
        if (!other.matchInfo_.isEmpty()) {
          if (matchInfo_.isEmpty()) {
            matchInfo_ = other.matchInfo_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMatchInfoIsMutable();
            matchInfo_.addAll(other.matchInfo_);
          }
          onChanged();
        }
      } else {
        if (!other.matchInfo_.isEmpty()) {
          if (matchInfoBuilder_.isEmpty()) {
            matchInfoBuilder_.dispose();
            matchInfoBuilder_ = null;
            matchInfo_ = other.matchInfo_;
            bitField0_ = (bitField0_ & ~0x00000001);
            matchInfoBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMatchInfoFieldBuilder() : null;
          } else {
            matchInfoBuilder_.addAllMessages(other.matchInfo_);
          }
        }
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
              com.tiwari.studence.proto.match.MatchInfoPb m =
                  input.readMessage(
                      com.tiwari.studence.proto.match.MatchInfoPb.parser(),
                      extensionRegistry);
              if (matchInfoBuilder_ == null) {
                ensureMatchInfoIsMutable();
                matchInfo_.add(m);
              } else {
                matchInfoBuilder_.addMessage(m);
              }
              break;
            } // case 10
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

    private java.util.List<com.tiwari.studence.proto.match.MatchInfoPb> matchInfo_ =
      java.util.Collections.emptyList();
    private void ensureMatchInfoIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        matchInfo_ = new java.util.ArrayList<com.tiwari.studence.proto.match.MatchInfoPb>(matchInfo_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.tiwari.studence.proto.match.MatchInfoPb, com.tiwari.studence.proto.match.MatchInfoPb.Builder, com.tiwari.studence.proto.match.MatchInfoPbOrBuilder> matchInfoBuilder_;

    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public java.util.List<com.tiwari.studence.proto.match.MatchInfoPb> getMatchInfoList() {
      if (matchInfoBuilder_ == null) {
        return java.util.Collections.unmodifiableList(matchInfo_);
      } else {
        return matchInfoBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public int getMatchInfoCount() {
      if (matchInfoBuilder_ == null) {
        return matchInfo_.size();
      } else {
        return matchInfoBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public com.tiwari.studence.proto.match.MatchInfoPb getMatchInfo(int index) {
      if (matchInfoBuilder_ == null) {
        return matchInfo_.get(index);
      } else {
        return matchInfoBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder setMatchInfo(
        int index, com.tiwari.studence.proto.match.MatchInfoPb value) {
      if (matchInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMatchInfoIsMutable();
        matchInfo_.set(index, value);
        onChanged();
      } else {
        matchInfoBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder setMatchInfo(
        int index, com.tiwari.studence.proto.match.MatchInfoPb.Builder builderForValue) {
      if (matchInfoBuilder_ == null) {
        ensureMatchInfoIsMutable();
        matchInfo_.set(index, builderForValue.build());
        onChanged();
      } else {
        matchInfoBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder addMatchInfo(com.tiwari.studence.proto.match.MatchInfoPb value) {
      if (matchInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMatchInfoIsMutable();
        matchInfo_.add(value);
        onChanged();
      } else {
        matchInfoBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder addMatchInfo(
        int index, com.tiwari.studence.proto.match.MatchInfoPb value) {
      if (matchInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMatchInfoIsMutable();
        matchInfo_.add(index, value);
        onChanged();
      } else {
        matchInfoBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder addMatchInfo(
        com.tiwari.studence.proto.match.MatchInfoPb.Builder builderForValue) {
      if (matchInfoBuilder_ == null) {
        ensureMatchInfoIsMutable();
        matchInfo_.add(builderForValue.build());
        onChanged();
      } else {
        matchInfoBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder addMatchInfo(
        int index, com.tiwari.studence.proto.match.MatchInfoPb.Builder builderForValue) {
      if (matchInfoBuilder_ == null) {
        ensureMatchInfoIsMutable();
        matchInfo_.add(index, builderForValue.build());
        onChanged();
      } else {
        matchInfoBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder addAllMatchInfo(
        java.lang.Iterable<? extends com.tiwari.studence.proto.match.MatchInfoPb> values) {
      if (matchInfoBuilder_ == null) {
        ensureMatchInfoIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, matchInfo_);
        onChanged();
      } else {
        matchInfoBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder clearMatchInfo() {
      if (matchInfoBuilder_ == null) {
        matchInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        matchInfoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public Builder removeMatchInfo(int index) {
      if (matchInfoBuilder_ == null) {
        ensureMatchInfoIsMutable();
        matchInfo_.remove(index);
        onChanged();
      } else {
        matchInfoBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public com.tiwari.studence.proto.match.MatchInfoPb.Builder getMatchInfoBuilder(
        int index) {
      return getMatchInfoFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public com.tiwari.studence.proto.match.MatchInfoPbOrBuilder getMatchInfoOrBuilder(
        int index) {
      if (matchInfoBuilder_ == null) {
        return matchInfo_.get(index);  } else {
        return matchInfoBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public java.util.List<? extends com.tiwari.studence.proto.match.MatchInfoPbOrBuilder> 
         getMatchInfoOrBuilderList() {
      if (matchInfoBuilder_ != null) {
        return matchInfoBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(matchInfo_);
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public com.tiwari.studence.proto.match.MatchInfoPb.Builder addMatchInfoBuilder() {
      return getMatchInfoFieldBuilder().addBuilder(
          com.tiwari.studence.proto.match.MatchInfoPb.getDefaultInstance());
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public com.tiwari.studence.proto.match.MatchInfoPb.Builder addMatchInfoBuilder(
        int index) {
      return getMatchInfoFieldBuilder().addBuilder(
          index, com.tiwari.studence.proto.match.MatchInfoPb.getDefaultInstance());
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.match.MatchInfoPb matchInfo = 1;</code>
     */
    public java.util.List<com.tiwari.studence.proto.match.MatchInfoPb.Builder> 
         getMatchInfoBuilderList() {
      return getMatchInfoFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.tiwari.studence.proto.match.MatchInfoPb, com.tiwari.studence.proto.match.MatchInfoPb.Builder, com.tiwari.studence.proto.match.MatchInfoPbOrBuilder> 
        getMatchInfoFieldBuilder() {
      if (matchInfoBuilder_ == null) {
        matchInfoBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.tiwari.studence.proto.match.MatchInfoPb, com.tiwari.studence.proto.match.MatchInfoPb.Builder, com.tiwari.studence.proto.match.MatchInfoPbOrBuilder>(
                matchInfo_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        matchInfo_ = null;
      }
      return matchInfoBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.match.MetaInfoPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.match.MetaInfoPb)
  private static final com.tiwari.studence.proto.match.MetaInfoPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.match.MetaInfoPb();
  }

  public static com.tiwari.studence.proto.match.MetaInfoPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MetaInfoPb>
      PARSER = new com.google.protobuf.AbstractParser<MetaInfoPb>() {
    @java.lang.Override
    public MetaInfoPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<MetaInfoPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MetaInfoPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.match.MetaInfoPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

