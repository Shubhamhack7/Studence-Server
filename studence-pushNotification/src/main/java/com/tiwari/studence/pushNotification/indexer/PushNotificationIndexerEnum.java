package com.tiwari.studence.pushNotification.indexer;

public enum PushNotificationIndexerEnum {
  PUSH_NOTIFICATION_TOKEN("PUSH_NOTIFICATION_TOKEN", false),
  PUSH_NOTIFICATION_ORGANISATION_REF_ID("PUSH_NOTIFICATION_ORGANISATION_REF_ID", false),
  PUSH_NOTIFICATION_ORGANISATION_REF_NAME("PUSH_NOTIFICATION_ORGANISATION_REF_NAME", false),
  PUSH_NOTIFICATION_CAMPUS_REF_ID("PUSH_NOTIFICATION_CAMPUS_REF_ID", false),
  PUSH_NOTIFICATION_CAMPUS_REF_NAME("PUSH_NOTIFICATION_CAMPUS_REF_NAME", false),
  PUSH_NOTIFICATION_DEVICE_REF_ID("PUSH_NOTIFICATION_DEVICE_REF_ID", false),
  PUSH_NOTIFICATION_DEVICE_REF_NAME("PUSH_NOTIFICATION_DEVICE_REF_NAME", false),
  PUSH_NOTIFICATION_LOGIN_REF_ID("PUSH_NOTIFICATION_LOGIN_REF_ID", false),
  PUSH_NOTIFICATION_LOGIN_REF_NAME("PUSH_NOTIFICATION_LOGIN_REF_NAME", false);

  private final String label;
  private final boolean isLowerCase;

  PushNotificationIndexerEnum(String label, boolean isLowerCase) {
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
