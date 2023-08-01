package com.tiwari.studence.common.controlflow;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.controlflow.CreateTableCF.State;
import com.tiwari.studence.dynamodb.database.table.PutItemInDynamoDbTable;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.serverConfig.IServerListener;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

@Singleton
public class PutTableCF
        extends AControlFlow<PutTableCF.State, HashMap<String, AttributeValue>, ErrorException> {

  private PutItemInDynamoDbTable m_putItemDynamoTable;
  private TableNameUtil m_tableNameUtil;
  private String m_tableName;
  private IServerListener m_ServerListener;
  private HashMap<String, AttributeValue> m_attributeValues;

  enum State {
    IN_DYNAMO,
    IN_BQUERY,
    DONE
  }

  @Inject
  public PutTableCF(String tableName, HashMap<String, AttributeValue> attributeValues,
          PutItemInDynamoDbTable putItemDynamoTable, TableNameUtil tableNameUtil,
          IServerListener serverListener) {
    super(State.IN_DYNAMO, State.DONE);
    m_putItemDynamoTable = putItemDynamoTable;
    m_attributeValues = attributeValues;
    m_tableName = tableName;
    m_tableNameUtil = tableNameUtil;
    m_ServerListener = serverListener;
    addStateHandler(State.IN_DYNAMO, new InsertDynamoDb());
    addStateHandler(State.IN_BQUERY, new InsertBQuery());
  }

  public class InsertDynamoDb implements StateHandler<State> {
    PutItemResponse m_future;

    @Override
    public void registerCalls() {
      System.out.println(m_tableName);

    }

    @Override
    public State handleState() {
      try {
        m_future = m_putItemDynamoTable.putItem(m_tableNameUtil.getTableOverServerEnvironmentType(
                m_ServerListener.getEnvironmentType(), m_tableName), m_attributeValues);
        getAsyncCallback().set(0, new HashMap<String, AttributeValue>(m_future.attributes()));
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
      }
      return State.DONE;
    }

  }

  public class InsertBQuery implements StateHandler<State> {
    CreateTableResponse m_future;

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {

      return State.DONE;
    }

  }

}
