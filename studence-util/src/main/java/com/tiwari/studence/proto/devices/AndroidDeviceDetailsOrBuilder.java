// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: devicePb.proto

package com.tiwari.studence.proto.devices;

public interface AndroidDeviceDetailsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.devices.AndroidDeviceDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string security_patch = 1;</code>
   * @return The securityPatch.
   */
  java.lang.String getSecurityPatch();
  /**
   * <code>string security_patch = 1;</code>
   * @return The bytes for securityPatch.
   */
  com.google.protobuf.ByteString
      getSecurityPatchBytes();

  /**
   * <code>int32 sdk_int = 2;</code>
   * @return The sdkInt.
   */
  int getSdkInt();

  /**
   * <code>string release = 3;</code>
   * @return The release.
   */
  java.lang.String getRelease();
  /**
   * <code>string release = 3;</code>
   * @return The bytes for release.
   */
  com.google.protobuf.ByteString
      getReleaseBytes();

  /**
   * <code>int32 preview_sdk_int = 4;</code>
   * @return The previewSdkInt.
   */
  int getPreviewSdkInt();

  /**
   * <code>string incremental = 5;</code>
   * @return The incremental.
   */
  java.lang.String getIncremental();
  /**
   * <code>string incremental = 5;</code>
   * @return The bytes for incremental.
   */
  com.google.protobuf.ByteString
      getIncrementalBytes();

  /**
   * <code>string codename = 6;</code>
   * @return The codename.
   */
  java.lang.String getCodename();
  /**
   * <code>string codename = 6;</code>
   * @return The bytes for codename.
   */
  com.google.protobuf.ByteString
      getCodenameBytes();

  /**
   * <code>string base_os = 7;</code>
   * @return The baseOs.
   */
  java.lang.String getBaseOs();
  /**
   * <code>string base_os = 7;</code>
   * @return The bytes for baseOs.
   */
  com.google.protobuf.ByteString
      getBaseOsBytes();

  /**
   * <code>string board = 8;</code>
   * @return The board.
   */
  java.lang.String getBoard();
  /**
   * <code>string board = 8;</code>
   * @return The bytes for board.
   */
  com.google.protobuf.ByteString
      getBoardBytes();

  /**
   * <code>string bootloader = 9;</code>
   * @return The bootloader.
   */
  java.lang.String getBootloader();
  /**
   * <code>string bootloader = 9;</code>
   * @return The bytes for bootloader.
   */
  com.google.protobuf.ByteString
      getBootloaderBytes();

  /**
   * <code>string brand = 10;</code>
   * @return The brand.
   */
  java.lang.String getBrand();
  /**
   * <code>string brand = 10;</code>
   * @return The bytes for brand.
   */
  com.google.protobuf.ByteString
      getBrandBytes();

  /**
   * <code>string device = 11;</code>
   * @return The device.
   */
  java.lang.String getDevice();
  /**
   * <code>string device = 11;</code>
   * @return The bytes for device.
   */
  com.google.protobuf.ByteString
      getDeviceBytes();

  /**
   * <code>string display = 12;</code>
   * @return The display.
   */
  java.lang.String getDisplay();
  /**
   * <code>string display = 12;</code>
   * @return The bytes for display.
   */
  com.google.protobuf.ByteString
      getDisplayBytes();

  /**
   * <code>string fingerprint = 13;</code>
   * @return The fingerprint.
   */
  java.lang.String getFingerprint();
  /**
   * <code>string fingerprint = 13;</code>
   * @return The bytes for fingerprint.
   */
  com.google.protobuf.ByteString
      getFingerprintBytes();

  /**
   * <code>string hardware = 14;</code>
   * @return The hardware.
   */
  java.lang.String getHardware();
  /**
   * <code>string hardware = 14;</code>
   * @return The bytes for hardware.
   */
  com.google.protobuf.ByteString
      getHardwareBytes();

  /**
   * <code>string host = 15;</code>
   * @return The host.
   */
  java.lang.String getHost();
  /**
   * <code>string host = 15;</code>
   * @return The bytes for host.
   */
  com.google.protobuf.ByteString
      getHostBytes();

  /**
   * <code>string id = 16;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 16;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string manufacturer = 17;</code>
   * @return The manufacturer.
   */
  java.lang.String getManufacturer();
  /**
   * <code>string manufacturer = 17;</code>
   * @return The bytes for manufacturer.
   */
  com.google.protobuf.ByteString
      getManufacturerBytes();

  /**
   * <code>string model = 18;</code>
   * @return The model.
   */
  java.lang.String getModel();
  /**
   * <code>string model = 18;</code>
   * @return The bytes for model.
   */
  com.google.protobuf.ByteString
      getModelBytes();

  /**
   * <code>string product = 19;</code>
   * @return The product.
   */
  java.lang.String getProduct();
  /**
   * <code>string product = 19;</code>
   * @return The bytes for product.
   */
  com.google.protobuf.ByteString
      getProductBytes();

  /**
   * <code>repeated string supported_32_bit_abis = 20;</code>
   * @return A list containing the supported32BitAbis.
   */
  java.util.List<java.lang.String>
      getSupported32BitAbisList();
  /**
   * <code>repeated string supported_32_bit_abis = 20;</code>
   * @return The count of supported32BitAbis.
   */
  int getSupported32BitAbisCount();
  /**
   * <code>repeated string supported_32_bit_abis = 20;</code>
   * @param index The index of the element to return.
   * @return The supported32BitAbis at the given index.
   */
  java.lang.String getSupported32BitAbis(int index);
  /**
   * <code>repeated string supported_32_bit_abis = 20;</code>
   * @param index The index of the value to return.
   * @return The bytes of the supported32BitAbis at the given index.
   */
  com.google.protobuf.ByteString
      getSupported32BitAbisBytes(int index);

  /**
   * <code>repeated string supported_64_bit_abis = 21;</code>
   * @return A list containing the supported64BitAbis.
   */
  java.util.List<java.lang.String>
      getSupported64BitAbisList();
  /**
   * <code>repeated string supported_64_bit_abis = 21;</code>
   * @return The count of supported64BitAbis.
   */
  int getSupported64BitAbisCount();
  /**
   * <code>repeated string supported_64_bit_abis = 21;</code>
   * @param index The index of the element to return.
   * @return The supported64BitAbis at the given index.
   */
  java.lang.String getSupported64BitAbis(int index);
  /**
   * <code>repeated string supported_64_bit_abis = 21;</code>
   * @param index The index of the value to return.
   * @return The bytes of the supported64BitAbis at the given index.
   */
  com.google.protobuf.ByteString
      getSupported64BitAbisBytes(int index);

  /**
   * <code>repeated string supported_abis = 22;</code>
   * @return A list containing the supportedAbis.
   */
  java.util.List<java.lang.String>
      getSupportedAbisList();
  /**
   * <code>repeated string supported_abis = 22;</code>
   * @return The count of supportedAbis.
   */
  int getSupportedAbisCount();
  /**
   * <code>repeated string supported_abis = 22;</code>
   * @param index The index of the element to return.
   * @return The supportedAbis at the given index.
   */
  java.lang.String getSupportedAbis(int index);
  /**
   * <code>repeated string supported_abis = 22;</code>
   * @param index The index of the value to return.
   * @return The bytes of the supportedAbis at the given index.
   */
  com.google.protobuf.ByteString
      getSupportedAbisBytes(int index);

  /**
   * <code>string tags = 23;</code>
   * @return The tags.
   */
  java.lang.String getTags();
  /**
   * <code>string tags = 23;</code>
   * @return The bytes for tags.
   */
  com.google.protobuf.ByteString
      getTagsBytes();

  /**
   * <code>string type = 24;</code>
   * @return The type.
   */
  java.lang.String getType();
  /**
   * <code>string type = 24;</code>
   * @return The bytes for type.
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>bool is_physical_device = 25;</code>
   * @return The isPhysicalDevice.
   */
  boolean getIsPhysicalDevice();

  /**
   * <code>repeated string system_features = 26;</code>
   * @return A list containing the systemFeatures.
   */
  java.util.List<java.lang.String>
      getSystemFeaturesList();
  /**
   * <code>repeated string system_features = 26;</code>
   * @return The count of systemFeatures.
   */
  int getSystemFeaturesCount();
  /**
   * <code>repeated string system_features = 26;</code>
   * @param index The index of the element to return.
   * @return The systemFeatures at the given index.
   */
  java.lang.String getSystemFeatures(int index);
  /**
   * <code>repeated string system_features = 26;</code>
   * @param index The index of the value to return.
   * @return The bytes of the systemFeatures at the given index.
   */
  com.google.protobuf.ByteString
      getSystemFeaturesBytes(int index);

  /**
   * <code>.com.tiwari.studence.proto.devices.AndroidDisplayInfo displayInfo = 27;</code>
   * @return Whether the displayInfo field is set.
   */
  boolean hasDisplayInfo();
  /**
   * <code>.com.tiwari.studence.proto.devices.AndroidDisplayInfo displayInfo = 27;</code>
   * @return The displayInfo.
   */
  com.tiwari.studence.proto.devices.AndroidDisplayInfo getDisplayInfo();
  /**
   * <code>.com.tiwari.studence.proto.devices.AndroidDisplayInfo displayInfo = 27;</code>
   */
  com.tiwari.studence.proto.devices.AndroidDisplayInfoOrBuilder getDisplayInfoOrBuilder();

  /**
   * <code>string serial_number = 28;</code>
   * @return The serialNumber.
   */
  java.lang.String getSerialNumber();
  /**
   * <code>string serial_number = 28;</code>
   * @return The bytes for serialNumber.
   */
  com.google.protobuf.ByteString
      getSerialNumberBytes();
}