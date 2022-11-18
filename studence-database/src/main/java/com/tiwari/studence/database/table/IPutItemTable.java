package com.tiwari.studence.database.table;

import java.util.HashMap;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

public interface IPutItemTable {
  public PutItemResponse putItem(String tableName, HashMap<String, AttributeValue> itemValues)
          throws Exception;
}
