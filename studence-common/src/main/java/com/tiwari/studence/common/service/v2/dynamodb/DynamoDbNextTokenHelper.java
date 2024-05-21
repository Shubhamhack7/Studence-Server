package com.tiwari.studence.common.service.v2.dynamodb;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.util.RangeHashKeyConcatinator;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.collect.Pair;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class DynamoDbNextTokenHelper {

  private final RangeHashKeyConcatinator m_split;

  @Inject
  public DynamoDbNextTokenHelper(RangeHashKeyConcatinator split) {
    m_split = split;
  }

  public Map<String, AttributeValue> getValue(PaginationRequestUiPb page) {
    Map<String, AttributeValue> map = Maps.newHashMap();
    String value = page.getStartToken();
    if (value.contains("@")) {
      Pair<String, String> pair = m_split.splitHashRangeKeys(value);
      AttributeValue hashKey = new AttributeValue();
      hashKey.setS(pair.getFirst());
      AttributeValue rangeKey = new AttributeValue();
      rangeKey.setS(pair.getSecond());
      map.put(EntityIndexAttributes.ITEM_ID.name(), hashKey);
      map.put(EntityIndexAttributes.RANGE_KEY.name(), rangeKey);
    } else {
      AttributeValue val = new AttributeValue();
      val.setS(value);
      map.put(EntityIndexAttributes.ITEM_ID.name(), val);

    }

    return map;
  }
}
