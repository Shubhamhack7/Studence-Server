// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: classPb.proto

package com.tiwari.studence.proto.classes;

public final class ClassPb {
  private ClassPb() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_classes_ClassesPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_classes_ClassesPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_classes_ClassesSearchReqPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_classes_ClassesSearchReqPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_classes_ClassesSearchRespPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_classes_ClassesSearchRespPb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rclassPb.proto\022!com.tiwari.studence.pro" +
      "to.classes\032\016entityPb.proto\032\017summaryPb.pr" +
      "oto\032\016campusPb.proto\032\022genericRefPb.proto\"" +
      "\345\002\n\tClassesPb\022:\n\006dbInfo\030\001 \001(\0132*.com.tiwa" +
      "ri.studence.proto.entity.EntityPb\022?\n\tcla" +
      "ssType\030\002 \001(\0162,.com.tiwari.studence.proto" +
      ".classes.ClassType\022C\n\013sectionType\030\003 \001(\0162" +
      "..com.tiwari.studence.proto.classes.Sect" +
      "ionType\022@\n\tcampusRef\030\004 \001(\0132-.com.tiwari." +
      "studence.proto.campus.CampusRefPb\022T\n\roth" +
      "ersTeacher\030\005 \003(\0132=.com.tiwari.studence.p" +
      "roto.genericRef.GenericRefPbWithBoolean\"" +
      "\246\001\n\014ClassesRefPb\022\020\n\010dbInfoId\030\001 \001(\t\022?\n\tcl" +
      "assType\030\002 \001(\0162,.com.tiwari.studence.prot" +
      "o.classes.ClassType\022C\n\013sectionType\030\003 \001(\016" +
      "2..com.tiwari.studence.proto.classes.Sec" +
      "tionType\"\257\001\n\022ClassesSearchReqPb\022?\n\tclass" +
      "Type\030\001 \001(\0162,.com.tiwari.studence.proto.c" +
      "lasses.ClassType\022C\n\013sectionType\030\002 \001(\0162.." +
      "com.tiwari.studence.proto.classes.Sectio" +
      "nType\022\023\n\013campusRefId\030\003 \001(\t\"\223\001\n\023ClassesSe" +
      "archRespPb\022=\n\007summary\030\001 \001(\0132,.com.tiwari" +
      ".studence.proto.summary.SummaryPb\022=\n\007res" +
      "ults\030\002 \003(\0132,.com.tiwari.studence.proto.c" +
      "lasses.ClassesPb*\222\002\n\tClassType\022\021\n\rCLASS_" +
      "UNKNOWN\020\000\022\r\n\tCLASS_ONE\020\001\022\r\n\tCLASS_TWO\020\002\022" +
      "\017\n\013CLASS_THREE\020\003\022\016\n\nCLASS_FOUR\020\004\022\016\n\nCLAS" +
      "S_FIVE\020\005\022\r\n\tCLASS_SIX\020\006\022\017\n\013CLASS_SEVEN\020\007" +
      "\022\017\n\013CLASS_EIGHT\020\010\022\016\n\nCLASS_NINE\020\t\022\r\n\tCLA" +
      "SS_TEN\020\n\022\020\n\014CLASS_ELEVEN\020\013\022\020\n\014CLASS_TWEL" +
      "VE\020\014\022\021\n\rCLASS_NURSERY\020\r\022\r\n\tCLASS_LKG\020\016\022\r" +
      "\n\tCLASS_UKG\020\017*\270\001\n\013SectionType\022\023\n\017SECTION" +
      "_UNKNOWN\020\000\022\r\n\tSECTION_A\020\001\022\r\n\tSECTION_B\020\002" +
      "\022\r\n\tSECTION_C\020\003\022\r\n\tSECTION_D\020\004\022\r\n\tSECTIO" +
      "N_E\020\005\022\r\n\tSECTION_F\020\006\022\r\n\tSECTION_G\020\007\022\r\n\tS" +
      "ECTION_H\020\010\022\r\n\tSECTION_I\020\t\022\r\n\tSECTION_J\020\n" +
      "B\005P\001\240\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.summary.SummaryPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.campus.CampusPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.genericRef.GenericRefPbOuterClass.getDescriptor(),
        });
    internal_static_com_tiwari_studence_proto_classes_ClassesPb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_classes_ClassesPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_classes_ClassesPb_descriptor,
        new java.lang.String[] { "DbInfo", "ClassType", "SectionType", "CampusRef", "OthersTeacher", });
    internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_classes_ClassesRefPb_descriptor,
        new java.lang.String[] { "DbInfoId", "ClassType", "SectionType", });
    internal_static_com_tiwari_studence_proto_classes_ClassesSearchReqPb_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_tiwari_studence_proto_classes_ClassesSearchReqPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_classes_ClassesSearchReqPb_descriptor,
        new java.lang.String[] { "ClassType", "SectionType", "CampusRefId", });
    internal_static_com_tiwari_studence_proto_classes_ClassesSearchRespPb_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_tiwari_studence_proto_classes_ClassesSearchRespPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_classes_ClassesSearchRespPb_descriptor,
        new java.lang.String[] { "Summary", "Results", });
    com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.summary.SummaryPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.campus.CampusPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.genericRef.GenericRefPbOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
