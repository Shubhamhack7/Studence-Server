// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: studentPb.proto

package com.tiwari.studence.proto.student;

public interface StudentRefPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.student.StudentRefPb)
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
   * <code>.com.tiwari.studence.proto.classes.ClassType classType = 3;</code>
   * @return The enum numeric value on the wire for classType.
   */
  int getClassTypeValue();
  /**
   * <code>.com.tiwari.studence.proto.classes.ClassType classType = 3;</code>
   * @return The classType.
   */
  com.tiwari.studence.proto.classes.ClassType getClassType();

  /**
   * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
   * @return Whether the campusRef field is set.
   */
  boolean hasCampusRef();
  /**
   * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
   * @return The campusRef.
   */
  com.tiwari.studence.proto.campus.CampusRefPb getCampusRef();
  /**
   * <code>.com.tiwari.studence.proto.campus.CampusRefPb campusRef = 4;</code>
   */
  com.tiwari.studence.proto.campus.CampusRefPbOrBuilder getCampusRefOrBuilder();

  /**
   * <code>string classRollNo = 5;</code>
   * @return The classRollNo.
   */
  java.lang.String getClassRollNo();
  /**
   * <code>string classRollNo = 5;</code>
   * @return The bytes for classRollNo.
   */
  com.google.protobuf.ByteString
      getClassRollNoBytes();

  /**
   * <code>.com.tiwari.studence.proto.guardian.GuardianRefPb parentRef = 6;</code>
   * @return Whether the parentRef field is set.
   */
  boolean hasParentRef();
  /**
   * <code>.com.tiwari.studence.proto.guardian.GuardianRefPb parentRef = 6;</code>
   * @return The parentRef.
   */
  com.tiwari.studence.proto.guardian.GuardianRefPb getParentRef();
  /**
   * <code>.com.tiwari.studence.proto.guardian.GuardianRefPb parentRef = 6;</code>
   */
  com.tiwari.studence.proto.guardian.GuardianRefPbOrBuilder getParentRefOrBuilder();
}
