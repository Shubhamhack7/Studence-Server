package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.service.v2.table.ATablePartitioner;

public interface ITables<TP extends ATablePartitioner> {

  public int getTableMaxAttributesSize();

  public String getDbTableName(String id);

  public String getDbTableNameWithTablePartitionKey(String tablePartitionKey);
}