package com.tiwari.studence.typeAhed.provider;

import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;

import javax.inject.Singleton;

@Singleton
public class TypeAhedProvider implements IPbBuilderProvider<TypeAheadPb, TypeAheadPb.Builder> {

  @Override
  public TypeAheadPb.Builder getBuilder() {
    return TypeAheadPb.newBuilder();
  }

  @Override
  public TypeAheadPb.Builder getBuilder(TypeAheadPb builder) {
    return TypeAheadPb.newBuilder(builder);
  }
}
