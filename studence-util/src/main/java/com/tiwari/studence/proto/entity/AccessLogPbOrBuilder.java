// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: entityPb.proto

package com.tiwari.studence.proto.entity;

public interface AccessLogPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.entity.AccessLogPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *		optional com.nsimpl.proto.entity.InterfaceInfoPb interfaceUsed = 1 [deprecated = true];
   *		optional DeviceInfoPb machineInfo = 2 [deprecated = true];
   * </pre>
   *
   * <code>optional .com.tiwari.studence.proto.entity.NetworkInfoPb networkInfo = 3;</code>
   * @return Whether the networkInfo field is set.
   */
  boolean hasNetworkInfo();
  /**
   * <pre>
   *		optional com.nsimpl.proto.entity.InterfaceInfoPb interfaceUsed = 1 [deprecated = true];
   *		optional DeviceInfoPb machineInfo = 2 [deprecated = true];
   * </pre>
   *
   * <code>optional .com.tiwari.studence.proto.entity.NetworkInfoPb networkInfo = 3;</code>
   * @return The networkInfo.
   */
  com.tiwari.studence.proto.entity.NetworkInfoPb getNetworkInfo();
  /**
   * <pre>
   *		optional com.nsimpl.proto.entity.InterfaceInfoPb interfaceUsed = 1 [deprecated = true];
   *		optional DeviceInfoPb machineInfo = 2 [deprecated = true];
   * </pre>
   *
   * <code>optional .com.tiwari.studence.proto.entity.NetworkInfoPb networkInfo = 3;</code>
   */
  com.tiwari.studence.proto.entity.NetworkInfoPbOrBuilder getNetworkInfoOrBuilder();

  /**
   * <code>optional .com.tiwari.studence.proto.entity.LocationInfoPb locationInfo = 4;</code>
   * @return Whether the locationInfo field is set.
   */
  boolean hasLocationInfo();
  /**
   * <code>optional .com.tiwari.studence.proto.entity.LocationInfoPb locationInfo = 4;</code>
   * @return The locationInfo.
   */
  com.tiwari.studence.proto.entity.LocationInfoPb getLocationInfo();
  /**
   * <code>optional .com.tiwari.studence.proto.entity.LocationInfoPb locationInfo = 4;</code>
   */
  com.tiwari.studence.proto.entity.LocationInfoPbOrBuilder getLocationInfoOrBuilder();
}
