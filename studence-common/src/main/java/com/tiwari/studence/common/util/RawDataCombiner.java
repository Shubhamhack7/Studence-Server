package com.tiwari.studence.common.util;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.encoders.Base64PbDecoder;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.util.collect.Maps;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class RawDataCombiner<R extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>> {
  private final Base64PbDecoder<R, B> m_pbDecoder;

  @Inject
  public RawDataCombiner(Base64PbDecoder<R, B> pbDecoder) {
    m_pbDecoder = pbDecoder;
  }

  public R getData(Map<String, String> dataPartisions) {
    StringBuilder b64EncodedPb = new StringBuilder();
    Map<Integer, String> rawDataMap = Maps.newHashMap();
    for (Map.Entry<String, String> partition : dataPartisions.entrySet()) {
      if (!partition.getKey().startsWith(EntityIndexAttributes.RAW_DATA.name())) {
        continue;
      }
      rawDataMap.put(
              Integer.valueOf(partition.getKey().substring(
                      EntityIndexAttributes.RAW_DATA.name().length() + 1)), partition.getValue());
    }
    for (int i = 0; i < rawDataMap.size(); i++) {
      b64EncodedPb.append(rawDataMap.get(i));
    }

    return m_pbDecoder.convert(b64EncodedPb.toString());
  }
}
