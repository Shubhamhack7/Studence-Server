// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: search.proto

package com.tiwari.studence.proto.search;

public interface PaginationRequestPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.search.PaginationRequestPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 maxResults = 1;</code>
   * @return Whether the maxResults field is set.
   */
  boolean hasMaxResults();
  /**
   * <code>optional int32 maxResults = 1;</code>
   * @return The maxResults.
   */
  int getMaxResults();

  /**
   * <code>optional string startToken = 2;</code>
   * @return Whether the startToken field is set.
   */
  boolean hasStartToken();
  /**
   * <code>optional string startToken = 2;</code>
   * @return The startToken.
   */
  java.lang.String getStartToken();
  /**
   * <code>optional string startToken = 2;</code>
   * @return The bytes for startToken.
   */
  com.google.protobuf.ByteString
      getStartTokenBytes();

  /**
   * <code>optional int32 startIndex = 3;</code>
   * @return Whether the startIndex field is set.
   */
  boolean hasStartIndex();
  /**
   * <code>optional int32 startIndex = 3;</code>
   * @return The startIndex.
   */
  int getStartIndex();
}
