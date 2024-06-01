package com.tiwari.studence.server.createLogin.controlFlow;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.firebase.service.IFirebaseService;
import com.tiwari.studence.login.service.ILoginService;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CreateLogin {
  private IFirebaseService m_firebase;

  private ILoginService m_loginService;

  @Inject
  public CreateLogin(IFirebaseService firebase, ILoginService loginService) {
    m_firebase = firebase;
    m_loginService = loginService;
  }

  public IFuture<LoginPb, ErrorException> createLogin(LoginPb loginPb) {
    CreateLoginCF cf = new CreateLoginCF(loginPb, m_firebase, m_loginService);
    cf.addLogObjects(loginPb);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

}
