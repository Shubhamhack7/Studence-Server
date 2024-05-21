package com.tiwari.studence.classes.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.classes.service.ClassesService;
import com.tiwari.studence.classes.service.IClassesService;

public class ClassesModule extends AbstractModule {
  @Override
  protected void configure(){
    bind(IClassesService.class).to(ClassesService.class);
  }
}
