package com.tiwari.studence.database.table;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.inject.Inject;

import com.tiwari.studence.database.DynamoDbConnector;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.model.AttributeAction;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValueUpdate;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;

public class UpdateItemInDynamoDbTable implements IUpdateItemTable {

  private DynamoDbConnector m_dynamoDbConnector;

  @Inject
  public UpdateItemInDynamoDbTable(DynamoDbConnector dynamoDbConnector) {
    m_dynamoDbConnector = dynamoDbConnector;
  }

  @Override
  public UpdateItemResponse updateItem(String tableName, HashMap<String, AttributeValue> itemKey,
          HashMap<String, AttributeValue> itemValues) throws Exception {
    HashMap<String, AttributeValueUpdate> updatedValues = new HashMap<>();
    for (Entry<String, AttributeValue> iterable_element : itemValues.entrySet()) {

      updatedValues.put(iterable_element.getKey(),
              AttributeValueUpdate.builder()
                      .value(AttributeValue.builder().s(iterable_element.getValue().s()).build())
                      .action(AttributeAction.PUT).build());
    }

    UpdateItemRequest request = UpdateItemRequest.builder().tableName(tableName).key(itemKey)
            .attributeUpdates(updatedValues).returnValues("ALL_NEW").build();

    try {
      return m_dynamoDbConnector.getDynamoDbClient().updateItem(request);
    } catch (ResourceNotFoundException e) {
      throw new ErrorException(e);
    } catch (DynamoDbException e) {
      throw new ErrorException(e);
    }
  }

}
