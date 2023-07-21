// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: searchdynamodb.proto

package com.tiwari.studence.proto.search;

public interface AttributeNameValuePairOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.search.AttributeNameValuePair)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tiwari.studence.proto.search.DynamoDBValue type = 1;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.com.tiwari.studence.proto.search.DynamoDBValue type = 1;</code>
   * @return The type.
   */
  com.tiwari.studence.proto.search.DynamoDBValue getType();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 intValue = 3;</code>
   * @return The intValue.
   */
  int getIntValue();

  /**
   * <code>float floatValue = 4;</code>
   * @return The floatValue.
   */
  float getFloatValue();

  /**
   * <code>string stringValue = 5;</code>
   * @return The stringValue.
   */
  java.lang.String getStringValue();
  /**
   * <code>string stringValue = 5;</code>
   * @return The bytes for stringValue.
   */
  com.google.protobuf.ByteString
      getStringValueBytes();

  /**
   * <code>bytes binaryValue = 6;</code>
   * @return The binaryValue.
   */
  com.google.protobuf.ByteString getBinaryValue();

  /**
   * <code>string expression = 7;</code>
   * @return The expression.
   */
  java.lang.String getExpression();
  /**
   * <code>string expression = 7;</code>
   * @return The bytes for expression.
   */
  com.google.protobuf.ByteString
      getExpressionBytes();

  /**
   * <code>string attributeNameAlias = 8;</code>
   * @return The attributeNameAlias.
   */
  java.lang.String getAttributeNameAlias();
  /**
   * <code>string attributeNameAlias = 8;</code>
   * @return The bytes for attributeNameAlias.
   */
  com.google.protobuf.ByteString
      getAttributeNameAliasBytes();

  /**
   * <code>string attributeValueAlias = 9;</code>
   * @return The attributeValueAlias.
   */
  java.lang.String getAttributeValueAlias();
  /**
   * <code>string attributeValueAlias = 9;</code>
   * @return The bytes for attributeValueAlias.
   */
  com.google.protobuf.ByteString
      getAttributeValueAliasBytes();
}