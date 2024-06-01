package com.tiwari.studence.campus.provider;

import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class CampusTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.CAMPUS.getValue();
  }
}
