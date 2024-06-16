package com.tiwari.studence.attendence.servlet;

import com.google.inject.Singleton;
import com.tiwari.studence.attendence.provider.AttendencePbProvider;
import com.tiwari.studence.attendence.provider.AttendenceSearchPbProvider;
import com.tiwari.studence.attendence.service.IAttendenceService;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.proto.attendence.AttendenceSearchReqPb;
import com.tiwari.studence.proto.attendence.AttendenceSearchRespPb;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class AttendenceServlet extends
        JsonResponseEntityServlet<IAttendenceService, AttendencePb, AttendenceSearchReqPb, AttendenceSearchRespPb, AttendencePbProvider, AttendenceSearchPbProvider> {

  private static final long serialVersionUID = 1L;

  @Inject
  public AttendenceServlet(
          JsonStringToPbConverter<AttendencePb, AttendencePbProvider> reqParser,
          JsonStringToReqPbConverter<AttendenceSearchReqPb, AttendenceSearchPbProvider> searchReqParser,
          IAttendenceService iOrganisationService,
          ErrorResponsePbConverter errorResponsePbConverter, IServerExceptionLogger exLogger,
          ResponseInterceptor responseInterceptor, ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iOrganisationService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
