package com.tiwari.studence.dynamodb.database.module;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.tiwari.studence.dynamodb.database.table.CreateDynamoDbTable;
import com.tiwari.studence.dynamodb.database.table.ICreateTable;

@Singleton
public class CreateDynamoDbTableModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ICreateTable.class).to(CreateDynamoDbTable.class);
  }

}
