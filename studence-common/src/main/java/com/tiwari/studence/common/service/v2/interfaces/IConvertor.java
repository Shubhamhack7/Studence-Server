package com.tiwari.studence.common.service.v2.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.List;

public interface IConvertor<P extends GeneratedMessageV3,Lresp extends GeneratedMessageV3> {
  public P convert(HashMap<String, AttributeValue> map);
  public Lresp searchRespConvert(List<HashMap<String, AttributeValue>> map,
          HashMap<String, AttributeValue> lastKey);
}
