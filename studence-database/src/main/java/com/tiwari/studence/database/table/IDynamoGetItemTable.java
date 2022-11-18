package com.tiwari.studence.database.table;

import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

public interface IDynamoGetItemTable {
  public GetItemResponse getDynamoDBItem(String tableName, String hash_keyVal, String Range_keyVal) throws ErrorException;
}
