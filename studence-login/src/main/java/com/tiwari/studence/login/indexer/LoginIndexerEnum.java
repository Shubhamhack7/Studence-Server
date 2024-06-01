package com.tiwari.studence.login.indexer;

public enum LoginIndexerEnum {
  LOGIN_TYPE("LOGIN_TYPE",false),
  LOGIN_REF_ID("LOGIN_REF_ID",false),
  LOGIN_REF_NAME("LOGIN_REF_NAME",true),
  LOGIN_MOBILE_NO("LOGIN_MOBILE_NO",false),
  LOGIN_EMAIL_ID("LOGIN_EMAIL_ID",true),
  LOGIN_FIREBASE_TOKEN("LOGIN_FIREBASE_TOKEN",false);

  private final String label;
  private final boolean isLowerCase;

  LoginIndexerEnum(String label, boolean isLowerCase) {
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
