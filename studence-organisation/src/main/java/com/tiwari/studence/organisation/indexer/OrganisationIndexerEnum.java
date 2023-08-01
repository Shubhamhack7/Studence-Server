package com.tiwari.studence.organisation.indexer;

public enum OrganisationIndexerEnum {
  ORGANISATION_NAME("ORGANISATION_NAME",true),
  ORGANISATION_EMAIL("ORGANISATION_EMAIL",true),
  ORGANISATION_MOBILE_NUMBER("ORGANISATION_MOBILE_NUMBER",false),
  ORGANISATION_ADDRESS("ORGANISATION_ADDRESS",true);

  private final String label;
  private final boolean isLowerCase;

  OrganisationIndexerEnum(String label, boolean isLowerCase) {
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
