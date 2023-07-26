package com.tiwari.studence.login.provider;

import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.login.LoginPb;

import javax.inject.Singleton;

@Singleton
public class LoginPbProvider implements IPbBuilderProvider<LoginPb, LoginPb.Builder> {
  @Override
  public LoginPb.Builder getBuilder() {
    return LoginPb.newBuilder();
  }

  @Override
  public LoginPb.Builder getBuilder(LoginPb builder) {
    return LoginPb.newBuilder(builder);
  }


}
