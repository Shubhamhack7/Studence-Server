package com.tiwari.studence.guardian.provider;

import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class GuardianTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.GUARDIAN.getValue();
  }
}
