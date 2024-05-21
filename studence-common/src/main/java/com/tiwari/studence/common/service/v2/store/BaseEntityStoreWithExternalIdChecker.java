package com.tiwari.studence.common.service.v2.store;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.entity.controlflow.InsertEntityControlFlowWithExternalIdCheck;
import com.tiwari.studence.common.service.v2.entity.controlflow.UpdateEntityWithExternalIdCheck;
import com.tiwari.studence.common.service.v2.helper.RequestIdHelper;
import com.tiwari.studence.common.service.v2.idGenerator.IdGenerator;
import com.tiwari.studence.common.service.v2.interfaces.*;
import com.tiwari.studence.common.service.v2.listener.TableUpdateListenerNotifier;
import com.tiwari.studence.common.service.v2.manager.EntityStoreManager;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.Map;
import java.util.Set;

public abstract class BaseEntityStoreWithExternalIdChecker<Pb extends GeneratedMessageV3, Store extends IPbTableStore<Pb>, IdStore extends IIdEntityStore, Ul extends ITableUpdateListener<Pb>>
        implements IEntityStore<Pb> {
  private final EntityStoreManager<Pb, Store> m_entityStoreManager;
  protected final IdGenerator<IdStore> m_idGenerator;
  protected final IEntityProtoWrapper<Pb> m_entityWrapper;
  private final RequestIdHelper m_requestIdHelper;
  // private final ExternalIdChecker m_externalIdChecker;
  private final UpdateEntityWithExternalIdCheck<?, Pb> m_updateEntityWithExternalIdCheck;
  private final Ul m_tableUpdateListener;
  private final TableUpdateListenerNotifier m_notifier;

  public BaseEntityStoreWithExternalIdChecker(EntityStoreManager<Pb, Store> entityStoreManager,
          IdGenerator<IdStore> idGenerator, IEntityProtoWrapper<Pb> entityWrapper,
          UpdateEntityWithExternalIdCheck<?, Pb> updateEntityWithExternalIdCheck,
          Ul tableUpdateListener, TableUpdateListenerNotifier notifier) {
    this(entityStoreManager, idGenerator, entityWrapper, null, updateEntityWithExternalIdCheck,
            tableUpdateListener, notifier);
  }

  public BaseEntityStoreWithExternalIdChecker(EntityStoreManager<Pb, Store> entityStoreManager,
          IdGenerator<IdStore> idGenerator, IEntityProtoWrapper<Pb> entityWrapper,
          RequestIdHelper requestIdHelper,
          UpdateEntityWithExternalIdCheck<?, Pb> updateEntityWithExternalIdCheck,
          Ul tableUpdateListener, TableUpdateListenerNotifier notifier) {
    m_entityStoreManager = entityStoreManager;
    m_idGenerator = idGenerator;
    // m_externalIdChecker = externalIdChecker;
    m_updateEntityWithExternalIdCheck = updateEntityWithExternalIdCheck;
    m_entityWrapper = (IEntityProtoWrapper<Pb>) entityWrapper;
    m_requestIdHelper = requestIdHelper;
    m_tableUpdateListener = tableUpdateListener;
    m_notifier = notifier;
  }

  @Override
  public IFuture<Pb, ErrorException> lookupEntity(String id) {
    return m_entityStoreManager.lookupEntity(id);
  }

  @Override
  public IFuture<Pair<Set<String>, Map<String, Pb>>, ErrorException> batchGetItem(
          Set<String> idList) {
    return m_entityStoreManager.batchGetItem(idList);
  }

  @Override
  public IFuture<Pb, ErrorException> insertEntity(Pb entity) {
    InsertEntityControlFlowWithExternalIdCheck<Pb> insertCf = new InsertEntityControlFlowWithExternalIdCheck<Pb>(
            m_entityStoreManager, null, entity, m_idGenerator, m_entityWrapper, false,
            m_requestIdHelper);
    insertCf.startAsyncCall();
    IFuture<Pb, ErrorException> createFuture = insertCf.getFutureResult();
    m_notifier.notifyCreate(m_tableUpdateListener, createFuture);
    return createFuture;
  }

  @Override
  public IFuture<Pb, ErrorException> updateEntity(Pb entity) {
    if (m_updateEntityWithExternalIdCheck != null) {
      return m_updateEntityWithExternalIdCheck.updateEntity(entity);
    }
    IFuture<Pb, ErrorException> updateFuture = m_entityStoreManager.updateEntity(entity);
    m_notifier.notifyUpdate(m_tableUpdateListener, updateFuture);
    return updateFuture;
  }

  @Override
  public IFuture<Pb, ErrorException> deleteEntity(Pb entity) {
    IFuture<Pb, ErrorException> deleteFuture = m_entityStoreManager.deleteEntity(entity);
    m_notifier.notifyDelete(m_tableUpdateListener, deleteFuture);
    return deleteFuture;
  }

  @Override
  public IFuture<Pb, ErrorException> deleteEntity(String requestId, Pb entity) {
    IFuture<Pb, ErrorException> deleteFuture = m_entityStoreManager.deleteEntity(requestId, entity);
    m_notifier.notifyDelete(m_tableUpdateListener, deleteFuture);
    return deleteFuture;
  }

  @Override
  public IFuture<Pb, ErrorException> insertEntity(String requestId, Pb entity) {
    InsertEntityControlFlowWithExternalIdCheck<Pb> insertCf = new InsertEntityControlFlowWithExternalIdCheck<Pb>(
            m_entityStoreManager, requestId, entity, m_idGenerator, m_entityWrapper, true,
            m_requestIdHelper);
    insertCf.startAsyncCall();
    IFuture<Pb, ErrorException> createFuture = insertCf.getFutureResult();
    m_notifier.notifyCreate(m_tableUpdateListener, createFuture);
    return createFuture;
  }

  @Override
  public IFuture<Pb, ErrorException> updateEntity(String requestId, Pb entity) {
    if (m_updateEntityWithExternalIdCheck != null) {
      return m_updateEntityWithExternalIdCheck.updateEntity(requestId, entity);
    }
    IFuture<Pb, ErrorException> updateFuture = m_entityStoreManager.updateEntity(entity);
    m_notifier.notifyUpdate(m_tableUpdateListener, updateFuture);
    return updateFuture;
  }
}
