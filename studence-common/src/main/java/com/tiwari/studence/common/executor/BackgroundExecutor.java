package com.tiwari.studence.common.executor;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.InvokingFuturesGetDoneCallback;
import com.tiwari.studence.util.log.IServerExceptionLogger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BackgroundExecutor {
  private final IServerExceptionLogger m_logger;

  @Inject
  public BackgroundExecutor(IServerExceptionLogger logger) {
    m_logger = logger;
  }

  public void runInBackground(String action, IFuture<?, ?>... futures) {
    for (int i = 0; i < futures.length; ++i) {
      new InvokingFuturesGetDoneCallback(m_logger, action, futures[i]);
    }
  }

  public void runInBackground(String action, List<IFuture<?, ?>> futures) {
    for (int i = 0; i < futures.size(); ++i) {
      new InvokingFuturesGetDoneCallback(m_logger, action, futures.get(i));
    }
  }
}
