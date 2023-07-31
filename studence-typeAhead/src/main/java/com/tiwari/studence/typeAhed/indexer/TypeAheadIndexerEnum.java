package com.tiwari.studence.typeAhed.indexer;

public enum TypeAheadIndexerEnum {
  TYPE_AHEAD_CONTEXT_ID("TYPE_AHEAD_CONTEXT_ID", false),
  TYPE_AHEAD_CONTEXT_NAME("TYPE_AHEAD_CONTEXT_NAME", true),
  TYPE_AHEAD_TYPE("TYPE_AHEAD_TYPE", false);

  private final String label;
  private final boolean isLowerCase;

  TypeAheadIndexerEnum(String label, boolean isLowerCase) {
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
