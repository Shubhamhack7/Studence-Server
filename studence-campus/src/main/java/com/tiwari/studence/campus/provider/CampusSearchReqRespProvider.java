package com.tiwari.studence.campus.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.campus.CampusSearchReqPb;
import com.tiwari.studence.proto.campus.CampusSearchRespPb;

import javax.inject.Singleton;

@Singleton
public class CampusSearchReqRespProvider implements IReqRespPbBuilderProvider<CampusSearchReqPb,CampusSearchReqPb.Builder, CampusSearchRespPb,CampusSearchRespPb.Builder> {
  @Override
  public CampusSearchReqPb.Builder getReqBuilder() {
    return CampusSearchReqPb.newBuilder();
  }

  @Override
  public CampusSearchReqPb.Builder getReqBuilder(CampusSearchReqPb builder) {
    return CampusSearchReqPb.newBuilder(builder);
  }

  @Override
  public CampusSearchRespPb.Builder getRespBuilder() {
    return CampusSearchRespPb.newBuilder();
  }

  @Override
  public CampusSearchRespPb.Builder getRespBuilder(CampusSearchRespPb builder) {
    return CampusSearchRespPb.newBuilder(builder);
  }
}
