// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: error.proto

package com.tiwari.studence.proto.error;

public interface ResultPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.error.ResultPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tiwari.studence.proto.error.ResultStatusUiEnum status = 1;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.com.tiwari.studence.proto.error.ResultStatusUiEnum status = 1;</code>
   * @return The status.
   */
  com.tiwari.studence.proto.error.ResultStatusUiEnum getStatus();

  /**
   * <code>.com.tiwari.studence.proto.error.ErrorResponsePb error = 2;</code>
   * @return Whether the error field is set.
   */
  boolean hasError();
  /**
   * <code>.com.tiwari.studence.proto.error.ErrorResponsePb error = 2;</code>
   * @return The error.
   */
  com.tiwari.studence.proto.error.ErrorResponsePb getError();
  /**
   * <code>.com.tiwari.studence.proto.error.ErrorResponsePb error = 2;</code>
   */
  com.tiwari.studence.proto.error.ErrorResponsePbOrBuilder getErrorOrBuilder();
}
