package com.tiwari.studence.common.service.v2.table;

import com.tiwari.studence.util.collect.Lists;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EmptyTablePartitioner extends ATablePartitioner {

  @Override
  public String getPartitionKey(String id) {
    return "";
  }

  @Override
  public String getPartitionKeyWithArg(String arg) {
    return "";
  }

  @Override
  public List<String> getAllTablePartitions() {
    return Lists.newArrayList("");
  }

}
