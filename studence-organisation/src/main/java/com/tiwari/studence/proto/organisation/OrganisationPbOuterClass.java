// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: organisationPb.proto

package com.tiwari.studence.proto.organisation;

public final class OrganisationPbOuterClass {
  private OrganisationPbOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_organisation_OrganisationPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_organisation_OrganisationPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchRespPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchRespPb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024organisationPb.proto\022&com.tiwari.stude" +
      "nce.proto.organisation\032\016entityPb.proto\"Z" +
      "\n\016OrganisationPb\022:\n\006dbInfo\030\001 \001(\0132*.com.t" +
      "iwari.studence.proto.entity.EntityPb\022\014\n\004" +
      "name\030\002 \001(\t\"c\n\027OrganisationSearchReqPb\022:\n" +
      "\006dbInfo\030\001 \001(\0132*.com.tiwari.studence.prot" +
      "o.entity.EntityPb\022\014\n\004name\030\002 \001(\t\"d\n\030Organ" +
      "isationSearchRespPb\022:\n\006dbInfo\030\001 \001(\0132*.co" +
      "m.tiwari.studence.proto.entity.EntityPb\022" +
      "\014\n\004name\030\002 \001(\tB\005P\001\240\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor(),
        });
    internal_static_com_tiwari_studence_proto_organisation_OrganisationPb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_organisation_OrganisationPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_organisation_OrganisationPb_descriptor,
        new java.lang.String[] { "DbInfo", "Name", });
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_descriptor,
        new java.lang.String[] { "DbInfo", "Name", });
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchRespPb_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchRespPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchRespPb_descriptor,
        new java.lang.String[] { "DbInfo", "Name", });
    com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
