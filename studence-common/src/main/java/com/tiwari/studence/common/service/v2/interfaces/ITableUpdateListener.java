package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.VoidException;

import java.util.Set;

public interface ITableUpdateListener<Pb> {
  public IFuture<Void, VoidException> onItemChange(Pb created);
  public IFuture<Void,VoidException> onItemChange(Pb data, Set<String> handlerIds);
}
