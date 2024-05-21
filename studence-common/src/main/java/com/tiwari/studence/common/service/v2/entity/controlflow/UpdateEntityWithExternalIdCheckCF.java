package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.manager.EntityStoreManager;
import com.tiwari.studence.util.exception.ErrorException;

public class UpdateEntityWithExternalIdCheckCF<R extends GeneratedMessageV3>
        extends AControlFlow<UpdateEntityWithExternalIdCheckCF.State, R, ErrorException> {

  private final IEntityProtoWrapper<R> m_entityWrapper;
  private final R m_entity;
  private final EntityStoreManager<R, ?> m_entityStoreManager;
  private final String m_requestId;

  public UpdateEntityWithExternalIdCheckCF(EntityStoreManager<R, ?> entityStoreManager,
          IEntityProtoWrapper<R> entityProtoWrapper, R entity, String requestId) {
    super(State.CHECK_EXTERNAL_ID_UNIQUENESS, State.DONE);
    m_entityStoreManager = entityStoreManager;
    m_entityWrapper = entityProtoWrapper;
    m_entity = entity;
    m_requestId = requestId;
    addStateHandler(State.CHECK_EXTERNAL_ID_UNIQUENESS, new CheckExternalIdUniquenessHandler());
    addStateHandler(State.UPDATE, new UpdateStateHandler());
  }

  public UpdateEntityWithExternalIdCheckCF(EntityStoreManager<R, ?> entityStoreManager,
          IEntityProtoWrapper<R> entityProtoWrapper, R entity) {
    this(entityStoreManager, entityProtoWrapper, entity, null);
  }

  public enum State {
    CHECK_EXTERNAL_ID_UNIQUENESS,
    UPDATE,
    DONE
  }

  public class CheckExternalIdUniquenessHandler implements StateHandler<State> {

    private IFuture<Boolean, ErrorException> m_future;
    private Boolean m_isUniqueExternalId;

    @Override
    public void registerCalls() {
      String entityId = m_entityWrapper.getEntityProto(m_entity).getId();
      // List<String> externalIdsList = m_entityWrapper.getEntityProto(m_entity).getExternalIdsList();
      //      m_future = m_externalIdChecker.isExternalIdUnique(entityId, externalIdsList);
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      //      try {
      //        m_isUniqueExternalId = m_future.get();
      //      } catch (ErrorException e) {
      //        getAsyncCallback().handleUnexpectedException(Exceptions.handleThrowable(e));
      //        return State.DONE;
      //      }
      //      if (!m_isUniqueExternalId) {
      //        getAsyncCallback().handleUnexpectedException(
      //                new LoggedRuntimeException(ErrorTypeUiPbEnum.VALIDATION_FAILED, m_entity));
      //        return State.DONE;
      //      }
      return State.UPDATE;
    }
  }

  public class UpdateStateHandler implements StateHandler<State> {

    private IFuture<R, ErrorException> m_updateEntity;

    @Override
    public void registerCalls() {
      if (m_requestId != null) {
        m_updateEntity = m_entityStoreManager.updateEntity(m_requestId, m_entity);
      } else {
        m_updateEntity = m_entityStoreManager.updateEntity(m_entity);
      }
      registerFutures(m_updateEntity);
    }

    @Override
    public State handleState() {
      try {
        getAsyncCallback().set(0, m_updateEntity.get());
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return State.DONE;
    }
  }

}
