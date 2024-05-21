package com.tiwari.studence.common.service.v2.requestBuilder;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbNextTokenHelper;
import com.tiwari.studence.common.service.v2.helper.ScanFilterHelper;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.common.Strings;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class ScanTableRequestBuilder {

  private final DynamoDbNextTokenHelper m_helper;
  private final ScanFilterHelper m_filterHelper;

  public ScanRequest createScanTableRequest(String tableName, PaginationRequestUiPb pageRequest) {
    ScanRequest scanRequest = new ScanRequest().withTableName(tableName);
    if (pageRequest.getMaxResults() > 0) {
      scanRequest.setLimit(pageRequest.getMaxResults());
    }
    if (Strings.notEmpty(pageRequest.getStartToken())) {
      AttributeValue val = new AttributeValue();
      val.setS(pageRequest.getStartToken());
      Map<String, AttributeValue> map = Maps.newHashMap();
      map.put(EntityIndexAttributes.ITEM_ID.name(), val);
      scanRequest.setExclusiveStartKey(map);
    }

    return scanRequest;
  }

  @Inject
  public ScanTableRequestBuilder(DynamoDbNextTokenHelper helper, ScanFilterHelper filterHelper) {
    m_helper = helper;
    m_filterHelper = filterHelper;

  }

  public ScanRequest createScanTableRequest(String tableName, PaginationRequestUiPb pageRequest,
          Map<String, String> filterMap, Map<String, AttributeValue> mapStartKey) {
    ScanRequest scanRequest = new ScanRequest().withTableName(tableName);
    if (pageRequest.getMaxResults() > 0) {
      scanRequest.setLimit(pageRequest.getMaxResults());
    }
    if (mapStartKey != null) {
      scanRequest.setExclusiveStartKey(mapStartKey);
    }
    Map<String, Condition> map1 = Maps.newHashMap();
    if (!filterMap.isEmpty()) {
      map1 = m_filterHelper.applyFilter(filterMap);
      scanRequest.withScanFilter(map1);
    }

    return scanRequest;

  }

  public ScanRequest createScanTableRequest(String tableName, Map<String, AttributeValue> mapStartKey,
          Map<String, String> filterMap) {
    ScanRequest scanRequest = new ScanRequest().withTableName(tableName);
    if (mapStartKey != null) {
      scanRequest.setExclusiveStartKey(mapStartKey);
    }
    Map<String, Condition> map1 = Maps.newHashMap();
    if (!filterMap.isEmpty()) {
      map1 = m_filterHelper.applyFilter(filterMap);
      scanRequest.withScanFilter(map1);
    }

    return scanRequest;
  }
}
