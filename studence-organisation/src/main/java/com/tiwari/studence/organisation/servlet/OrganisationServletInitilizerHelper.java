package com.tiwari.studence.organisation.servlet;

import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.servlet.ResponseInterceptor;
import com.tiwari.studence.organisation.provider.OrganisationPbProvider;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

import javax.inject.Inject;

public class OrganisationServletInitilizerHelper {

    private static JsonStringToPbConverter<OrganisationPb, OrganisationPbProvider> m_reqParser;
    @Inject
    private static IOrganisationService m_service;
    private static ErrorResponsePbConverter m_errorResponseUiPbConverter;
    private  static ResponseInterceptor m_responseInterceptor;
    private  static IServerExceptionLogger m_exLogger;
    private  static ServerConfigUtility m_serverConfigUtility;

    @Inject
    public OrganisationServletInitilizerHelper(JsonStringToPbConverter<OrganisationPb, OrganisationPbProvider> reqParser,
                                               IOrganisationService service, ErrorResponsePbConverter errorResponseUiPbConverter,
                                               ResponseInterceptor responseInterceptor, IServerExceptionLogger exLogger,
                                               ServerConfigUtility serverConfigUtility) {
        m_exLogger = exLogger;
        m_errorResponseUiPbConverter = errorResponseUiPbConverter;
        m_responseInterceptor = responseInterceptor;
        m_service = service;
        m_serverConfigUtility = serverConfigUtility;
        m_reqParser = reqParser;

    }

    public static JsonStringToPbConverter<OrganisationPb, OrganisationPbProvider> getReqParser() {
        return m_reqParser;
    }

    public static IOrganisationService getService() {
        return m_service;
    }

    public static ErrorResponsePbConverter getErrorResponseUiPbConverter() {
        return m_errorResponseUiPbConverter;
    }

    public static ResponseInterceptor getResponseInterceptor() {
        return m_responseInterceptor;
    }

    public static IServerExceptionLogger getExLogger() {
        return m_exLogger;
    }

    public static ServerConfigUtility getServerConfigUtility() {
        return m_serverConfigUtility;
    }


}
