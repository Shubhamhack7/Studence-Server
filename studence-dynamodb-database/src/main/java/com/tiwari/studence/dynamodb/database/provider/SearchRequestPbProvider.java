package com.tiwari.studence.dynamodb.database.provider;

import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.provider.interfaces.IPbBuilderProvider;

public class SearchRequestPbProvider
        implements IPbBuilderProvider<SearchRequestsPb, SearchRequestsPb.Builder> {
  @Override
  public SearchRequestsPb.Builder getBuilder() {
    return SearchRequestsPb.newBuilder();
  }

  @Override
  public SearchRequestsPb.Builder getBuilder(SearchRequestsPb builder) {
    return SearchRequestsPb.newBuilder(builder);
  }
}
