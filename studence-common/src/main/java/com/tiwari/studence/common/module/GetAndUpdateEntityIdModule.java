package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.common.controlflow.PutItemDynamoTable;
import com.tiwari.studence.common.entity.GetAndUpdateEntity;
import com.tiwari.studence.common.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;

public class GetAndUpdateEntityIdModule extends AbstractModule{
  @Override
  protected void configure() {
    bind(IGetEntityId.class).to(GetAndUpdateEntity.class);
  }

}
