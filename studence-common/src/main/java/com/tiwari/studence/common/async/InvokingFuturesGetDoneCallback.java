package com.tiwari.studence.common.async;

import com.tiwari.studence.util.log.IServerExceptionLogger;

public class InvokingFuturesGetDoneCallback implements IDoneCallback {
	  private final IFuture<?, ?> m_future;
	  private final IServerExceptionLogger m_logger;
	  private final String m_action;

	  public InvokingFuturesGetDoneCallback(IServerExceptionLogger logger, String action,
	          IFuture<?, ?> future) {
	    m_logger = logger;
	    m_action = action;
	    m_future = future;
	    m_future.addDoneCallback(this);
	  }

	  @Override
	  public void done() {
	    try {
	      m_future.get();
	    } catch (Throwable th) {
	      m_logger.logError(th, m_action);
	    }
	  }
	}