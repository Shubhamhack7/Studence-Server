// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: attendencePb.proto

package com.tiwari.studence.proto.attendence;

public final class AttendencePbOuterClass {
  private AttendencePbOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_attendence_AttendencePb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_attendence_AttendencePb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_attendence_AttendenceRefPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_attendence_AttendenceRefPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchReqPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchReqPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchRespPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchRespPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_attendence_MarkAttendencePb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_attendence_MarkAttendencePb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022attendencePb.proto\022$com.tiwari.studenc" +
      "e.proto.attendence\032\016entityPb.proto\032\014name" +
      "Pb.proto\032\017summaryPb.proto\032\017studentPb.pro" +
      "to\032\rclassPb.proto\032\017teacherPb.proto\032\021data" +
      "TypesPb.proto\"\222\003\n\014AttendencePb\022:\n\006dbInfo" +
      "\030\001 \001(\0132*.com.tiwari.studence.proto.entit" +
      "y.EntityPb\0224\n\004name\030\002 \001(\0132&.com.tiwari.st" +
      "udence.proto.name.NamePb\022C\n\nstudentRef\030\003" +
      " \001(\0132/.com.tiwari.studence.proto.student" +
      ".StudentRefPb\022A\n\010classRef\030\004 \001(\0132/.com.ti" +
      "wari.studence.proto.classes.ClassesRefPb" +
      "\022C\n\nteacherRef\030\005 \001(\0132/.com.tiwari.studen" +
      "ce.proto.teacher.TeacherRefPb\022C\n\tisPrese" +
      "nt\030\006 \001(\01620.com.tiwari.studence.proto.dat" +
      "atypes.BooleanEnum\"1\n\017AttendenceRefPb\022\020\n" +
      "\010dbInfoId\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\"%\n\025Attende" +
      "nceSearchReqPb\022\014\n\004name\030\001 \001(\t\"\234\001\n\026Attende" +
      "nceSearchRespPb\022=\n\007summary\030\001 \001(\0132,.com.t" +
      "iwari.studence.proto.summary.SummaryPb\022C" +
      "\n\007results\030\002 \003(\01322.com.tiwari.studence.pr" +
      "oto.attendence.AttendencePb\"(\n\020MarkAtten" +
      "dencePb\022\024\n\014attendenceId\030\001 \003(\tB\005P\001\240\001\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.name.NamePbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.summary.SummaryPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.student.StudentPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.classes.ClassPb.getDescriptor(),
          com.tiwari.studence.proto.teacher.TeacherPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.datatypes.DataTypesPb.getDescriptor(),
        });
    internal_static_com_tiwari_studence_proto_attendence_AttendencePb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_attendence_AttendencePb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_attendence_AttendencePb_descriptor,
        new java.lang.String[] { "DbInfo", "Name", "StudentRef", "ClassRef", "TeacherRef", "IsPresent", });
    internal_static_com_tiwari_studence_proto_attendence_AttendenceRefPb_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_tiwari_studence_proto_attendence_AttendenceRefPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_attendence_AttendenceRefPb_descriptor,
        new java.lang.String[] { "DbInfoId", "Name", });
    internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchReqPb_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchReqPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchReqPb_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchRespPb_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchRespPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_attendence_AttendenceSearchRespPb_descriptor,
        new java.lang.String[] { "Summary", "Results", });
    internal_static_com_tiwari_studence_proto_attendence_MarkAttendencePb_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_tiwari_studence_proto_attendence_MarkAttendencePb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_attendence_MarkAttendencePb_descriptor,
        new java.lang.String[] { "AttendenceId", });
    com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.name.NamePbOuterClass.getDescriptor();
    com.tiwari.studence.proto.summary.SummaryPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.student.StudentPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.classes.ClassPb.getDescriptor();
    com.tiwari.studence.proto.teacher.TeacherPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.datatypes.DataTypesPb.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
