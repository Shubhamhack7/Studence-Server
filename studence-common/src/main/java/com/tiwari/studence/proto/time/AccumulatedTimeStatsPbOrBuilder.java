// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: time.proto

package com.tiwari.studence.proto.time;

public interface AccumulatedTimeStatsPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.time.AccumulatedTimeStatsPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.tiwari.studence.proto.time.TimeStatsPb timeStats = 2;</code>
   */
  java.util.List<com.tiwari.studence.proto.time.TimeStatsPb> 
      getTimeStatsList();
  /**
   * <code>repeated .com.tiwari.studence.proto.time.TimeStatsPb timeStats = 2;</code>
   */
  com.tiwari.studence.proto.time.TimeStatsPb getTimeStats(int index);
  /**
   * <code>repeated .com.tiwari.studence.proto.time.TimeStatsPb timeStats = 2;</code>
   */
  int getTimeStatsCount();
  /**
   * <code>repeated .com.tiwari.studence.proto.time.TimeStatsPb timeStats = 2;</code>
   */
  java.util.List<? extends com.tiwari.studence.proto.time.TimeStatsPbOrBuilder> 
      getTimeStatsOrBuilderList();
  /**
   * <code>repeated .com.tiwari.studence.proto.time.TimeStatsPb timeStats = 2;</code>
   */
  com.tiwari.studence.proto.time.TimeStatsPbOrBuilder getTimeStatsOrBuilder(
      int index);

  /**
   * <code>.com.tiwari.studence.proto.time.AccumulatedTimeStatsIdPb name = 3;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>.com.tiwari.studence.proto.time.AccumulatedTimeStatsIdPb name = 3;</code>
   * @return The name.
   */
  com.tiwari.studence.proto.time.AccumulatedTimeStatsIdPb getName();
  /**
   * <code>.com.tiwari.studence.proto.time.AccumulatedTimeStatsIdPb name = 3;</code>
   */
  com.tiwari.studence.proto.time.AccumulatedTimeStatsIdPbOrBuilder getNameOrBuilder();
}
