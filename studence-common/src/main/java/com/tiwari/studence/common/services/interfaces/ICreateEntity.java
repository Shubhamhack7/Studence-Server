package com.tiwari.studence.common.services.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.ErrorException;

public interface ICreateEntity<T extends GeneratedMessageV3> {
  public IFuture<T, ErrorException> createEntity(T entity);
}
