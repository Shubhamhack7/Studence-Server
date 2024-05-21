package com.tiwari.studence.common.voidPb.provider;

import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.voidPb.VoidPb;

public class VoidPbProvider implements IPbBuilderProvider<VoidPb,VoidPb.Builder> {
  @Override
  public VoidPb.Builder getBuilder() {
    return VoidPb.newBuilder();
  }

  @Override
  public VoidPb.Builder getBuilder(VoidPb builder) {
    return VoidPb.newBuilder(builder);
  }
}
