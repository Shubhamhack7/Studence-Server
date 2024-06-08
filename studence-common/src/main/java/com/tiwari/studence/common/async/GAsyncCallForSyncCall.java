package com.tiwari.studence.common.async;

import java.util.concurrent.ExecutorService;

import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.ExceptionHandler;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

public class GAsyncCallForSyncCall<R, Ex extends Exception> extends ABatchAsyncCall<R, Ex> {
	  private final ALoggableCallable<R> m_syncCall;
	  private final ExecutorService m_executor;
	  private final ExceptionHandler m_exceptionhandler;
	  private final String m_serviceCode;

	  public GAsyncCallForSyncCall(ALoggableCallable<R> syncCall, ExecutorService executor,
	          ExceptionHandler exceptionhandler, String serviceCode) {
	    m_syncCall = syncCall;
	    m_executor = executor;
	    m_serviceCode = serviceCode;
	    m_exceptionhandler = exceptionhandler;
	    getAsyncCallback().setExceptionLogInfo(m_syncCall.getLogInfo());
	  }

	  @Override
	  protected void startAsyncCallInternal() {
	    Runnable callSync = new Runnable() {
	      @Override
	      public void run() {
	        try {
	          R value = m_syncCall.call();
	          getAsyncCallback().set(0, value);
	        } catch (Throwable t) {
	          Exception e = null;
	          if (Strings.notEmpty(m_serviceCode)) {
	            e = m_exceptionhandler.handleException(t, m_serviceCode, m_syncCall.getLogInfo());
	          } else {
	            e = m_exceptionhandler.handleException(t, m_syncCall.getLogInfo());
	          }
	          if (e instanceof ErrorException) {
	            getAsyncCallback().handleException(0, (Ex) e);
	          } else {
	            getAsyncCallback().handleUnexpectedException((LoggedRuntimeException) e);
	          }
	        } finally {
	          getAsyncCallback().done();
	        }
	      }
	    };
	    m_executor.execute(callSync);
	  }
	}