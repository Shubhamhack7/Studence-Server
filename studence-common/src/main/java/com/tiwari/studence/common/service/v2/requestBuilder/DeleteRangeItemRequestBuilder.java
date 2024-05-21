package com.tiwari.studence.common.service.v2.requestBuilder;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.util.collect.Maps;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class DeleteRangeItemRequestBuilder {

  public DeleteItemRequest createDeleteItemRequest(String tableName, String id, String rangeKey) {
    DeleteItemRequest delRequest = new DeleteItemRequest();
    Map<String, AttributeValue> data = Maps.newHashMap();
    data.put(EntityIndexAttributes.ITEM_ID.name(), new AttributeValue().withS(id));
    data.put(EntityIndexAttributes.RANGE_KEY.name(), new AttributeValue().withS(rangeKey));
    delRequest.withTableName(tableName).withKey(data);
    return delRequest;
  }
}
