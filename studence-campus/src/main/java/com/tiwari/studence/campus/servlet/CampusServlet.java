package com.tiwari.studence.campus.servlet;

import com.tiwari.studence.campus.provider.CampusProvider;
import com.tiwari.studence.campus.provider.CampusSearchReqRespProvider;
import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.campus.CampusSearchReqPb;
import com.tiwari.studence.proto.campus.CampusSearchRespPb;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class CampusServlet extends
        JsonResponseEntityServlet<ICampusService, CampusPb, CampusSearchReqPb, CampusSearchRespPb, CampusProvider, CampusSearchReqRespProvider> {

  private static final long serialVersionUID = 1L;
  @Inject
  public CampusServlet(JsonStringToPbConverter<CampusPb, CampusProvider> reqParser,
          JsonStringToReqPbConverter<CampusSearchReqPb, CampusSearchReqRespProvider> searchReqParser,
          ICampusService iCampusService, ErrorResponsePbConverter errorResponsePbConverter,
          IServerExceptionLogger exLogger, ResponseInterceptor responseInterceptor,
          ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iCampusService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
