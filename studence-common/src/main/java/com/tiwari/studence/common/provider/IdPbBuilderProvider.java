package com.tiwari.studence.common.provider;

import com.google.inject.Singleton;
import com.tiwari.studence.common.service.v2.interfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.id.IdProtoPb;

@Singleton
public class IdPbBuilderProvider implements IPbBuilderProvider<IdProtoPb.Builder> {
  @Override
  public IdProtoPb.Builder getPbBuilder() {
    return IdProtoPb.newBuilder();
  }
}
