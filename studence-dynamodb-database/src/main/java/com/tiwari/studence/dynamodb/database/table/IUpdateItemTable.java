package com.tiwari.studence.dynamodb.database.table;

import java.util.HashMap;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;

public interface IUpdateItemTable {
  public UpdateItemResponse updateItem(String tableName,
          HashMap<String, AttributeValue> itemKey, HashMap<String, AttributeValue> itemValues)
          throws Exception;
}
