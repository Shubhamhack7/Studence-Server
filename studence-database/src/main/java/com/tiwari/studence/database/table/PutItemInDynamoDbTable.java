package com.tiwari.studence.database.table;

import java.util.HashMap;

import javax.inject.Inject;

import com.tiwari.studence.database.DynamoDbConnector;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

public class PutItemInDynamoDbTable implements IPutItemTable {

  private DynamoDbConnector m_dynamoDbConnector;

  @Inject
  public PutItemInDynamoDbTable(DynamoDbConnector dynamoDbConnector) {
    m_dynamoDbConnector = dynamoDbConnector;
  }

  @Override
  public PutItemResponse putItem(String tableName, HashMap<String, AttributeValue> itemValues)
          throws ErrorException {
    PutItemRequest request = PutItemRequest.builder().tableName(tableName).item(itemValues)
            .returnValues("ALL_OLD").build();

    try {
      PutItemResponse a = m_dynamoDbConnector.getDynamoDbClient().putItem(request);
      return a;
    } catch (ResourceNotFoundException e) {
      throw new ErrorException(e);
    } catch (DynamoDbException e) {
      throw new ErrorException(e);
    }
  }

}
