package com.tiwari.studence.common.service.v2.requestBuilder;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.partitioner.RawDataPartitioner;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.encoder.IBiConverter;

import java.util.Map;

public abstract class AUpdateItemRequestBuilder<R> {
  private final RawDataPartitioner<?, ?> m_rawDataPartitioner;

  protected AUpdateItemRequestBuilder(RawDataPartitioner<?, ?> rawDataPartitioner) {
    m_rawDataPartitioner = rawDataPartitioner;
  }

  public R createUpdateItemRequest(String tableName, GeneratedMessageV3 message, int version,
          String id) {
    Map<String, String> emptyMap = Maps.newHashMap();
    return createUpdateItemRequest(tableName, message, version, id, emptyMap);
  }

  public R createUpdateItemRequest(String tableName, GeneratedMessageV3 message, int version,
          String id, Map<String, String> globalIndexes) {
    IBiConverter<Integer, String> encoder = EntityIndexAttributes.VERSION.getStringEncoder();
    String versionValue = encoder.convert(version - 1);
    return createUpdateItemRequest(tableName, versionValue, encoder.convert(version), id,
            m_rawDataPartitioner.getRawDataPartitions(message), globalIndexes);
  }

  protected abstract R createUpdateItemRequest(String tableName, String expectedVersion,
          String version, String id, Map<String, String> rawData,
          Map<String, String> globalIndexes);
}
