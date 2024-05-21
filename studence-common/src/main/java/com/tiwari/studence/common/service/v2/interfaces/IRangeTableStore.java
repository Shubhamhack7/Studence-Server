package com.tiwari.studence.common.service.v2.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.proto.search.TablePartitionInfoUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.VoidException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRangeTableStore<Pb extends GeneratedMessageV3> {

  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> filerDeletedEntries(
          final IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> iFuture);

  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> getRange(String id,
          String startKey, String endKey, boolean ascending, TablePartitionInfoUiPb partitionUiPb,
          PaginationRequestUiPb pagination);

  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> getPrefixRange(String id,
          String beginKey, boolean ascending, TablePartitionInfoUiPb partitionUiPb,
          PaginationRequestUiPb pagination);

  public IFuture<Pb, ErrorException> createItem(String id, String rangeKey, Pb pb);

  public IFuture<Pb, ErrorException> updateItem(String id, String rangeKey, Pb pb, int version);

  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> getLargest(String id,
          String rangeKey, boolean includeMatch, TablePartitionInfoUiPb partitionUiPb,
          PaginationRequestUiPb pagination);

  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> getSmallest(String id,
          String rangeKey, boolean includeMatch, TablePartitionInfoUiPb partitionUiPb,
          PaginationRequestUiPb pagination);

  public IFuture<Pb, ErrorException> get(String id, String rangeKey);

  public IFuture<Void, ErrorException> deleteEntity(String id, String rangeKey);

  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, ErrorException> getScanTable(
          PaginationRequestUiPb request, Map<String, String> map,
          TablePartitionInfoUiPb partitionUiPb);

  public IFuture<Pair<Set<String>,Map<String, Pb>>, ErrorException> batchGetItem(Set<String> idList);

}
