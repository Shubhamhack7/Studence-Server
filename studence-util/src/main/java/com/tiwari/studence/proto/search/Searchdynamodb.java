// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: searchdynamodb.proto

package com.tiwari.studence.proto.search;

public final class Searchdynamodb {
  private Searchdynamodb() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_search_AttributeNameValuePair_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_search_AttributeNameValuePair_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_search_SearchPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_search_SearchPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_search_SearchRequestsPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_search_SearchRequestsPb_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_tiwari_studence_proto_search_DynamoDbSearchPb_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_tiwari_studence_proto_search_DynamoDbSearchPb_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024searchdynamodb.proto\022 com.tiwari.stude" +
      "nce.proto.search\"\321\002\n\026AttributeNameValueP" +
      "air\022=\n\004type\030\001 \001(\0162/.com.tiwari.studence." +
      "proto.search.DynamoDBValue\022\014\n\004name\030\002 \001(\t" +
      "\022\020\n\010intValue\030\003 \001(\005\022\022\n\nfloatValue\030\004 \001(\002\022\023" +
      "\n\013stringValue\030\005 \001(\t\022\023\n\013binaryValue\030\006 \001(\014" +
      "\022\022\n\nexpression\030\007 \001(\t\022\032\n\022attributeNameAli" +
      "as\030\010 \001(\t\022\033\n\023attributeValueAlias\030\t \001(\t\022M\n" +
      "\013compareType\030\n \001(\01628.com.tiwari.studence" +
      ".proto.search.ComparisonOperatorEnum\"\240\001\n" +
      "\010SearchPb\022F\n\004type\030\001 \001(\01628.com.tiwari.stu" +
      "dence.proto.search.ComparisonOperatorEnu" +
      "m\022L\n\nattributes\030\002 \003(\01328.com.tiwari.stude" +
      "nce.proto.search.AttributeNameValuePair\"" +
      "\366\001\n\020SearchRequestsPb\022B\n\004mode\030\001 \001(\01624.com" +
      ".tiwari.studence.proto.search.DynamoDBSe" +
      "archMode\022M\n\tOperators\030\002 \003(\0162:.com.tiwari" +
      ".studence.proto.search.DynamoDBLogicalOp" +
      "erators\022<\n\010requests\030\003 \003(\0132*.com.tiwari.s" +
      "tudence.proto.search.SearchPb\022\021\n\tnextTok" +
      "en\030\004 \001(\t\"\240\002\n\020DynamoDbSearchPb\022B\n\004mode\030\001 " +
      "\001(\01624.com.tiwari.studence.proto.search.D" +
      "ynamoDBSearchMode\022\021\n\ttableName\030\002 \001(\t\022\021\n\t" +
      "indexName\030\003 \001(\t\022\036\n\026keyConditionExpressio" +
      "n\030\004 \001(\t\022\030\n\020filterExpression\030\006 \001(\t\022U\n\023exp" +
      "ressionAttribute\030\007 \003(\01328.com.tiwari.stud" +
      "ence.proto.search.AttributeNameValuePair" +
      "\022\021\n\tnextToken\030\010 \001(\t*\203\001\n\022DynamoDBSearchMo" +
      "de\022\020\n\014UNKNOWN_MODE\020\000\022\016\n\nQUERY_MODE\020\001\022\024\n\020" +
      "SCAN_FILTER_MODE\020\002\022\032\n\026GLOBAL_SECONDARY_I" +
      "NDEX\020\003\022\031\n\025LOCAL_SECONDARY_INDEX\020\004*K\n\030Dyn" +
      "amoDBLogicalOperators\022\025\n\021UNKNOWN_OPERATO" +
      "RS\020\000\022\007\n\003AND\020\001\022\006\n\002OR\020\002\022\007\n\003NOT\020\003*\375\001\n\026Compa" +
      "risonOperatorEnum\022\013\n\007UNKNOWN\020\000\022\014\n\010EQUAL_" +
      "TO\020\001\022\020\n\014NOT_EQUAL_TO\020\002\022\020\n\014GREATER_THAN\020\003" +
      "\022\r\n\tLESS_THAN\020\004\022\034\n\030GREATER_THAN_OR_EQUAL" +
      "_TO\020\005\022\031\n\025LESS_THAN_OR_EQUAL_TO\020\006\022\013\n\007BETW" +
      "EEN\020\007\022\006\n\002IN\020\010\022\014\n\010NOT_NULL\020\t\022\010\n\004NULL\020\n\022\014\n" +
      "\010CONTAINS\020\013\022\020\n\014NOT_CONTAINS\020\014\022\017\n\013BEGINS_" +
      "WITH\020\r*\227\001\n\rDynamoDBValue\022\036\n\032DYNAMODB_VAL" +
      "UE_UNSPECIFIED\020\000\022\031\n\025DYNAMODB_VALUE_STRIN" +
      "G\020\001\022\026\n\022DYNAMODB_VALUE_INT\020\002\022\031\n\025DYNAMODB_" +
      "VALUE_BINARY\020\003\022\030\n\024DYNAMODB_VALUE_FLOAT\020\004" +
      "B\005P\001\240\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_tiwari_studence_proto_search_AttributeNameValuePair_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_tiwari_studence_proto_search_AttributeNameValuePair_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_search_AttributeNameValuePair_descriptor,
        new java.lang.String[] { "Type", "Name", "IntValue", "FloatValue", "StringValue", "BinaryValue", "Expression", "AttributeNameAlias", "AttributeValueAlias", "CompareType", });
    internal_static_com_tiwari_studence_proto_search_SearchPb_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_tiwari_studence_proto_search_SearchPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_search_SearchPb_descriptor,
        new java.lang.String[] { "Type", "Attributes", });
    internal_static_com_tiwari_studence_proto_search_SearchRequestsPb_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_tiwari_studence_proto_search_SearchRequestsPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_search_SearchRequestsPb_descriptor,
        new java.lang.String[] { "Mode", "Operators", "Requests", "NextToken", });
    internal_static_com_tiwari_studence_proto_search_DynamoDbSearchPb_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_tiwari_studence_proto_search_DynamoDbSearchPb_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_tiwari_studence_proto_search_DynamoDbSearchPb_descriptor,
        new java.lang.String[] { "Mode", "TableName", "IndexName", "KeyConditionExpression", "FilterExpression", "ExpressionAttribute", "NextToken", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
