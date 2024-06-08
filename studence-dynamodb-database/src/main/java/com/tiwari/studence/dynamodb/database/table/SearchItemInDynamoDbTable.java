package com.tiwari.studence.dynamodb.database.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.tiwari.studence.dynamodb.database.DynamoDbConnector;
import com.tiwari.studence.proto.search.ComparisonOperatorEnum;
import com.tiwari.studence.proto.search.DynamoDbSearchPb;

import com.tiwari.studence.util.common.CommonUtil;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.collect.Pair;
import software.amazon.awssdk.services.dynamodb.model.*;

public class SearchItemInDynamoDbTable implements ISearchItemTable {

  private DynamoDbConnector m_dynamoDbConnector;

  @Inject
  public SearchItemInDynamoDbTable(DynamoDbConnector dynamoDbConnector) {
    m_dynamoDbConnector = dynamoDbConnector;
  }

  @Override
  public Pair<Set<Map.Entry<String, AttributeValue>>, List<Map<String, AttributeValue>>> searchItemsScanSpec(
          DynamoDbSearchPb request) throws InvalidProtocolBufferException {
    System.out.println(JsonFormat.printer().print(request));
    switch (request.getMode()) {

    case UNKNOWN_MODE:
      break;
    case QUERY_MODE:
      break;
    case SCAN_FILTER_MODE:
      return scanandFilterResponse(request);
    case GLOBAL_SECONDARY_INDEX:
      break;
    case LOCAL_SECONDARY_INDEX:
      break;
    case UNRECOGNIZED:
      break;
    }
    return null;
  }

  public void queryOpreationResponse(String tableName) throws JsonProcessingException {
    //100_ORGANISATION_DEVEL
    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(":id_", AttributeValue.builder().s("I").build());
    expressionAttributeValues.put(":name_", AttributeValue.builder().s("ram shyam").build());

    QueryRequest queryRequest = QueryRequest.builder().tableName(tableName)
            .keyConditionExpression("ID = :id_").filterExpression("ORGANISATION_NAME = :name_")
            .expressionAttributeValues(expressionAttributeValues).build();
    System.out.println(queryRequest);
    QueryResponse queryResponse = m_dynamoDbConnector.getDynamoDbClient().query(queryRequest);
    List<Map<String, AttributeValue>> items = queryResponse.items();
    for (Map<String, AttributeValue> item : items) {
      System.out.println(item);
    }
  }

  public Pair<Set<Map.Entry<String, AttributeValue>>, List<Map<String, AttributeValue>>> scanandFilterResponse(
          DynamoDbSearchPb req) {
   /* Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    Map<String, AttributeValue> exclusiveStartKey = new HashMap<>();
    if (Strings.notEmpty(req.getNextToken())) {
      CommonUtil.getKeyValueFromNextToken(exclusiveStartKey, req.getNextToken());
    }
    req.getExpressionAttributeList().forEach(request -> {
      if (request.getCompareType() == ComparisonOperatorEnum.IN) {
        expressionAttributeValues.put(request.getAttributeNameAlias(), AttributeValue.builder()
                .ss(Strings.getList(request.getStringValue(),
                        StudenceSpecialCharecterEnum.COMMA.getSign())).build());
      } else if (request.getCompareType() == ComparisonOperatorEnum.NOT_NULL) {
        expressionAttributeValues.put(request.getAttributeNameAlias(),
                AttributeValue.builder().nul(false).build());
      } else if (request.getCompareType() == ComparisonOperatorEnum.NULL) {
        expressionAttributeValues.put(request.getAttributeNameAlias(),
                AttributeValue.builder().nul(true).build());
      } else {
        expressionAttributeValues.put(request.getAttributeNameAlias(),
                AttributeValue.builder().s(request.getStringValue()).build());
      }
    });
    ScanRequest scanRequest = null;
    if (Strings.notEmpty(req.getNextToken())) {
      scanRequest = ScanRequest.builder().tableName(req.getTableName())
              .filterExpression(req.getFilterExpression())
              .expressionAttributeValues(expressionAttributeValues).limit(100)
              .exclusiveStartKey(exclusiveStartKey).build();
    } else {
      scanRequest = ScanRequest.builder().tableName(req.getTableName())
              .filterExpression(req.getFilterExpression())
              .expressionAttributeValues(expressionAttributeValues).limit(100).build();
    }
    System.out.println(scanRequest);
    ScanResponse scanResponse = m_dynamoDbConnector.getDynamoDbClient().scan(scanRequest);
    for (Map.Entry<String, AttributeValue> key : scanResponse.lastEvaluatedKey().entrySet()) {
      System.out.print("KEY: =>" + key.getKey() + " \n" + " VALUE: =>" + key.getValue());
    }
    Set<Map.Entry<String, AttributeValue>> a = scanResponse.lastEvaluatedKey().entrySet();

    List<Map<String, AttributeValue>> items = scanResponse.items();
    Pair<Set<Map.Entry<String, AttributeValue>>, List<Map<String, AttributeValue>>> resPair = new Pair(
            scanResponse.lastEvaluatedKey().entrySet(), scanResponse.items());*/
    return null;
  }
}

