package com.tiwari.studence.common.service.v2.listener;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.ITableUpdateListener;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.VoidException;

public class TableUpdateListenerNotifierCF<Pb extends GeneratedMessageV3>
        extends AControlFlow<TableUpdateListenerNotifierCF.State, Void, VoidException> {
  private final IFuture<Pb, ErrorException> m_futureToWait;
  private final ITableUpdateListener<Pb> m_listener;
  private Pb m_pb;

  public TableUpdateListenerNotifierCF(IFuture<Pb, ErrorException> futureToWait,
          ITableUpdateListener<Pb> listener) {
    super(State.WAIT_FOR_FUTURE, State.DONE);
    addStateHandler(State.WAIT_FOR_FUTURE, new WaitForFutureHandler());
    addStateHandler(State.CALL_LISTENER, new ListenerHandler());
    m_futureToWait = futureToWait;
    m_listener = listener;
  }

  public enum State {
    WAIT_FOR_FUTURE,
    CALL_LISTENER,
    DONE;
  }

  public class WaitForFutureHandler implements StateHandler<State> {
    @Override
    public void registerCalls() {
      registerFutures(m_futureToWait);
    }

    @Override
    public State handleState() {
      try {
        m_pb = m_futureToWait.get();
        return State.CALL_LISTENER;
      } catch (Throwable t) {
        throw Exceptions.handleThrowable(t);
      }
    }
  }

  public class ListenerHandler implements StateHandler<State> {
    private IFuture<Void, VoidException> m_listenerFuture;

    @Override
    public void registerCalls() {
      m_listenerFuture = m_listener.onItemChange(m_pb);
      registerFutures(m_listenerFuture);
    }

    @Override
    public State handleState() {
      m_listenerFuture.get();
      return State.DONE;
    }
  }
}
