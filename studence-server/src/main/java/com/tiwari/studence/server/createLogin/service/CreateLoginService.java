package com.tiwari.studence.server.createLogin.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.server.createLogin.controlFlow.CreateLogin;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;

public class CreateLoginService implements ICreateLoginService {

  private CreateLogin m_createLogin;

  @Inject
  CreateLoginService(CreateLogin createLogin) {
    m_createLogin = createLogin;
  }

  @Override
  public IFuture<LoginPb, ErrorException> executeService(LoginPb pb) {
    return m_createLogin.createLogin(pb);
  }
}
