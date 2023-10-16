package com.tiwari.studence.common.convertor;

import java.util.HashMap;

import com.google.protobuf.GeneratedMessageV3;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface IConvertor<P extends GeneratedMessageV3> {
  public P convert(HashMap<String, AttributeValue> map);
}
