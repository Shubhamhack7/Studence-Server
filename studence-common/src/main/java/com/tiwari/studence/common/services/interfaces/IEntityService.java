package com.tiwari.studence.common.services.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.exception.ErrorException;

public interface IEntityService<T extends GeneratedMessageV3, Req extends GeneratedMessageV3, Resp extends GeneratedMessageV3> {
  public IFuture<T, ErrorException> get(String entity);
  
  public IFuture<T, ErrorException> get(EntityPb entity);

  public IFuture<T, ErrorException> create(T entity);

  public IFuture<T, ErrorException> delete(String entity);

  public IFuture<T, ErrorException> update(String id,T entity);

  public IFuture<Resp, ErrorException> search(Req entity);
}
