package com.tiwari.studence.common.service.v2.requestBuilder;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbInfo;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.common.service.v2.partitioner.RawDataPartitioner;
import com.tiwari.studence.util.collect.Maps;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class UpdateItemRequestBuilder<T extends ITables>
        extends AUpdateItemRequestBuilder<PutItemRequest> {
  @Inject
  public UpdateItemRequestBuilder(RawDataPartitioner<T, DynamoDbInfo> rawDataPartitioner) {
    super(rawDataPartitioner);
  }

  @Override
  protected PutItemRequest createUpdateItemRequest(String tableName, String expectedVersion,
          String version, String id, Map<String, String> rawData,
          Map<String, String> secondaryIndexes) {
    PutItemRequest request = new PutItemRequest();
    Map<String, AttributeValue> data = Maps.newHashMap();
    data.put(EntityIndexAttributes.ITEM_ID.name(), new AttributeValue().withS(id));
    data.put(EntityIndexAttributes.VERSION.name(), new AttributeValue().withS(version));
    for (Map.Entry<String, String> attr : rawData.entrySet()) {
      data.put(attr.getKey(), new AttributeValue().withS(attr.getValue()));
    }
    for (Map.Entry<String, String> attr : secondaryIndexes.entrySet()) {
      data.put(attr.getKey(), new AttributeValue().withS(attr.getValue()));
    }
    request.withTableName(tableName).withItem(data)
            .addExpectedEntry(EntityIndexAttributes.VERSION.name(),
                    new ExpectedAttributeValue((new AttributeValue(expectedVersion))));
    return request;
  }

}
