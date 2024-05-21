package com.tiwari.studence.common.service.v2.async;

import com.tiwari.studence.common.async.GAsyncCallForSyncCall;
import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.exception.ExceptionHandler;
import com.tiwari.studence.util.exception.VoidException;

import java.util.concurrent.ExecutorService;

public class AsyncCallForSyncCallWithoutException<R>
        extends GAsyncCallForSyncCall<R, VoidException> {
  public AsyncCallForSyncCallWithoutException(ALoggableCallable<R> syncCall,
          ExecutorService executor, ExceptionHandler exceptionhandler) {
    super(syncCall, executor, exceptionhandler, "");
  }

  public AsyncCallForSyncCallWithoutException(ALoggableCallable<R> syncCall,
          ExecutorService executor, String serviceCode, ExceptionHandler exceptionhandler) {
    super(syncCall, executor, exceptionhandler, serviceCode);
  }
}
