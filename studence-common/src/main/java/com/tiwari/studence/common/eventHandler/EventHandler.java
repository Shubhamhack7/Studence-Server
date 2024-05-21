package com.tiwari.studence.common.eventHandler;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.SyncFuture;

import javax.inject.Singleton;

@Singleton
public class EventHandler {
  public IFuture handleEvent() {
    return new SyncFuture();
  }
}
