package com.tiwari.studence.attendence.provider;

import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class AttendenceTableNameProvider implements ITableNameProvider{

  @Override
  public String getTableName() {
    return TableNameEnum.ORGANISATION.getValue();
  }

}
