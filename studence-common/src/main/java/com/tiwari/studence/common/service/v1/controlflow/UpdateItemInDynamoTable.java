package com.tiwari.studence.common.service.v1.controlflow;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.dynamodb.database.helper.DynamoDBSearchHelper;
import com.tiwari.studence.dynamodb.database.table.UpdateItemInDynamoDbTable;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.serverConfig.IServerListener;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class UpdateItemInDynamoTable implements IDynamoUpdateTable {

  private UpdateItemInDynamoDbTable m_updateItemInDynamoDbTable;
  private TableNameUtil m_tableNameUtil;
  private IServerListener m_ServerListener;
  private DynamoDBSearchHelper m_helper;

  @Inject
  public UpdateItemInDynamoTable(UpdateItemInDynamoDbTable updateItemInDynamoDbTable,
          TableNameUtil tableNameUtil, IServerListener serverListener) {
    m_updateItemInDynamoDbTable = updateItemInDynamoDbTable;
    m_tableNameUtil = tableNameUtil;
    m_ServerListener = serverListener;
  }

  @Override
  public IFuture<HashMap<String, AttributeValue>, ErrorException> updateDbTable(String tablename,
          HashMap<String, AttributeValue> keys, HashMap<String, AttributeValue> attributeValues) {
    Preconditions.validate(Strings.notEmpty(tablename), "Table Name is Empty");
    Preconditions.validate(attributeValues.size() != 0, "Data is Empty");
    UpdateItemCF cf = new UpdateItemCF(tablename, attributeValues, keys,
            m_updateItemInDynamoDbTable, m_tableNameUtil, m_ServerListener);
    cf.addLogObjects(tablename);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
