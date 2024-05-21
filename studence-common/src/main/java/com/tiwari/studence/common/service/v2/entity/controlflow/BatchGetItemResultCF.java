package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClient;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.handler.BatchItemGetResultHandler;
import com.tiwari.studence.common.service.v2.requestBuilder.BatchItemGetRequestBuilder;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;

import java.util.Map;
import java.util.Set;

public class BatchGetItemResultCF<Pb extends GeneratedMessageV3> extends
        AControlFlow<BatchGetItemResultCF.State, Pair<Set<String>, Map<String, Pb>>, ErrorException> {
  enum State {
    LOOK_UP_STORE,
    PARSE_RESULT,
    DONE

  }

  private final Set<String> m_ids;
  private final DynamoDbTableInfo<?> m_clientTableInfo;
  private final BatchItemGetRequestBuilder<?> m_batchItemGetRequestBuilder;
  private final BatchItemGetResultHandler<Pb, ?> m_resultHandler;
  private final boolean m_isHashRangeRequest;
  private BatchGetItemResult m_result;

  public BatchGetItemResultCF(Set<String> ids, DynamoDbTableInfo<?> clientTableInfo,
          BatchItemGetRequestBuilder<?> batchItemGetRequestBuilder,
          BatchItemGetResultHandler<Pb, ?> resultHandler, boolean isHashRangeRequest) {
    super(State.LOOK_UP_STORE, State.DONE);
    m_ids = ids;
    m_clientTableInfo = clientTableInfo;
    m_batchItemGetRequestBuilder = batchItemGetRequestBuilder;
    m_resultHandler = resultHandler;
    m_isHashRangeRequest = isHashRangeRequest;
    addStateHandler(State.LOOK_UP_STORE, new LookUpStateHandler());
    addStateHandler(State.PARSE_RESULT, new ParseResultStateHandler());
  }

  private class LookUpStateHandler implements StateHandler<State> {
    IFuture<BatchGetItemResult, ErrorException> m_future;

    @Override
    public void registerCalls() {
      Map<String, String> keyWithTablePartition = getKeyWithTablePartition();
      BatchGetItemRequest request = m_batchItemGetRequestBuilder
              .createBatchGetItemRequest(keyWithTablePartition, m_isHashRangeRequest);
      m_future = m_clientTableInfo.getDbClientAndTableName(null).getFirst()
              .batchGetItemAsyn(request);
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        m_result = m_future.get();
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(Exceptions.handleThrowable(e));
        return State.DONE;
      }
      return State.PARSE_RESULT;
    }

  }

  private class ParseResultStateHandler implements StateHandler<State> {

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      Pair<Set<String>, Map<String, Pb>> result = m_resultHandler.getEntityData(m_result,
              m_isHashRangeRequest);
      getAsyncCallback().set(0, result);
      return State.DONE;
    }

  }

  private Map<String, String> getKeyWithTablePartition() {
    Map<String, String> keyWithTableName = Maps.newHashMap();
    for (String id : m_ids) {
      Pair<AwsDynamoDbAsyncClient, String> dbClientAndtable = m_clientTableInfo
              .getDbClientAndTableName(id);
      keyWithTableName.put(id, dbClientAndtable.getSecond());
    }
    return keyWithTableName;
  }
}
