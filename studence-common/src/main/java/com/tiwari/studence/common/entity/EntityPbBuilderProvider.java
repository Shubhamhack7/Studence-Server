package com.tiwari.studence.common.entity;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.prtovider.IPbBuilderProvider;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.entity.EntityPb.Builder;

@Singleton
public class EntityPbBuilderProvider implements IPbBuilderProvider<EntityPb, EntityPb.Builder> {
  
  @Inject
  public EntityPbBuilderProvider() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Builder getBuilder() {
    return EntityPb.newBuilder();
  }

  @Override
  public Builder getBuilder(EntityPb builder) {
    return EntityPb.newBuilder(builder);
  }

}
