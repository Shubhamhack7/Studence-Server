package com.tiwari.studence.common.async;

import com.google.inject.Singleton;

@Singleton
public class TimingControlFlowHookprovider {
  public static TimingControlFlowHook newCFHook() {
    if (RequestScopeHelper.getRequestContext() != null) {
      return new TimingControlFlowHook();
    } else {
      return null;
    }
  }
}
