package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.common.service.v1.controlflow.PutItemDynamoTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;

public class PutItemDynamoTableModule extends AbstractModule{
  @Override
  protected void configure() {
    bind(IDynamoPutTable.class).to(PutItemDynamoTable.class);
  }

}
