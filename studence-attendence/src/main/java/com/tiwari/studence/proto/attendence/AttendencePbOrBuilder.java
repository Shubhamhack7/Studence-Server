// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: attendencePb.proto

package com.tiwari.studence.proto.attendence;

public interface AttendencePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.attendence.AttendencePb)
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
   * <code>.com.tiwari.studence.proto.name.NamePb name = 2;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>.com.tiwari.studence.proto.name.NamePb name = 2;</code>
   * @return The name.
   */
  com.tiwari.studence.proto.name.NamePb getName();
  /**
   * <code>.com.tiwari.studence.proto.name.NamePb name = 2;</code>
   */
  com.tiwari.studence.proto.name.NamePbOrBuilder getNameOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.student.StudentRefPb studentRef = 3;</code>
   * @return Whether the studentRef field is set.
   */
  boolean hasStudentRef();
  /**
   * <code>.com.tiwari.studence.proto.student.StudentRefPb studentRef = 3;</code>
   * @return The studentRef.
   */
  com.tiwari.studence.proto.student.StudentRefPb getStudentRef();
  /**
   * <code>.com.tiwari.studence.proto.student.StudentRefPb studentRef = 3;</code>
   */
  com.tiwari.studence.proto.student.StudentRefPbOrBuilder getStudentRefOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.classes.ClassesRefPb classRef = 4;</code>
   * @return Whether the classRef field is set.
   */
  boolean hasClassRef();
  /**
   * <code>.com.tiwari.studence.proto.classes.ClassesRefPb classRef = 4;</code>
   * @return The classRef.
   */
  com.tiwari.studence.proto.classes.ClassesRefPb getClassRef();
  /**
   * <code>.com.tiwari.studence.proto.classes.ClassesRefPb classRef = 4;</code>
   */
  com.tiwari.studence.proto.classes.ClassesRefPbOrBuilder getClassRefOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.teacher.TeacherRefPb teacherRef = 5;</code>
   * @return Whether the teacherRef field is set.
   */
  boolean hasTeacherRef();
  /**
   * <code>.com.tiwari.studence.proto.teacher.TeacherRefPb teacherRef = 5;</code>
   * @return The teacherRef.
   */
  com.tiwari.studence.proto.teacher.TeacherRefPb getTeacherRef();
  /**
   * <code>.com.tiwari.studence.proto.teacher.TeacherRefPb teacherRef = 5;</code>
   */
  com.tiwari.studence.proto.teacher.TeacherRefPbOrBuilder getTeacherRefOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.datatypes.BooleanEnum isPresent = 6;</code>
   * @return The enum numeric value on the wire for isPresent.
   */
  int getIsPresentValue();
  /**
   * <code>.com.tiwari.studence.proto.datatypes.BooleanEnum isPresent = 6;</code>
   * @return The isPresent.
   */
  com.tiwari.studence.proto.datatypes.BooleanEnum getIsPresent();
}
