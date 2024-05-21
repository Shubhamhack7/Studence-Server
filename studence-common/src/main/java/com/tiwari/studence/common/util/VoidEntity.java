package com.tiwari.studence.common.util;

import com.tiwari.studence.common.service.v2.interfaces.ISecondaryIndexEntity;

import javax.inject.Singleton;

@Singleton
public class VoidEntity implements ISecondaryIndexEntity {

  @Override
  public String getEntityFullName() {
    return "";
  }

  @Override
  public String getRangeKeyName() {
    return "";
  }

  @Override
  public String getItemIdName() {
    return "";
  }

}
