// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: mergeOption.proto

package com.tiwari.studence.proto.mergeOption;

public final class MergeOption {
  private MergeOption() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
    registry.add(com.tiwari.studence.proto.mergeOption.MergeOption.mergeToken);
    registry.add(com.tiwari.studence.proto.mergeOption.MergeOption.isBasicType);
    registry.add(com.tiwari.studence.proto.mergeOption.MergeOption.matcher);
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public static final int MERGETOKEN_FIELD_NUMBER = 51234;
  /**
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.lang.String> mergeToken = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int ISBASICTYPE_FIELD_NUMBER = 51235;
  /**
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.lang.String> isBasicType = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int MATCHER_FIELD_NUMBER = 51236;
  /**
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.lang.String> matcher = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021mergeOption.proto\022%com.tiwari.studence" +
      ".proto.mergeOption\032 google/protobuf/desc" +
      "riptor.proto:8\n\nmergeToken\022\037.google.prot" +
      "obuf.MessageOptions\030\242\220\003 \001(\t\210\001\001:9\n\013isBasi" +
      "cType\022\037.google.protobuf.MessageOptions\030\243" +
      "\220\003 \001(\t\210\001\001:5\n\007matcher\022\037.google.protobuf.M" +
      "essageOptions\030\244\220\003 \001(\t\210\001\001B\005P\001\240\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.DescriptorProtos.getDescriptor(),
        });
    mergeToken.internalInit(descriptor.getExtensions().get(0));
    isBasicType.internalInit(descriptor.getExtensions().get(1));
    matcher.internalInit(descriptor.getExtensions().get(2));
    com.google.protobuf.DescriptorProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
