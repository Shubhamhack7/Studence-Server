// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: exponentialDelay.proto

package com.tiwari.studence.proto.exponentialDelay;

public final class ExponentialDelay {
  private ExponentialDelay() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_exponentialDelay_ExponentialDelayPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_exponentialDelay_ExponentialDelayPb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026exponentialDelay.proto\022*com.tiwari.stu" +
      "dence.proto.exponentialDelay\"^\n\022Exponent" +
      "ialDelayPb\022\026\n\tbaseDelay\030\001 \001(\005H\000\210\001\001\022\025\n\010ma" +
      "xTries\030\003 \001(\005H\001\210\001\001B\014\n\n_baseDelayB\013\n\t_maxT" +
      "riesB\005P\001\240\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_tiwari_studence_proto_exponentialDelay_ExponentialDelayPb_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_exponentialDelay_ExponentialDelayPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_exponentialDelay_ExponentialDelayPb_descriptor,
        new java.lang.String[] { "BaseDelay", "MaxTries", "BaseDelay", "MaxTries", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
