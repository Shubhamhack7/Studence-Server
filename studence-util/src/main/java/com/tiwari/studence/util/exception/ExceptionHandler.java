// Copyright (c) 2011, All Right Reserved, http://nsimpl.com/

package com.tiwari.studence.util.exception;

import javax.inject.Singleton;

@Singleton
public class ExceptionHandler {
  public LoggedRuntimeException handleException(Throwable t, Object... objects) {
    return Exceptions.handleThrowable(t, objects);
  }

  public LoggedRuntimeException handleException(Throwable t, String serviceCode,
          Object... objects) {
    return Exceptions.handleThrowable(t, objects);
  }
}
