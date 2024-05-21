package com.tiwari.studence.campus.provider;

import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.campus.CampusPb;

import javax.inject.Singleton;

@Singleton
public class CampusProvider implements IPbBuilderProvider<CampusPb,CampusPb.Builder> {
  @Override
  public CampusPb.Builder getBuilder() {
    return CampusPb.newBuilder();
  }

  @Override
  public CampusPb.Builder getBuilder(CampusPb builder) {
    return CampusPb.newBuilder(builder);
  }
}
