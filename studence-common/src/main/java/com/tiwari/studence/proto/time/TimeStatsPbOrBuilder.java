// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: time.proto

package com.tiwari.studence.proto.time;

public interface TimeStatsPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.time.TimeStatsPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>int32 totalValue = 2;</code>
   * @return The totalValue.
   */
  int getTotalValue();

  /**
   * <code>int32 totalData = 3;</code>
   * @return The totalData.
   */
  int getTotalData();

  /**
   * <code>int32 minValue = 4;</code>
   * @return The minValue.
   */
  int getMinValue();

  /**
   * <code>int32 maxValue = 5;</code>
   * @return The maxValue.
   */
  int getMaxValue();

  /**
   * <code>double avg = 6;</code>
   * @return The avg.
   */
  double getAvg();
}
