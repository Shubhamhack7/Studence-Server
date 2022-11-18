package com.tiwari.studence.util.exception;

public class ExceptionStackTrace {
  public static String getExceptionTrace(Throwable throwable) {
    StackTraceElement[] stackTrace = throwable.getStackTrace();
    StringBuffer stackTraceString = new StringBuffer();
    stackTraceString.append(throwable.toString() + "@" + Integer.toHexString(throwable.hashCode()));
    if (throwable.getMessage() != null) {
      stackTraceString.append("\n\t");
      stackTraceString.append(throwable.getMessage());
    }
    stackTraceString.append("\n\t");
    for (int i = 0; i < stackTrace.length; i++) {
      stackTraceString.append(getTrace(stackTrace[i]));
      stackTraceString.append("\n\t");
    }
    return stackTraceString.toString();
  }

  private static String getTrace(StackTraceElement stackTraceElement) {
    return "[" + stackTraceElement.getClassName() + ":" + stackTraceElement.getMethodName() + ":"
            + stackTraceElement.getLineNumber() + "]";
  }
}
