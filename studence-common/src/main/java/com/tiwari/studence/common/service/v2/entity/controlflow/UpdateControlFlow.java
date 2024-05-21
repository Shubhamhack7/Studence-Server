package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClient;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.index.SecondaryIndexGenerator;
import com.tiwari.studence.common.service.v2.requestBuilder.UpdateItemRequestBuilder;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

public class UpdateControlFlow<R extends GeneratedMessageV3>
        extends AControlFlow<UpdateControlFlow.State, R, ErrorException> {
  enum State {
    UPDATE_STORE,
    DONE
  }

  private final DynamoDbTableInfo<?> m_dbInfo;
  private final UpdateItemRequestBuilder<?> m_requestBuilder;
  private final SecondaryIndexGenerator<R> m_secondaryIndexGenerator;
  private final R m_entity;
  private final String m_id;
  private final int m_version;

  public UpdateControlFlow(DynamoDbTableInfo<?> dbInfo, UpdateItemRequestBuilder<?> requestBuilder,
          SecondaryIndexGenerator<R> secondaryIndexGenerator, R entity, String id, int version) {
    super(State.UPDATE_STORE, State.DONE);
    m_dbInfo = dbInfo;
    m_entity = entity;
    m_requestBuilder = requestBuilder;
    m_secondaryIndexGenerator = secondaryIndexGenerator;
    m_id = id;
    m_version = version;
    addStateHandler(State.UPDATE_STORE, new UpdateStoreHandler());
  }

  private class UpdateStoreHandler implements StateHandler<State> {
    private IFuture<Void, ErrorException> m_updateFuture;

    @Override
    public void registerCalls() {
      Pair<AwsDynamoDbAsyncClient, String> dbClientAndtable = m_dbInfo
              .getDbClientAndTableName(m_id);
      PutItemRequest request = m_requestBuilder.createUpdateItemRequest(
              dbClientAndtable.getSecond(), m_entity, m_version, m_id,
              m_secondaryIndexGenerator.getAllSecondaryIndexes(m_entity));
      m_updateFuture = dbClientAndtable.getFirst().putItemAsync(request);
      registerFutures(m_updateFuture);
    }

    @Override
    public State handleState() {
      try {
        m_updateFuture.get();
        getAsyncCallback().set(0, m_entity);
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return State.DONE;
    }
  }
}