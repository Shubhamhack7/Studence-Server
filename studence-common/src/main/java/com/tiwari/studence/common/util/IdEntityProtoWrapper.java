package com.tiwari.studence.common.util;

import com.google.inject.Singleton;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.proto.entity.EntityProtoPb;
import com.tiwari.studence.proto.id.IdProtoPb;

@Singleton
public class IdEntityProtoWrapper implements IEntityProtoWrapper<IdProtoPb> {
  @Override
  public EntityProtoPb getEntityProto(IdProtoPb entity) {
    return entity.getEntityProto();
  }

  @Override
  public IdProtoPb setEntityProto(IdProtoPb entity, EntityProtoPb entityProto) {
    return IdProtoPb.newBuilder(entity).setEntityProto(entityProto).build();
  }
}
