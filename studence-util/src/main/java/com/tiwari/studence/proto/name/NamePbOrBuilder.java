// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: namePb.proto

package com.tiwari.studence.proto.name;

public interface NamePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.name.NamePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string firstName = 1;</code>
   * @return The firstName.
   */
  java.lang.String getFirstName();
  /**
   * <code>string firstName = 1;</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>repeated string middleName = 2;</code>
   * @return A list containing the middleName.
   */
  java.util.List<java.lang.String>
      getMiddleNameList();
  /**
   * <code>repeated string middleName = 2;</code>
   * @return The count of middleName.
   */
  int getMiddleNameCount();
  /**
   * <code>repeated string middleName = 2;</code>
   * @param index The index of the element to return.
   * @return The middleName at the given index.
   */
  java.lang.String getMiddleName(int index);
  /**
   * <code>repeated string middleName = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the middleName at the given index.
   */
  com.google.protobuf.ByteString
      getMiddleNameBytes(int index);

  /**
   * <code>string lastName = 3;</code>
   * @return The lastName.
   */
  java.lang.String getLastName();
  /**
   * <code>string lastName = 3;</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>string canonicalName = 4;</code>
   * @return The canonicalName.
   */
  java.lang.String getCanonicalName();
  /**
   * <code>string canonicalName = 4;</code>
   * @return The bytes for canonicalName.
   */
  com.google.protobuf.ByteString
      getCanonicalNameBytes();
}