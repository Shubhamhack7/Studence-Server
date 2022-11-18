package com.tiwari.studence.organisation.provider;

import com.tiwari.studence.common.services.interfaces.ITableNameProvider;

public class OraganisationTableNameProvider implements ITableNameProvider{

  @Override
  public String getTableName() {
    return "100_ORGANISATION";
  }

}
