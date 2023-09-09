package com.tiwari.studence.student.provider;

import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class StudentTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.STUDENT.getValue();
  }
}
