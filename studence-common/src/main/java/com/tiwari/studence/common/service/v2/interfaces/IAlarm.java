package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.eventHandler.EventHandler;
import com.tiwari.studence.util.exception.VoidException;

public interface IAlarm {
  public void setRepeatedAlarm(int timeInSec, EventHandler eventHandler);

  public IFuture<Void, VoidException> setAlarm(long delayInMiliSeconds);

}
