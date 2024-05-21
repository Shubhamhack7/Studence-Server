package com.tiwari.studence.common.service.v1.updater;

import java.util.HashMap;

import com.google.protobuf.GeneratedMessageV3;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface IUpdater<P extends GeneratedMessageV3> {
  abstract HashMap<String, AttributeValue> updater(P builder);
}