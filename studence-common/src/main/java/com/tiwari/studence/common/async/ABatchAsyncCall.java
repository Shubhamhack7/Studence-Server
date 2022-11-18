package com.tiwari.studence.common.async;

import java.util.List;

import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.exception.VoidException;

public abstract class ABatchAsyncCall<R, E extends Exception> implements IBatchAsyncCall<R, E> {
	  private boolean m_started = false;
	  private final CallbackFuturesGroup<R, E> m_callbackFutures;
	  protected final TimingControlFlowHook m_cfHook;

	  public enum TIME_STATS_ID {
	    WAIT,
	    TOTAL
	  }

	  protected ABatchAsyncCall() {
	    this(1);
	  }

	  protected ABatchAsyncCall(int noOfRequests) {
	    m_callbackFutures = new CallbackFuturesGroup<R, E>(noOfRequests);
	    m_cfHook = TimingControlFlowHookprovider.newCFHook();
	    if (m_cfHook != null) {
	      m_cfHook.asyncCallCreate(ABatchAsyncCall.this);
	    }
	    m_callbackFutures.addDoneCallback(new CalltimeTrackerCallback());
	  }

	  private class CalltimeTrackerCallback implements IDoneCallback {
	    @Override
	    public void done() {
	      if (m_cfHook != null) {
	        m_cfHook.callEnded();
	      }
	    }
	  }

	  @Override
	  public final void startAsyncCall() {
	    Preconditions.check(!m_started, "Async Call already started");
	    m_started = true;
	    try {
	      startAsyncCallInternal();
	    } catch (Throwable t) {
	      throw Exceptions.handleThrowable(t);
	    }
	  }

	  protected boolean callStarted() {
	    return m_started;
	  }

	  /**
	   * The implementation of this method should start the call and ensure that the
	   * callback is always called.
	   * 
	   * @param callback
	   */
	  protected abstract void startAsyncCallInternal();

	  protected final CallbackFuturesGroup<R, E> getAsyncCallback() {
	    return m_callbackFutures;
	  }

	  public IFuture<List<IFuture<R, E>>, VoidException> getFutureResults() {
	    return m_callbackFutures;
	  }

	  public IFuture<R, E> getFutureResult() {
	    return m_callbackFutures.getEnclosedFuture();
	  }

	}
