// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: campusPb.proto

package com.tiwari.studence.proto.campus;

/**
 * Protobuf type {@code com.tiwari.studence.proto.campus.CampusSearchRespPb}
 */
public final class CampusSearchRespPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.tiwari.studence.proto.campus.CampusSearchRespPb)
    CampusSearchRespPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CampusSearchRespPb.newBuilder() to construct.
  private CampusSearchRespPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CampusSearchRespPb() {
    results_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CampusSearchRespPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.tiwari.studence.proto.campus.CampusPbOuterClass.internal_static_com_tiwari_studence_proto_campus_CampusSearchRespPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.tiwari.studence.proto.campus.CampusPbOuterClass.internal_static_com_tiwari_studence_proto_campus_CampusSearchRespPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.tiwari.studence.proto.campus.CampusSearchRespPb.class, com.tiwari.studence.proto.campus.CampusSearchRespPb.Builder.class);
  }

  public static final int SUMMARY_FIELD_NUMBER = 1;
  private com.tiwari.studence.proto.summary.SummaryPb summary_;
  /**
   * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
   * @return Whether the summary field is set.
   */
  @java.lang.Override
  public boolean hasSummary() {
    return summary_ != null;
  }
  /**
   * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
   * @return The summary.
   */
  @java.lang.Override
  public com.tiwari.studence.proto.summary.SummaryPb getSummary() {
    return summary_ == null ? com.tiwari.studence.proto.summary.SummaryPb.getDefaultInstance() : summary_;
  }
  /**
   * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.summary.SummaryPbOrBuilder getSummaryOrBuilder() {
    return summary_ == null ? com.tiwari.studence.proto.summary.SummaryPb.getDefaultInstance() : summary_;
  }

  public static final int RESULTS_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private java.util.List<com.tiwari.studence.proto.campus.CampusPb> results_;
  /**
   * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
   */
  @java.lang.Override
  public java.util.List<com.tiwari.studence.proto.campus.CampusPb> getResultsList() {
    return results_;
  }
  /**
   * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.tiwari.studence.proto.campus.CampusPbOrBuilder> 
      getResultsOrBuilderList() {
    return results_;
  }
  /**
   * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
   */
  @java.lang.Override
  public int getResultsCount() {
    return results_.size();
  }
  /**
   * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.campus.CampusPb getResults(int index) {
    return results_.get(index);
  }
  /**
   * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
   */
  @java.lang.Override
  public com.tiwari.studence.proto.campus.CampusPbOrBuilder getResultsOrBuilder(
      int index) {
    return results_.get(index);
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
    if (summary_ != null) {
      output.writeMessage(1, getSummary());
    }
    for (int i = 0; i < results_.size(); i++) {
      output.writeMessage(2, results_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (summary_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getSummary());
    }
    for (int i = 0; i < results_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, results_.get(i));
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
    if (!(obj instanceof com.tiwari.studence.proto.campus.CampusSearchRespPb)) {
      return super.equals(obj);
    }
    com.tiwari.studence.proto.campus.CampusSearchRespPb other = (com.tiwari.studence.proto.campus.CampusSearchRespPb) obj;

    if (hasSummary() != other.hasSummary()) return false;
    if (hasSummary()) {
      if (!getSummary()
          .equals(other.getSummary())) return false;
    }
    if (!getResultsList()
        .equals(other.getResultsList())) return false;
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
    if (hasSummary()) {
      hash = (37 * hash) + SUMMARY_FIELD_NUMBER;
      hash = (53 * hash) + getSummary().hashCode();
    }
    if (getResultsCount() > 0) {
      hash = (37 * hash) + RESULTS_FIELD_NUMBER;
      hash = (53 * hash) + getResultsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.tiwari.studence.proto.campus.CampusSearchRespPb parseFrom(
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
  public static Builder newBuilder(com.tiwari.studence.proto.campus.CampusSearchRespPb prototype) {
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
   * Protobuf type {@code com.tiwari.studence.proto.campus.CampusSearchRespPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.tiwari.studence.proto.campus.CampusSearchRespPb)
      com.tiwari.studence.proto.campus.CampusSearchRespPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.tiwari.studence.proto.campus.CampusPbOuterClass.internal_static_com_tiwari_studence_proto_campus_CampusSearchRespPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.tiwari.studence.proto.campus.CampusPbOuterClass.internal_static_com_tiwari_studence_proto_campus_CampusSearchRespPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.tiwari.studence.proto.campus.CampusSearchRespPb.class, com.tiwari.studence.proto.campus.CampusSearchRespPb.Builder.class);
    }

    // Construct using com.tiwari.studence.proto.campus.CampusSearchRespPb.newBuilder()
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
      summary_ = null;
      if (summaryBuilder_ != null) {
        summaryBuilder_.dispose();
        summaryBuilder_ = null;
      }
      if (resultsBuilder_ == null) {
        results_ = java.util.Collections.emptyList();
      } else {
        results_ = null;
        resultsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.tiwari.studence.proto.campus.CampusPbOuterClass.internal_static_com_tiwari_studence_proto_campus_CampusSearchRespPb_descriptor;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.campus.CampusSearchRespPb getDefaultInstanceForType() {
      return com.tiwari.studence.proto.campus.CampusSearchRespPb.getDefaultInstance();
    }

    @java.lang.Override
    public com.tiwari.studence.proto.campus.CampusSearchRespPb build() {
      com.tiwari.studence.proto.campus.CampusSearchRespPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.tiwari.studence.proto.campus.CampusSearchRespPb buildPartial() {
      com.tiwari.studence.proto.campus.CampusSearchRespPb result = new com.tiwari.studence.proto.campus.CampusSearchRespPb(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.tiwari.studence.proto.campus.CampusSearchRespPb result) {
      if (resultsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          results_ = java.util.Collections.unmodifiableList(results_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.results_ = results_;
      } else {
        result.results_ = resultsBuilder_.build();
      }
    }

    private void buildPartial0(com.tiwari.studence.proto.campus.CampusSearchRespPb result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.summary_ = summaryBuilder_ == null
            ? summary_
            : summaryBuilder_.build();
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
      if (other instanceof com.tiwari.studence.proto.campus.CampusSearchRespPb) {
        return mergeFrom((com.tiwari.studence.proto.campus.CampusSearchRespPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.tiwari.studence.proto.campus.CampusSearchRespPb other) {
      if (other == com.tiwari.studence.proto.campus.CampusSearchRespPb.getDefaultInstance()) return this;
      if (other.hasSummary()) {
        mergeSummary(other.getSummary());
      }
      if (resultsBuilder_ == null) {
        if (!other.results_.isEmpty()) {
          if (results_.isEmpty()) {
            results_ = other.results_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureResultsIsMutable();
            results_.addAll(other.results_);
          }
          onChanged();
        }
      } else {
        if (!other.results_.isEmpty()) {
          if (resultsBuilder_.isEmpty()) {
            resultsBuilder_.dispose();
            resultsBuilder_ = null;
            results_ = other.results_;
            bitField0_ = (bitField0_ & ~0x00000002);
            resultsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getResultsFieldBuilder() : null;
          } else {
            resultsBuilder_.addAllMessages(other.results_);
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
              input.readMessage(
                  getSummaryFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              com.tiwari.studence.proto.campus.CampusPb m =
                  input.readMessage(
                      com.tiwari.studence.proto.campus.CampusPb.parser(),
                      extensionRegistry);
              if (resultsBuilder_ == null) {
                ensureResultsIsMutable();
                results_.add(m);
              } else {
                resultsBuilder_.addMessage(m);
              }
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

    private com.tiwari.studence.proto.summary.SummaryPb summary_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.summary.SummaryPb, com.tiwari.studence.proto.summary.SummaryPb.Builder, com.tiwari.studence.proto.summary.SummaryPbOrBuilder> summaryBuilder_;
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     * @return Whether the summary field is set.
     */
    public boolean hasSummary() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     * @return The summary.
     */
    public com.tiwari.studence.proto.summary.SummaryPb getSummary() {
      if (summaryBuilder_ == null) {
        return summary_ == null ? com.tiwari.studence.proto.summary.SummaryPb.getDefaultInstance() : summary_;
      } else {
        return summaryBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     */
    public Builder setSummary(com.tiwari.studence.proto.summary.SummaryPb value) {
      if (summaryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        summary_ = value;
      } else {
        summaryBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     */
    public Builder setSummary(
        com.tiwari.studence.proto.summary.SummaryPb.Builder builderForValue) {
      if (summaryBuilder_ == null) {
        summary_ = builderForValue.build();
      } else {
        summaryBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     */
    public Builder mergeSummary(com.tiwari.studence.proto.summary.SummaryPb value) {
      if (summaryBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          summary_ != null &&
          summary_ != com.tiwari.studence.proto.summary.SummaryPb.getDefaultInstance()) {
          getSummaryBuilder().mergeFrom(value);
        } else {
          summary_ = value;
        }
      } else {
        summaryBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     */
    public Builder clearSummary() {
      bitField0_ = (bitField0_ & ~0x00000001);
      summary_ = null;
      if (summaryBuilder_ != null) {
        summaryBuilder_.dispose();
        summaryBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     */
    public com.tiwari.studence.proto.summary.SummaryPb.Builder getSummaryBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getSummaryFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     */
    public com.tiwari.studence.proto.summary.SummaryPbOrBuilder getSummaryOrBuilder() {
      if (summaryBuilder_ != null) {
        return summaryBuilder_.getMessageOrBuilder();
      } else {
        return summary_ == null ?
            com.tiwari.studence.proto.summary.SummaryPb.getDefaultInstance() : summary_;
      }
    }
    /**
     * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.tiwari.studence.proto.summary.SummaryPb, com.tiwari.studence.proto.summary.SummaryPb.Builder, com.tiwari.studence.proto.summary.SummaryPbOrBuilder> 
        getSummaryFieldBuilder() {
      if (summaryBuilder_ == null) {
        summaryBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.tiwari.studence.proto.summary.SummaryPb, com.tiwari.studence.proto.summary.SummaryPb.Builder, com.tiwari.studence.proto.summary.SummaryPbOrBuilder>(
                getSummary(),
                getParentForChildren(),
                isClean());
        summary_ = null;
      }
      return summaryBuilder_;
    }

    private java.util.List<com.tiwari.studence.proto.campus.CampusPb> results_ =
      java.util.Collections.emptyList();
    private void ensureResultsIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        results_ = new java.util.ArrayList<com.tiwari.studence.proto.campus.CampusPb>(results_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.tiwari.studence.proto.campus.CampusPb, com.tiwari.studence.proto.campus.CampusPb.Builder, com.tiwari.studence.proto.campus.CampusPbOrBuilder> resultsBuilder_;

    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public java.util.List<com.tiwari.studence.proto.campus.CampusPb> getResultsList() {
      if (resultsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(results_);
      } else {
        return resultsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public int getResultsCount() {
      if (resultsBuilder_ == null) {
        return results_.size();
      } else {
        return resultsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public com.tiwari.studence.proto.campus.CampusPb getResults(int index) {
      if (resultsBuilder_ == null) {
        return results_.get(index);
      } else {
        return resultsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder setResults(
        int index, com.tiwari.studence.proto.campus.CampusPb value) {
      if (resultsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResultsIsMutable();
        results_.set(index, value);
        onChanged();
      } else {
        resultsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder setResults(
        int index, com.tiwari.studence.proto.campus.CampusPb.Builder builderForValue) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        results_.set(index, builderForValue.build());
        onChanged();
      } else {
        resultsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder addResults(com.tiwari.studence.proto.campus.CampusPb value) {
      if (resultsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResultsIsMutable();
        results_.add(value);
        onChanged();
      } else {
        resultsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder addResults(
        int index, com.tiwari.studence.proto.campus.CampusPb value) {
      if (resultsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureResultsIsMutable();
        results_.add(index, value);
        onChanged();
      } else {
        resultsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder addResults(
        com.tiwari.studence.proto.campus.CampusPb.Builder builderForValue) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        results_.add(builderForValue.build());
        onChanged();
      } else {
        resultsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder addResults(
        int index, com.tiwari.studence.proto.campus.CampusPb.Builder builderForValue) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        results_.add(index, builderForValue.build());
        onChanged();
      } else {
        resultsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder addAllResults(
        java.lang.Iterable<? extends com.tiwari.studence.proto.campus.CampusPb> values) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, results_);
        onChanged();
      } else {
        resultsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder clearResults() {
      if (resultsBuilder_ == null) {
        results_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        resultsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public Builder removeResults(int index) {
      if (resultsBuilder_ == null) {
        ensureResultsIsMutable();
        results_.remove(index);
        onChanged();
      } else {
        resultsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public com.tiwari.studence.proto.campus.CampusPb.Builder getResultsBuilder(
        int index) {
      return getResultsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public com.tiwari.studence.proto.campus.CampusPbOrBuilder getResultsOrBuilder(
        int index) {
      if (resultsBuilder_ == null) {
        return results_.get(index);  } else {
        return resultsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public java.util.List<? extends com.tiwari.studence.proto.campus.CampusPbOrBuilder> 
         getResultsOrBuilderList() {
      if (resultsBuilder_ != null) {
        return resultsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(results_);
      }
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public com.tiwari.studence.proto.campus.CampusPb.Builder addResultsBuilder() {
      return getResultsFieldBuilder().addBuilder(
          com.tiwari.studence.proto.campus.CampusPb.getDefaultInstance());
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public com.tiwari.studence.proto.campus.CampusPb.Builder addResultsBuilder(
        int index) {
      return getResultsFieldBuilder().addBuilder(
          index, com.tiwari.studence.proto.campus.CampusPb.getDefaultInstance());
    }
    /**
     * <code>repeated .com.tiwari.studence.proto.campus.CampusPb results = 2;</code>
     */
    public java.util.List<com.tiwari.studence.proto.campus.CampusPb.Builder> 
         getResultsBuilderList() {
      return getResultsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.tiwari.studence.proto.campus.CampusPb, com.tiwari.studence.proto.campus.CampusPb.Builder, com.tiwari.studence.proto.campus.CampusPbOrBuilder> 
        getResultsFieldBuilder() {
      if (resultsBuilder_ == null) {
        resultsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.tiwari.studence.proto.campus.CampusPb, com.tiwari.studence.proto.campus.CampusPb.Builder, com.tiwari.studence.proto.campus.CampusPbOrBuilder>(
                results_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        results_ = null;
      }
      return resultsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.tiwari.studence.proto.campus.CampusSearchRespPb)
  }

  // @@protoc_insertion_point(class_scope:com.tiwari.studence.proto.campus.CampusSearchRespPb)
  private static final com.tiwari.studence.proto.campus.CampusSearchRespPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.tiwari.studence.proto.campus.CampusSearchRespPb();
  }

  public static com.tiwari.studence.proto.campus.CampusSearchRespPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CampusSearchRespPb>
      PARSER = new com.google.protobuf.AbstractParser<CampusSearchRespPb>() {
    @java.lang.Override
    public CampusSearchRespPb parsePartialFrom(
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

  public static com.google.protobuf.Parser<CampusSearchRespPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CampusSearchRespPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.tiwari.studence.proto.campus.CampusSearchRespPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

