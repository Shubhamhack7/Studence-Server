package com.tiwari.studence.classes.provider;

import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class ClassesTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.CLASS.getValue();
  }
}
