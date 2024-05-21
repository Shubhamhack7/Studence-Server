package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.common.service.v1.entity.GetAndUpdateEntity;
import com.tiwari.studence.common.service.v1.entity.IGetEntityId;

public class GetAndUpdateEntityIdModule extends AbstractModule{
  @Override
  protected void configure() {
    bind(IGetEntityId.class).to(GetAndUpdateEntity.class);
  }

}
