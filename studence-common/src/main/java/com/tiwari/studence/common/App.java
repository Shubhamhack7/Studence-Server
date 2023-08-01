package com.tiwari.studence.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.xspec.ExpressionSpecBuilder;
import com.google.inject.Injector;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.controlflow.CreateDynamoTable;
import com.tiwari.studence.common.entity.GetAndUpdateEntity;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.injector.InjectorProvider;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.dynamodb.database.DynamoDbConnector;
import com.tiwari.studence.dynamodb.database.table.CreateDynamoDbTable;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.proto.search.*;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.exception.ErrorException;

import org.apache.commons.text.StringEscapeUtils;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.paginators.ScanIterable;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws ErrorException {

    Injector inj = InjectorProvider.createInjector();
    CreateDynamoTable service = inj.getInstance(CreateDynamoTable.class);
    //GetAndUpdateEntity service = inj.getInstance(GetAndUpdateEntity.class);
    // System.out.println(service.getNewEntityId().get());

    DynamoDbConnector connector = new DynamoDbConnector();
    //updateTableItem(connector.getDynamoDbClient());
   // System.out.println(queryTable(connector.getDynamoDbClient()));
    //scanItems(connector.getDynamoDbClient());
   /// searchData(inj);
    for (TableNameEnum tableName :TableNameEnum.values()) {
      try {
        service.createDbTable(tableName.getValue());
      }catch(Exception e) {
        continue;
      }
    }

    //searchData(inj);
  }

  private static void scanandFilter(Injector inj, DynamoDbConnector connector) {
    AmazonDynamoDB aclient  = connector.getAmazonDynamoDB();
    DynamoDbClient dclient  = connector.getDynamoDbClient();
    DynamoDBMapper mapper = new DynamoDBMapper(aclient);

    Condition condition1 = Condition.builder()
            .attributeValueList(AttributeValue.builder().s("ACTIVE").build())
            .comparisonOperator(software.amazon.awssdk.services.dynamodb.model.ComparisonOperator.EQ)
            .build();

    Condition condition2 = Condition.builder()
            .attributeValueList(AttributeValue.builder().s("demo").build())
            .comparisonOperator(software.amazon.awssdk.services.dynamodb.model.ComparisonOperator.EQ)
            .build();

    Map<String, Condition> conditions = new HashMap<>();
    conditions.put("LIFETIME", condition1);
    conditions.put("NAME", condition2);

    // Configure the scan request
    ScanRequest scanRequest = ScanRequest.builder()
            .tableName("100_ORGANISATION_DEVEL")
            .scanFilter(conditions)
            .build();

    // Execute the scan operation and get the results
    ScanIterable scanResults = dclient.scanPaginator(scanRequest);
    for (ScanResponse page : scanResults) {
      // Process the results
      List<Map<String, AttributeValue>> items = page.items();
      for (Map<String, AttributeValue> item : items) {
       System.out.println(item);
      }
    }

  }


  private static void searchData(Injector inj) {
    IDynamoSearchTable search = inj.getInstance(IDynamoSearchTable.class);
    SearchRequestsPb.Builder searchRequest = SearchRequestsPb.newBuilder();
    searchRequest.setModeValue(DynamoDBSearchMode.SCAN_FILTER_MODE_VALUE);
    SearchPb.Builder builder = searchRequest.addRequestsBuilder();
    AttributeNameValuePair.Builder builder1 = builder.addAttributesBuilder();
    builder.setType(ComparisonOperatorEnum.EQUAL_TO);
    builder1.setType(DynamoDBValue.DYNAMODB_VALUE_STRING);
    builder1.setName(AEntitySearcher.GenericSearchEnum.LIFETIME.name());
    builder1.setStringValue(LifeTimeEnum.ACTIVE.name());
    AttributeNameValuePair.Builder attrbu2 = builder.addAttributesBuilder();
    attrbu2.setType(DynamoDBValue.DYNAMODB_VALUE_STRING);
    attrbu2.setName("ORGANISATION_NAME");
    attrbu2.setStringValue("ram shyam");
   // System.out.print(searchRequest);
    searchRequest.addOperators(DynamoDBLogicalOperators.AND);
    System.out.print(StringEscapeUtils.unescapeJava("\\u003d"));
    search.searchDbTable("100_ORGANISATION",searchRequest.build());
  }

  public static void scanItems( DynamoDbClient ddb ) {
	  HashMap<String,String> attrNameAlias = new HashMap<String,String>();
      attrNameAlias.put("#lifetime", "LIFETIME");

      HashMap<String, AttributeValue> attrValues = new HashMap<>();

      attrValues.put(":"+"lifetime", AttributeValue.builder()
          .s("UNKNOWN_LIFETIME")
          .build());

      try {
          ScanRequest scanRequest = ScanRequest.builder()
              .tableName("100_ORGANISATION_DEVEL")
              //.attributesToGet("RAW_DATA,LIFETIME")
              .filterExpression("LIFETIME=:lifetime")
             // .expressionAttributeNames(attrNameAlias)
              .expressionAttributeValues(attrValues)
              .build();

          ScanResponse response = ddb.scan(scanRequest);
          System.out.println(response.count());
          for (Map<String, AttributeValue> item : response.items()) {
              Set<String> keys = item.keySet();
              for (String key : keys) {
                  System.out.println ("The key name is "+key +"\n" );
                  System.out.println("The value is "+item.get(key).s());
              }
          }

      } catch (DynamoDbException e) {
          e.printStackTrace();
          System.exit(1);
      }
  }
  
  public static int queryTable(DynamoDbClient ddb) {

      // Set up an alias for the partition key name in case it's a reserved word.
      HashMap<String,String> attrNameAlias = new HashMap<String,String>();
      attrNameAlias.put("#range", "RANGE");
      attrNameAlias.put("#id", "ID");

      // Set up mapping of the partition name with the value.
      HashMap<String, AttributeValue> attrValues = new HashMap<>();

      attrValues.put(":"+"range", AttributeValue.builder()
          .s("46")
          .build());
      attrValues.put(":"+"id", AttributeValue.builder()
              .s("u")
              .build());

      QueryRequest queryReq = QueryRequest.builder()
          .tableName("100_ORGANISATION_DEVEL")
          .keyConditionExpression("#id=:id and #range=:range")
          .expressionAttributeNames(attrNameAlias)
          .expressionAttributeValues(attrValues)
          .build();
      System.out.println(queryReq);

      try {
          QueryResponse response = ddb.query(queryReq);
          return response.count();

      } catch (DynamoDbException e) {
          System.err.println(e.getMessage());
          System.exit(1);
      }
      return -1;
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
