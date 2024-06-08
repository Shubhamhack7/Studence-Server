package com.tiwari.studence.classes.indexer;

public enum ClassesIndexerEnum {
  CLASSES_CAMPUS_REF_ID("CLASSES_CAMPUS_REF_ID", false),
  CLASSES_CAMPUS_REF_NAME("CLASSES_CAMPUS_REF_NAME", true),
  CLASSES_CLASS_TYPE("CLASSES_CLASS_TYPE",false),
  CLASSES_SECTION_TYPE("CLASSES_SECTION_TYPE",false),
  CLASSES_ORGANISATION_REF_ID("CLASSES_ORGANISATION_REF_ID", false),
  CLASSES_ORGANISATION_REF_NAME("CLASSES_ORGANISATION_REF_NAME", true);
  /*CLASSES_CAMPUS_REF_ORG_ID("CLASSES_CAMPUS_REF_ORG_ID", false),
  CLASSES_CAMPUS_REF_ORG_NAME("CLASSES_CAMPUS_REF_ORG_NAME", true),*/
  /*CLASSES_OTHER_TEACHER_REF_ID("CLASSES_OTHER_TEACHER_REF_ID", false),
  CLASSES_OTHER_TEACHER_REF_NAME("CLASSES_OTHER_TEACHER_REF_NAME", true);*/


  private final String label;
  private final boolean isLowerCase;

  ClassesIndexerEnum(String label, boolean isLowerCase) {
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
