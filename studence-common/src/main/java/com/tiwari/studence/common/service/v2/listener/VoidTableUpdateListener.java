package com.tiwari.studence.common.service.v2.listener;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.SyncFuture;
import com.tiwari.studence.common.service.v2.interfaces.ITableUpdateListener;
import com.tiwari.studence.util.exception.VoidException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Set;

@Singleton
public class VoidTableUpdateListener<Pb extends GeneratedMessageV3> implements
        ITableUpdateListener<Pb> {
  @Inject
  private VoidTableUpdateListener() {
  }

  @Override
  public IFuture<Void, VoidException> onItemChange(Pb created) {
    return new SyncFuture<Void, VoidException>();
  }

  @Override
  public IFuture<Void, VoidException> onItemChange(Pb data, Set<String> handlerIds) {
    // TODO Auto-generated method stub
    return new SyncFuture<Void, VoidException>();
  }
}