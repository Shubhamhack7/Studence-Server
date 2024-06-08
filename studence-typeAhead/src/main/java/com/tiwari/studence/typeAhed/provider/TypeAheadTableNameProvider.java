package com.tiwari.studence.typeAhed.provider;

import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

import javax.inject.Singleton;

@Singleton
public class TypeAheadTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.TYPE_AHEAD.getValue();
  }
}
