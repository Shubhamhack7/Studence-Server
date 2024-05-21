package com.tiwari.studence.common.providerInterfaces;

import com.google.protobuf.GeneratedMessageV3;

public interface IPbBuilderProvider<P extends GeneratedMessageV3,PB extends GeneratedMessageV3.Builder> {
  public PB getBuilder();
  public PB getBuilder(P builder);
}
