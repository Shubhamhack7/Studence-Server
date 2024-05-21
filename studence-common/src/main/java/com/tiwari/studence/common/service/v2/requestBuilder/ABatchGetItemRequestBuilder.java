package com.tiwari.studence.common.service.v2.requestBuilder;

import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.interfaces.IDbInfo;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.util.collect.Lists;

import java.util.List;
import java.util.Map;

public abstract class ABatchGetItemRequestBuilder<T extends ITables, forDb extends IDbInfo, R> {
  private final int m_tableMaxAttributeSize;
  private final int m_dbMaxAttributeSize;

  protected ABatchGetItemRequestBuilder(T forTables, forDb forDB) {
    m_tableMaxAttributeSize = forTables.getTableMaxAttributesSize();
    m_dbMaxAttributeSize = forDB.getDBMaxAttributesSize();
  }

  public R createBatchGetItemRequest(Map<String, String> keyWithTablePatition,
          boolean isRangeRequest) {
    int numberOfRawData = (int) Math
            .ceil(((double) m_tableMaxAttributeSize) / m_dbMaxAttributeSize);
    List<String> attributesNameList = Lists.newArrayList();
    for (int index = 0; index < numberOfRawData; ++index) {
      attributesNameList.add(EntityIndexAttributes.RAW_DATA.name() + "_" + String.valueOf(index));
    }
    return createRequestInternal(keyWithTablePatition, attributesNameList, isRangeRequest);
  }

  protected abstract R createRequestInternal(Map<String, String> keyWithTablePatition,
          List<String> attrList, boolean isRangeRequest);
}