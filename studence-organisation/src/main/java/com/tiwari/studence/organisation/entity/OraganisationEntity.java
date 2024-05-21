package com.tiwari.studence.organisation.entity;

import com.tiwari.studence.common.service.v2.interfaces.IEntity;
import com.tiwari.studence.organisation.provider.OraganisationTableNameProvider;

public class OraganisationEntity extends OraganisationTableNameProvider implements IEntity {
  @Override
  public String getEntityFullName() {
    return getTableName();
  }
}
