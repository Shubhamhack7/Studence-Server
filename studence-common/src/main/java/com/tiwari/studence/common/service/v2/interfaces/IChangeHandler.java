package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IFuture;

public interface IChangeHandler<UiPb> {
  public IFuture handleChange(UiPb wrapper);
}
