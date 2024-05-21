package com.tiwari.studence.common.service.v2.interfaces;

import com.amazonaws.services.simpledb.model.SelectRequest;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.index.IndexPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.VoidException;

import java.util.List;

public interface IIndexTableStore extends IPbTableStore<IndexPb> {
  public IFuture<Void, ErrorException> deleteItem(String id);

  public IFuture<Pair<SearchResultSummaryUiPb, List<IndexPb>>, VoidException> search(
          SelectRequest req);

  public IFuture<Integer, VoidException> searchCount(SelectRequest req);


}
