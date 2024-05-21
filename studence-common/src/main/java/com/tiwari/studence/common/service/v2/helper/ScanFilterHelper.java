package com.tiwari.studence.common.service.v2.helper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.tiwari.studence.util.collect.Maps;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class ScanFilterHelper {

  public Map<String, Condition> applyFilter(Map<String, String> filter) {

    String enumValue = null, value = null;
    for (String key : filter.keySet()) {
      enumValue = key;

    }

    for (String v : filter.values()) {
      value = v;

    }

    Condition keyCondition = new Condition().withComparisonOperator(
            ComparisonOperator.EQ).withAttributeValueList(
            new AttributeValue().withS(value));
    Map<String, Condition> map1 = Maps.newHashMap();
    map1.put(enumValue, keyCondition);
    return map1;
  }
}
