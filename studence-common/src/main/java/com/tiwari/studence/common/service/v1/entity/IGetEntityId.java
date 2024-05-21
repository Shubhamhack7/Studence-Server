package com.tiwari.studence.common.service.v1.entity;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

public interface IGetEntityId {
 public IFuture<Pair<Integer, String>,ErrorException> getNewEntityId();
}
