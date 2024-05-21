package com.tiwari.studence.common.service.v2.requestBuilder;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbInfo;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.common.util.RangeHashKeyConcatinator;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.collect.Pair;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Singleton
public class BatchItemGetRequestBuilder<T extends ITables>
        extends ABatchGetItemRequestBuilder<T, DynamoDbInfo, BatchGetItemRequest> {
  private final RangeHashKeyConcatinator m_rangeHashKeyConcatinator;

  @Inject
  public BatchItemGetRequestBuilder(T table, DynamoDbInfo forDB,
          RangeHashKeyConcatinator rangeHashKeyConcatinator) {
    super(table, forDB);
    m_rangeHashKeyConcatinator = rangeHashKeyConcatinator;
  }

  @Override
  protected BatchGetItemRequest createRequestInternal(Map<String, String> keyWithTableName,
          List<String> attrList, boolean isRangeRequest) {
    BatchGetItemRequest request = new BatchGetItemRequest();
    List<Map<String, AttributeValue>> keyAtrrtibuteValueList = Lists.newArrayList();
    Map<String, Map<String, AttributeValue>> rowIdWitthkeyAtrrtibuteValueList = Maps.newHashMap();

    Map<String, KeysAndAttributes> mapOfTableWithkeysAndAttributes = null;
    if (isRangeRequest) {
      for (String id : keyWithTableName.keySet()) {
        Pair<String, String> hashRangeKey = m_rangeHashKeyConcatinator.splitHashRangeKeys(id);
        Map<String, AttributeValue> keyAttributeValue = Maps.newHashMap();
        keyAttributeValue.put(EntityIndexAttributes.ITEM_ID.name(),
                new AttributeValue(hashRangeKey.getFirst()));
        keyAttributeValue.put(EntityIndexAttributes.RANGE_KEY.name(),
                new AttributeValue(hashRangeKey.getSecond()));
        keyAtrrtibuteValueList.add(keyAttributeValue);
        rowIdWitthkeyAtrrtibuteValueList.put(id, keyAttributeValue);
      }
      attrList.add(EntityIndexAttributes.ITEM_ID.name());
      attrList.add(EntityIndexAttributes.RANGE_KEY.name());
      mapOfTableWithkeysAndAttributes = getTableWithKeysAndAttributes(attrList,
              rowIdWitthkeyAtrrtibuteValueList, keyWithTableName);
      Map<String, KeysAndAttributes> tableWithKeysAndAttributes = Maps.newHashMap();
      for (Map.Entry<String, KeysAndAttributes> rowIdWithKeyAttributes : mapOfTableWithkeysAndAttributes.entrySet()) {
        tableWithKeysAndAttributes.put(rowIdWithKeyAttributes.getKey(),
                rowIdWithKeyAttributes.getValue());
      }
      request.setRequestItems(tableWithKeysAndAttributes);
    } else {
      for (String id : keyWithTableName.keySet()) {
        Map<String, AttributeValue> keyAttributeValue = Maps.newHashMap();
        keyAttributeValue.put(EntityIndexAttributes.ITEM_ID.name(), new AttributeValue(id));
        keyAtrrtibuteValueList.add(keyAttributeValue);
        rowIdWitthkeyAtrrtibuteValueList.put(id, keyAttributeValue);
      }
      attrList.add(EntityIndexAttributes.ITEM_ID.name());
      mapOfTableWithkeysAndAttributes = getTableWithKeysAndAttributes(attrList,
              rowIdWitthkeyAtrrtibuteValueList, keyWithTableName);
      Map<String, KeysAndAttributes> tableWithKeysAndAttributes = Maps.newHashMap();
      for (Map.Entry<String, KeysAndAttributes> rowIdWithKeyAttributes : mapOfTableWithkeysAndAttributes.entrySet()) {
        tableWithKeysAndAttributes.put(rowIdWithKeyAttributes.getKey(),
                rowIdWithKeyAttributes.getValue());
      }
      request.setRequestItems(tableWithKeysAndAttributes);

    }

    return request;
  }

  private Map<String, KeysAndAttributes> getTableWithKeysAndAttributes(List<String> attrList,
          Map<String, Map<String, AttributeValue>> rowIdWithKeyAtrrtibuteValueList,
          Map<String, String> keyWithTableName) {
    Map<String, KeysAndAttributes> mapOfRowIdWithKeyAttributes = Maps.newHashMap();
    for (Map.Entry<String, Map<String, AttributeValue>> rowIdWithListAttribute : rowIdWithKeyAtrrtibuteValueList.entrySet()) {
      if (mapOfRowIdWithKeyAttributes.containsKey(
              keyWithTableName.get(rowIdWithListAttribute.getKey()))) {
        KeysAndAttributes keysAndAttributes = mapOfRowIdWithKeyAttributes.get(
                keyWithTableName.get(rowIdWithListAttribute.getKey()));
        List<Map<String, AttributeValue>> list = keysAndAttributes.getKeys();
        list.add(rowIdWithListAttribute.getValue());
        keysAndAttributes.setKeys(list);
        mapOfRowIdWithKeyAttributes.put(keyWithTableName.get(rowIdWithListAttribute.getKey()),
                keysAndAttributes);
      } else {
        KeysAndAttributes keysAndAttributes = new KeysAndAttributes();
        keysAndAttributes.setKeys(Arrays.asList(rowIdWithListAttribute.getValue()));
        keysAndAttributes.withAttributesToGet(attrList);
        mapOfRowIdWithKeyAttributes.put(keyWithTableName.get(rowIdWithListAttribute.getKey()),
                keysAndAttributes);
      }
    }

    return mapOfRowIdWithKeyAttributes;
  }

}
