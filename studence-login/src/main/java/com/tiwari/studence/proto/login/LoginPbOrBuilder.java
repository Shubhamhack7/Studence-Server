// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: loginPb.proto

package com.tiwari.studence.proto.login;

public interface LoginPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.login.LoginPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   * @return Whether the dbInfo field is set.
   */
  boolean hasDbInfo();
  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   * @return The dbInfo.
   */
  com.tiwari.studence.proto.entity.EntityPb getDbInfo();
  /**
   * <code>.com.tiwari.studence.proto.entity.EntityPb dbInfo = 1;</code>
   */
  com.tiwari.studence.proto.entity.EntityPbOrBuilder getDbInfoOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.login.ProfileTypeEnum type = 2;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.com.tiwari.studence.proto.login.ProfileTypeEnum type = 2;</code>
   * @return The type.
   */
  com.tiwari.studence.proto.login.ProfileTypeEnum getType();

  /**
   * <code>.com.tiwari.studence.proto.genericRef.GenericRefPb ref = 3;</code>
   * @return Whether the ref field is set.
   */
  boolean hasRef();
  /**
   * <code>.com.tiwari.studence.proto.genericRef.GenericRefPb ref = 3;</code>
   * @return The ref.
   */
  com.tiwari.studence.proto.genericRef.GenericRefPb getRef();
  /**
   * <code>.com.tiwari.studence.proto.genericRef.GenericRefPb ref = 3;</code>
   */
  com.tiwari.studence.proto.genericRef.GenericRefPbOrBuilder getRefOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.contactDetails.MobileNumberPb mobileNo = 4;</code>
   * @return Whether the mobileNo field is set.
   */
  boolean hasMobileNo();
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.MobileNumberPb mobileNo = 4;</code>
   * @return The mobileNo.
   */
  com.tiwari.studence.proto.contactDetails.MobileNumberPb getMobileNo();
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.MobileNumberPb mobileNo = 4;</code>
   */
  com.tiwari.studence.proto.contactDetails.MobileNumberPbOrBuilder getMobileNoOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.contactDetails.EmailPb emailId = 5;</code>
   * @return Whether the emailId field is set.
   */
  boolean hasEmailId();
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.EmailPb emailId = 5;</code>
   * @return The emailId.
   */
  com.tiwari.studence.proto.contactDetails.EmailPb getEmailId();
  /**
   * <code>.com.tiwari.studence.proto.contactDetails.EmailPb emailId = 5;</code>
   */
  com.tiwari.studence.proto.contactDetails.EmailPbOrBuilder getEmailIdOrBuilder();

  /**
   * <code>string encryptedPassword = 6;</code>
   * @return The encryptedPassword.
   */
  java.lang.String getEncryptedPassword();
  /**
   * <code>string encryptedPassword = 6;</code>
   * @return The bytes for encryptedPassword.
   */
  com.google.protobuf.ByteString
      getEncryptedPasswordBytes();
}
