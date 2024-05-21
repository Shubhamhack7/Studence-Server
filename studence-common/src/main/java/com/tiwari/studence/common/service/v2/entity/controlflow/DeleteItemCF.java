package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClient;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.requestBuilder.DeleteRangeItemRequestBuilder;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

public class DeleteItemCF extends AControlFlow<DeleteItemCF.State, Void, ErrorException> {
  private final String m_id;
  private final String m_rangeKey;
  private final DynamoDbTableInfo<?> m_dbInfo;
  private final DeleteRangeItemRequestBuilder m_requestBuilder;

  public DeleteItemCF(String id, String rangeKey, DynamoDbTableInfo<?> dbInfo,
          DeleteRangeItemRequestBuilder requestBuilder) {
    super(State.DELETE_STORE, State.DONE);
    m_id = id;
    m_rangeKey = rangeKey;
    m_dbInfo = dbInfo;
    m_requestBuilder = requestBuilder;

    addStateHandler(State.DELETE_STORE, new DeleteStoreHandler());
  }

  enum State {
    DELETE_STORE,
    DONE
  }

  private class DeleteStoreHandler implements StateHandler<State> {
    private IFuture<DeleteItemResult, ErrorException> m_deleteFuture;

    @Override
    public void registerCalls() {
      String partitionId = m_id + "@" + m_rangeKey;
      Pair<AwsDynamoDbAsyncClient, String> dbClientAndtable = m_dbInfo
              .getDbClientAndTableName(partitionId);
      DeleteItemRequest delRequest = m_requestBuilder.createDeleteItemRequest(
              dbClientAndtable.getSecond(), m_id, m_rangeKey);
      m_deleteFuture = dbClientAndtable.getFirst().deleteItemAsyn(delRequest);
      registerFutures(m_deleteFuture);
    }

    @Override
    public State handleState() {
      try {
        m_deleteFuture.get();
        // /getAsyncCallback().set(0, m_deleteFuture.get());
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return State.DONE;
    }

  }
}
