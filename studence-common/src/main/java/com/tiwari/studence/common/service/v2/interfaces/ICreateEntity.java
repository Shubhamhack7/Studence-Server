package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.ErrorException;

public interface ICreateEntity<Req> {
  public IFuture<Req, ErrorException> createEntity(Req request);

}
