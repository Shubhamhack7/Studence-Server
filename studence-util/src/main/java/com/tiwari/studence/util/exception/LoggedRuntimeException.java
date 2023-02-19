// Copyright (c) 2011, All Right Reserved, http://nsimpl.com/

package com.tiwari.studence.util.exception;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.googlecode.protobuf.format.JsonFormat;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.collect.Lists;

/**
 * All Runtime exceptions should be of this time. This exception logs itself on
 * creation time.
 * <p>
 * All preconditions or other correctness checks should throw a
 * LoggedRuntimeException.
 * <p>
 * A LoggedRuntimeException need not be logged when catched at is is logged at
 * creation time.
 * <p>
 * The code should try to catch a runtime exception if: 1. He wants to log more
 * information and should throw a new logged exception in that case. 2. A class
 * which manages threads and does not want the threads to be killed in case of
 * exceptions.
 * 
 * @author shubham
 */
public class LoggedRuntimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("LoggedRuntimeException");
	private final ParsedErrorProto m_errorProto;
	private final List<Object> m_args;
	private final String m_stackTrace;
	private String m_uiErrorString;
	private String m_errorCode;
	private String m_serviceCode;
	private String m_operationId;

	public LoggedRuntimeException(ErrorException e) {
		m_errorProto = e.getErrorProto();
		m_args = e.getArgs();
		m_errorCode = e.getErrorCode();
		m_args.add("Converted From ErrorException@" + Integer.toHexString(System.identityHashCode(e)));
		m_args.add("For LoggedRuntimeException@" + Integer.toHexString(System.identityHashCode(this)));
		m_stackTrace = createStackTraceString();
		printError();
	}

	public LoggedRuntimeException(String serviceCode, String errorCode, String uiErrorString, Throwable e,
			Object... args) {
		// m_errorProto = new ParsedErrorProto(errorCategory, errorType);
		m_errorProto = null;
		m_args = Lists.newArrayList();
		if (e != null) {
			if (e instanceof LoggedRuntimeException) {
				m_args.add("Caused by LoggedRuntimeException@" + Integer.toHexString(System.identityHashCode(e)));
			} else if (e instanceof ErrorException) {
				m_args.add("Caused by ErrorException@" + Integer.toHexString(System.identityHashCode(e)));
			} else {
				m_args.add("Caused by \n\t" + ExceptionStackTrace.getExceptionTrace(e));
			}
			m_args.add("Wrapped LoggedRuntimeException@" + Integer.toHexString(System.identityHashCode(this)));
		} else {
			// nothing
		}
		if (args != null && args.length > 0) {
			m_args.addAll(Arrays.asList(args));
		}
		m_serviceCode = serviceCode;
		m_errorCode = errorCode;
		m_uiErrorString = uiErrorString;
		m_stackTrace = createStackTraceString();
		printError();
	}

	public LoggedRuntimeException(Throwable t, Object[] objects) {
		this.m_errorProto = new ParsedErrorProto();
		this.m_args = Lists.newArrayList();
		this.m_args.add(objects);
		this.m_stackTrace = createStackTraceString(t);
		printError();
	}

	public LoggedRuntimeException(String string, Object[] args) {
		this.m_errorProto = new ParsedErrorProto();
		this.m_args = null;
		this.m_stackTrace = createStackTraceString();
		printError();
	}

	public LoggedRuntimeException(String string2, String tableId, GeneratedMessageV3 pb) {
		this.m_errorProto = null;
		this.m_args = Lists.newArrayList();
		this.m_args.add(tableId);
		this.m_args.add(string2);
		this.m_args.add(new JsonFormat().printToString(pb));
		this.m_stackTrace = createStackTraceString();
		printError();
	}

	private void printError() {
		// LOGGER.severe(ErrorProtoUiPbJsonString.getUrlJson(m_errorProto.getErrorProto()));
		if (Strings.notEmpty(m_uiErrorString)) {
			LOGGER.severe(m_uiErrorString);
		}
		if (Strings.notEmpty(m_serviceCode)) {
			LOGGER.severe(m_serviceCode);
		}
		if (Strings.notEmpty(m_operationId)) {
			LOGGER.severe(m_operationId);
		}
		if (Strings.notEmpty(m_errorCode)) {
			LOGGER.severe(m_errorCode);
		}
		LOGGER.severe(m_args.toString());
		LOGGER.severe(m_stackTrace);
	}

	public String getStackTraceString() {
		return m_stackTrace;
	}

	public ParsedErrorProto getErrorProto() {
		return (ParsedErrorProto) m_errorProto;
	}

	public String getExceptionId() {
		return Integer.toHexString(this.hashCode());
	}

	public String getUiErrorString() {
		return m_uiErrorString;
	}

	public String getErrorCode() {
		return m_errorCode;
	}

	public List<Object> getArgs() {
		return m_args;
	}

	public void addArgs(Object... args) {
		if (args == null || args.length == 0) {
			return;
		}
		m_args.addAll(Arrays.asList(args));
	}

	public String getServiceCode() {
		return m_serviceCode;
	}

	public String getOperationId() {
		return m_operationId;
	}

	private String createStackTraceString() {
		// return ExceptionStackTrace.getExceptionTrace(this);

		StringBuilder stackTrace = new StringBuilder(ExceptionStackTrace.getExceptionTrace(this));
		stackTrace.append("\n");
		stackTrace.append("Loggedruntime Exception caused by :\n");
		if (getCause() instanceof LoggedRuntimeException) {
			LoggedRuntimeException cause = (LoggedRuntimeException) getCause();
			stackTrace.append(cause.getStackTraceString());
		} else if (getCause() instanceof ErrorException) {
			ErrorException cause = (ErrorException) getCause();
			stackTrace.append(cause.getStackTraceString());
		} else {
			stackTrace.append(ExceptionStackTrace.getExceptionTrace(getCause()));
		}
		return stackTrace.toString();

	}
	
	private String createStackTraceString(Throwable t) {
		// return ExceptionStackTrace.getExceptionTrace(this);

		StringBuilder stackTrace = new StringBuilder(ExceptionStackTrace.getExceptionTrace(this));
		stackTrace.append("\n");
		stackTrace.append("Loggedruntime Exception caused by :\n");
		if (getCause() instanceof LoggedRuntimeException) {
			LoggedRuntimeException cause = (LoggedRuntimeException) getCause();
			stackTrace.append(cause.getStackTraceString());
		} else if (getCause() instanceof ErrorException) {
			ErrorException cause = (ErrorException) getCause();
			stackTrace.append(cause.getStackTraceString());
		} else {
			stackTrace.append(ExceptionStackTrace.getExceptionTrace(t));
		}
		return stackTrace.toString();

	}
}
