package com.tiwari.studence.common.service.v1.controlflow;

import javax.inject.Inject;

import com.google.inject.Singleton;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.dynamodb.database.table.CreateDynamoDbTable;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;

@Singleton
public class CreateTableCF extends AControlFlow<CreateTableCF.State, String, ErrorException> {

  private CreateDynamoDbTable m_createDynamoDbTable;
  private TableNameUtil m_tableNameUtil;
  private String m_tableName;

  @Inject
  protected CreateTableCF(String tableName, CreateDynamoDbTable createDynamoDbTable,
          TableNameUtil tableNameUtil) {
    super(State.DYNAMO_DB_PROD, State.DONE);
    m_createDynamoDbTable = createDynamoDbTable;
    m_tableName = tableName;
    m_tableNameUtil = tableNameUtil;
    addStateHandler(State.DYNAMO_DB_PROD, new CreateDynamoDbProd());
    addStateHandler(State.DYNAMO_DB_DEVEL, new CreateDynamoDbDevel());
  }

  enum State {
    DYNAMO_DB_PROD,
    DYNAMO_DB_DEVEL,
    DONE
  }

  public class CreateDynamoDbProd implements StateHandler<State> {
    CreateTableResponse m_future;

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      try {
        m_future = m_createDynamoDbTable.createTable(m_tableNameUtil.getDynamoProd(m_tableName));
        getAsyncCallback().set(0, m_future.responseMetadata().requestId());
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DYNAMO_DB_DEVEL;
    }

  }

  public class CreateDynamoDbDevel implements StateHandler<State> {
    CreateTableResponse m_future;

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      try {
        m_future = m_createDynamoDbTable.createTable(m_tableNameUtil.getDynamoDevel(m_tableName));
        getAsyncCallback().set(0, m_future.responseMetadata().requestId());
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }

  }

}
