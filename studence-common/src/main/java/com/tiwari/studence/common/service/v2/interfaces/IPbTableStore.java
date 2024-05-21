package com.tiwari.studence.common.service.v2.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.index.IndexVersionPb;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.proto.search.TablePartitionInfoUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IPbTableStore<Pb extends GeneratedMessageV3> {
  public IFuture<Pb, ErrorException> getItem(String id);

  public IFuture<IndexVersionPb, ErrorException> getIndexVersion(String id);

  public IFuture<Pb, ErrorException> createItem(String id, Pb pb);

  public IFuture<Pb, ErrorException> updateItem(String id, Pb pb, int version);

  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, ErrorException> getScanTable(
          PaginationRequestUiPb request, Map<String, String> map,
          TablePartitionInfoUiPb partitionUiPb);

  public IFuture<Pair<Set<String>, Map<String, Pb>>, ErrorException> batchGetItem(
          Set<String> idList);

}

