package com.tiwari.studence.common.service.v2.handler;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.util.RawDataCombiner;
import com.tiwari.studence.util.collect.Maps;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class GetItemResultHandler<R extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>>
        extends AResultHandler<R, GetItemResult> {
  @Inject
  public GetItemResultHandler(RawDataCombiner<R, B> pbDecoder) {
    super(pbDecoder);
  }

  @Override
  protected Map<String, String> getRawData(GetItemResult result) {
    Map<String, String> attrData = Maps.newHashMap();
    if (result.getItem() != null) {
      for (Map.Entry<String, AttributeValue> attr : result.getItem().entrySet()) {
        attrData.put(attr.getKey(), attr.getValue().getS());
      }
    }
    return attrData;
  }
}