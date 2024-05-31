package com.tiwari.studence.server.organisationCreateAndCampus.servlet;

import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.common.voidPb.provider.VoidPbProvider;
import com.tiwari.studence.organisation.provider.OrganisationPbProvider;
import com.tiwari.studence.organisation.provider.OrganisationSearchPbProvider;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateRespPb;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;
import com.tiwari.studence.proto.voidPb.VoidPb;
import com.tiwari.studence.server.organisationCreateAndCampus.provider.OrganisationCreateAndCampusProvider;
import com.tiwari.studence.server.organisationCreateAndCampus.service.IOrganisationCreateAndCampusCreate;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class OrganisationCreateAndCampusServlet extends
        JsonResponseEntityServlet<IOrganisationCreateAndCampusCreate, VoidPb, OrganisationCreateAndCampusCreateReqPb, OrganisationCreateAndCampusCreateRespPb, VoidPbProvider, OrganisationCreateAndCampusProvider> {
  @Inject
  public OrganisationCreateAndCampusServlet(
          JsonStringToPbConverter<VoidPb, VoidPbProvider> reqParser,
          JsonStringToReqPbConverter<OrganisationCreateAndCampusCreateReqPb, OrganisationCreateAndCampusProvider> searchReqParser,
          IOrganisationCreateAndCampusCreate iOrganisationCreateAndCampusCreate,
          ErrorResponsePbConverter errorResponsePbConverter, IServerExceptionLogger exLogger,
          ResponseInterceptor responseInterceptor, ServerConfigUtility serverConfigUtility) {
    super(reqParser, searchReqParser, iOrganisationCreateAndCampusCreate, errorResponsePbConverter,
            exLogger, responseInterceptor, serverConfigUtility);
  }
}
