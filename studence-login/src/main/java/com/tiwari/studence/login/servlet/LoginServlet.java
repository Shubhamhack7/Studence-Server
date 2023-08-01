package com.tiwari.studence.login.servlet;

import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.login.provider.LoginPbProvider;
import com.tiwari.studence.login.provider.LoginSearchPbProvider;
import com.tiwari.studence.login.service.ILoginService;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.proto.login.LoginSearchReqPb;
import com.tiwari.studence.proto.login.LoginSearchRespPb;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginServlet extends JsonResponseEntityServlet<ILoginService, LoginPb, LoginSearchReqPb, LoginSearchRespPb, LoginPbProvider, LoginSearchPbProvider> {

  @Inject
  public LoginServlet(JsonStringToPbConverter<LoginPb, LoginPbProvider> reqParser,
          JsonStringToReqPbConverter<LoginSearchReqPb, LoginSearchPbProvider> searchReqParser,
          ILoginService iLoginService, ErrorResponsePbConverter errorResponsePbConverter,
          IServerExceptionLogger exLogger, ResponseInterceptor responseInterceptor,
          ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iLoginService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
