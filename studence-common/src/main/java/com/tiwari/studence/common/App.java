package com.tiwari.studence.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.inject.Injector;
import com.tiwari.studence.common.entity.GetAndUpdateEntity;
import com.tiwari.studence.common.injector.InjectorProvider;
import com.tiwari.studence.database.DynamoDbConnector;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeAction;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValueUpdate;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws ErrorException {

    Injector inj = InjectorProvider.createInjector();
    // CreateDynamoTable service = inj.getInstance(CreateDynamoTable.class);
    GetAndUpdateEntity service = inj.getInstance(GetAndUpdateEntity.class);
    // System.out.println(service.getNewEntityId().get());

    DynamoDbConnector connector = new DynamoDbConnector();
    updateTableItem(connector.getDynamoDbClient());
  }

  public static void updateTableItem(DynamoDbClient ddb) {

    HashMap<String, AttributeValue> itemKey = new HashMap<>();
    itemKey.put("ID", AttributeValue.builder().s("g").build());
    itemKey.put("RANGE", AttributeValue.builder().s("32").build());

    HashMap<String, AttributeValueUpdate> updatedValues = new HashMap<>();
    updatedValues.put("LIFETIME",
            AttributeValueUpdate.builder().value(AttributeValue.builder().s("ACTIVE").build())
                    .action(AttributeAction.PUT).build());

    UpdateItemRequest request = UpdateItemRequest.builder().tableName("100_ORGANISATION_DEVEL")
            .key(itemKey).attributeUpdates(updatedValues).returnValues("ALL_NEW").build();

    try {
      UpdateItemResponse a = ddb.updateItem(request);
      System.out.println(a.attributes());
    } catch (ResourceNotFoundException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    } catch (DynamoDbException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
    System.out.println("The Amazon DynamoDB table was updated!");
  }

  public static void getDynamoDBItem(DynamoDbClient ddb, String tableName, String key,
          String keyVal) {

    HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(key, AttributeValue.builder().s(keyVal).build());
    keyToGet.put("RANGE", AttributeValue.builder().s("fdd").build());

    GetItemRequest request = GetItemRequest.builder().key(keyToGet).tableName(tableName).build();

    try {
      Map<String, AttributeValue> returnedItem = ddb.getItem(request).item();
      if (returnedItem != null) {
        Set<String> keys = returnedItem.keySet();
        System.out.println("Amazon DynamoDB table attributes: \n");

        for (String key1 : keys) {
          System.out.format("%s: %s\n", key1, returnedItem.get(key1).toString());
        }
      } else {
        System.out.format("No item found with the key %s!\n", key);
      }

    } catch (DynamoDbException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

}
