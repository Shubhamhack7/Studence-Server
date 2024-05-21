package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.helper.RequestIdHelper;
import com.tiwari.studence.common.service.v2.idGenerator.IdGenerator;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.manager.EntityStoreManager;
import com.tiwari.studence.proto.entity.EntityProtoPb;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.exception.VoidException;

public class InsertEntityControlFlowWithExternalIdCheck<R extends GeneratedMessageV3>
        extends AControlFlow<InsertEntityControlFlowWithExternalIdCheck.State, R, ErrorException> {

  enum State {
    CHECK_EXTERNAL_ID_UNIQUENESS,
    CHECK_OR_GET_ID,
    INSERT,
    GET_AND_CHECK_INSERTED,
    DONE
  }

  private final EntityStoreManager<R, ?> m_entityStoreManager;
  private final String m_requestId;
  private final R m_entity;
  private final boolean m_retryable;
  private final IdGenerator<?> m_idGenerator;
  private final IEntityProtoWrapper<R> m_entityWrapper;
  private final RequestIdHelper m_requestIdHelper;
  private String m_newId;
  private ErrorException m_insertException;
  // private final IExternalIdChecker m_externalIdChecker;

  public InsertEntityControlFlowWithExternalIdCheck(EntityStoreManager<R, ?> entityStoreManager,
          String requestId, R entity, IdGenerator<?> idGenerator,
          IEntityProtoWrapper<R> entityWrapper, boolean retryable,
          RequestIdHelper requestIdHelper) {
    super(State.CHECK_EXTERNAL_ID_UNIQUENESS, State.DONE);
    m_entityStoreManager = entityStoreManager;
    m_requestId = requestId;
    m_entity = entity;
    m_retryable = retryable;
    m_idGenerator = idGenerator;
    m_entityWrapper = entityWrapper;
    m_requestIdHelper = requestIdHelper;
    // m_externalIdChecker = externalIdChecker;
    addStateHandler(State.CHECK_EXTERNAL_ID_UNIQUENESS, new CheckExternalIdUniquenessHandler());
    addStateHandler(State.CHECK_OR_GET_ID, new CheckOrGetIdHandler());
    addStateHandler(State.INSERT, new InsertHandler());
    addStateHandler(State.GET_AND_CHECK_INSERTED, new GetAndCheckInsertedHandler());
  }

  public class CheckExternalIdUniquenessHandler implements StateHandler<State> {

    private IFuture<Boolean, ErrorException> m_future;

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      return State.CHECK_OR_GET_ID;

    }
  }

  private class CheckOrGetIdHandler implements StateHandler<State> {
    private IFuture<String, VoidException> m_idFuture;

    @Override
    public void registerCalls() {
      EntityProtoPb entityProto = m_entityWrapper.getEntityProto(m_entity);
      if (m_retryable) {
        // TODO: Make call without id retryable by using externalId and then
        // remove this condition.
        Preconditions.check(!Strings.isEmpty(entityProto.getId()));
      } else if (Strings.isEmpty(entityProto.getId())) {
        m_idFuture = m_idGenerator.getANewId();
        registerFutures(m_idFuture);
      }
    }

    @Override
    public State handleState() {
      if (m_idFuture != null) {
        m_newId = m_idFuture.get();
      }
      return State.INSERT;
    }
  }

  private class InsertHandler implements StateHandler<State> {
    private IFuture<R, ErrorException> m_insertFuture;

    @Override
    public void registerCalls() {
      // TODO : move this logic to helper.
      R entityToInsert = m_entity;
      if (m_newId != null) {
        EntityProtoPb entityProto = m_entityWrapper.getEntityProto(m_entity);
        EntityProtoPb.Builder entityUpdater = EntityProtoPb.newBuilder(entityProto);
        entityUpdater.setId(m_newId);
        entityToInsert = m_entityWrapper.setEntityProto(m_entity, entityUpdater.build());
      }
      if (m_retryable) {
        m_insertFuture = m_entityStoreManager.insertEntity(m_requestId, entityToInsert);
      } else {
        m_insertFuture = m_entityStoreManager.insertEntity(entityToInsert);
      }
      registerFutures(m_insertFuture);
    }

    @Override
    public State handleState() {
      try {
        R insertedEntity = m_insertFuture.get();
        getAsyncCallback().set(0, insertedEntity);
        return State.DONE;
      } catch (ErrorException le) {
        if (m_retryable && le.getErrorProto().getErrorProto()
                .getErrorCategory() == ErrorCategoryUiEnum.CONCURRENT_CALL_ERROR) {
          m_insertException = le;
          return State.GET_AND_CHECK_INSERTED;
        }
        getAsyncCallback().handleException(0, le);
        return State.DONE;
      }
    }
  }

  private class GetAndCheckInsertedHandler implements StateHandler<State> {
    private IFuture<R, ErrorException> m_lookupFuture;

    @Override
    public void registerCalls() {
      EntityProtoPb entityProto = m_entityWrapper.getEntityProto(m_entity);
      m_lookupFuture = m_entityStoreManager.lookupEntity(entityProto.getId());
      registerFutures(m_lookupFuture);
    }

    @Override
    public State handleState() {
      try {
        R lookedEntity = m_lookupFuture.get();
        EntityProtoPb entityProto = m_entityWrapper.getEntityProto(lookedEntity);
        Preconditions.check(m_requestIdHelper.hasRequestId(m_requestId, 1, entityProto),
                entityProto, m_requestId);
        getAsyncCallback().set(0, lookedEntity);
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, m_insertException);
      }
      return State.DONE;
    }
  }
}
