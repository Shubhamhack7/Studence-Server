package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.common.service.v1.controlflow.SearchItemDynamoTable;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;

public class SearchItemDynamoTableModule  extends AbstractModule {
  @Override
  protected void configure() {
    bind(IDynamoSearchTable.class).to(SearchItemDynamoTable.class);
  }

}