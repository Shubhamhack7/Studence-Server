package com.tiwari.studence.common.entity;

import java.util.HashMap;
import java.util.Map;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.encoder.Base64IntegerEncoder;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.serverConfig.IServerListener;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class GetAndUpdateEntityCF
        extends AControlFlow<GetAndUpdateEntityCF.State, Pair<Integer, String>, ErrorException> {

  private IDynamoGetEntityTable m_dynamoGetEntityTable;
  private IDynamoPutTable m_dynamoPutTable;
  private Base64IntegerEncoder m_base64IntegerEncoder;
  private IServerListener m_serverListener;
  private TableNameUtil m_tableNameUtil;
  private String TABLE_NAME = "00_ENTITY";
  private String TABLE_NAME_ENV = "";
  private String KEY = "KEY";
  private Map<String, AttributeValue> m_resp;
  private Pair<Integer, String> m_new_id;

  protected GetAndUpdateEntityCF(IDynamoGetEntityTable dynamoGetEntityTable,
          IDynamoPutTable dynamoPutTable, Base64IntegerEncoder base64IntegerEncoder,
          IServerListener serverListener, TableNameUtil tableNameUtil) {
    super(State.GET_ENTITY, State.DONE);
    m_dynamoGetEntityTable = dynamoGetEntityTable;
    m_dynamoPutTable = dynamoPutTable;
    m_base64IntegerEncoder = base64IntegerEncoder;
    m_serverListener = serverListener;
    m_tableNameUtil = tableNameUtil;
    addStateHandler(State.GET_ENTITY, new GetEntityHandler());
    addStateHandler(State.PROCESS_ENTITY, new ProcessesEntityHandler());
    addStateHandler(State.UPDATE_ENTITY, new UpdateEntityHandler());
  }

  enum State {
    GET_ENTITY,
    PROCESS_ENTITY,
    UPDATE_ENTITY,
    DONE
  }

  public class GetEntityHandler implements StateHandler<State> {
    IFuture<Map<String, AttributeValue>, ErrorException> m_future;

    @Override
    public void registerCalls() {
//      TABLE_NAME_ENV = m_tableNameUtil
//              .getTableOverServerEnvironmentType(m_serverListener.getEnvironmentType(), TABLE_NAME);
      System.out.println(TABLE_NAME_ENV);
      m_future = m_dynamoGetEntityTable.getEntityDbTable(TABLE_NAME, "ENTITY!ID");
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        m_resp = m_future.get();
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.PROCESS_ENTITY;
    }

  }

  public class ProcessesEntityHandler implements StateHandler<State> {

    @Override
    public void registerCalls() {

    }

    @Override
    public State handleState() {
      try {
        int value = Integer.parseInt(m_resp.get(KEY).s().toString());
        String string_val = m_base64IntegerEncoder.convert(value);
        m_new_id = new Pair<Integer, String>(value, string_val);
        value = value + 1;
        AttributeValue bu = AttributeValue.builder().s(String.valueOf(value)).build();
        HashMap<String, AttributeValue> resp  = new HashMap<String, AttributeValue>(m_resp);
        resp.put(KEY, bu);
        m_resp = resp;
      } catch (Exception e) {
        getAsyncCallback().handleException(0, new ErrorException(e));
        return State.DONE;
      }
      return State.UPDATE_ENTITY;
    }

  }

  public class UpdateEntityHandler implements StateHandler<State> {
    IFuture<HashMap<String, AttributeValue>, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_dynamoPutTable.putDbTable(TABLE_NAME,
              new HashMap<String, AttributeValue>(m_resp));
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        m_resp = m_future.get();
        getAsyncCallback().set(0, m_new_id);
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }

  }

}
