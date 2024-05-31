package com.tiwari.studence.common.voidPb.provider;

import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.voidPb.VoidSearchReqPb;
import com.tiwari.studence.proto.voidPb.VoidSearchRespPb;

public class VoidSearchPbProvider implements
        IReqRespPbBuilderProvider<VoidSearchReqPb, VoidSearchReqPb.Builder, VoidSearchRespPb, VoidSearchRespPb.Builder> {
  @Override
  public VoidSearchReqPb.Builder getReqBuilder() {
    return VoidSearchReqPb.newBuilder();
  }

  @Override
  public VoidSearchReqPb.Builder getReqBuilder(VoidSearchReqPb builder) {
    return VoidSearchReqPb.newBuilder(builder);
  }

  @Override
  public VoidSearchRespPb.Builder getRespBuilder() {
    return VoidSearchRespPb.newBuilder();
  }

  @Override
  public VoidSearchRespPb.Builder getRespBuilder(VoidSearchRespPb builder) {
    return VoidSearchRespPb.newBuilder(builder);
  }
}
