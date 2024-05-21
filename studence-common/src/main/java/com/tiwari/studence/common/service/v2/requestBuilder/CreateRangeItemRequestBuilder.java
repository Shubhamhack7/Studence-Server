package com.tiwari.studence.common.service.v2.requestBuilder;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbInfo;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.common.service.v2.partitioner.RawDataPartitioner;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.encoder.IBiConverter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class CreateRangeItemRequestBuilder<T extends ITables>
        extends ACreateRangeItemRequestBuilder<PutItemRequest> {
  @Inject
  public CreateRangeItemRequestBuilder(RawDataPartitioner<T, DynamoDbInfo> rawDataPartitioner) {
    super(rawDataPartitioner);
  }

  @Override
  protected PutItemRequest createCreateItemRequest(String tableName, String id, String rangeKey,
          Map<String, String> rawData, Map<String, String> secondaryIndexes) {
    PutItemRequest request = new PutItemRequest();
    Map<String, AttributeValue> data = Maps.newHashMap();
    data.put(EntityIndexAttributes.ITEM_ID.name(), new AttributeValue().withS(id));
    data.put(EntityIndexAttributes.RANGE_KEY.name(), new AttributeValue().withS(rangeKey));
    IBiConverter<Integer, String> encoder = EntityIndexAttributes.VERSION.getStringEncoder();
    String versionValue = encoder.convert(1);
    data.put(EntityIndexAttributes.VERSION.name(), new AttributeValue().withS(versionValue));
    for (Map.Entry<String, String> attr : rawData.entrySet()) {
      data.put(attr.getKey(), new AttributeValue().withS(attr.getValue()));
    }
    for (Map.Entry<String, String> attr : secondaryIndexes.entrySet()) {
      data.put(attr.getKey(), new AttributeValue().withS(attr.getValue()));
    }
    return request.withTableName(tableName).withItem(data)
            .addExpectedEntry(EntityIndexAttributes.VERSION.name(),
                    new ExpectedAttributeValue(false));

  }
}
