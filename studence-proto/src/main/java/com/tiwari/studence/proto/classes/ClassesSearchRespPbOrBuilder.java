// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: classesPb.proto

package com.tiwari.studence.proto.classes;

public interface ClassesSearchRespPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.classes.ClassesSearchRespPb)
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
   * <code>repeated .com.tiwari.studence.proto.classes.ClassesPb results = 2;</code>
   */
  java.util.List<com.tiwari.studence.proto.classes.ClassesPb> 
      getResultsList();
  /**
   * <code>repeated .com.tiwari.studence.proto.classes.ClassesPb results = 2;</code>
   */
  com.tiwari.studence.proto.classes.ClassesPb getResults(int index);
  /**
   * <code>repeated .com.tiwari.studence.proto.classes.ClassesPb results = 2;</code>
   */
  int getResultsCount();
  /**
   * <code>repeated .com.tiwari.studence.proto.classes.ClassesPb results = 2;</code>
   */
  java.util.List<? extends com.tiwari.studence.proto.classes.ClassesPbOrBuilder> 
      getResultsOrBuilderList();
  /**
   * <code>repeated .com.tiwari.studence.proto.classes.ClassesPb results = 2;</code>
   */
  com.tiwari.studence.proto.classes.ClassesPbOrBuilder getResultsOrBuilder(
      int index);
}
