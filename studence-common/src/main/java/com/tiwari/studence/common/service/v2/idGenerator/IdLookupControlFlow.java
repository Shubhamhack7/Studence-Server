package com.tiwari.studence.common.service.v2.idGenerator;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.IIdEntityStore;
import com.tiwari.studence.proto.entity.EntityProtoPb;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.proto.id.IdProtoPb;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;

import java.util.concurrent.atomic.AtomicLong;

public class IdLookupControlFlow
        extends AControlFlow<IdLookupControlFlow.State, AtomicLong, ErrorException> {

  private final IIdEntityStore m_storeManager;
  private final String m_id;
  private final long m_chunkSize;
  private final long INITIAL_ID = 0;
  private IdProtoPb m_lookedUpIdProtoPb;

  public IdLookupControlFlow(IIdEntityStore storeManager, long chunkSize) {
    super(State.LOOKUP_ID_TABLE, State.DONE);
    m_storeManager = storeManager;
    m_id = storeManager.getIdRowDbId();
    m_chunkSize = chunkSize;
    addStateHandler(State.LOOKUP_ID_TABLE, new LookupIdTableHandler());
    addStateHandler(State.INSERT_ID_TABLE, new InsertIdTableHandler());
    addStateHandler(State.UPDATE_ID_TABLE, new UpdateIdTableHandler());
  }

  enum State {
    LOOKUP_ID_TABLE,
    INSERT_ID_TABLE,
    UPDATE_ID_TABLE,
    DONE;
  }

  private class LookupIdTableHandler implements StateHandler<State> {
    private IFuture<IdProtoPb, ErrorException> m_lookupId;

    public void registerCalls() {
      m_lookupId = m_storeManager.lookupEntity(m_id);
      registerFutures(m_lookupId);
    }

    public State handleState() {
      try {
        m_lookedUpIdProtoPb = m_lookupId.get();
        return State.UPDATE_ID_TABLE;
      } catch (ErrorException e) {
        if (e.getErrorProto().getErrorProto().getErrorTypePbEnum() == ErrorTypePbEnum.NOT_FOUND) {
          m_lookedUpIdProtoPb = IdProtoPb.newBuilder()
                  .setEntityProto(EntityProtoPb.newBuilder().setId(m_id).build()).setId(INITIAL_ID)
                  .build();
          return State.INSERT_ID_TABLE;
        } else {
          getAsyncCallback().handleUnexpectedException(Exceptions.handleThrowable(e));
          return State.DONE;
        }
      }
    }
  }

  private class InsertIdTableHandler extends UpdateIdTableHandler {
    @Override
    protected IFuture<IdProtoPb, ErrorException> updateEntity(IdProtoPb proto) {
      return m_storeManager.insertEntity(proto);
    }
  }

  public class UpdateIdTableHandler implements StateHandler<State> {
    protected IFuture<IdProtoPb, ErrorException> m_updateEntity;

    @Override
    public void registerCalls() {
      m_updateEntity = updateEntity(createIdProtoForUpdate());
      registerFutures(m_updateEntity);
    }

    @Override
    public State handleState() {
      try {
        m_updateEntity.get();
        getAsyncCallback().set(0, new AtomicLong(m_lookedUpIdProtoPb.getId() + 1));
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return State.DONE;
    }

    protected IFuture<IdProtoPb, ErrorException> updateEntity(IdProtoPb proto) {
      return m_storeManager.updateEntity(proto);
    }

    private IdProtoPb createIdProtoForUpdate() {
      return IdProtoPb.newBuilder(m_lookedUpIdProtoPb)
              .setId(m_lookedUpIdProtoPb.getId() + m_chunkSize).build();
    }
  }
}
