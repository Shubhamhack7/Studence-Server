package com.tiwari.studence;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.tiwari.studence.dynamodb.database.DynamoDbConnector;

import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.waiters.DynamoDbWaiter;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws JsonProcessingException {
    DynamoDbConnector connector = new DynamoDbConnector();
   // putItemInTable(connector.getDynamoDbClient(), "00_ENTITY_DEVEL");
    //putItemInTable(connector.getDynamoDbClient(), "00_ENTITY_PROD");
   // searchItem(connector);
    //SearchItemInDynamoDbTable searchItem = new SearchItemInDynamoDbTable(connector);
    //searchItem.queryOpreationResponse("100_ORGANISATION_DEVEL");
    //searchItem.scanandFilterResponse("100_ORGANISATION_DEVEL");
    truncateTable(connector.getDynamoDbClient(),"100_ORGANISATION_DEVEL");
   // truncateTable(connector.getDynamoDbClient(),"101_CAMPUS_DEVEL");
  }

  public static void truncateTable(DynamoDbClient dynamoDbClient, String tableName) {
    ScanRequest scanRequest = ScanRequest.builder()
            .tableName(tableName)
            .build();

    ScanResponse scanResponse;
    do {
      scanResponse = dynamoDbClient.scan(scanRequest);

      for (Map<String, AttributeValue> item : scanResponse.items()) {
        DeleteItemRequest deleteItemRequest = DeleteItemRequest.builder()
                .tableName(tableName)
                .key(item)
                .build();

        dynamoDbClient.deleteItem(deleteItemRequest);
      }

      scanRequest = ScanRequest.builder()
              .tableName(tableName)
              .exclusiveStartKey(scanResponse.lastEvaluatedKey())
              .build();
    } while (scanResponse.hasLastEvaluatedKey());
  }

  private static void searchItem(DynamoDbConnector dynamoDbClient) {
    HashMap<String, String> attrNameAlias = new HashMap<String, String>();
    attrNameAlias.put("#lifetime", "LIFETIME");

//	      HashMap<String, AttributeValue> attrValues = new HashMap<>();
//
//	      attrValues.put(":"+"lifetime", AttributeValue.builder()
//	          .s("UNKNOWN_LIFETIME")
//	          .build());

		/*try {
			ScanRequest scanRequest = ScanRequest.builder().tableName(tableName)
					// .attributesToGet("RAW_DATA,LIFETIME")
					.filterExpression(filterExpression)
					// .expressionAttributeNames(attrNameAlias)
					.expressionAttributeValues(attrValues).build();

			return m_dynamoDbConnector.getDynamoDbClient().scan(scanRequest);

		} catch (DynamoDbException e) {
			throw new ErrorException(e);
		}*/
    DynamoDB dynamoDB = new DynamoDB(dynamoDbClient.getAmazonDynamoDB());
    Table table = dynamoDB.getTable("100_ORGANISATION_DEVEL");

    ScanSpec scanSpec = new ScanSpec()
            .withFilterExpression("#attr1 = :value1 and #attr2 >= :value2")
            .withNameMap(new NameMap().with("#attr1", "NAME").with("#attr2", "LIFETIME"))
            .withValueMap(new ValueMap().with(":value1", "demo school").with(":value2", "UNKNOWN_LIFETIME"));

    ItemCollection<ScanOutcome> outcome = table.scan(scanSpec);
    for (Item item : outcome) {
      System.out.println(item.toJSONPretty());
    }
  }

  public static void putItemInTable(DynamoDbClient ddb, String tableName) {

    HashMap<String, AttributeValue> itemValues = new HashMap<>();
    itemValues.put("ID", AttributeValue.builder().s("ENTITY").build());
    itemValues.put("RANGE", AttributeValue.builder().s("ID").build());
    itemValues.put("KEY", AttributeValue.builder().s("0").build());

    PutItemRequest request = PutItemRequest.builder().tableName(tableName).item(itemValues).build();

    try {
      PutItemResponse response = ddb.putItem(request);
      System.out.println(tableName + " was successfully updated. The request id is "
              + response.responseMetadata().requestId());

    } catch (ResourceNotFoundException e) {
      System.err.format("Error: The Amazon DynamoDB table \"%s\" can't be found.\n", tableName);
      System.err.println("Be sure that it exists and that you've typed its name correctly!");
      System.exit(1);
    } catch (DynamoDbException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

  /*public static String createTable(DynamoDbClient dynamoDbClient, String tableName, String key) {

    DynamoDbWaiter dbWaiter = dynamoDbClient.waiter();
    CreateTableRequest request = CreateTableRequest.builder()
            .attributeDefinitions(
                    AttributeDefinition.builder().attributeName("ID")
                            .attributeType(ScalarAttributeType.S).build(),
                    AttributeDefinition.builder().attributeName("RANGE")
                            .attributeType(ScalarAttributeType.S).build())
            .keySchema(KeySchemaElement.builder().attributeName("ID").keyType(KeyType.HASH).build(),
                    KeySchemaElement.builder().attributeName("RANGE").keyType(KeyType.RANGE)
                            .build())
            .provisionedThroughput(ProvisionedThroughput.builder().readCapacityUnits(new Long(10))
                    .writeCapacityUnits(new Long(10)).build())
            .tableName(tableName).build();

    String newTable = "";
    try {
      CreateTableResponse response = dynamoDbClient.createTable(request);
      DescribeTableRequest tableRequest = DescribeTableRequest.builder().tableName(tableName)
              .build();

      // Wait until the Amazon DynamoDB table is created.
      WaiterResponse<DescribeTableResponse> waiterResponse = dbWaiter
              .waitUntilTableExists(tableRequest);
      waiterResponse.matched().response().ifPresent(System.out::println);
      newTable = response.tableDescription().tableName();
      return newTable;

    } catch (DynamoDbException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
    return "";
  }*/
}
