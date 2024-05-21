package com.tiwari.studence.server.createLogin.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.server.createLogin.service.CreateLoginService;
import com.tiwari.studence.server.createLogin.service.ICreateLoginService;

public class CreateLoginModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ICreateLoginService.class).to(CreateLoginService.class);
  }
}
