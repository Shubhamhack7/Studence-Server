package com.tiwari.studence.common.service.v1.controlflow;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.dynamodb.database.table.UpdateItemInDynamoDbTable;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.serverConfig.IServerListener;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;

import java.util.HashMap;

public class UpdateItemCF extends
        AControlFlow<UpdateItemCF.State, HashMap<String, AttributeValue>, ErrorException> {

  private UpdateItemInDynamoDbTable m_updateItemDynamoTable;
  private TableNameUtil m_tableNameUtil;
  private String m_tableName;
  private IServerListener m_ServerListener;

  private HashMap<String, AttributeValue> m_keys;
  private HashMap<String, AttributeValue> m_attributeValues;

  protected UpdateItemCF(String tableName, HashMap<String, AttributeValue> attributeValues,HashMap<String, AttributeValue> keys,
          UpdateItemInDynamoDbTable putItemDynamoTable, TableNameUtil tableNameUtil,
          IServerListener serverListener) {
    super(State.IN_DYANMODB, State.DONE);
    m_updateItemDynamoTable = putItemDynamoTable;
    m_attributeValues = attributeValues;
    m_tableName = tableName;
    m_keys = keys;
    m_tableNameUtil = tableNameUtil;
    m_ServerListener = serverListener;
    addStateHandler(State.IN_DYANMODB, new InsertDynamoDb());
  }

  enum State {
    IN_DYANMODB,
    DONE,
  }

  public class InsertDynamoDb implements StateHandler<State> {
    UpdateItemResponse m_future;

    @Override
    public void registerCalls() {
      System.out.println(m_tableName);

    }

    @Override
    public State handleState() {
      try {

        m_future = m_updateItemDynamoTable.updateItem(m_tableNameUtil.getTableOverServerEnvironmentType(
                m_ServerListener.getEnvironmentType(), m_tableName),m_keys, m_attributeValues);
        getAsyncCallback().set(0, new HashMap<String, AttributeValue>(m_future.attributes()));
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
      }
      return State.DONE;
    }

  }
}
