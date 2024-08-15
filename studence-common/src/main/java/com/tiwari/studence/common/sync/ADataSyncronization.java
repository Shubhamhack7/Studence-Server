package com.tiwari.studence.common.sync;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.entity.EntityUtilHelper;

import javax.inject.Inject;

public class ADataSyncronization<P extends GeneratedMessageV3, S extends IEntityService> {
  S m_service;

  @Inject
  public ADataSyncronization(S service) {
    m_service = service;
  }

  public void sync(String req) {
    ADataSyncronizationCF<P, S> cf = new ADataSyncronizationCF(req, m_service);
    cf.addLogObjects(req);
    cf.startAsyncCall();
    cf.getFutureResult();
  }

  public void sync(EntityPb req) {
    ADataSyncronizationCF<P, S> cf = new ADataSyncronizationCF(
            EntityUtilHelper.getDbInfoIdWithSpecialCharecterUsingEntityPb(req), m_service);
    cf.addLogObjects(req);
    cf.startAsyncCall();
    cf.getFutureResult();
  }

}
