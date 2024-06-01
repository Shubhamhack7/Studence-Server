package com.tiwari.studence.student.indexer;

public enum StudentIndexerEnum {
  STUDENT_CLASS_REF_ID("STUDENT_CLASS_REF_ID",false),
  STUDENT_CLASS_TYPE_REF("STUDENT_CLASS_TYPE_REF",false),
  STUDENT_CLASS_SECTION_TYPE_REF("STUDENT_CLASS_SECTION_TYPE_REF",false),
  STUDENT_CAMPUS_REF_ID("STUDENT_CAMPUS_REF_ID",false),
  STUDENT_CAMPUS_REF_NAME("STUDENT_CAMPUS_REF_NAME",true),
  STUDENT_CAMPUS_REF_ORG_ID("STUDENT_CAMPUS_REF_ORG_ID",false),
  STUDENT_CAMPUS_REF_ORG_NAME("STUDENT_CAMPUS_REF_ORG_NAME",true),
  STUDENT_PARENT_REF_ID("STUDENT_PARENT_CLASS_REF_ID",false),
  STUDENT_PARENT_REF_FATHER_NAME("STUDENT_PARENT_REF_FATHER_NAME",false),
  STUDENT_PARENT_REF_MOTHER_NAME("STUDENT_PARENT_REF_MOTHER_NAME",false);


  private final String label;
  private final boolean isLowerCase;

  StudentIndexerEnum(String label, boolean isLowerCase) {
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
