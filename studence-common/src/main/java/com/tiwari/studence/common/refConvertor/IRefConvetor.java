package com.tiwari.studence.common.refConvertor;

import com.google.protobuf.GeneratedMessageV3;

public interface IRefConvetor<RP extends GeneratedMessageV3, P extends GeneratedMessageV3> {
  public RP refUpdater(P pb);
}
