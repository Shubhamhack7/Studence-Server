// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: attendencePb.proto

package com.tiwari.studence.proto.attendence;

public interface AttendenceSearchRespPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.attendence.AttendenceSearchRespPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
   * @return Whether the summary field is set.
   */
  boolean hasSummary();
  /**
   * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
   * @return The summary.
   */
  com.tiwari.studence.proto.summary.SummaryPb getSummary();
  /**
   * <code>.com.tiwari.studence.proto.summary.SummaryPb summary = 1;</code>
   */
  com.tiwari.studence.proto.summary.SummaryPbOrBuilder getSummaryOrBuilder();

  /**
   * <code>repeated .com.tiwari.studence.proto.attendence.AttendencePb results = 2;</code>
   */
  java.util.List<com.tiwari.studence.proto.attendence.AttendencePb> 
      getResultsList();
  /**
   * <code>repeated .com.tiwari.studence.proto.attendence.AttendencePb results = 2;</code>
   */
  com.tiwari.studence.proto.attendence.AttendencePb getResults(int index);
  /**
   * <code>repeated .com.tiwari.studence.proto.attendence.AttendencePb results = 2;</code>
   */
  int getResultsCount();
  /**
   * <code>repeated .com.tiwari.studence.proto.attendence.AttendencePb results = 2;</code>
   */
  java.util.List<? extends com.tiwari.studence.proto.attendence.AttendencePbOrBuilder> 
      getResultsOrBuilderList();
  /**
   * <code>repeated .com.tiwari.studence.proto.attendence.AttendencePb results = 2;</code>
   */
  com.tiwari.studence.proto.attendence.AttendencePbOrBuilder getResultsOrBuilder(
      int index);
}
