package com.tiwari.studence.organisation.servlet;

import javax.inject.Inject;

import com.google.inject.Singleton;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.organisation.provider.OrganisationPbProvider;
import com.tiwari.studence.organisation.provider.OrganisationSearchPbProvider;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;
import jakarta.servlet.ServletException;

@Singleton
public class OrganisationServlet extends
        JsonResponseEntityServlet<IOrganisationService, OrganisationPb, OrganisationSearchReqPb, OrganisationSearchRespPb, OrganisationPbProvider, OrganisationSearchPbProvider> {

  private static final long serialVersionUID = 1L;

  @Inject
  public OrganisationServlet(
          JsonStringToPbConverter<OrganisationPb, OrganisationPbProvider> reqParser,
          JsonStringToReqPbConverter<OrganisationSearchReqPb, OrganisationSearchPbProvider> searchReqParser,
          IOrganisationService iOrganisationService,
          ErrorResponsePbConverter errorResponsePbConverter, IServerExceptionLogger exLogger,
          ResponseInterceptor responseInterceptor, ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iOrganisationService, errorResponsePbConverter, exLogger,
            responseInterceptor, serverConfigUtility);
  }
}
