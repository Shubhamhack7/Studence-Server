package com.tiwari.studence.dynamodb.database.table;

public enum TableNameEnum {
  ENTITY("00_ENTITY"),
  ORGANISATION("100_ORGANISATION"),
  CAMPUS("101_CAMPUS"),
  TEACHER("102_TEACHER"),
  STUDENT("104_STUDENT"),
  ATTENDANCE("105_ATTENDANCE"),
  GUARDIAN("106_GUARDIAN"),
  CLASS("103_CLASS"),
  LOGIN("107_LOGIN"),
  TYPE_AHEAD("108_TYPE_AHEAD");

  private final String value;

  TableNameEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
