package com.tiwari.studence.server.createLogin.provider;

import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.login.LoginPb;

import javax.inject.Singleton;

@Singleton
public class CreateLoginProvider implements IPbBuilderProvider<LoginPb, LoginPb.Builder> {
  @Override
  public LoginPb.Builder getBuilder() {
    return LoginPb.newBuilder();
  }

  @Override
  public LoginPb.Builder getBuilder(LoginPb builder) {
    return LoginPb.newBuilder(builder);
  }
}
