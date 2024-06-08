package com.tiwari.studence.student.servlet;

import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.proto.student.StudentPb;
import com.tiwari.studence.proto.student.StudentSearchReqPb;
import com.tiwari.studence.proto.student.StudentSearchRespPb;
import com.tiwari.studence.student.provider.StudentProvider;
import com.tiwari.studence.student.provider.StudentSearchReqRespProvider;
import com.tiwari.studence.student.service.IStudentService;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class StudentServlet extends
        JsonResponseEntityServlet<IStudentService, StudentPb, StudentSearchReqPb, StudentSearchRespPb, StudentProvider, StudentSearchReqRespProvider> {

  private static final long serialVersionUID = 1L;
  @Inject
  public StudentServlet(JsonStringToPbConverter<StudentPb, StudentProvider> reqParser,
                        JsonStringToReqPbConverter<StudentSearchReqPb, StudentSearchReqRespProvider> searchReqParser,
                        IStudentService iStudentService, ErrorResponsePbConverter errorResponsePbConverter,
                        IServerExceptionLogger exLogger, ResponseInterceptor responseInterceptor,
                        ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iStudentService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
