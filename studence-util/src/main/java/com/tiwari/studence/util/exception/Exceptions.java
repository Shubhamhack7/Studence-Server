// Copyright (c) 2011, All Right Reserved, http://nsimpl.com/

package com.tiwari.studence.util.exception;

public class Exceptions {
  public static LoggedRuntimeException handleThrowable(Throwable t, Object... objects) {
    if (t instanceof ErrorException) {
      return convertToLoggedRuntimeException((ErrorException) t);
    }
    if (t instanceof LoggedRuntimeException) {
      return (LoggedRuntimeException) t;
    }
    return new LoggedRuntimeException(t, objects);
  }

  public static LoggedRuntimeException convertToLoggedRuntimeException(ErrorException ee) {
    LoggedRuntimeException lre = new LoggedRuntimeException(ee);
    return lre;
  }
}
