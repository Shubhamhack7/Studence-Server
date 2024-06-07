package com.tiwari.studence.common.http.servlet;

import javax.inject.Inject;

import com.google.inject.Singleton;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;
import jakarta.servlet.ServletException;

@Singleton
public class JsonResponseEntityServlet<Service, UiPb extends GeneratedMessageV3,Req extends GeneratedMessageV3,Resp extends GeneratedMessageV3, UiPbBuProvider extends IPbBuilderProvider<?,?>,ReqPbBuProvider extends IReqRespPbBuilderProvider<?, ?, ?, ?>>
		extends AHttpEntityServlet<Service,UiPb,Req,Resp,UiPbBuProvider,ReqPbBuProvider> {
	private static final long serialVersionUID = 1L;

	@Inject
	public JsonResponseEntityServlet(JsonStringToPbConverter<UiPb, UiPbBuProvider> reqParser,
									 JsonStringToReqPbConverter<Req, ReqPbBuProvider> searchReqParser, Service service,
									 ErrorResponsePbConverter errorResponsePbConverter, IServerExceptionLogger exLogger,
									 ResponseInterceptor responseInterceptor, ServerConfigUtility serverConfigUtility) {
		super(reqParser, searchReqParser, service, errorResponsePbConverter, exLogger,
				responseInterceptor, serverConfigUtility);
	}
}