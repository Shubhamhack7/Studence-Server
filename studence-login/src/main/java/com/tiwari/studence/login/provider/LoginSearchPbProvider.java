package com.tiwari.studence.login.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.login.LoginSearchReqPb;
import com.tiwari.studence.proto.login.LoginSearchRespPb;

public class LoginSearchPbProvider implements
        IReqRespPbBuilderProvider<LoginSearchReqPb, LoginSearchReqPb.Builder, LoginSearchRespPb, LoginSearchRespPb.Builder> {
  @Override
  public LoginSearchReqPb.Builder getReqBuilder() {
    return LoginSearchReqPb.newBuilder();
  }

  @Override
  public LoginSearchReqPb.Builder getReqBuilder(LoginSearchReqPb builder) {
    return LoginSearchReqPb.newBuilder(builder);
  }

  @Override
  public LoginSearchRespPb.Builder getRespBuilder() {
    return LoginSearchRespPb.newBuilder();
  }

  @Override
  public LoginSearchRespPb.Builder getRespBuilder(LoginSearchRespPb builder) {
    return LoginSearchRespPb.newBuilder(builder);
  }
}
