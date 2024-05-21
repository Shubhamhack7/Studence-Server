package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.manager.EntityStoreManager;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UpdateEntityWithExternalIdCheck<ESM extends EntityStoreManager<R, ?>, R extends GeneratedMessageV3> {

  private final ESM m_entityStoreManager;
  private final IEntityProtoWrapper<R> m_entityProtoWrapper;

  @Inject
  public UpdateEntityWithExternalIdCheck(ESM entityStoreManager,
          IEntityProtoWrapper<R> entityProtoWrapper) {
    m_entityStoreManager = entityStoreManager;
    m_entityProtoWrapper = entityProtoWrapper;
  }

  public IFuture<R, ErrorException> updateEntity(R entity) {
    UpdateEntityWithExternalIdCheckCF<R> cf = new UpdateEntityWithExternalIdCheckCF<R>(
            m_entityStoreManager, m_entityProtoWrapper, entity);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  public IFuture<R, ErrorException> updateEntity(String requestId, R entity) {
    UpdateEntityWithExternalIdCheckCF<R> cf = new UpdateEntityWithExternalIdCheckCF<R>(
            m_entityStoreManager, m_entityProtoWrapper, entity, requestId);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
