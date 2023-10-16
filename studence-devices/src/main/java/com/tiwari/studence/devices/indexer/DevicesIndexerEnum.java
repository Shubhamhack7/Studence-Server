package com.tiwari.studence.devices.indexer;

public enum DevicesIndexerEnum {

  DEVICE_OS_TYPE("DEVICE_OS_TYPE", true),
  DEVICE_IP_ADDRESS("DEVICE_IP_ADDRESS", false),
  DEVICE_UNIQUE_ID("DEVICE_UNIQUE_ID", false),
  DEVICE_APP_MODE("DEVICE_APP_MODE", false),
  DEVICE_TYPE("DEVICE_TYPE", false),
  DEVICE_PUSH_NOTIFICATION_REF_ID("DEVICE_PUSH_NOTIFICATION_REF_ID", false);


  private final String label;
  private final boolean isLowerCase;

  DevicesIndexerEnum(String label, boolean isLowerCase) {
    this.label = label;
    this.isLowerCase = isLowerCase;
  }

  public String getLabel() {
    return label;
  }

  public boolean isLowerCase() {
    return isLowerCase;
  }
}
