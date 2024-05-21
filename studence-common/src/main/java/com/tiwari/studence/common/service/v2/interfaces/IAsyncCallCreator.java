package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IBatchAsyncCall;

public interface IAsyncCallCreator<R, E extends Exception> {
  public IBatchAsyncCall<R, E> createAsyncCall();
}
