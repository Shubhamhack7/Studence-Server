package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.tiwari.studence.common.provider.PaginationTokenUiPbBuilderProvider;
import com.tiwari.studence.common.service.v2.interfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.search.PaginationTokenUiPb;

@Singleton
public class PaginationTokenUiPbModule extends AbstractModule {

  @Override
  protected void configure() {
    TypeLiteral<IPbBuilderProvider<PaginationTokenUiPb.Builder>> pbBuilderLiteral = new TypeLiteral<IPbBuilderProvider<PaginationTokenUiPb.Builder>>() {
    };
    bind(pbBuilderLiteral).to(PaginationTokenUiPbBuilderProvider.class);
  }

}
