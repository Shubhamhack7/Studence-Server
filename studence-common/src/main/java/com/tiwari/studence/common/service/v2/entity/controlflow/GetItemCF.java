package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClient;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.handler.RangeResultHandler;
import com.tiwari.studence.common.service.v2.requestBuilder.RangeRequestBuilder;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.VoidException;

public class GetItemCF<Pb extends GeneratedMessageV3>
        extends AControlFlow<GetItemCF.State, Pb, ErrorException> {
  private final DynamoDbTableInfo<?> m_dbInfo;
  private final RangeRequestBuilder m_getRequestBuilder;
  private final RangeResultHandler<Pb, ?> m_getResultHandler;
  private final String m_id;
  private final String m_rangeKey;
  private QueryRequest m_request;
  IFuture<QueryResult, VoidException> m_searchResult;

  enum State {
    LOOKUP_STORE,
    PARSE_PB,
    DONE;
  }

  public GetItemCF(DynamoDbTableInfo<?> dbInfo, RangeRequestBuilder getRequestBuilder,
          RangeResultHandler<Pb, ?> getResultHandler, String id, String rangeKey) {
    super(State.LOOKUP_STORE, State.DONE);
    m_dbInfo = dbInfo;
    m_getRequestBuilder = getRequestBuilder;
    m_getResultHandler = getResultHandler;
    m_id = id;
    m_rangeKey = rangeKey;
    addStateHandler(State.LOOKUP_STORE, new LookupStoreHandler());
    addStateHandler(State.PARSE_PB, new ParsePbHandler());
  }

  private class LookupStoreHandler implements StateHandler<State> {
    @Override
    public void registerCalls() {
      String partitionId = m_id + "@" + m_rangeKey;
      Pair<AwsDynamoDbAsyncClient, String> dbClientAndtable = m_dbInfo.getDbClientAndTableName(
              partitionId);
      m_request = m_getRequestBuilder.createGetRequest(dbClientAndtable.getSecond(), m_id,
              m_rangeKey);
      m_searchResult = dbClientAndtable.getFirst().rangeQueryAsync(m_request);
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
      Pb data = m_getResultHandler.getSingleResult(m_searchResult.get());
      if (data != null) {
        getAsyncCallback().set(0, data);
      } else {
        getAsyncCallback().handleException(0,
                new ErrorException(ErrorTypePbEnum.NOT_FOUND, m_id, m_rangeKey));
      }
      return State.DONE;
    }
  }
}
