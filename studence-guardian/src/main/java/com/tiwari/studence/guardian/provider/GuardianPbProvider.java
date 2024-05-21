package com.tiwari.studence.guardian.provider;

import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.guardian.GuardianPb;

import javax.inject.Singleton;

@Singleton
public class GuardianPbProvider implements IPbBuilderProvider<GuardianPb, GuardianPb.Builder> {
  @Override
  public GuardianPb.Builder getBuilder() {
    return GuardianPb.newBuilder();
  }

  @Override
  public GuardianPb.Builder getBuilder(GuardianPb builder) {
    return GuardianPb.newBuilder(builder);
  }

}
