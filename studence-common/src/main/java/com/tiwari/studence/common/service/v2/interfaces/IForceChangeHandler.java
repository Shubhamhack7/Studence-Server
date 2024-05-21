package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IFuture;

public interface IForceChangeHandler<UiPb> extends IChangeHandler<UiPb> {

  public IFuture handleChange(UiPb wrapper, boolean isForceful);
}
