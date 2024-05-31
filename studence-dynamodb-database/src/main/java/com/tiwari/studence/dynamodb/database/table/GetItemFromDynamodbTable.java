package com.tiwari.studence.dynamodb.database.table;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.dynamodb.database.DynamoDbConnector;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

@Singleton
public class GetItemFromDynamodbTable implements IDynamoGetItemTable {

  private DynamoDbConnector m_dynamoDbConnector;
  private String m_hash_key = "ID";
  private String m_range_key = "RANGE";

  @Inject
  public GetItemFromDynamodbTable(DynamoDbConnector dynamoDbConnector) {
    m_dynamoDbConnector = dynamoDbConnector;
  }

  @Override
  public GetItemResponse getDynamoDBItem(String tableName, String hash_keyVal, String range_keyVal)
          throws ErrorException {
    GetItemResponse returnedItem = null;
    HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(m_hash_key, AttributeValue.builder().s(hash_keyVal).build());
    keyToGet.put(m_range_key, AttributeValue.builder().s(range_keyVal).build());

    GetItemRequest request = GetItemRequest.builder().key(keyToGet).tableName(tableName).build();

    try {
      return m_dynamoDbConnector.getDynamoDbClient().getItem(request);
    } catch (Exception e){
      throw new ErrorException(e);
    }/*catch (DynamoDbException e) {
      throw new ErrorException(e);
    }*/
  }

}
