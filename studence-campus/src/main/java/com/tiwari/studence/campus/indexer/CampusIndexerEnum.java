package com.tiwari.studence.campus.indexer;

public enum CampusIndexerEnum {
  CAMPUS_NAME("CAMPUS_NAME", true),
  CAMPUS_MOBILE("CAMPUS_MOBILE", true),
  CAMPUS_EMAIL("CAMPUS_EMAIL", true),
  CAMPUS_ADDRESS("CAMPUS_ADDRESS", true),
  CAMPUS_ORG_REF_ID("CAMPUS_ORG_REF_ID", false),
  CAMPUS_ORG_REF_NAME("CAMPUS_ORG_REF_NAME", true);

  private final String label;
  private final boolean isLowerCase;

  CampusIndexerEnum(String label, boolean isLowerCase) {
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
