package com.tiwari.studence.common.indexer;

import java.util.HashMap;

import com.google.protobuf.GeneratedMessageV3;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface IIndexer<P extends GeneratedMessageV3> {
  public HashMap<String, AttributeValue> indexer(P builder);
}
