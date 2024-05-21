package com.tiwari.studence.common.util;

import com.google.inject.Inject;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.eventHandler.EventHandler;
import com.tiwari.studence.common.service.v2.async.AsyncCallForSyncCallWithoutException;
import com.tiwari.studence.common.service.v2.interfaces.IAlarm;
import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.exception.*;

import javax.inject.Singleton;
import java.util.concurrent.ExecutorService;

@Singleton
public class AlarmServer implements IAlarm {
  private final ExecutorService m_executor;
  private final ExceptionHandler m_exceptionHandler;

  @Inject
  public AlarmServer(ExecutorService executor, ExceptionHandler exceptionHandler) {
    m_executor = executor;
    m_exceptionHandler = exceptionHandler;
  }

  @Override
  public void setRepeatedAlarm(int timeInSec, EventHandler eventHandler) {
    Preconditions.check(false, "Function not supported");
  }

  @Override
  public IFuture<Void, VoidException> setAlarm(final long delayInMiliSeconds) {
    ALoggableCallable<Void> syncCall = new ALoggableCallable<Void>() {
      @Override
      public Void call() throws ErrorException {
        try {
          if (delayInMiliSeconds > 0) {
            Thread.sleep(delayInMiliSeconds);
          }
        } catch (Throwable t) {
          throw Exceptions.handleThrowable(t, "Alarm Server got exception during sleep");
        }
        return null;
      }
    };

    AsyncCallForSyncCallWithoutException<Void> asyncCall = new AsyncCallForSyncCallWithoutException<Void>(
            syncCall, m_executor, m_exceptionHandler);
    asyncCall.startAsyncCall();
    return asyncCall.getFutureResult();
  }
}
