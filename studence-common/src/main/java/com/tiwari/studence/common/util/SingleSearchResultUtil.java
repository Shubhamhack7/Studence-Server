package com.tiwari.studence.common.util;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class SingleSearchResultUtil {
  public <R extends GeneratedMessageV3> R getSingleSearchResult(
          Pair<SearchResultSummaryUiPb, List<R>> searchResults) {
    Preconditions.check(searchResults.getFirst().getTotalHits() <= 1);
    if (searchResults.getFirst().getTotalHits() == 1) {
      return searchResults.getSecond().get(0);
    }
    return null;
  }
}
