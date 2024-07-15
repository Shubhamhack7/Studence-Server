package com.tiwari.studence.common.listener;

import com.google.protobuf.GeneratedMessageV3;

public interface IUpdateListener<P extends GeneratedMessageV3> {
  public void listen(P pb);
}
