package com.tiwari.studence.common.service.v2.handler;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.util.RangeHashKeyConcatinator;
import com.tiwari.studence.common.util.RawDataCombiner;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.collect.Sets;
import com.tiwari.studence.util.common.Strings;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Singleton
public class BatchItemGetResultHandler<R extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>>
        extends ABatchGetItemResultHandler<R, BatchGetItemResult> {
  private final RangeHashKeyConcatinator m_helper;

  @Inject
  public BatchItemGetResultHandler(RawDataCombiner<R, B> pbDecoder,
          RangeHashKeyConcatinator helper) {
    super(pbDecoder);
    m_helper = helper;
  }

  @Override
  protected Pair<Set<String>, List<Pair<String, Map<String, String>>>> getRawData(
          BatchGetItemResult result, boolean isHashRangeKey) {
    String key = "";
    List<Pair<String, Map<String, String>>> rows = Lists.newArrayList();
    Map<String, List<Map<String, AttributeValue>>> responses = result.getResponses();
    for (Map.Entry<String, List<Map<String, AttributeValue>>> tablesWithData : responses.entrySet()) {
      for (Map<String, AttributeValue> data : tablesWithData.getValue()) {
        Map<String, String> attrData = Maps.newHashMap();
        String hashKey = "";
        String rangeKey = "";
        // Columns-ITEM_ID,RANGE_KEY,RAW_DATA
        for (Map.Entry<String, AttributeValue> colWithValues : data.entrySet()) {
          if (colWithValues.getKey().startsWith(EntityIndexAttributes.RAW_DATA.name())) {
            attrData.put(colWithValues.getKey(), colWithValues.getValue().getS());
          } else if (colWithValues.getKey().equals(EntityIndexAttributes.ITEM_ID.name())) {
            hashKey = colWithValues.getValue().getS();
          } else {
            rangeKey = colWithValues.getValue().getS();
          }

        }
        if (isHashRangeKey) {
          key = m_helper.joinHashRangeKeys(hashKey, rangeKey);
        } else {
          key = hashKey;
        }
        Pair<String, Map<String, String>> keyWithData = new Pair<String, Map<String, String>>(key,
                attrData);
        rows.add(keyWithData);
      }
    }
    Set<String> unProcessedKey = getUnProcessedKey(result.getUnprocessedKeys());

    return new Pair<Set<String>, List<Pair<String, Map<String, String>>>>(unProcessedKey, rows);
  }

  private Set<String> getUnProcessedKey(Map<String, KeysAndAttributes> unprocessedKeys) {
    Set<String> unProcessedIds = Sets.newHashSet();
    String hashKey = "", rangeKey = "";
    // key-tableName,value:attributes
    for (Map.Entry<String, KeysAndAttributes> tableWithKeyAtrributes : unprocessedKeys.entrySet()) {
      KeysAndAttributes value = tableWithKeyAtrributes.getValue();
      // Access rows
      for (Map<String, AttributeValue> keyWithAtrributeValue : value.getKeys()) {
        // Access columns
        for (Map.Entry<String, AttributeValue> colWithValues : keyWithAtrributeValue.entrySet()) {
          if (colWithValues.getKey().equals(EntityIndexAttributes.ITEM_ID.name())) {
            hashKey = colWithValues.getValue().getS();
          }
          if (colWithValues.getKey().equals(EntityIndexAttributes.RANGE_KEY.name())) {
            rangeKey = colWithValues.getValue().getS();
          }
        }
        if (Strings.notEmpty(hashKey) && Strings.notEmpty(hashKey)) {
          unProcessedIds.add(m_helper.joinHashRangeKeys(hashKey, rangeKey));
        } else {
          unProcessedIds.add(hashKey);

        }
      }
    }
    return unProcessedIds;
  }

}