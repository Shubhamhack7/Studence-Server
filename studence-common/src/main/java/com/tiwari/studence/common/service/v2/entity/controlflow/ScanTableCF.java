package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClient;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.handler.ScanResultHandler;
import com.tiwari.studence.common.service.v2.helper.DynamoDbNextTokenWithTablePartitionHelper;
import com.tiwari.studence.common.service.v2.requestBuilder.ScanTableRequestBuilder;
import com.tiwari.studence.common.service.v2.table.ATablePartitioner;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.proto.search.TablePartitionInfoUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.List;
import java.util.Map;

public class ScanTableCF<Pb extends GeneratedMessageV3> extends
        AControlFlow<ScanTableCF.State, Pair<SearchResultSummaryUiPb, List<Pb>>, ErrorException> {
  private final DynamoDbTableInfo<?> m_dbInfo;
  private final ScanTableRequestBuilder m_requestBuilder;
  private final ScanResultHandler<Pb, ?> m_scanResultHandler;
  private final PaginationRequestUiPb m_pageRequest;
  private final Map<String, String> m_filter;
  private final DynamoDbNextTokenWithTablePartitionHelper m_dynamoDbNextTokenWithTablePartitionHelper;
  private final ATablePartitioner m_tablePartitioner;
  private final TablePartitionInfoUiPb m_tablePartitionInfo;
  private ScanResult m_result;
  private String m_partitionKey;

  public ScanTableCF(ATablePartitioner tablePartitioner, TablePartitionInfoUiPb tablePartitionInfo,
          DynamoDbNextTokenWithTablePartitionHelper dynamoDbNextTokenWithTablePartitionHelper,
          DynamoDbTableInfo<?> dbInfo, ScanTableRequestBuilder request,
          PaginationRequestUiPb pageRequest, ScanResultHandler<Pb, ?> scanResultHandler,
          Map<String, String> mapFilter) {
    super(State.SCANTABLE, State.DONE);
    m_requestBuilder = request;
    m_dbInfo = dbInfo;
    m_pageRequest = pageRequest;
    m_scanResultHandler = scanResultHandler;
    m_filter = mapFilter;
    m_tablePartitioner = tablePartitioner;
    m_dynamoDbNextTokenWithTablePartitionHelper = dynamoDbNextTokenWithTablePartitionHelper;
    m_tablePartitionInfo = tablePartitionInfo;
    addStateHandler(State.SCANTABLE, new ScanTableHandler());
    addStateHandler(State.CREATE_RESPONSE, new CreateResponseHandler());
  }

  enum State {
    SCANTABLE,
    CREATE_RESPONSE,
    DONE

  }

  private class ScanTableHandler implements StateHandler<State> {
    IFuture<ScanResult, ErrorException> m_scanResult;

    @Override
    public void registerCalls() {
      Pair<String, PaginationRequestUiPb> partitionKeyAndPagination = m_tablePartitioner
              .getPartitionKeyAndPagination(m_tablePartitionInfo, m_pageRequest, true);
      m_partitionKey = partitionKeyAndPagination.getFirst();
      PaginationRequestUiPb pagination = partitionKeyAndPagination.getSecond();
      Map<String, AttributeValue> map = m_dynamoDbNextTokenWithTablePartitionHelper
              .getStartKey(null, pagination.getStartToken());
      Pair<AwsDynamoDbAsyncClient, String> dbClientAndtabl = m_dbInfo
              .getDbClientAndTableNameWithTablePartitionKey(m_partitionKey);
      ScanRequest scanRequest = m_requestBuilder.createScanTableRequest(dbClientAndtabl.getSecond(),
              m_pageRequest, m_filter, map);
      m_scanResult = dbClientAndtabl.getFirst().scanTableAsyn(scanRequest);
      registerFutures(m_scanResult);
    }

    @Override
    public State handleState() {

      try {
        m_result = m_scanResult.get();
        return State.CREATE_RESPONSE;

      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
        return State.DONE;
      }
    }
  }

  private class CreateResponseHandler implements StateHandler<State> {
    @Override
    public void registerCalls() {
    }

    @Override
    public State handleState() {
      Pair<SearchResultSummaryUiPb, List<Pb>> entityData = m_scanResultHandler.getResult(m_result);
      SearchResultSummaryUiPb resultSummary = m_tablePartitioner
              .getSearchResultSummaryWithTablePartition(entityData.getFirst(), m_tablePartitionInfo,
                      m_partitionKey, true);
      List<Pb> results = entityData.getSecond();
      getAsyncCallback().set(0,
              new Pair<SearchResultSummaryUiPb, List<Pb>>(resultSummary, results));
      return State.DONE;
    }

  }
}
