package com.tiwari.studence.login.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.login.service.ILoginService;
import com.tiwari.studence.login.service.LoginService;

public class LoginModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ILoginService.class).to(LoginService.class);
  }

}
