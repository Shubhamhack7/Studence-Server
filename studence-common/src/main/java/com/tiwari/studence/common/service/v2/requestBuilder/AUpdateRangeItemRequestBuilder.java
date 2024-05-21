package com.tiwari.studence.common.service.v2.requestBuilder;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.partitioner.RawDataPartitioner;
import com.tiwari.studence.util.encoder.IBiConverter;

import java.util.Map;

public abstract class AUpdateRangeItemRequestBuilder<R> {
  private final RawDataPartitioner<?, ?> m_rawDataPartitioner;

  protected AUpdateRangeItemRequestBuilder(RawDataPartitioner<?, ?> rawDataPartitioner) {
    m_rawDataPartitioner = rawDataPartitioner;
  }

  public R createUpdateItemRequest(String tableName, GeneratedMessageV3 message, int version,
          String id, String rangeKey, Map<String, String> globalIndexes) {
    IBiConverter<Integer, String> encoder = EntityIndexAttributes.VERSION.getStringEncoder();
    String versionValue = encoder.convert(version - 1);
    return createUpdateItemRequest(tableName, versionValue, encoder.convert(version), id, rangeKey,
            m_rawDataPartitioner.getRawDataPartitionsWithoutEmpty(message), globalIndexes);
  }

  protected abstract R createUpdateItemRequest(String tableName, String expectedVersion,
          String version, String id, String rangeKey, Map<String, String> rawData,
          Map<String, String> globalIndexes);
}
