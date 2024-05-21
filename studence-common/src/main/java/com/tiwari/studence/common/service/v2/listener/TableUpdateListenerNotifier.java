package com.tiwari.studence.common.service.v2.listener;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.executor.BackgroundExecutor;
import com.tiwari.studence.common.service.v2.interfaces.ITableUpdateListener;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TableUpdateListenerNotifier {
  private final BackgroundExecutor m_backExecutor;

  @Inject
  public TableUpdateListenerNotifier(BackgroundExecutor exec) {
    m_backExecutor = exec;
  }

  public <Pb extends GeneratedMessageV3, L extends ITableUpdateListener<Pb>> void notifyCreate(
          final L listener, final IFuture<Pb, ErrorException> createFuture) {
    notifyInternal(listener, createFuture);
  }

  public <Pb extends GeneratedMessageV3, L extends ITableUpdateListener<Pb>> void notifyUpdate(
          final L listener, final IFuture<Pb, ErrorException> updateFuture, Object... logs) {
    notifyInternal(listener, updateFuture);
  }

  public <Pb extends GeneratedMessageV3, L extends ITableUpdateListener<Pb>> void notifyDelete(
          final L listener, final IFuture<Pb, ErrorException> deleteFuture) {
    notifyInternal(listener, deleteFuture);
  }

  private <Pb extends GeneratedMessageV3, L extends ITableUpdateListener<Pb>> void notifyInternal(
          final L listener, final IFuture<Pb, ErrorException> future) {
    if (listener == null) {
      return;
    }
    TableUpdateListenerNotifierCF<Pb> cf = new TableUpdateListenerNotifierCF<Pb>(future, listener);
    cf.startAsyncCall();
    cf.addLogObjects(future,listener);
    m_backExecutor.runInBackground(this.getClass().getCanonicalName(), cf.getFutureResult());
  }
}