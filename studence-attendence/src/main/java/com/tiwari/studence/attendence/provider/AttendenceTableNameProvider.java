package com.tiwari.studence.attendence.provider;

import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class AttendenceTableNameProvider implements ITableNameProvider{

  @Override
  public String getTableName() {
    return TableNameEnum.ORGANISATION.getValue();
  }

}
