package com.tiwari.studence.common.service.v2.idGenerator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tiwari.studence.common.async.IBatchAsyncCall;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.IAlarm;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncCallCreator;
import com.tiwari.studence.proto.exponentialDelay.ExponentialDelayPb;
import com.tiwari.studence.util.log.IServerExceptionLogger;


import java.util.concurrent.Callable;

@Singleton
public class ExponentialBackoffAsyncCallScheduler {
  private final ExponentialDelayPb m_expDelay;
  private final ExponentialDelayCalculator m_expDelayCalc;
  private final IAlarm m_ialarm;
  private final IServerExceptionLogger m_exceptionLogger;

  @Inject
  public ExponentialBackoffAsyncCallScheduler(IAlarm ialarm,
          ExponentialDelayCalculator expDelayCalc, IServerExceptionLogger exceptionLogger) {
    m_expDelay = ExponentialDelayPb.newBuilder().build();
    m_expDelayCalc = expDelayCalc;
    m_ialarm = ialarm;
    m_exceptionLogger = exceptionLogger;
  }

  public <R, E extends Exception> IFuture<R, E> scheduleCall(
          final IAsyncCallCreator<R, E> asyncCallCreator) {
    Callable<IFuture<R, E>> callable = new Callable<IFuture<R, E>>() {
      @Override
      public IFuture<R, E> call() {
        IBatchAsyncCall<R, E> call = asyncCallCreator.createAsyncCall();
        call.startAsyncCall();
        return call.getFutureResult();
      }
    };
    return scheduleCallForFuture(callable);
  }

  public <R, E extends Exception> IFuture<R, E> scheduleCallForFuture(
          Callable<IFuture<R, E>> callable) {
    ExponentialBackoffAsyncCallExecutorCF<R, E> cf = new ExponentialBackoffAsyncCallExecutorCF<R, E>(
            m_expDelayCalc, m_expDelay, callable, m_ialarm, m_exceptionLogger);
    cf.startAsyncCall();
    return cf.getFutureResult();

  }

}