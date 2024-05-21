package com.tiwari.studence.common.service.v2.handler;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.util.RawDataCombiner;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.collect.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ABatchGetItemResultHandler<R extends GeneratedMessageV3, Re> {
  private final RawDataCombiner<R, ?> m_pbDecoder;

  protected ABatchGetItemResultHandler(RawDataCombiner<R, ?> pbDecoder) {
    m_pbDecoder = pbDecoder;
  }

  /**
   * @param BatchetItemRequest
   * @return Map of databaseId and data associated with key
   */
  public Pair<Set<String>, Map<String, R>> getEntityData(Re result, boolean isHashRangeKey) {
    Map<String, R> keyWithData = Maps.newHashMap();
    Pair<Set<String>, List<Pair<String, Map<String, String>>>> response = getRawData(result,
            isHashRangeKey);
    for (Pair<String, Map<String, String>> keyWithRawData : response.getSecond()) {
      keyWithData.put(keyWithRawData.getFirst(), m_pbDecoder.getData(keyWithRawData.getSecond()));
    }

    return new Pair<Set<String>, Map<String, R>>(response.getFirst(), keyWithData);
  }

  protected abstract Pair<Set<String>, List<Pair<String, Map<String, String>>>> getRawData(
          Re result, boolean isHashRangeKey);
}
