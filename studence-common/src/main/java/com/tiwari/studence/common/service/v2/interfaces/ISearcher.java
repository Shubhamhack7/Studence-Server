package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.List;

public interface ISearcher<LReq, Resp> {
  public IFuture<Pair<SearchResultSummaryUiPb, List<Resp>>, ErrorException> search(LReq searchReq);

  public boolean canHandleSearch(LReq searchReq);
}
