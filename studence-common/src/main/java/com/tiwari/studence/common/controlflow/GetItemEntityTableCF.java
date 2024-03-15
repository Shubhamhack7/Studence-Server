package com.tiwari.studence.common.controlflow;

import java.util.Map;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.dynamodb.database.table.GetItemFromDynamodbTable;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.serverConfig.IServerListener;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

public class GetItemEntityTableCF extends
        AControlFlow<GetItemEntityTableCF.State, Map<String, AttributeValue>, ErrorException> {

  private GetItemFromDynamodbTable m_getItemFromDynamodbTable;
  private TableNameUtil m_tableNameUtil;
  private IServerListener m_ServerListener;
  private String m_tableName;
  private String m_entity_id;

  protected GetItemEntityTableCF(String tableName, String entity_id,
          GetItemFromDynamodbTable getItemFromDynamodbTable, TableNameUtil tableNameUtil,
          IServerListener ServerListener) {
    super(State.GET_ID, State.DONE);
    m_getItemFromDynamodbTable = getItemFromDynamodbTable;
    m_tableName = tableName;
    m_tableNameUtil = tableNameUtil;
    m_entity_id = entity_id;
    m_ServerListener = ServerListener;
    addStateHandler(State.GET_ID, new GetEntityDynamoDbProd());
  }

  enum State {
    GET_ID,
    DONE
  }

  public class GetEntityDynamoDbProd implements StateHandler<State> {
    GetItemResponse m_future;

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      try {
        String[] id_split = m_entity_id.split(StudenceSpecialCharecterEnum.EXCLAMATION.getSign());
        m_future = m_getItemFromDynamodbTable.getDynamoDBItem(
                m_tableNameUtil.getTableOverServerEnvironmentType(
                        m_ServerListener.getEnvironmentType(), m_tableName),
                id_split[0], id_split[1]);
        getAsyncCallback().set(0, m_future.item());
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
      }
      return State.DONE;
    }

  }
}
