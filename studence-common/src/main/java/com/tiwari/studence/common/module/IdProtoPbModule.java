package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.tiwari.studence.common.provider.IdPbBuilderProvider;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.interfaces.IPbBuilderProvider;
import com.tiwari.studence.common.util.IdEntityProtoWrapper;
import com.tiwari.studence.proto.id.IdProtoPb;

@Singleton
public class IdProtoPbModule extends AbstractModule {
  @Override
  protected void configure() {
    TypeLiteral<IPbBuilderProvider<IdProtoPb.Builder>> pbBuilderLiteral = new TypeLiteral<IPbBuilderProvider<IdProtoPb.Builder>>() {
    };
    bind(pbBuilderLiteral).to(IdPbBuilderProvider.class).in(Singleton.class);
    TypeLiteral<IEntityProtoWrapper<IdProtoPb>> pbProtoWrapperLiteral = new TypeLiteral<IEntityProtoWrapper<IdProtoPb>>() {
    };
    bind(pbProtoWrapperLiteral).to(IdEntityProtoWrapper.class).in(Singleton.class);
    //expose(pbProtoWrapperLiteral);
  }
}