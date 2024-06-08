package com.tiwari.studence.classes.servlet;

import com.tiwari.studence.classes.provider.ClassesProvider;
import com.tiwari.studence.classes.provider.ClassesSearchReqRespProvider;
import com.tiwari.studence.classes.service.IClassesService;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.proto.classes.ClassesSearchReqPb;
import com.tiwari.studence.proto.classes.ClassesSearchRespPb;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class ClassesServlet extends
        JsonResponseEntityServlet<IClassesService, ClassesPb, ClassesSearchReqPb, ClassesSearchRespPb, ClassesProvider, ClassesSearchReqRespProvider> {

  @Inject
  public ClassesServlet(JsonStringToPbConverter<ClassesPb, ClassesProvider> reqParser,
          JsonStringToReqPbConverter<ClassesSearchReqPb, ClassesSearchReqRespProvider> searchReqParser,
          IClassesService iClassesService, ErrorResponsePbConverter errorResponsePbConverter,
          IServerExceptionLogger exLogger, ResponseInterceptor responseInterceptor,
          ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iClassesService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
