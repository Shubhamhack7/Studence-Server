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
    internal_static_com_tiwari_studence_proto_organisation_OrganisationRefPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_organisation_OrganisationRefPb_fieldAccessorTable;
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
      "nce.proto.organisation\032\016entityPb.proto\032\014" +
      "namePb.proto\032\026contactDetailsPb.proto\032\017su" +
      "mmaryPb.proto\"\326\001\n\016OrganisationPb\022:\n\006dbIn" +
      "fo\030\001 \001(\0132*.com.tiwari.studence.proto.ent" +
      "ity.EntityPb\0224\n\004name\030\002 \001(\0132&.com.tiwari." +
      "studence.proto.name.NamePb\022R\n\016contactDet" +
      "ails\030\003 \001(\0132:.com.tiwari.studence.proto.c" +
      "ontactDetails.ContactDetailsPb\"3\n\021Organi" +
      "sationRefPb\022\020\n\010dbInfoId\030\001 \001(\t\022\014\n\004name\030\002 " +
      "\001(\t\"\'\n\027OrganisationSearchReqPb\022\014\n\004name\030\001" +
      " \001(\t\"\242\001\n\030OrganisationSearchRespPb\022=\n\007sum" +
      "mary\030\001 \001(\0132,.com.tiwari.studence.proto.s" +
      "ummary.SummaryPb\022G\n\007results\030\002 \003(\01326.com." +
      "tiwari.studence.proto.organisation.Organ" +
      "isationPbB\005P\001\240\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.name.NamePbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.getDescriptor(),
          com.tiwari.studence.proto.summary.SummaryPbOuterClass.getDescriptor(),
        });
    internal_static_com_tiwari_studence_proto_organisation_OrganisationPb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_organisation_OrganisationPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_organisation_OrganisationPb_descriptor,
        new java.lang.String[] { "DbInfo", "Name", "ContactDetails", });
    internal_static_com_tiwari_studence_proto_organisation_OrganisationRefPb_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_tiwari_studence_proto_organisation_OrganisationRefPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_organisation_OrganisationRefPb_descriptor,
        new java.lang.String[] { "DbInfoId", "Name", });
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchReqPb_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchRespPb_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchRespPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_organisation_OrganisationSearchRespPb_descriptor,
        new java.lang.String[] { "Summary", "Results", });
    com.tiwari.studence.proto.entity.EntityPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.name.NamePbOuterClass.getDescriptor();
    com.tiwari.studence.proto.contactDetails.ContactDetailsPbOuterClass.getDescriptor();
    com.tiwari.studence.proto.summary.SummaryPbOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
