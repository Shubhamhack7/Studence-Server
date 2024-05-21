package com.tiwari.studence.typeAhed.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchReqPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchRespPb;

public class TypeAheadSearchReqRespProvider implements
        IReqRespPbBuilderProvider<TypeAheadSearchReqPb, TypeAheadSearchReqPb.Builder, TypeAheadSearchRespPb, TypeAheadSearchRespPb.Builder> {
  @Override
  public TypeAheadSearchReqPb.Builder getReqBuilder() {
    return TypeAheadSearchReqPb.newBuilder();
  }

  @Override
  public TypeAheadSearchReqPb.Builder getReqBuilder(TypeAheadSearchReqPb builder) {
    return TypeAheadSearchReqPb.newBuilder(builder);
  }

  @Override
  public TypeAheadSearchRespPb.Builder getRespBuilder() {
    return TypeAheadSearchRespPb.newBuilder();
  }

  @Override
  public TypeAheadSearchRespPb.Builder getRespBuilder(TypeAheadSearchRespPb builder) {
    return TypeAheadSearchRespPb.newBuilder(builder);
  }
}
