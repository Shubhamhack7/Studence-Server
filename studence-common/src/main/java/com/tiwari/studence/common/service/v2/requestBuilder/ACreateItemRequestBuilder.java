package com.tiwari.studence.common.service.v2.requestBuilder;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.partitioner.RawDataPartitioner;
import com.tiwari.studence.util.collect.Maps;

import java.util.Map;

public abstract class ACreateItemRequestBuilder<R> {
  private final RawDataPartitioner<?, ?> m_rawDataPartitioner;

  protected ACreateItemRequestBuilder(RawDataPartitioner<?, ?> rawDataPartitioner) {
    m_rawDataPartitioner = rawDataPartitioner;
  }

  public R createCreateItemRequest(String tableName, GeneratedMessageV3 message, String id) {
    Map<String, String> emptyMap = Maps.newHashMap();
    return createCreateItemRequest(tableName, message, id, emptyMap);
  }

  public R createCreateItemRequest(String tableName, GeneratedMessageV3 message, String id,
          Map<String, String> globalIndexes) {
    return createCreateItemRequest(tableName, id,
            m_rawDataPartitioner.getRawDataPartitions(message), globalIndexes);
  }

  protected abstract R createCreateItemRequest(String tableName, String id,
          Map<String, String> rawData, Map<String, String> globalIndexes);
}
