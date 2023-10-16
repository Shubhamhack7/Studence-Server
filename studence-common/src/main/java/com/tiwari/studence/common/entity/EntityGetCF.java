package com.tiwari.studence.common.entity;

import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.IConvertor;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class EntityGetCF<P extends GeneratedMessageV3,Lresp extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>, C extends IConvertor<P,Lresp>, T extends ITableNameProvider>
        extends AControlFlow<EntityGetCF.State, P, ErrorException> {

  private C m_convertor;
  private IDynamoGetEntityTable m_dynamoGetTable;
  private BP m_builderProvider;
  private T m_tableNameProvider;
  private String m_request;

  protected EntityGetCF(String request, C convertor, BP builderProvider, T tableNameProvider,
          IDynamoGetEntityTable dynamoGetTable) {
    super(State.GET_ENTITY, State.DONE);
    m_request = request;
    m_convertor = convertor;
    m_builderProvider = builderProvider;
    m_tableNameProvider = tableNameProvider;
    m_dynamoGetTable = dynamoGetTable;
    addStateHandler(State.GET_ENTITY, new GetEntity());
  }

  enum State {
    GET_ENTITY,
    DONE,
  }

  public class GetEntity implements StateHandler<State> {
    IFuture<Map<String, AttributeValue>, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_dynamoGetTable.getEntityDbTable(m_tableNameProvider.getTableName(), m_request);
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        P resp = m_convertor.convert(new HashMap<String, AttributeValue>(m_future.get()));
        getAsyncCallback().set(0, resp);
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }

  }

}
