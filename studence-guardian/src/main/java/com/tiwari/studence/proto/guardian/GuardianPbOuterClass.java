// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: guardianPb.proto

package com.tiwari.studence.proto.guardian;

public final class GuardianPbOuterClass {
  private GuardianPbOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_guardian_GuardianPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_guardian_GuardianPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_guardian_GuardianRefPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_guardian_GuardianRefPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_guardian_GuardianSearchReqPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_guardian_GuardianSearchReqPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_guardian_GuardianSearchRespPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_guardian_GuardianSearchRespPb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020guardianPb.proto\022\"com.tiwari.studence." +
      "proto.guardian\032\016entityPb.proto\032\014namePb.p" +
      "roto\032\026contactDetailsPb.proto\032\017summaryPb." +
      "proto\"\252\002\n\nGuardianPb\022:\n\006dbInfo\030\001 \001(\0132*.c" +
      "om.tiwari.studence.proto.entity.EntityPb" +
      "\022:\n\nfatherName\030\002 \001(\0132&.com.tiwari.studen" +
      "ce.proto.name.NamePb\022:\n\nmotherName\030\003 \001(\013" +
      "2&.com.tiwari.studence.proto.name.NamePb" +
      "\022\024\n\014noOfChildern\030\004 \001(\005\022R\n\016contactDetails" +
      "\030\005 \001(\0132:.com.tiwari.studence.proto.conta" +
      "ctDetails.ContactDetailsPb\"I\n\rGuardianRe" +
      "fPb\022\020\n\010dbInfoId\030\001 \001(\t\022\022\n\nfatherName\030\002 \001(" +
      "\t\022\022\n\nmotherName\030\003 \001(\t\"6\n\023GuardianSearchR" +
      "eqPb\022\021\n\tnextToken\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\"\226\001" +
      "\n\024GuardianSearchRespPb\022=\n\007summary\030\001 \001(\0132" +
      ",.com.tiwari.studence.proto.summary.Summ" +
      "aryPb\022?\n\007results\030\002 \003(\0132..com.tiwari.stud" +
      "ence.proto.guardian.GuardianPbB\005P\001\240\001\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.name.NamePbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.summary.SummaryPbOuterClass.getDescriptor(),
        });
    internal_static_com_tiwari_studence_proto_guardian_GuardianPb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_guardian_GuardianPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_guardian_GuardianPb_descriptor,
        new java.lang.String[] { "DbInfo", "FatherName", "MotherName", "NoOfChildern", "ContactDetails", });
    internal_static_com_tiwari_studence_proto_guardian_GuardianRefPb_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_tiwari_studence_proto_guardian_GuardianRefPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_guardian_GuardianRefPb_descriptor,
        new java.lang.String[] { "DbInfoId", "FatherName", "MotherName", });
    internal_static_com_tiwari_studence_proto_guardian_GuardianSearchReqPb_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_tiwari_studence_proto_guardian_GuardianSearchReqPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_guardian_GuardianSearchReqPb_descriptor,
        new java.lang.String[] { "NextToken", "Name", });
    internal_static_com_tiwari_studence_proto_guardian_GuardianSearchRespPb_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_tiwari_studence_proto_guardian_GuardianSearchRespPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_guardian_GuardianSearchRespPb_descriptor,
        new java.lang.String[] { "Summary", "Results", });
    com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.name.NamePbOuterClass.getDescriptor();
    com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.summary.SummaryPbOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
