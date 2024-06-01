package com.tiwari.studence.attendence.indexer;

public enum AttendenceIndexerEnum {
  ATTENDENCE_STUDENT_REF_ID("ATTENDENCE_STUDENT_REF_ID",false),
  ATTENDENCE_STUDENT_REF_NAME("ATTENDENCE_STUDENT_REF_NAME",true),
  ATTENDENCE_CLASS_REF_ID("ATTENDENCE_CLASS_REF_ID",false),
  ATTENDENCE_CLASS_TYPE_REF("ATTENDENCE_CLASS_TYPE_REF",false),
  ATTENDENCE_CLASS_SECTION_TYPE_REF("ATTENDENCE_CLASS_SECTION_TYPE_REF",false),
  ATTENDENCE_TEACHER_REF_ID("ATTENDENCE_TEACHER_REF_ID",false),
  ATTENDENCE_TEACHER_REF_NAME("ATTENDENCE_TEACHER_REF_NAME",true),
  ATTENDENCE_IS_PRESENT("ATTENDENCE_IS_PRESENT",false);


  private final String label;
  private final boolean isLowerCase;


  AttendenceIndexerEnum(String label, boolean isLowerCase) {
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
