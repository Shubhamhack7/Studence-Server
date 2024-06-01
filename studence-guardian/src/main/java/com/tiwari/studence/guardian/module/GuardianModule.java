package com.tiwari.studence.guardian.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.guardian.service.GuardianService;
import com.tiwari.studence.guardian.service.IGuardianService;

public class GuardianModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IGuardianService.class).to(GuardianService.class);
  }
}
