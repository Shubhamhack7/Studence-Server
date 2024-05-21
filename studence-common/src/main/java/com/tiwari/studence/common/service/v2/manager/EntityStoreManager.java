package com.tiwari.studence.common.service.v2.manager;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.SyncFuture;
import com.tiwari.studence.common.service.v2.helper.RequestIdHelper;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.interfaces.IPbTableStore;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Set;

@Singleton
public class EntityStoreManager<Pb extends GeneratedMessageV3, Store extends IPbTableStore<Pb>> {
  private final IEntityProtoWrapper<Pb> m_entityWrapper;
  private final RequestIdHelper m_requestIdHelper;
  private final Store m_dbInternalStore;
  protected final VersionManager<Pb> m_versionManager;

  @Inject
  public EntityStoreManager(IEntityProtoWrapper<Pb> entityWrapper, Store dbManager,
          VersionManager<Pb> versionManager) {
    m_entityWrapper = entityWrapper;
    m_requestIdHelper = null;
    m_dbInternalStore = dbManager;
    m_versionManager = versionManager;
  }

  public final IFuture<Pb, ErrorException> lookupEntity(String id) {
    return m_dbInternalStore.getItem(id);
  }

  public final IFuture<Pb, ErrorException> insertEntity(Pb entity) {
    entity = m_versionManager.initializeVersion(entity);
    return m_dbInternalStore.createItem(m_entityWrapper.getEntityProto(entity).getId(), entity);
  }

  public final IFuture<Pb, ErrorException> insertEntity(String requestId, Pb entity) {
    return new SyncFuture<Pb, ErrorException>(
            new ErrorException(ErrorTypePbEnum.VALIDATION_FAILED));
    // EntityProtoPb entityProto = m_entityWrapper.getEntityProto(entity);
    // Preconditions.check(entityProto.getRequestIdsCount() == 0,
    // "RequestId should be checked earlier");
    // Preconditions.check(entityProto.getVersion() == 0);
    // entityProto = m_requestIdHelper.addRequestId(requestId, entityProto);
    // entity = m_entityWrapper.setEntityProto(entity, entityProto);
    // return insertEntity(entity);
  }

  public final IFuture<Pb, ErrorException> updateEntity(Pb entity) {
    entity = m_versionManager.incrementVersion(entity);
    return m_dbInternalStore.updateItem(m_entityWrapper.getEntityProto(entity).getId(), entity,
            m_entityWrapper.getEntityProto(entity).getVersion());
  }

  public final IFuture<Pb, ErrorException> updateEntity(String requestId, Pb entity) {
    return new SyncFuture<Pb, ErrorException>(
            new ErrorException(ErrorTypePbEnum.VALIDATION_FAILED));
    // EntityProtoPb entityProto = m_entityWrapper.getEntityProto(entity);
    // Preconditions.check(!m_requestIdHelper.hasRequestId(requestId,
    // entityProto),
    // "RequestId should be checked earlier");
    // entityProto = m_requestIdHelper.addRequestId(requestId, entityProto);
    // entity = m_entityWrapper.setEntityProto(entity, entityProto);
    // return updateEntity(entity);
  }

  public final IFuture<Pb, ErrorException> deleteEntity(Pb entity) {
    entity = m_versionManager.incrementVersionAndSetDeleted(entity);
    return m_dbInternalStore.updateItem(m_entityWrapper.getEntityProto(entity).getId(), entity,
            m_entityWrapper.getEntityProto(entity).getVersion());
  }

  public final IFuture<Pb, ErrorException> deleteEntity(String requestId, Pb entity) {
    return new SyncFuture<Pb, ErrorException>(
            new ErrorException(ErrorTypePbEnum.VALIDATION_FAILED));
    // EntityProtoPb entityProto = m_entityWrapper.getEntityProto(entity);
    // Preconditions.check(!m_requestIdHelper.hasRequestId(requestId,
    // entityProto),
    // "RequestId should be checked earlier");
    // entityProto = m_requestIdHelper.addRequestId(requestId, entityProto);
    // entity = m_entityWrapper.setEntityProto(entity, entityProto);
    // return deleteEntity(entity);
  }

  public IFuture<Pair<Set<String>, Map<String, Pb>>, ErrorException> batchGetItem(
          Set<String> idList) {
    return m_dbInternalStore.batchGetItem(idList);
  }

}
