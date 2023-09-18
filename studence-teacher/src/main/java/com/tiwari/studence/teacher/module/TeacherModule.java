package com.tiwari.studence.teacher.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.teacher.service.ITeacherService;
import com.tiwari.studence.teacher.service.TeacherService;

public class TeacherModule extends AbstractModule {
  @Override
  protected void configure(){
    bind(ITeacherService.class).to(TeacherService.class);
  }
}
