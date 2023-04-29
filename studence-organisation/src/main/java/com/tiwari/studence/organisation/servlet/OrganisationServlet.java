package com.tiwari.studence.organisation.servlet;

import javax.inject.Inject;

import com.google.inject.Singleton;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.servlet.JsonResponseEntityServlet;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.organisation.provider.OrganisationPbProvider;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;


@Singleton
public class OrganisationServlet
        extends JsonResponseEntityServlet<IOrganisationService, OrganisationPb, OrganisationPbProvider> {

    @Inject
    public OrganisationServlet(JsonStringToPbConverter<OrganisationPb, OrganisationPbProvider> reqParser,
                               IOrganisationService service, ErrorResponsePbConverter errorResponseUiPbConverter,
                               ResponseInterceptor responseInterceptor, IServerExceptionLogger exLogger,
                               ServerConfigUtility serverConfigUtility) {
        super(reqParser, service, errorResponseUiPbConverter, responseInterceptor, exLogger, serverConfigUtility);
    }

    private static final long serialVersionUID = 1L;

    public static OrganisationServlet createInstance() {
        return new OrganisationServlet(OrganisationServletInitilizerHelper.getReqParser(), OrganisationServletInitilizerHelper.getService(), OrganisationServletInitilizerHelper.getErrorResponseUiPbConverter(), OrganisationServletInitilizerHelper.getResponseInterceptor(), OrganisationServletInitilizerHelper.getExLogger(), OrganisationServletInitilizerHelper.getServerConfigUtility());
    }

}
