// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: typeAheadPb.proto

package com.tiwari.studence.proto.typeAhead;

public interface TypeAheadPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.typeAhead.TypeAheadPb)
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
   * <code>.com.tiwari.studence.proto.genericRef.GenericRefPb context = 2;</code>
   * @return Whether the context field is set.
   */
  boolean hasContext();
  /**
   * <code>.com.tiwari.studence.proto.genericRef.GenericRefPb context = 2;</code>
   * @return The context.
   */
  com.tiwari.studence.proto.genericRef.GenericRefPb getContext();
  /**
   * <code>.com.tiwari.studence.proto.genericRef.GenericRefPb context = 2;</code>
   */
  com.tiwari.studence.proto.genericRef.GenericRefPbOrBuilder getContextOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.login.ProfileTypeEnum typeAheadType = 3;</code>
   * @return The enum numeric value on the wire for typeAheadType.
   */
  int getTypeAheadTypeValue();
  /**
   * <code>.com.tiwari.studence.proto.login.ProfileTypeEnum typeAheadType = 3;</code>
   * @return The typeAheadType.
   */
  com.tiwari.studence.proto.login.ProfileTypeEnum getTypeAheadType();
}