// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: error.proto

package com.tiwari.studence.proto.error;

public interface RedirectPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.error.RedirectPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .com.tiwari.studence.proto.error.RedirectTypeEnum redirectType = 1;</code>
   * @return Whether the redirectType field is set.
   */
  boolean hasRedirectType();
  /**
   * <code>optional .com.tiwari.studence.proto.error.RedirectTypeEnum redirectType = 1;</code>
   * @return The enum numeric value on the wire for redirectType.
   */
  int getRedirectTypeValue();
  /**
   * <code>optional .com.tiwari.studence.proto.error.RedirectTypeEnum redirectType = 1;</code>
   * @return The redirectType.
   */
  com.tiwari.studence.proto.error.RedirectTypeEnum getRedirectType();

  /**
   * <code>optional string location = 2;</code>
   * @return Whether the location field is set.
   */
  boolean hasLocation();
  /**
   * <code>optional string location = 2;</code>
   * @return The location.
   */
  java.lang.String getLocation();
  /**
   * <code>optional string location = 2;</code>
   * @return The bytes for location.
   */
  com.google.protobuf.ByteString
      getLocationBytes();
}
