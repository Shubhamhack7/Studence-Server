package com.tiwari.studence.common.http.servlet;

import javax.inject.Inject;

import com.google.inject.Singleton;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.prtovider.IPbBuilderProvider;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;

@Singleton
public class JsonResponseEntityServlet<Service, UiPb extends GeneratedMessageV3, UiPbBuProvider extends IPbBuilderProvider<?,?>>
		extends AHttpEntityServlet<Service, UiPb, UiPbBuProvider> {
	private static final long serialVersionUID = 1L;

	@Inject
	public JsonResponseEntityServlet(JsonStringToPbConverter<UiPb, UiPbBuProvider> reqParser, Service service,
			ErrorResponsePbConverter errorResponseUiPbConverter, ResponseInterceptor responseInterceptor,
			IServerExceptionLogger exLogger, ServerConfigUtility serverConfigUtility) {
		super(reqParser, service, errorResponseUiPbConverter, exLogger, responseInterceptor, serverConfigUtility);
	}

}
