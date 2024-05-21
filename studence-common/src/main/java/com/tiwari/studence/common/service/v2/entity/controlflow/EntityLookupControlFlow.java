package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClient;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.handler.GetItemResultHandler;
import com.tiwari.studence.common.service.v2.requestBuilder.GetItemRequestBuilder;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

public class EntityLookupControlFlow<R extends GeneratedMessageV3>
        extends AControlFlow<EntityLookupControlFlow.State, R, ErrorException> {
  private final DynamoDbTableInfo<?> m_dbInfo;
  private final GetItemRequestBuilder<?> m_getRequestBuilder;
  private final GetItemResultHandler<R, ?> m_getResultHandler;
  private final String m_id;
  private GetItemRequest m_request;
  private IFuture<GetItemResult, ErrorException> m_lookupResult;

  enum State {
    LOOKUP_STORE,
    PARSE_PB,
    DONE;
  }

  public EntityLookupControlFlow(DynamoDbTableInfo<?> dbInfo,
          GetItemRequestBuilder<?> getRequestBuilder, GetItemResultHandler<R, ?> getResultHandler,
          String id) {
    super(State.LOOKUP_STORE, State.DONE);
    m_dbInfo = dbInfo;
    m_getRequestBuilder = getRequestBuilder;
    m_getResultHandler = getResultHandler;
    m_id = id;
    addStateHandler(State.LOOKUP_STORE, new LookupStoreHandler());
    addStateHandler(State.PARSE_PB, new ParsePbHandler());
  }

  private class LookupStoreHandler implements StateHandler<State> {
    @Override
    public void registerCalls() {
      Pair<AwsDynamoDbAsyncClient, String> dbClientAndtable = m_dbInfo
              .getDbClientAndTableName(m_id);
      m_request = m_getRequestBuilder.createGetItemRequest(dbClientAndtable.getSecond(), m_id);
      m_lookupResult = dbClientAndtable.getFirst().getItemAsync(m_request);
      registerFutures(m_lookupResult);
    }

    @Override
    public State handleState() {
      try {
        m_lookupResult.get();
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
        return State.DONE;
      }
      return State.PARSE_PB;
    }
  }

  private class ParsePbHandler implements StateHandler<State> {
    @Override
    public void registerCalls() {
    }

    @Override
    public State handleState() {
      try {
        R entityData = m_getResultHandler.getEntityData(m_lookupResult.get());
        if (entityData == null) {
          throw new ErrorException(ErrorTypePbEnum.NOT_FOUND, m_id, m_request);
        }
        getAsyncCallback().set(0, entityData);
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return State.DONE;
    }
  }
}
