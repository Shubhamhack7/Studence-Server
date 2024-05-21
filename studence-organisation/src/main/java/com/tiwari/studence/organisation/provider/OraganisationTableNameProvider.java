package com.tiwari.studence.organisation.provider;

import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class OraganisationTableNameProvider implements ITableNameProvider{

  @Override
  public String getTableName() {
    return TableNameEnum.ORGANISATION.getValue();
  }

}
