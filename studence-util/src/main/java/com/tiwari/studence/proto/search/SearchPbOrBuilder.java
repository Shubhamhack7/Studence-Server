// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: searchdynamodb.proto

package com.tiwari.studence.proto.search;

public interface SearchPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.search.SearchPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tiwari.studence.proto.search.ComparisonOperatorEnum type = 1;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.com.tiwari.studence.proto.search.ComparisonOperatorEnum type = 1;</code>
   * @return The type.
   */
  com.tiwari.studence.proto.search.ComparisonOperatorEnum getType();

  /**
   * <code>repeated .com.tiwari.studence.proto.search.AttributeNameValuePair attributes = 2;</code>
   */
  java.util.List<com.tiwari.studence.proto.search.AttributeNameValuePair> 
      getAttributesList();
  /**
   * <code>repeated .com.tiwari.studence.proto.search.AttributeNameValuePair attributes = 2;</code>
   */
  com.tiwari.studence.proto.search.AttributeNameValuePair getAttributes(int index);
  /**
   * <code>repeated .com.tiwari.studence.proto.search.AttributeNameValuePair attributes = 2;</code>
   */
  int getAttributesCount();
  /**
   * <code>repeated .com.tiwari.studence.proto.search.AttributeNameValuePair attributes = 2;</code>
   */
  java.util.List<? extends com.tiwari.studence.proto.search.AttributeNameValuePairOrBuilder> 
      getAttributesOrBuilderList();
  /**
   * <code>repeated .com.tiwari.studence.proto.search.AttributeNameValuePair attributes = 2;</code>
   */
  com.tiwari.studence.proto.search.AttributeNameValuePairOrBuilder getAttributesOrBuilder(
      int index);
}
