package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.common.controlflow.GetItemFroomDynamoTable;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;

public class GetItemFroomDynamoTableModule extends AbstractModule{
  @Override
  protected void configure() {
    bind(IDynamoGetEntityTable.class).to(GetItemFroomDynamoTable.class);
  }

}
