package com.tiwari.studence.common.interfaces;

import java.util.HashMap;
import java.util.Map;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface IDynamoPutTable {
  public IFuture<HashMap<String, AttributeValue>, ErrorException> putDbTable(String tablename,
          HashMap<String, AttributeValue> attributeValues);
}
