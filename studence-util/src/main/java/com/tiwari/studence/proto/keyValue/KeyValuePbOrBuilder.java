// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: keyValue.proto

package com.tiwari.studence.proto.keyValue;

public interface KeyValuePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.keyValue.KeyValuePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string key = 1;</code>
   * @return Whether the key field is set.
   */
  boolean hasKey();
  /**
   * <code>optional string key = 1;</code>
   * @return The key.
   */
  java.lang.String getKey();
  /**
   * <code>optional string key = 1;</code>
   * @return The bytes for key.
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <code>optional string value = 2;</code>
   * @return Whether the value field is set.
   */
  boolean hasValue();
  /**
   * <code>optional string value = 2;</code>
   * @return The value.
   */
  java.lang.String getValue();
  /**
   * <code>optional string value = 2;</code>
   * @return The bytes for value.
   */
  com.google.protobuf.ByteString
      getValueBytes();
}
