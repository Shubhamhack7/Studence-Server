// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: devicePb.proto

package com.tiwari.studence.proto.devices;

public interface WebBrowserInfoDetailsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.devices.WebBrowserInfoDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string browserName = 1;</code>
   * @return The browserName.
   */
  java.lang.String getBrowserName();
  /**
   * <code>string browserName = 1;</code>
   * @return The bytes for browserName.
   */
  com.google.protobuf.ByteString
      getBrowserNameBytes();

  /**
   * <code>string appCodeName = 2;</code>
   * @return The appCodeName.
   */
  java.lang.String getAppCodeName();
  /**
   * <code>string appCodeName = 2;</code>
   * @return The bytes for appCodeName.
   */
  com.google.protobuf.ByteString
      getAppCodeNameBytes();

  /**
   * <code>string appName = 3;</code>
   * @return The appName.
   */
  java.lang.String getAppName();
  /**
   * <code>string appName = 3;</code>
   * @return The bytes for appName.
   */
  com.google.protobuf.ByteString
      getAppNameBytes();

  /**
   * <code>string appVersion = 4;</code>
   * @return The appVersion.
   */
  java.lang.String getAppVersion();
  /**
   * <code>string appVersion = 4;</code>
   * @return The bytes for appVersion.
   */
  com.google.protobuf.ByteString
      getAppVersionBytes();

  /**
   * <code>uint32 deviceMemory = 5;</code>
   * @return The deviceMemory.
   */
  int getDeviceMemory();

  /**
   * <code>string language = 6;</code>
   * @return The language.
   */
  java.lang.String getLanguage();
  /**
   * <code>string language = 6;</code>
   * @return The bytes for language.
   */
  com.google.protobuf.ByteString
      getLanguageBytes();

  /**
   * <code>repeated string languages = 7;</code>
   * @return A list containing the languages.
   */
  java.util.List<java.lang.String>
      getLanguagesList();
  /**
   * <code>repeated string languages = 7;</code>
   * @return The count of languages.
   */
  int getLanguagesCount();
  /**
   * <code>repeated string languages = 7;</code>
   * @param index The index of the element to return.
   * @return The languages at the given index.
   */
  java.lang.String getLanguages(int index);
  /**
   * <code>repeated string languages = 7;</code>
   * @param index The index of the value to return.
   * @return The bytes of the languages at the given index.
   */
  com.google.protobuf.ByteString
      getLanguagesBytes(int index);

  /**
   * <code>string platform = 8;</code>
   * @return The platform.
   */
  java.lang.String getPlatform();
  /**
   * <code>string platform = 8;</code>
   * @return The bytes for platform.
   */
  com.google.protobuf.ByteString
      getPlatformBytes();

  /**
   * <code>string product = 9;</code>
   * @return The product.
   */
  java.lang.String getProduct();
  /**
   * <code>string product = 9;</code>
   * @return The bytes for product.
   */
  com.google.protobuf.ByteString
      getProductBytes();

  /**
   * <code>string productSub = 10;</code>
   * @return The productSub.
   */
  java.lang.String getProductSub();
  /**
   * <code>string productSub = 10;</code>
   * @return The bytes for productSub.
   */
  com.google.protobuf.ByteString
      getProductSubBytes();

  /**
   * <code>string userAgent = 11;</code>
   * @return The userAgent.
   */
  java.lang.String getUserAgent();
  /**
   * <code>string userAgent = 11;</code>
   * @return The bytes for userAgent.
   */
  com.google.protobuf.ByteString
      getUserAgentBytes();

  /**
   * <code>string vendor = 12;</code>
   * @return The vendor.
   */
  java.lang.String getVendor();
  /**
   * <code>string vendor = 12;</code>
   * @return The bytes for vendor.
   */
  com.google.protobuf.ByteString
      getVendorBytes();

  /**
   * <code>string vendorSub = 13;</code>
   * @return The vendorSub.
   */
  java.lang.String getVendorSub();
  /**
   * <code>string vendorSub = 13;</code>
   * @return The bytes for vendorSub.
   */
  com.google.protobuf.ByteString
      getVendorSubBytes();

  /**
   * <code>uint32 hardwareConcurrency = 14;</code>
   * @return The hardwareConcurrency.
   */
  int getHardwareConcurrency();

  /**
   * <code>uint32 maxTouchPoints = 15;</code>
   * @return The maxTouchPoints.
   */
  int getMaxTouchPoints();
}
