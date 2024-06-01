package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.devices.DeviceIPAddressType;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPAddressCategorizer {

  private static boolean isIPv4(String ipAddress) {
    String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    Pattern pattern = Pattern.compile(ipv4Pattern);
    Matcher matcher = pattern.matcher(ipAddress);
    return matcher.matches();
  }

  private static boolean isIPv6(String ipAddress) {
    String ipv6Pattern = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
    Pattern pattern = Pattern.compile(ipv6Pattern);
    Matcher matcher = pattern.matcher(ipAddress);
    return matcher.matches();
  }

  public static DeviceIPAddressType getIPType(String deviceIpAddress) {
    if (isIPv4(deviceIpAddress)) {
      return DeviceIPAddressType.IPV4;
    } else if (isIPv6(deviceIpAddress)) {
      return DeviceIPAddressType.IPV6;
    } else {
      return DeviceIPAddressType.UNKNOWN_IPADDRESS_TYPE;
    }
  }
}
