package com.tiwari.studence.teacher.indexer;

public enum TeacherIndexerEnum {
  TEACHER_NAME("TEACHER_NAME", true),
  TEACHER_MOBILE("TEACHER_MOBILE", true),
  TEACHER_EMAIL("TEACHER_EMAIL", true),
  TEACHER_ADDRESS("CAMPUS_ADDRESS", true),
  TEACHER_CAMPUS_REF_ID("TEACHER_ADDRESS", true),
  TEACHER_CAMPUS_REF_ORG_ID("TEACHER_CAMPUS_REF_ORG_ID", false),
  TEACHER_CAMPUS_REF_ORG_NAME("TEACHER_CAMPUS_REF_ORG_NAME", true),
  TEACHER_CAMPUS_REF_NAME("TEACHER_CAMPUS_REF_NAME", true),
  TEACHER_IS_CLASS_TEACHER("TEACHER_IS_CLASS_TEACHER",false);


  private final String label;
  private final boolean isLowerCase;

  TeacherIndexerEnum(String label, boolean isLowerCase) {
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
