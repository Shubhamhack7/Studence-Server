package com.tiwari.studence.common.interfaces;

import java.util.Map;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface IDynamoGetEntityTable {
  public IFuture<Map<String, AttributeValue>, ErrorException> getEntityDbTable(String tablename,
          String entity_id);
}
