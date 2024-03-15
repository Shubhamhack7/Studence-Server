package com.tiwari.studence.guardian.indexer;

public enum GuardianIndexerEnum {
  GUARDIAN_FATHER_NAME("GUARDIAN_FATHER_NAME", true),
  GUARDIAN_MOTHER_NAME("GUARDIAN_MOTHER_NAME", true),
  GUARDIAN_EMAIL("GUARDIAN_EMAIL", true),
  GUARDIAN_MOBILE_NUMBER("GUARDIAN_MOBILE_NUMBER", false),
  GUARDIAN_ADDRESS("GUARDIAN_ADDRESS", true);

  private final String label;
  private final boolean isLowerCase;

  GuardianIndexerEnum(String label, boolean isLowerCase) {
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
