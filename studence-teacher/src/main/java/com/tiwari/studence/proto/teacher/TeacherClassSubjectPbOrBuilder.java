// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: teacherPb.proto

package com.tiwari.studence.proto.teacher;

public interface TeacherClassSubjectPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.teacher.TeacherClassSubjectPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tiwari.studence.proto.subject.SubjectTypeEnum subjectType = 1;</code>
   * @return The enum numeric value on the wire for subjectType.
   */
  int getSubjectTypeValue();
  /**
   * <code>.com.tiwari.studence.proto.subject.SubjectTypeEnum subjectType = 1;</code>
   * @return The subjectType.
   */
  com.tiwari.studence.proto.subject.SubjectTypeEnum getSubjectType();

  /**
   * <code>.com.tiwari.studence.proto.classes.ClassesRefPb classTeacher = 2;</code>
   * @return Whether the classTeacher field is set.
   */
  boolean hasClassTeacher();
  /**
   * <code>.com.tiwari.studence.proto.classes.ClassesRefPb classTeacher = 2;</code>
   * @return The classTeacher.
   */
  com.tiwari.studence.proto.classes.ClassesRefPb getClassTeacher();
  /**
   * <code>.com.tiwari.studence.proto.classes.ClassesRefPb classTeacher = 2;</code>
   */
  com.tiwari.studence.proto.classes.ClassesRefPbOrBuilder getClassTeacherOrBuilder();
}
