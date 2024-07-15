package com.tiwari.studence.common.listener;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.executor.StudenceThreadExecuter;

import javax.inject.Inject;
import java.util.Arrays;

public abstract class ATableUpdateListener<P extends GeneratedMessageV3> {
  private IUpdateListener<P>[] m_updatelist;

  @Inject
  public ATableUpdateListener(IUpdateListener... updateListeners) {
    m_updatelist = updateListeners;
  }

  public void listen(P pb) {
    StudenceThreadExecuter.execute(StudenceThreadExecuter.ThreadExecutionMode.BACKGROUND,
            new Runnable() {
              @Override
              public void run() {
                Arrays.stream(m_updatelist).forEach(iUpdateListener -> {
                  iUpdateListener.listen(pb);
                });
              }
            });
  }
}
