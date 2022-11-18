package com.tiwari.studence.common.async;

import com.tiwari.studence.util.exception.LoggedRuntimeException;

// Do we really need exception type or it should always be wrapped in LoggedRuntimeexception.

public interface ICallback<R, E extends Exception> extends IDoneCallback {
  /**
   * The response type.
   */
  public void set(R response);

  /**
   * Called in case of exception
   */
  public void handleException(E errors);
  
  /**
   * Called in case of unknown exception or error
   */
  public void handleUnexpectedException(LoggedRuntimeException exception);

  public E getCheckedException();

  public LoggedRuntimeException getUnexpectedException();
}
