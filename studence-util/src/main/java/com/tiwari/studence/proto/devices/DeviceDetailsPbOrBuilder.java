// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: devicePb.proto

package com.tiwari.studence.proto.devices;

public interface DeviceDetailsPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.devices.DeviceDetailsPb)
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
   * <code>.com.tiwari.studence.proto.devices.DeviceOSTypeEnum deviceOsType = 2;</code>
   * @return The enum numeric value on the wire for deviceOsType.
   */
  int getDeviceOsTypeValue();
  /**
   * <code>.com.tiwari.studence.proto.devices.DeviceOSTypeEnum deviceOsType = 2;</code>
   * @return The deviceOsType.
   */
  com.tiwari.studence.proto.devices.DeviceOSTypeEnum getDeviceOsType();

  /**
   * <code>.com.tiwari.studence.proto.devices.AndroidDeviceDetails androidDevice = 3;</code>
   * @return Whether the androidDevice field is set.
   */
  boolean hasAndroidDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.AndroidDeviceDetails androidDevice = 3;</code>
   * @return The androidDevice.
   */
  com.tiwari.studence.proto.devices.AndroidDeviceDetails getAndroidDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.AndroidDeviceDetails androidDevice = 3;</code>
   */
  com.tiwari.studence.proto.devices.AndroidDeviceDetailsOrBuilder getAndroidDeviceOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.devices.IOSDeviceDetails iosDevice = 4;</code>
   * @return Whether the iosDevice field is set.
   */
  boolean hasIosDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.IOSDeviceDetails iosDevice = 4;</code>
   * @return The iosDevice.
   */
  com.tiwari.studence.proto.devices.IOSDeviceDetails getIosDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.IOSDeviceDetails iosDevice = 4;</code>
   */
  com.tiwari.studence.proto.devices.IOSDeviceDetailsOrBuilder getIosDeviceOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.devices.WindowsDeviceDetails windowsDevice = 5;</code>
   * @return Whether the windowsDevice field is set.
   */
  boolean hasWindowsDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.WindowsDeviceDetails windowsDevice = 5;</code>
   * @return The windowsDevice.
   */
  com.tiwari.studence.proto.devices.WindowsDeviceDetails getWindowsDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.WindowsDeviceDetails windowsDevice = 5;</code>
   */
  com.tiwari.studence.proto.devices.WindowsDeviceDetailsOrBuilder getWindowsDeviceOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.devices.MacOSDeviceDetails macOsDevice = 6;</code>
   * @return Whether the macOsDevice field is set.
   */
  boolean hasMacOsDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.MacOSDeviceDetails macOsDevice = 6;</code>
   * @return The macOsDevice.
   */
  com.tiwari.studence.proto.devices.MacOSDeviceDetails getMacOsDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.MacOSDeviceDetails macOsDevice = 6;</code>
   */
  com.tiwari.studence.proto.devices.MacOSDeviceDetailsOrBuilder getMacOsDeviceOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.devices.WebBrowserInfoDetails webBrowserDevice = 7;</code>
   * @return Whether the webBrowserDevice field is set.
   */
  boolean hasWebBrowserDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.WebBrowserInfoDetails webBrowserDevice = 7;</code>
   * @return The webBrowserDevice.
   */
  com.tiwari.studence.proto.devices.WebBrowserInfoDetails getWebBrowserDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.WebBrowserInfoDetails webBrowserDevice = 7;</code>
   */
  com.tiwari.studence.proto.devices.WebBrowserInfoDetailsOrBuilder getWebBrowserDeviceOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.devices.LinuxDeviceInfoDetails linuxDevice = 8;</code>
   * @return Whether the linuxDevice field is set.
   */
  boolean hasLinuxDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.LinuxDeviceInfoDetails linuxDevice = 8;</code>
   * @return The linuxDevice.
   */
  com.tiwari.studence.proto.devices.LinuxDeviceInfoDetails getLinuxDevice();
  /**
   * <code>.com.tiwari.studence.proto.devices.LinuxDeviceInfoDetails linuxDevice = 8;</code>
   */
  com.tiwari.studence.proto.devices.LinuxDeviceInfoDetailsOrBuilder getLinuxDeviceOrBuilder();

  /**
   * <code>.com.tiwari.studence.proto.devices.DeviceScreenSize screeSize = 9;</code>
   * @return Whether the screeSize field is set.
   */
  boolean hasScreeSize();
  /**
   * <code>.com.tiwari.studence.proto.devices.DeviceScreenSize screeSize = 9;</code>
   * @return The screeSize.
   */
  com.tiwari.studence.proto.devices.DeviceScreenSize getScreeSize();
  /**
   * <code>.com.tiwari.studence.proto.devices.DeviceScreenSize screeSize = 9;</code>
   */
  com.tiwari.studence.proto.devices.DeviceScreenSizeOrBuilder getScreeSizeOrBuilder();

  /**
   * <code>string deviceMacId = 10;</code>
   * @return The deviceMacId.
   */
  java.lang.String getDeviceMacId();
  /**
   * <code>string deviceMacId = 10;</code>
   * @return The bytes for deviceMacId.
   */
  com.google.protobuf.ByteString
      getDeviceMacIdBytes();

  /**
   * <code>string deviceIpAddress = 11;</code>
   * @return The deviceIpAddress.
   */
  java.lang.String getDeviceIpAddress();
  /**
   * <code>string deviceIpAddress = 11;</code>
   * @return The bytes for deviceIpAddress.
   */
  com.google.protobuf.ByteString
      getDeviceIpAddressBytes();

  /**
   * <code>string unique_id = 12;</code>
   * @return The uniqueId.
   */
  java.lang.String getUniqueId();
  /**
   * <code>string unique_id = 12;</code>
   * @return The bytes for uniqueId.
   */
  com.google.protobuf.ByteString
      getUniqueIdBytes();

  /**
   * <code>.com.tiwari.studence.proto.devices.DeviceAppMode mode = 13;</code>
   * @return The enum numeric value on the wire for mode.
   */
  int getModeValue();
  /**
   * <code>.com.tiwari.studence.proto.devices.DeviceAppMode mode = 13;</code>
   * @return The mode.
   */
  com.tiwari.studence.proto.devices.DeviceAppMode getMode();

  /**
   * <code>.com.tiwari.studence.proto.devices.DeviceTypeEnum deviceType = 14;</code>
   * @return The enum numeric value on the wire for deviceType.
   */
  int getDeviceTypeValue();
  /**
   * <code>.com.tiwari.studence.proto.devices.DeviceTypeEnum deviceType = 14;</code>
   * @return The deviceType.
   */
  com.tiwari.studence.proto.devices.DeviceTypeEnum getDeviceType();

  /**
   * <code>.com.tiwari.studence.proto.pushNotification.PushNotificationRefPb pushNotificationRef = 15;</code>
   * @return Whether the pushNotificationRef field is set.
   */
  boolean hasPushNotificationRef();
  /**
   * <code>.com.tiwari.studence.proto.pushNotification.PushNotificationRefPb pushNotificationRef = 15;</code>
   * @return The pushNotificationRef.
   */
  com.tiwari.studence.proto.pushNotification.PushNotificationRefPb getPushNotificationRef();
  /**
   * <code>.com.tiwari.studence.proto.pushNotification.PushNotificationRefPb pushNotificationRef = 15;</code>
   */
  com.tiwari.studence.proto.pushNotification.PushNotificationRefPbOrBuilder getPushNotificationRefOrBuilder();
}