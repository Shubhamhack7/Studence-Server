package com.tiwari.studence.common.service.v1.entity;

import com.google.protobuf.GeneratedMessageV3;

public interface IEntityCreate<P extends GeneratedMessageV3> {
  public P create(P builder);
}
