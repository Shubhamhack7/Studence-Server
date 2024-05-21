package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClient;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.handler.RangeResultHandler;
import com.tiwari.studence.common.service.v2.interfaces.ISecondaryIndexEntity;
import com.tiwari.studence.common.service.v2.requestBuilder.RangeRequestBuilder;
import com.tiwari.studence.common.service.v2.table.ATablePartitioner;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.proto.search.TablePartitionInfoUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.VoidException;

import java.util.List;

public class GetSmallestCF<Pb extends GeneratedMessageV3> extends
        AControlFlow<GetSmallestCF.State, Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> {
  private final DynamoDbTableInfo<?> m_dbInfo;
  private final ISecondaryIndexEntity m_secondaryIndexEntity;
  private final RangeRequestBuilder m_getRequestBuilder;
  private final RangeResultHandler<Pb, ?> m_getResultHandler;
  private final String m_id;
  private final String m_rangeKey;
  private final boolean m_includeMatch;
  private QueryRequest m_request;
  private String m_partitionKey;
  private IFuture<QueryResult, VoidException> m_searchResult;
  private final TablePartitionInfoUiPb m_tablePartitionInfo;
  private final PaginationRequestUiPb m_pagination;
  private final ATablePartitioner m_tablePartitioner;

  enum State {
    LOOKUP_STORE,
    PARSE_PB,
    DONE;
  }

  public GetSmallestCF(DynamoDbTableInfo<?> dbInfo, ISecondaryIndexEntity secondaryIndexEntity,
          RangeRequestBuilder getRequestBuilder, RangeResultHandler<Pb, ?> getResultHandler,
          String id, String rangeKey, boolean includeMatch, TablePartitionInfoUiPb tablePartition,
          PaginationRequestUiPb pagination, ATablePartitioner tablePartitioner) {
    super(State.LOOKUP_STORE, State.DONE);
    m_dbInfo = dbInfo;
    m_secondaryIndexEntity = secondaryIndexEntity;
    m_getRequestBuilder = getRequestBuilder;
    m_getResultHandler = getResultHandler;
    m_id = id;
    m_rangeKey = rangeKey;
    m_includeMatch = includeMatch;
    m_tablePartitionInfo = tablePartition;
    m_pagination = pagination;
    m_tablePartitioner = tablePartitioner;
    addStateHandler(State.LOOKUP_STORE, new LookupStoreHandler());
    addStateHandler(State.PARSE_PB, new ParsePbHandler());
  }

  private class LookupStoreHandler implements StateHandler<State> {

    @Override
    public void registerCalls() {
      Pair<String, PaginationRequestUiPb> partitionKeyAndPagination = m_tablePartitioner.getPartitionKeyAndPagination(
              m_tablePartitionInfo, m_pagination, true);
      m_partitionKey = partitionKeyAndPagination.getFirst();
      PaginationRequestUiPb pagination = partitionKeyAndPagination.getSecond();
      Pair<AwsDynamoDbAsyncClient, String> tableClientAndName = m_dbInfo.getDbClientAndTableNameWithTablePartitionKey(
              m_partitionKey);
      m_request = m_getRequestBuilder.createSmallestRequest(tableClientAndName.getSecond(),
              m_secondaryIndexEntity, m_id, m_rangeKey, m_includeMatch, pagination.getStartToken(),
              pagination.getMaxResults());
      m_searchResult = tableClientAndName.getFirst().rangeQueryAsync(m_request);
      registerFutures(m_searchResult);
    }

    @Override
    public State handleState() {
      return State.PARSE_PB;
    }
  }

  private class ParsePbHandler implements StateHandler<State> {

    @Override
    public void registerCalls() {
    }

    @Override
    public State handleState() {
      Pair<SearchResultSummaryUiPb, List<Pb>> entityData = m_getResultHandler.getResult(
              m_searchResult.get(), m_secondaryIndexEntity);
      SearchResultSummaryUiPb resultSummary = m_tablePartitioner.getSearchResultSummaryWithTablePartition(
              entityData.getFirst(), m_tablePartitionInfo, m_partitionKey, true);
      List<Pb> results = entityData.getSecond();
      getAsyncCallback().set(0,
              new Pair<SearchResultSummaryUiPb, List<Pb>>(resultSummary, results));
      return State.DONE;
    }
  }
}
