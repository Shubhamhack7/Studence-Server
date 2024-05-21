package com.tiwari.studence.login.provider;

import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class LoginTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.LOGIN.getValue();
  }
}
