package com.tiwari.studence.common.service.v2.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.util.exception.ErrorException;

public interface IUpdateHandler<U extends GeneratedMessageV3, F extends GeneratedMessageV3> {

  public void update(F updateInfo) throws ErrorException;

  public boolean hasUpdates();

  public U getUpdated();
}
