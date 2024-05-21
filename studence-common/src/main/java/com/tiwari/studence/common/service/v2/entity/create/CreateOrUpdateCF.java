package com.tiwari.studence.common.service.v2.entity.create;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.index.GIndexStore;
import com.tiwari.studence.proto.entity.EntityProtoUiPb;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.proto.index.IndexPb;
import com.tiwari.studence.proto.index.IndexVersionPb;
import com.tiwari.studence.util.encoder.IBiConverter;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;

public class CreateOrUpdateCF
        extends AControlFlow<CreateOrUpdateCF.State, IndexPb, ErrorException> {
  enum State {
    GET_CURRENT_INDEX,
    GET_ITEM,
    CREATE_ITEM,
    UPDATE_ITEM,
    DONE
  }

  private final GIndexStore<?, ?, ?, ?> m_store;
  private final IndexPb m_entity;
  private EntityProtoUiPb m_entityPb;
  private IndexVersionPb m_currentIndexVersionPb;
  private IndexPb m_lookedUpEntity;

  public CreateOrUpdateCF(GIndexStore<?, ?, ?, ?> dbInfo, IndexPb entity,
          EntityProtoUiPb entityPb) {
    super(State.GET_CURRENT_INDEX, State.DONE);
    m_store = dbInfo;
    m_entity = entity;
    m_entityPb = entityPb;
    addStateHandler(State.GET_CURRENT_INDEX, new GetIndexItemHandler());
    addStateHandler(State.GET_ITEM, new GetItemHandler());
    addStateHandler(State.CREATE_ITEM, new CreateItemHandler());
    addStateHandler(State.UPDATE_ITEM, new UpdateItemHandler());
  }

  private class GetIndexItemHandler implements StateHandler<State> {
    private IFuture<IndexVersionPb, ErrorException> m_getFuture;

    @Override
    public void registerCalls() {
      m_getFuture = m_store.getIndexVersion(m_entity.getEntityProto().getId());
      registerFutures(m_getFuture);
    }

    @Override
    public State handleState() {
      try {
        m_currentIndexVersionPb = m_getFuture.get();
        if (m_currentIndexVersionPb.getEntityVersion() <= m_entityPb.getVersion()) {
          return State.UPDATE_ITEM;
        } else {
          return State.GET_ITEM;
          // do nothing
        }

      } catch (ErrorException e) {
        if (e.getErrorProto().getErrorProto().getErrorTypePbEnum() == ErrorTypePbEnum.NOT_FOUND) {
          return State.CREATE_ITEM;
        } else {
          getAsyncCallback().handleUnexpectedException(
                  Exceptions.convertToLoggedRuntimeException(e));
          return State.DONE;
        }
      }
    }
  }

  private class GetItemHandler implements StateHandler<State> {
    private IFuture<IndexPb, ErrorException> m_getFuture;

    @Override
    public void registerCalls() {
      m_getFuture = m_store.getItem(m_entity.getEntityProto().getId());
      registerFutures(m_getFuture);
    }

    @Override
    public State handleState() {
      try {
        m_lookedUpEntity = m_getFuture.get();
        getAsyncCallback().set(0, m_lookedUpEntity);
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(Exceptions.convertToLoggedRuntimeException(e));
      }
      return State.DONE;
    }
  }

  private class CreateItemHandler implements StateHandler<State> {
    private IFuture<IndexPb, ErrorException> m_createFuture;

    @Override
    public void registerCalls() {
      m_createFuture = m_store.createItem(m_entity);
      registerFutures(m_createFuture);
    }

    @Override
    public State handleState() {
      try {
        IndexPb createdIndex = m_createFuture.get();
        getAsyncCallback().set(0, createdIndex);
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return State.DONE;
    }
  }

  private class UpdateItemHandler implements StateHandler<State> {
    private IFuture<IndexPb, ErrorException> m_updateFuture;

    @Override
    public void registerCalls() {
      IndexPb.Builder indexWithVersion = IndexPb.newBuilder(m_entity);
      IBiConverter<Integer, String> encoder = EntityIndexAttributes.VERSION.getStringEncoder();
      indexWithVersion.getEntityProtoBuilder()
              .setVersion(encoder.reverseConvert(m_currentIndexVersionPb.getIndexVersion()));
      m_updateFuture = m_store.updateItem(indexWithVersion.build());
      registerFutures(m_updateFuture);
    }

    @Override
    public State handleState() {
      try {
        IndexPb updatedIndex = m_updateFuture.get();
        getAsyncCallback().set(0, updatedIndex);
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return State.DONE;
    }
  }
}