package com.tiwari.studence.student.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.student.service.StudentService;
import com.tiwari.studence.student.service.IStudentService;

public class StudentModule extends AbstractModule {
  @Override
  protected void configure(){
    bind(IStudentService.class).to(StudentService.class);
  }
}
