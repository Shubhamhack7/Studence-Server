package com.tiwari.studence.common.service.v2.handler;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.helper.DynamoDbNextTokenWithTablePartitionHelper;
import com.tiwari.studence.common.util.RangeHashKeyConcatinator;
import com.tiwari.studence.common.util.RawDataCombiner;
import com.tiwari.studence.common.util.SingleSearchResultUtil;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.common.Strings;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Singleton
public class ScanResultHandler<Pb extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>> {
  private final RawDataCombiner<Pb, B> m_rawDataCombiner;
  private final SingleSearchResultUtil m_singleSearchUtil;
  private final RangeHashKeyConcatinator m_concat;
  private final DynamoDbNextTokenWithTablePartitionHelper m_nextTokenHelper;

  @Inject
  public ScanResultHandler(RawDataCombiner<Pb, B> rawDataCombiner,
          SingleSearchResultUtil singleSearchUtil, RangeHashKeyConcatinator concat,
          DynamoDbNextTokenWithTablePartitionHelper nextTokenHelper) {
    m_rawDataCombiner = rawDataCombiner;
    m_singleSearchUtil = singleSearchUtil;
    m_concat = concat;
    m_nextTokenHelper = nextTokenHelper;
  }

  public Pb getSingleResult(ScanResult result) {
    return m_singleSearchUtil.getSingleSearchResult(getResult(result));
  }

  public Pair<SearchResultSummaryUiPb, List<Pb>> getResult(ScanResult result) {
    Pair<SearchResultSummaryUiPb, List<Map<String, String>>> searchResults = getResultInternal(
            result);
    List<Pb> items = Lists.newArrayList();

    for (Map<String, String> itemData : searchResults.getSecond()) {
      items.add(m_rawDataCombiner.getData(itemData));

    }
    return new Pair<SearchResultSummaryUiPb, List<Pb>>(searchResults.getFirst(), items);
  }

  private Pair<SearchResultSummaryUiPb, List<Map<String, String>>> getResultInternal(
          ScanResult result) {
    List<Map<String, String>> results = getItems(result.getItems());
    SearchResultSummaryUiPb.Builder summary = SearchResultSummaryUiPb.newBuilder();
    summary.setTotalHits(result.getCount());
    String nextToken = m_nextTokenHelper.getNextToken(null, result.getLastEvaluatedKey());
    if (Strings.notEmpty(nextToken)) {
      summary.setNextToken(nextToken);
    }
    return new Pair<SearchResultSummaryUiPb, List<Map<String, String>>>(summary.build(), results);

  }

  private List<Map<String, String>> getItems(List<Map<String, AttributeValue>> items) {
    List<Map<String, String>> results = Lists.newArrayList();
    for (Map<String, AttributeValue> item : items) {
      Map<String, String> itemData = Maps.newHashMap();
      results.add(itemData);
      for (Map.Entry<String, AttributeValue> attr : item.entrySet()) {
        itemData.put(attr.getKey(), attr.getValue().getS());
      }
    }
    return results;
  }
}
