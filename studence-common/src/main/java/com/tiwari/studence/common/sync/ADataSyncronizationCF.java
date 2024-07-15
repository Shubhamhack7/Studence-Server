package com.tiwari.studence.common.sync;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

public class ADataSyncronizationCF<P extends GeneratedMessageV3, S extends IEntityService>
        extends AControlFlow<ADataSyncronizationCF.State, Void, ErrorException> {
  String m_id;
  S m_service;
  GeneratedMessageV3 builder;

  public ADataSyncronizationCF(String id, S service) {
    super(State.GET_ITEM, State.DONE);
    m_id = id;
    m_service = service;
    addStateHandler(State.GET_ITEM, new GetItemHandler());
    addStateHandler(State.UPDATE_ITEM, new UpdateItemHandler());
  }

  enum State {
    GET_ITEM,
    UPDATE_ITEM,
    DONE
  }

  public class GetItemHandler implements StateHandler<State> {
    IFuture<P, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_service.get(m_id);
    }

    @Override
    public State handleState() {
      try {
        builder = m_future.get();
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.UPDATE_ITEM;
    }

  }

  public class UpdateItemHandler implements StateHandler<State> {
    IFuture<P, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_service.update(m_id, builder);
    }

    @Override
    public State handleState() {
      try {
        m_future.get();
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }

  }
}
