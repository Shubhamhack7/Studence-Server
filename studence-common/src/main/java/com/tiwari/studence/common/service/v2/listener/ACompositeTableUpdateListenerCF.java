package com.tiwari.studence.common.service.v2.listener;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.async.Futures;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncConverter;
import com.tiwari.studence.common.service.v2.interfaces.IChangeHandler;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.VoidException;

import java.util.List;

public class ACompositeTableUpdateListenerCF<Pb extends GeneratedMessageV3, UiPb extends GeneratedMessageV3, Converter extends IAsyncConverter<Pb, UiPb>>
        extends AControlFlow<ACompositeTableUpdateListenerCF.State, Void, VoidException> {
  enum State {
    CONVERT_TO_WRAPPER,
    INVOKE_CHANGE_HANDLERS,
    DONE
  };

  private final Converter m_converter;
  private final List<IChangeHandler<Pb>> m_changeHandlers;
  private final Pb m_changedPb;

  protected ACompositeTableUpdateListenerCF(State startState, State endState,
          Converter converter,
          List<IChangeHandler<Pb>> changeHandlers, Pb data) {
    super(State.CONVERT_TO_WRAPPER, State.DONE);
    m_converter = converter;
    m_changeHandlers = changeHandlers;
    m_changedPb = data;
    addStateHandler(State.CONVERT_TO_WRAPPER, new ConvertToUiPbHandler());
    addStateHandler(State.INVOKE_CHANGE_HANDLERS, new InvokeChangeHandlers());
  }

  private class ConvertToUiPbHandler implements StateHandler<State> {
    private IFuture<UiPb, ErrorException> m_getUiPbFuture;

    @Override
    public void registerCalls() {
      m_getUiPbFuture = m_converter.convert(m_changedPb);
      registerFutures(m_getUiPbFuture);
    }

    @Override
    public State handleState() {
      try {
        UiPb uiPb = m_getUiPbFuture.get();
        return State.INVOKE_CHANGE_HANDLERS;
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(Exceptions.handleThrowable(e));
        return State.DONE;
      }
    }
  }

  private class InvokeChangeHandlers implements StateHandler<State> {
    private List<IFuture<?, ?>> m_changeHandlerFutures;

    @Override
    public void registerCalls() {
      for (IChangeHandler<Pb> handler : m_changeHandlers) {
        m_changeHandlerFutures.add(handler.handleChange(m_changedPb));
      }
    }

    @Override
    public State handleState() {
      try {
        Futures.invokeGet(m_changeHandlerFutures);
      } catch (Exception e) {
        getAsyncCallback().handleUnexpectedException(Exceptions.handleThrowable(e));
      }
      return State.DONE;
    }
  }
}
