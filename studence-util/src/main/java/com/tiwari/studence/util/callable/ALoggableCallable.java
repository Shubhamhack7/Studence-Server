package com.tiwari.studence.util.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import com.tiwari.studence.util.exception.ErrorException;


public abstract class ALoggableCallable<V> implements Callable<V> {
  private final List<Object> m_infoToLog;

  public ALoggableCallable(Object... infoToLog) {
    m_infoToLog = Arrays.asList(infoToLog);
  }

  public List<Object> getLogInfo() {
    return m_infoToLog;
  }

  public abstract V call() throws ErrorException;
}
