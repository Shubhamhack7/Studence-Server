package com.tiwari.studence.common.provider;

import com.google.inject.Singleton;
import com.tiwari.studence.common.service.v2.interfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.search.PaginationTokenUiPb;

@Singleton
public class PaginationTokenUiPbBuilderProvider implements
        IPbBuilderProvider<PaginationTokenUiPb.Builder> {

  @Override
  public PaginationTokenUiPb.Builder getPbBuilder() {
    return PaginationTokenUiPb.newBuilder();
  }

}
