package com.tiwari.studence.server.createLogin.servlet;

import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.common.voidPb.provider.VoidSearchPbProvider;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.proto.voidPb.VoidSearchReqPb;
import com.tiwari.studence.proto.voidPb.VoidSearchRespPb;
import com.tiwari.studence.server.createLogin.provider.CreateLoginProvider;
import com.tiwari.studence.server.createLogin.service.ICreateLoginService;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class CreateLoginServlet extends
        JsonResponseEntityServlet<ICreateLoginService, LoginPb, VoidSearchReqPb, VoidSearchRespPb, CreateLoginProvider, VoidSearchPbProvider> {

  @Inject
  public CreateLoginServlet(JsonStringToPbConverter<LoginPb, CreateLoginProvider> reqParser,
          JsonStringToReqPbConverter<VoidSearchReqPb, VoidSearchPbProvider> searchReqParser,
          ICreateLoginService iCreateLoginService,
          ErrorResponsePbConverter errorResponsePbConverter, IServerExceptionLogger exLogger,
          ResponseInterceptor responseInterceptor, ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iCreateLoginService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
