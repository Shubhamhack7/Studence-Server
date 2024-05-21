package com.tiwari.studence.common.service.v2.idGenerator;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.IAlarm;
import com.tiwari.studence.proto.exponentialDelay.ExponentialDelayPb;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.exception.VoidException;
import com.tiwari.studence.util.log.IServerExceptionLogger;

import javax.inject.Inject;
import java.util.concurrent.Callable;

public class ExponentialBackoffAsyncCallExecutorCF<R, E extends Exception>
        extends AControlFlow<ExponentialBackoffAsyncCallExecutorCF.States, R, E> {
  private final ExponentialDelayPb m_expDelay;
  private final ExponentialDelayCalculator m_expDelayCalc;
  private final Callable<IFuture<R, E>> m_callable;
  private int m_currentTry = 0;
  private final IAlarm m_alarmService;
  private final IServerExceptionLogger m_exceptionLogger;

  @Inject
  public ExponentialBackoffAsyncCallExecutorCF(ExponentialDelayCalculator expDelayCalc,
          ExponentialDelayPb expDelay, Callable<IFuture<R, E>> callable, IAlarm alarmService,
          IServerExceptionLogger exceptionLogger) {
    super(States.SET_ALARM, States.DONE);
    m_expDelay = expDelay;
    m_expDelayCalc = expDelayCalc;
    m_callable = callable;
    m_alarmService = alarmService;
    m_exceptionLogger = exceptionLogger;
    addStateHandler(States.SET_ALARM, new StateAlramHandler());
    addStateHandler(States.RUN_CALLABLE, new RunCallableHandler());
  }

  enum States {
    SET_ALARM,
    RUN_CALLABLE,
    DONE
  }

  private class StateAlramHandler implements StateHandler<States> {
    IFuture<Void, VoidException> future;

    @Override
    public void registerCalls() {
      int delay = m_expDelayCalc.exponentialDelay(m_expDelay, m_currentTry);
      future = m_alarmService.setAlarm(delay);

      registerFutures(future);
    }

    @Override
    public States handleState() {
      future.get();
      return States.RUN_CALLABLE;
    }
  }

  private class RunCallableHandler implements StateHandler<States> {
    private IFuture<R, E> m_future;

    @Override
    public void registerCalls() {
      m_currentTry++;
      try {
        m_future = m_callable.call();
      } catch (Exception e) {
        m_exceptionLogger.logError(e, "ExponentialBackoffAsyncCallExecutorCF");

      }
      registerFutures(m_future);
    }

    @Override
    public States handleState() {
      if (m_future != null) {
        try {
          getAsyncCallback().set(0, m_future.get());
          return States.DONE;
        } catch (LoggedRuntimeException e) {
          if (m_currentTry < m_expDelay.getMaxTries()) {
            return States.SET_ALARM;
          }
          getAsyncCallback().handleException(0, (E) e);
          return States.DONE;
        } catch (Exception e) {
          getAsyncCallback().handleException(0, (E) e);
          return States.DONE;
        }
      } else {
        getAsyncCallback().handleException(0, (E) new Exception("Future is null"));
        return States.DONE;
      }
    }
  }
}