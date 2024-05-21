package com.tiwari.studence.guardian.provider;

import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class GuardianTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.GUARDIAN.getValue();
  }
}
