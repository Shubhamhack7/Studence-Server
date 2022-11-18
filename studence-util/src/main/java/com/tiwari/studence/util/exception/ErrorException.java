package com.tiwari.studence.util.exception;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

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
public class ErrorException extends Exception {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger("ErrorException");
  private final List<ParsedErrorProto> m_errorProto = Lists.newArrayList();
  private final List<Object> m_args;
  private final String m_stackTrace;
  private String m_uiErrorString;
  private String m_errorCode;

//  public ErrorException(ErrorTypeUiPbEnum type, Object... args) {
//    m_errorProto.add(new ParsedErrorProto(
//            ErrorProtoBuilder.createErrorProto(type).getErrorCategory(), type));
//    m_args = Lists.newArrayList(args);
//    m_stackTrace = createStackTraceString();
//    printError();
//  }
  

  public ErrorException(List<ParsedErrorProto> errors, Object... args) {
    m_errorProto.addAll(errors);
    m_args = Lists.newArrayList(args);
    m_stackTrace = createStackTraceString();
    printError();
  }

//  public ErrorException(ErrorProtoUiPb errorProto, Object... args) {
//    m_errorProto.add(new ParsedErrorProto(errorProto));
//    m_args = Lists.newArrayList(args);
//    m_stackTrace = createStackTraceString();
//    printError();
//  }

  public ErrorException(Object... args) {
    m_args = Lists.newArrayList(args);
    m_stackTrace = createStackTraceString();
    printError();
  }
  
  public ErrorException(Exception e) {
    super(e);
    m_args = Lists.newArrayList(e);
    m_stackTrace = createStackTraceString();
    printError();
  }

  public String getExceptionId() {
    return Integer.toHexString(this.hashCode());
  }

  private void printError() {
    LOGGER.severe(m_errorProto.toString());
    LOGGER.severe(m_args.toString());
    LOGGER.severe(m_stackTrace);
  }

  public String getStackTraceString() {
    return m_stackTrace;
  }

  public ParsedErrorProto getErrorProto() {
//    Preconditions.check(m_errorProto.size() == 1,
//            "This method should be called in case of single error");
    return (ParsedErrorProto) m_errorProto.get(0);
  }

  public List<ParsedErrorProto> getErrorProtoS() {
    return m_errorProto;
  }

  private String createStackTraceString() {
    return ExceptionStackTrace.getExceptionTrace(this);
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

  public String getUiErrorString() {
    return m_uiErrorString;
  }

  public String getErrorCode() {
    return m_errorCode;
  }

}
