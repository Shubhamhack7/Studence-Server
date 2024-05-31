package com.tiwari.studence.common.async;

import java.util.concurrent.ExecutorService;

import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.ExceptionHandler;

public class AsyncCallForSyncCall<R> extends GAsyncCallForSyncCall<R, ErrorException> {
	  public AsyncCallForSyncCall(ALoggableCallable<R> syncCall, ExecutorService executor,
	          ExceptionHandler exceptionhandler) {
	    super(syncCall, executor, exceptionhandler, "");
	  }

	  public AsyncCallForSyncCall(ALoggableCallable<R> syncCall, ExecutorService executor,
	          String serviceCode, ExceptionHandler exceptionhandler) {
	    super(syncCall, executor, exceptionhandler, serviceCode);
	  }

	}