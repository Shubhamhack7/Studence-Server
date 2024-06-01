package com.tiwari.studence.common.http.servlet;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.SyncFuture;
import com.tiwari.studence.common.async.WaitOnFutureAndExecuteRunnableControlFlow;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.request.RequestExecutor;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.proto.error.ErrorResponsePb;
import com.tiwari.studence.proto.error.RedirectPb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.protobuf.ProtobufToJson;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpStatus;

import javax.inject.Inject;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;





public abstract class BaseHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 7363247856122469816L;

	private final ErrorResponsePbConverter m_ErrorResponsePbConverter;
	private final IServerExceptionLogger m_exLogger;
	private final ResponseInterceptor m_responseInterceptor;
	private final ServerConfigUtility m_serverConfigUtility;

	@Inject
	public BaseHttpServlet(ErrorResponsePbConverter ErrorResponsePbConverter, IServerExceptionLogger exLogger,
			ResponseInterceptor responseInterceptor, ServerConfigUtility serverConfigUtility) {
		m_ErrorResponsePbConverter = ErrorResponsePbConverter;
		m_exLogger = exLogger;
		m_responseInterceptor = responseInterceptor;
		m_serverConfigUtility = serverConfigUtility;
	}

	public enum ReqMethod {
		PUT, POST, GET, DELETE, HEAD, OPTIONS, TRACE
	}


	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
		RequestExecutor.getInstance().runRequestInContext(this.getClass().getSimpleName(), ReqMethod.POST.name(),
				new Callable<IFuture>() {
					@Override
					public IFuture call() throws Exception {
						startAsyncCall(req, resp, ReqMethod.POST);
						return new SyncFuture();
					}
				});
	}


	protected void doPut(final HttpServletRequest req, final HttpServletResponse resp) {
		RequestExecutor.getInstance().runRequestInContext(this.getClass().getSimpleName(), ReqMethod.PUT.name(),
				new Callable<IFuture>() {
					@Override
					public IFuture call() throws Exception {
						startAsyncCall(req, resp, ReqMethod.PUT);
						return new SyncFuture();
					}
				});
	}


	protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) {
		RequestExecutor.getInstance().runRequestInContext(this.getClass().getSimpleName(), ReqMethod.DELETE.name(),
				new Callable<IFuture>() {
					@Override
					public IFuture call() throws Exception {
						startAsyncCall(req, resp, ReqMethod.DELETE);
						return new SyncFuture();
					}
				});
	}


	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
		RequestExecutor.getInstance().runRequestInContext(this.getClass().getSimpleName(), ReqMethod.GET.name(),
				new Callable<IFuture>() {
					@Override
					public IFuture call() throws Exception {
						startAsyncCall(req, resp, ReqMethod.GET);
						return new SyncFuture();
					}
				});
	}

	private void startAsyncCall(final HttpServletRequest request, final HttpServletResponse response,
			ReqMethod reqType) {
		final String name = Strings.join("!", request.getServerName(), "" + request.getServerPort(),
				request.getRequestURI(), request.getServletPath());
		final AsyncContext asyncContext = (AsyncContext) request.startAsync();
		final AtomicBoolean respReturnedOrNot = new AtomicBoolean(false);
		asyncContext.setTimeout(58000);

		asyncContext.addListener(new AsyncListener() {
			@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
				if (!respReturnedOrNot.getAndSet(true)) {
					writeTimeoutErrorResponse(response);
					asyncContext.complete();
				}
			}

			@Override
			public void onStartAsync(AsyncEvent arg0) throws IOException {
			}

			@Override
			public void onError(AsyncEvent arg0) throws IOException {
			}

			@Override
			public void onComplete(AsyncEvent arg0) throws IOException {
			}
		});
		try {
			if (!m_serverConfigUtility.validateServerConfig()) {
				throw new LoggedRuntimeException(ErrorCategoryUiEnum.SERVER_MISCONFIGURED_ERROR);
			}
			final HttpServletRequest req = request;
			final HttpServletResponse resp = response;
			final IFuture<?, Exception> callFuture = handleAsyncCall(req, reqType);
			Callable<Void> callable = new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					if (respReturnedOrNot.getAndSet(true)) {
						return null;
					}
					try {
						Object response = callFuture.get();
						writeResponse(req, resp, response);
					} catch (Throwable t) {
						m_exLogger.logError(t, name + "!");
						writeErrorResponse(req, resp,
								m_ErrorResponsePbConverter.convert(Exceptions.handleThrowable(t)));
					} finally {
						asyncContext.complete();
					}
					return null;
				}
			};
			WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(callable, callFuture);
		} catch (Throwable t) {
			m_exLogger.logError(t, name + "!");
			writeErrorResponse(request, response, m_ErrorResponsePbConverter.convert(Exceptions.handleThrowable(t)));
			asyncContext.complete();
		} finally {
			// nothing
		}
	}

	private void writeResponse(HttpServletRequest req, HttpServletResponse resp, Object o) {
		if (o instanceof RedirectPb) {
			RedirectPb redirect = (RedirectPb) o;
			writeRedirectResponse(resp, redirect);
		} else {
			resp.setStatus(HttpServletResponse.SC_OK);
			setCacheHeaders(req, resp);
			Object respObj = m_responseInterceptor.getResponse(req, resp, o);
			writePayload(resp, respObj);
		}
	}

	private void writeRedirectResponse(HttpServletResponse resp, RedirectPb redirect) {
		Preconditions.check(Strings.notEmpty(redirect.getLocation()), "Invalid redirect", redirect);
		switch (redirect.getRedirectType()) {
		case TEMPORARY_REDIRECT:
			resp.setStatus(307);
			resp.setHeader("Location", redirect.getLocation());
			break;
		case PERMANENT_REDIRECT:
			resp.setStatus(308);
			resp.setHeader("Location", redirect.getLocation());
			break;
		default:
			Preconditions.check(false, "Invalid redirect", redirect);
			break;
		}
	}

	private void setCacheHeaders(HttpServletRequest req, HttpServletResponse resp) {
		// find cache-TIME using regex
		String pathInfo = req.getRequestURI().substring(req.getContextPath().length() + req.getServletPath().length());
		String splits[] = pathInfo.split("/");
		if (splits.length > 1 && splits[1].contains("cache")
				&& NumberUtils.isNumber(splits[1].substring(splits[1].indexOf("-") + 1))) {

			int duration = 3600 * Integer.parseInt(splits[1].substring(splits[1].indexOf("-") + 1));
			if (duration > 0) {
				resp.addHeader("Cache-Control", "public, max-age=" + duration);
				resp.setDateHeader("Expires", System.currentTimeMillis() + duration * 1000);
			} else {
				resp.setHeader("Cache-Control", "max-age=0, no-cache, no-store, must-revalidate");
				resp.setHeader("Pragma", "no-cache");
				resp.setHeader("Expires", "0");
			}
		} else {
			resp.setHeader("Cache-Control", "max-age=0, no-cache, no-store, must-revalidate");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Expires", "0");
		}
	}

	protected abstract IFuture<?, Exception> handleAsyncCall(HttpServletRequest req, ReqMethod reqType);

	private void writeTimeoutErrorResponse(HttpServletResponse resp) {
		ErrorResponsePb.Builder errorUiPb = ErrorResponsePb.newBuilder();
		resp.setStatus(HttpStatus.SC_GATEWAY_TIMEOUT);
		errorUiPb.setUiErrorString("Call is taking too long time.Timeout after 58 seconds.");
		errorUiPb.setErrorCategory(ErrorCategoryUiEnum.REQUEST_TIMEOUT);
		errorUiPb.setErrorCode("504");
		errorUiPb.setDebugStackTrace("BaseHttpServlet.startAsyncCall.timeout");
		writePayload(resp, errorUiPb.build());
	}

	private void writeErrorResponse(HttpServletRequest req, HttpServletResponse resp, ErrorResponsePb errorUiPb) {
		System.out.println(ProtobufToJson.convert(errorUiPb));
		switch (errorUiPb.getErrorCategory()) {
		case DATA_MISMATCH_ERROR:
		case INPUT_VALIDATION_ERROR:
		case DUPLICATE_ITEM_FOUND:
			resp.setStatus(HttpStatus.SC_BAD_REQUEST);
			break;
		case DOWNSTREAM_SERVER_UNAVAILABLE_ERROR:
		case PROVISIONED_THROUGHPUT_EXCEPTION:
		case BLOCKED_DOWNSTREAM_CONNECTION_ERROR:
		case NO_SLOW_OR_BLOCKED_DOWNSTREAM_CONNECTION_ERROR:
		case NO_OR_SLOW_DOWNSTREAM_CONNECTION_ERROR:
		case DEVICE_NOT_REACHABLE:
			resp.setStatus(HttpStatus.SC_SERVICE_UNAVAILABLE);
			break;
		case DOWNSTREAM_REQUEST_TIMEOUT_ERROR:
		case REQUEST_TIMEOUT:
			resp.setStatus(HttpStatus.SC_GATEWAY_TIMEOUT);
			break;
		case VERSION_MISMATCH:
		case CONCURRENT_CALL_ERROR:
			resp.setStatus(HttpStatus.SC_CONFLICT);
			break;
		case ITEM_NOT_FOUND:
			resp.setStatus(HttpStatus.SC_NOT_FOUND);
			break;
		case UN_AUTHORIZED:
			resp.setStatus(HttpStatus.SC_UNAUTHORIZED);
			break;
		case SERVER_MISCONFIGURED_ERROR:
			resp.setStatus(HttpStatus.SC_BAD_GATEWAY);
			break;
		default:
			resp.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		}
		writePayload(resp, errorUiPb);
	}

	protected void writePayload(HttpServletResponse resp, Object o) {
		String r = getResponseString(o);
		if (Strings.isEmpty(r)) {
			return;
		}
		GZIPOutputStream gzipStream = null;
		try {
			resp.addHeader("Content-Encoding", "gzip");
			gzipStream = new GZIPOutputStream(resp.getOutputStream());
			gzipStream.write(r.getBytes());
		} catch (IOException ioe) {
			throw Exceptions.handleThrowable(ioe);
		} finally {
			try {
				gzipStream.close();
			} catch (IOException ioe) {
				throw Exceptions.handleThrowable(ioe);
			}
		}
	}

	private String getResponseString(Object respObj) {
		if (respObj == null) {
			return null;
		}
		if (respObj instanceof String) {
			return (String) respObj;
		}
		if (respObj instanceof GeneratedMessageV3) {
			return ProtobufToJson.convert((GeneratedMessageV3) respObj);
		}
		Preconditions.check(false, respObj);
		return null;
	}
}