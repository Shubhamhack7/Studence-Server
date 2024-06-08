package com.tiwari.studence.typeAhed.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.tiwari.studence.typeAhed.service.ITypeAheadService;
import com.tiwari.studence.typeAhed.service.TypeAhedService;

@Singleton
public class TypeAhedModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ITypeAheadService.class).to(TypeAhedService.class);
  }
}
