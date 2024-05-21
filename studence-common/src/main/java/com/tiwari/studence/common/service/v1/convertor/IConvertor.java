package com.tiwari.studence.common.service.v1.convertor;

import java.util.HashMap;
import java.util.List;

import com.google.protobuf.GeneratedMessageV3;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface IConvertor<P extends GeneratedMessageV3,Lresp extends GeneratedMessageV3> {
  public P convert(HashMap<String, AttributeValue> map);
  public Lresp searchRespConvert(List<HashMap<String, AttributeValue>> map,
          HashMap<String, AttributeValue> lastKey);
}
