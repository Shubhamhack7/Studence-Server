// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: loginPb.proto

package com.tiwari.studence.proto.login;

public interface LoginRespUiPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.login.LoginRespUiPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.tiwari.studence.proto.login.LoginPb login = 1;</code>
   * @return Whether the login field is set.
   */
  boolean hasLogin();
  /**
   * <code>.com.tiwari.studence.proto.login.LoginPb login = 1;</code>
   * @return The login.
   */
  com.tiwari.studence.proto.login.LoginPb getLogin();
  /**
   * <code>.com.tiwari.studence.proto.login.LoginPb login = 1;</code>
   */
  com.tiwari.studence.proto.login.LoginPbOrBuilder getLoginOrBuilder();

  /**
   * <code>string sesssionId = 2;</code>
   * @return The sesssionId.
   */
  java.lang.String getSesssionId();
  /**
   * <code>string sesssionId = 2;</code>
   * @return The bytes for sesssionId.
   */
  com.google.protobuf.ByteString
      getSesssionIdBytes();

  /**
   * <code>string sesssionToken = 3;</code>
   * @return The sesssionToken.
   */
  java.lang.String getSesssionToken();
  /**
   * <code>string sesssionToken = 3;</code>
   * @return The bytes for sesssionToken.
   */
  com.google.protobuf.ByteString
      getSesssionTokenBytes();
}
