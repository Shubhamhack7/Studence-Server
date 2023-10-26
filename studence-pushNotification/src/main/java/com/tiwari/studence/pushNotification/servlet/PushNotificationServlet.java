package com.tiwari.studence.pushNotification.servlet;

import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchReqPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchRespPb;
import com.tiwari.studence.pushNotification.provider.PushNotificationProvider;
import com.tiwari.studence.pushNotification.provider.PushNotificationSearchPbProvider;
import com.tiwari.studence.pushNotification.service.IPushNotificationService;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class PushNotificationServlet extends
        JsonResponseEntityServlet<IPushNotificationService, PushNotificationPb, PushNotificationSearchReqPb, PushNotificationSearchRespPb, PushNotificationProvider, PushNotificationSearchPbProvider> {

  @Inject
  public PushNotificationServlet(
          JsonStringToPbConverter<PushNotificationPb, PushNotificationProvider> reqParser,
          JsonStringToReqPbConverter<PushNotificationSearchReqPb, PushNotificationSearchPbProvider> searchReqParser,
          IPushNotificationService iPushNotificationService,
          ErrorResponsePbConverter errorResponsePbConverter, IServerExceptionLogger exLogger,
          ResponseInterceptor responseInterceptor, ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iPushNotificationService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
