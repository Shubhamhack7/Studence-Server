// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: match.proto

package com.tiwari.studence.proto.match;

public interface MatchInfoPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.match.MatchInfoPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string sourceRefId = 1;</code>
   * @return Whether the sourceRefId field is set.
   */
  boolean hasSourceRefId();
  /**
   * <code>optional string sourceRefId = 1;</code>
   * @return The sourceRefId.
   */
  java.lang.String getSourceRefId();
  /**
   * <code>optional string sourceRefId = 1;</code>
   * @return The bytes for sourceRefId.
   */
  com.google.protobuf.ByteString
      getSourceRefIdBytes();

  /**
   * <code>optional .com.tiwari.studence.proto.match.MatchInfoUiEnum matchInfo = 2;</code>
   * @return Whether the matchInfo field is set.
   */
  boolean hasMatchInfo();
  /**
   * <code>optional .com.tiwari.studence.proto.match.MatchInfoUiEnum matchInfo = 2;</code>
   * @return The enum numeric value on the wire for matchInfo.
   */
  int getMatchInfoValue();
  /**
   * <code>optional .com.tiwari.studence.proto.match.MatchInfoUiEnum matchInfo = 2;</code>
   * @return The matchInfo.
   */
  com.tiwari.studence.proto.match.MatchInfoUiEnum getMatchInfo();

  /**
   * <code>optional .com.tiwari.studence.proto.time.TimePb matchedTime = 3;</code>
   * @return Whether the matchedTime field is set.
   */
  boolean hasMatchedTime();
  /**
   * <code>optional .com.tiwari.studence.proto.time.TimePb matchedTime = 3;</code>
   * @return The matchedTime.
   */
  com.tiwari.studence.proto.time.TimePb getMatchedTime();
  /**
   * <code>optional .com.tiwari.studence.proto.time.TimePb matchedTime = 3;</code>
   */
  com.tiwari.studence.proto.time.TimePbOrBuilder getMatchedTimeOrBuilder();

  /**
   * <code>optional int32 diff = 4;</code>
   * @return Whether the diff field is set.
   */
  boolean hasDiff();
  /**
   * <code>optional int32 diff = 4;</code>
   * @return The diff.
   */
  int getDiff();
}
