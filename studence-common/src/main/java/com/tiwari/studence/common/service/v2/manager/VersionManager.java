package com.tiwari.studence.common.service.v2.manager;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.proto.entity.EntityProtoPb;
import com.tiwari.studence.proto.entity.LifeTimeEnum;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class VersionManager<R extends GeneratedMessageV3> {
  private final IEntityProtoWrapper<R> m_entityWrapper;

  @Inject
  public VersionManager(IEntityProtoWrapper<R> entityWrapper) {
    m_entityWrapper = entityWrapper;
  }

  public R initializeVersion(R entity) {
    EntityProtoPb.Builder entityUpdater = EntityProtoPb.newBuilder(m_entityWrapper
            .getEntityProto(entity));
    entityUpdater.setVersion(1);
    return m_entityWrapper.setEntityProto(entity, entityUpdater.build());
  }

  public R incrementVersion(R entity) {
    EntityProtoPb.Builder entityUpdater = EntityProtoPb.newBuilder(m_entityWrapper
            .getEntityProto(entity));
    entityUpdater.setVersion(entityUpdater.getVersion() + 1);
    return m_entityWrapper.setEntityProto(entity, entityUpdater.build());
  }

  public R incrementVersionAndSetDeleted(R entity) {
    EntityProtoPb.Builder entityUpdater = EntityProtoPb.newBuilder(m_entityWrapper
            .getEntityProto(entity));
    entityUpdater.setVersion(entityUpdater.getVersion() + 1);
    entityUpdater.setLifetimeState(LifeTimeEnum.DELETED);
    return m_entityWrapper.setEntityProto(entity, entityUpdater.build());
  }
}
