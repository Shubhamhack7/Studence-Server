// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: organisationPb.proto

package com.tiwari.studence.proto.organisation;

public interface OrganisationSearchRespPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.organisation.OrganisationSearchRespPb)
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
   * <code>repeated .com.tiwari.studence.proto.organisation.OrganisationPb results = 2;</code>
   */
  java.util.List<com.tiwari.studence.proto.organisation.OrganisationPb> 
      getResultsList();
  /**
   * <code>repeated .com.tiwari.studence.proto.organisation.OrganisationPb results = 2;</code>
   */
  com.tiwari.studence.proto.organisation.OrganisationPb getResults(int index);
  /**
   * <code>repeated .com.tiwari.studence.proto.organisation.OrganisationPb results = 2;</code>
   */
  int getResultsCount();
  /**
   * <code>repeated .com.tiwari.studence.proto.organisation.OrganisationPb results = 2;</code>
   */
  java.util.List<? extends com.tiwari.studence.proto.organisation.OrganisationPbOrBuilder> 
      getResultsOrBuilderList();
  /**
   * <code>repeated .com.tiwari.studence.proto.organisation.OrganisationPb results = 2;</code>
   */
  com.tiwari.studence.proto.organisation.OrganisationPbOrBuilder getResultsOrBuilder(
      int index);
}
