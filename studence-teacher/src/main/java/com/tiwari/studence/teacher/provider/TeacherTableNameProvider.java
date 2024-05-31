package com.tiwari.studence.teacher.provider;

import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class TeacherTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.TEACHER.getValue();
  }
}
