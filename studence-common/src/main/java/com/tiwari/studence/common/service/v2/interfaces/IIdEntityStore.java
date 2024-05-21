package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.proto.id.IdProtoPb;

public interface IIdEntityStore extends IEntityStore<IdProtoPb> {
  public String getIdRowDbId();
}