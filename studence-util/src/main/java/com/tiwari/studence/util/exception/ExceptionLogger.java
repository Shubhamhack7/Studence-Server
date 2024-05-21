package com.tiwari.studence.util.exception;

import com.tiwari.studence.util.log.IServerExceptionLogger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExceptionLogger implements IServerExceptionLogger {

  @Inject
  public ExceptionLogger() {
  }

  public void logError(Throwable t, String errorAction) {}
}
