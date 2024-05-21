package com.tiwari.studence.common.service.v2.requestBuilder;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.partitioner.RawDataPartitioner;

import java.util.Map;

public abstract class ACreateRangeItemRequestBuilder<Pb> {
  private final RawDataPartitioner<?, ?> m_rawDataPartitioner;

  protected ACreateRangeItemRequestBuilder(RawDataPartitioner<?, ?> rawDataPartitioner) {
    m_rawDataPartitioner = rawDataPartitioner;
  }

  public Pb createCreateItemRequest(String tableName, GeneratedMessageV3 message, String id,
          String rangeKey, Map<String, String> globalIndexes) {
    return createCreateItemRequest(tableName, id, rangeKey,
            m_rawDataPartitioner.getRawDataPartitionsWithoutEmpty(message), globalIndexes);
  }

  protected abstract Pb createCreateItemRequest(String tableName, String id, String rangeKey,
          Map<String, String> rawData, Map<String, String> globalIndexes);
}
