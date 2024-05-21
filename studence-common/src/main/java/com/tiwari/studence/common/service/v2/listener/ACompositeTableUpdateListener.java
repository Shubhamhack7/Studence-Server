package com.tiwari.studence.common.service.v2.listener;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.WaitOnFutureAndExecuteRunnableControlFlow;
import com.tiwari.studence.common.executor.BackgroundExecutor;
import com.tiwari.studence.common.request.RequestExecutor;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncConverter;
import com.tiwari.studence.common.service.v2.interfaces.IChangeHandler;
import com.tiwari.studence.common.service.v2.interfaces.IForceChangeHandler;
import com.tiwari.studence.common.service.v2.interfaces.ITableUpdateListener;
import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.VoidException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public abstract class ACompositeTableUpdateListener<Pb, UiPb, Converter extends IAsyncConverter<Pb, UiPb>>
        implements ITableUpdateListener<Pb> {
  private final Converter m_converter;
  private final IChangeHandler<UiPb>[] m_changeHandlers;
  private final BackgroundExecutor m_backExec;
  private final Map<String, IChangeHandler> m_handlerMap = Maps.newHashMap();

  public ACompositeTableUpdateListener(Converter converter,
          BackgroundExecutor backExec, IChangeHandler<UiPb>... changeHandlers) {
    m_converter = converter;
    m_backExec = backExec;
    m_changeHandlers = changeHandlers;
    for (IChangeHandler<UiPb> handler : m_changeHandlers) {
      m_handlerMap.put(handler.getClass().getCanonicalName(), handler);
    }
  }

  @Override
  public IFuture<Void, VoidException> onItemChange(final Pb data, final Set<String> handlerIds) {
    List<IChangeHandler<UiPb>> selectedChangeHandlers = Lists.newArrayList();
    for (String handlerId : handlerIds) {
      final IChangeHandler<UiPb> chHandler = m_handlerMap.get(handlerId);
      if (chHandler != null) {
        selectedChangeHandlers.add(chHandler);
      }
    }
    return callHandlers(data, selectedChangeHandlers, true);
  }

  @Override
  public IFuture<Void, VoidException> onItemChange(final Pb created) {
    return callHandlers(created, Arrays.asList(m_changeHandlers), false);
  }

  private IFuture<Void, VoidException> callHandlers(final Pb data,
          List<IChangeHandler<UiPb>> changeHandlers, final boolean isForcefull) {
    Callable<IFuture> callable1 = new Callable<IFuture>() {
      @Override
      public IFuture call() throws Exception {
        final IFuture<UiPb, ErrorException> future = m_converter.convert(data);
        ALoggableCallable<Void> callable = new ALoggableCallable<Void>() {
          @Override
          public Void call() throws ErrorException {
            UiPb uiPb = future.get();
            for (int i = 0; i < m_changeHandlers.length; ++i) {
              final IChangeHandler<UiPb> chHandler = m_changeHandlers[i];
              if ((chHandler != null)) {
                if (chHandler instanceof IForceChangeHandler) {
                  final IForceChangeHandler handler = (IForceChangeHandler) chHandler;
                  RequestExecutor.getInstance().runRequestInContext(handler.getClass().getName(),
                          new Callable<IFuture>() {
                            @Override
                            public IFuture call() throws Exception {
                              return handler.handleChange(uiPb, isForcefull);
                            }
                          });
                } else {
                  RequestExecutor.getInstance().runRequestInContext(chHandler.getClass().getName(),
                          new Callable<IFuture>() {
                            @Override
                            public IFuture call() throws Exception {
                              return chHandler.handleChange(uiPb);
                            }
                          });
                }
              }
            }
            return null;
          }
        };
        return WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(callable, future);
      }
    };
    return (IFuture<Void, VoidException>) RequestExecutor.getInstance()
            .runRequestInContext(this.getClass().getName(), callable1);
  }

}
