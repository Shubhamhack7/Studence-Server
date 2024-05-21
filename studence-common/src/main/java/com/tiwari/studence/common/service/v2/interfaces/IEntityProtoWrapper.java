package com.tiwari.studence.common.service.v2.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.proto.entity.EntityProtoPb;

public interface IEntityProtoWrapper<R extends GeneratedMessageV3> {
  public EntityProtoPb getEntityProto(R entity);

  public R setEntityProto(R entity, EntityProtoPb entityProto);
}

