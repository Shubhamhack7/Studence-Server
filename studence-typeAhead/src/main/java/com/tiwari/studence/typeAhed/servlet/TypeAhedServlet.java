package com.tiwari.studence.typeAhed.servlet;

import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchReqPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchRespPb;
import com.tiwari.studence.typeAhed.provider.TypeAheadSearchReqRespProvider;
import com.tiwari.studence.typeAhed.provider.TypeAhedProvider;
import com.tiwari.studence.typeAhed.service.ITypeAheadService;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TypeAhedServlet extends
        JsonResponseEntityServlet<ITypeAheadService, TypeAheadPb, TypeAheadSearchReqPb, TypeAheadSearchRespPb, TypeAhedProvider, TypeAheadSearchReqRespProvider> {

  @Inject
  public TypeAhedServlet(JsonStringToPbConverter<TypeAheadPb, TypeAhedProvider> reqParser,
          JsonStringToReqPbConverter<TypeAheadSearchReqPb, TypeAheadSearchReqRespProvider> searchReqParser,
          ITypeAheadService iTypeAheadService, ErrorResponsePbConverter errorResponsePbConverter,
          IServerExceptionLogger exLogger, ResponseInterceptor responseInterceptor,
          ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iTypeAheadService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
