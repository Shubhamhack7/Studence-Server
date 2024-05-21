package com.tiwari.studence.common.service.v2.requestBuilder;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbInfo;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.interfaces.ITables;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class GetItemRequestBuilder<T extends ITables> extends
        AGetItemRequestBuilder<T, DynamoDbInfo, GetItemRequest> {
  @Inject
  public GetItemRequestBuilder(T forTables, DynamoDbInfo forDB) {
    super(forTables, forDB);
  }

  @Override
  protected GetItemRequest createRequestInternal(String tableName, List<String> attrList, String id) {
    GetItemRequest request = new GetItemRequest();
    request.withTableName(tableName).withAttributesToGet(attrList)
            .addKeyEntry(EntityIndexAttributes.ITEM_ID.name(), new AttributeValue().withS(id));
    return request;
  }


}
