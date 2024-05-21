package com.tiwari.studence.common.service.v2.handler;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.util.RawDataCombiner;

import java.util.Map;

public abstract class AResultHandler<R extends GeneratedMessageV3, Re> {
  private final RawDataCombiner<R, ?> m_pbDecoder;

  protected AResultHandler(RawDataCombiner<R, ?> pbDecoder) {
    m_pbDecoder = pbDecoder;
  }

  public R getEntityData(Re result) {
    return m_pbDecoder.getData(getRawData(result));
  }

  protected abstract Map<String, String> getRawData(Re result);

}
