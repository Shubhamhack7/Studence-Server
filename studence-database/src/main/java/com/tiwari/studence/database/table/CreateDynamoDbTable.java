package com.tiwari.studence.database.table;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.database.DynamoDbConnector;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableResponse;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.waiters.DynamoDbWaiter;

@Singleton
public class CreateDynamoDbTable implements ICreateTable {

  private DynamoDbConnector m_dynamoDbConnector;

  @Inject
  public CreateDynamoDbTable(DynamoDbConnector dynamoDbConnector) {
    m_dynamoDbConnector = dynamoDbConnector;
  }

  @Override
  public CreateTableResponse createTable(String tableName) throws ErrorException {
    CreateTableResponse response = null;

    DynamoDbWaiter dbWaiter = m_dynamoDbConnector.getDynamoDbClient().waiter();
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
      response = m_dynamoDbConnector.getDynamoDbClient().createTable(request);
      DescribeTableRequest tableRequest = DescribeTableRequest.builder().tableName(tableName)
              .build();
      // Wait until the Amazon DynamoDB table is created.
      WaiterResponse<DescribeTableResponse> waiterResponse = dbWaiter
              .waitUntilTableExists(tableRequest);
      waiterResponse.matched().response().ifPresent(System.out::println);

    } catch (DynamoDbException e) {
      throw new ErrorException(e);
    }
    return response;
  }

}
