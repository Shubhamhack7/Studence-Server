// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: campusPb.proto

package com.tiwari.studence.proto.campus;

public interface CampusRefPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.campus.CampusRefPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string dbInfoId = 1;</code>
   * @return The dbInfoId.
   */
  java.lang.String getDbInfoId();
  /**
   * <code>string dbInfoId = 1;</code>
   * @return The bytes for dbInfoId.
   */
  com.google.protobuf.ByteString
      getDbInfoIdBytes();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.com.tiwari.studence.proto.organisation.OrganisationRefPb organisationRef = 3;</code>
   * @return Whether the organisationRef field is set.
   */
  boolean hasOrganisationRef();
  /**
   * <code>.com.tiwari.studence.proto.organisation.OrganisationRefPb organisationRef = 3;</code>
   * @return The organisationRef.
   */
  com.tiwari.studence.proto.organisation.OrganisationRefPb getOrganisationRef();
  /**
   * <code>.com.tiwari.studence.proto.organisation.OrganisationRefPb organisationRef = 3;</code>
   */
  com.tiwari.studence.proto.organisation.OrganisationRefPbOrBuilder getOrganisationRefOrBuilder();
}
