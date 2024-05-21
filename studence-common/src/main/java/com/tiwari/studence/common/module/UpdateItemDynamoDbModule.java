package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.common.service.v1.controlflow.UpdateItemInDynamoTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;

public class UpdateItemDynamoDbModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IDynamoUpdateTable.class).to(UpdateItemInDynamoTable.class);
  }
}
