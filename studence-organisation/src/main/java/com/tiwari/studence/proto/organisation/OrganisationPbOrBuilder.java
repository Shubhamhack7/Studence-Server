// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: organisationPb.proto

package com.tiwari.studence.proto.organisation;

public interface OrganisationPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.organisation.OrganisationPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   * @return Whether the dbInfo field is set.
   */
  boolean hasDbInfo();
  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   * @return The dbInfo.
   */
  com.tiwari.studence.proto.entity.EntityPb getDbInfo();
  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   */
  com.tiwari.studence.proto.entity.EntityPbOrBuilder getDbInfoOrBuilder();

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
}
