package com.tiwari.studence.guardian.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.guardian.GuardianSearchReqPb;
import com.tiwari.studence.proto.guardian.GuardianSearchRespPb;

import javax.inject.Singleton;

@Singleton
public class GuardianSearchPbProvider implements
        IReqRespPbBuilderProvider<GuardianSearchReqPb, GuardianSearchReqPb.Builder, GuardianSearchRespPb, GuardianSearchRespPb.Builder> {
  @Override
  public GuardianSearchReqPb.Builder getReqBuilder() {
    return GuardianSearchReqPb.newBuilder();
  }

  @Override
  public GuardianSearchReqPb.Builder getReqBuilder(GuardianSearchReqPb builder) {
    return GuardianSearchReqPb.newBuilder(builder);
  }

  @Override
  public GuardianSearchRespPb.Builder getRespBuilder() {
    return GuardianSearchRespPb.newBuilder();
  }

  @Override
  public GuardianSearchRespPb.Builder getRespBuilder(GuardianSearchRespPb builder) {
    return GuardianSearchRespPb.newBuilder(builder);
  }
}
