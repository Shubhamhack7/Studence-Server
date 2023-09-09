package com.tiwari.studence.teacher.servlet;

import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.proto.teacher.TeacherPb;
import com.tiwari.studence.proto.teacher.TeacherSearchReqPb;
import com.tiwari.studence.proto.teacher.TeacherSearchRespPb;
import com.tiwari.studence.teacher.provider.TeacherProvider;
import com.tiwari.studence.teacher.provider.TeacherSearchReqRespProvider;
import com.tiwari.studence.teacher.service.ITeacherService;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class TeacherServlet extends
        JsonResponseEntityServlet<ITeacherService, TeacherPb, TeacherSearchReqPb, TeacherSearchRespPb, TeacherProvider, TeacherSearchReqRespProvider> {

  private static final long serialVersionUID = 1L;
  @Inject
  public TeacherServlet(JsonStringToPbConverter<TeacherPb, TeacherProvider> reqParser,
                        JsonStringToReqPbConverter<TeacherSearchReqPb, TeacherSearchReqRespProvider> searchReqParser,
                        ITeacherService iTeacherService, ErrorResponsePbConverter errorResponsePbConverter,
                        IServerExceptionLogger exLogger, ResponseInterceptor responseInterceptor,
                        ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iTeacherService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
