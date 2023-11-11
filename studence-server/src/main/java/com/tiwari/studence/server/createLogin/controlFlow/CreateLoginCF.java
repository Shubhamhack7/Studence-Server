package com.tiwari.studence.server.createLogin.controlFlow;

import com.google.firebase.auth.UserRecord;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.firebase.service.IFirebaseService;
import com.tiwari.studence.login.service.ILoginService;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.entity.EntityUtilHelper;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

public class CreateLoginCF extends AControlFlow<CreateLoginCF.State, LoginPb, ErrorException> {

  private IFirebaseService m_firebase;

  private ILoginService m_loginService;
  private LoginPb m_loginReq;

  LoginPb.Builder builder;

  private String m_password;

  public CreateLoginCF(LoginPb loginReq, IFirebaseService firebase, ILoginService loginService) {
    super(State.CREATE_LOGIN_IN_DYNAMO, State.DONE);
    m_loginReq = loginReq;
    m_firebase = firebase;
    m_loginService = loginService;
    m_password = m_loginReq.getEncryptedPassword();
    addStateHandler(State.CREATE_LOGIN_IN_DYNAMO, new CreateLoginInDynamoDb());
    addStateHandler(State.CREATE_LOGIN_IN_FIREBASE, new CreateFirebaseToken());
    addStateHandler(State.UPDATE_LOGIN_IN_DYNAMO, new UpdateLoginInDynamoDb());
  }

  enum State {
    CREATE_LOGIN_IN_FIREBASE,
    CREATE_LOGIN_IN_DYNAMO,
    UPDATE_LOGIN_IN_DYNAMO,
    DONE
  }

  public class CreateLoginInDynamoDb implements StateHandler<State> {
    IFuture<LoginPb, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_loginService.create(m_loginReq);
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        m_loginReq = m_future.get();
        //getAsyncCallback().set(0, m_future.item());
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.CREATE_LOGIN_IN_FIREBASE;
    }
  }

  public class CreateFirebaseToken implements StateHandler<State> {
    UserRecord m_future;

    @Override
    public void registerCalls() {
      m_future = m_firebase.createUserWithEmail(m_loginReq.getEmailId().getCanonicalEmail(),
              m_password, EntityUtilHelper.getDbInfoIdWithSpecialCharecterUsingEntityPb(
                      m_loginReq.getDbInfo()));
      //registerFutures(m_future);
    }

    @Override
    public State handleState() {
      if (Strings.notEmpty(m_future.getUid())) {
        builder = LoginPb.newBuilder(m_loginReq);
        builder.setFirebaseToken(m_future.getUid());
        return State.UPDATE_LOGIN_IN_DYNAMO;
      } else {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException("", "", null));
        return State.DONE;
      }
    }

  }

  public class UpdateLoginInDynamoDb implements StateHandler<State> {
    IFuture<LoginPb, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_loginService.update(
              EntityUtilHelper.getDbInfoIdWithSpecialCharecterUsingEntityPb(builder.getDbInfo()),
              builder.build());
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        m_loginReq = m_future.get();
        getAsyncCallback().set(0, m_future.get());
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }

  }

}
