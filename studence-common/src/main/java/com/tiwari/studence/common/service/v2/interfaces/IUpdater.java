package com.tiwari.studence.common.service.v2.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.util.exception.ErrorException;

public interface IUpdater<P extends GeneratedMessageV3, U extends GeneratedMessageV3> {
  public P update(P current, U updateInfo) throws ErrorException;

  public P create(U info) throws ErrorException;
}
