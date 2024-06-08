package com.tiwari.studence.common.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.ErrorException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;

public interface IDynamoUpdateTable {
  public IFuture<HashMap<String, AttributeValue>, ErrorException> updateDbTable(String tablename,
          HashMap<String, AttributeValue> keys,HashMap<String, AttributeValue> attributeValues);
}
