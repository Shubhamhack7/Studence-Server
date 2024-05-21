package com.tiwari.studence.common.controlflow;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.dynamodb.database.table.PutItemInDynamoDbTable;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.serverConfig.IServerListener;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@Singleton
public class PutItemDynamoTable implements IDynamoPutTable {
  private PutItemInDynamoDbTable m_putItemDynamoTable;
  private IServerListener m_serverListener;
  private TableNameUtil m_tableNameUtil;

  @Inject
  public PutItemDynamoTable(PutItemInDynamoDbTable putItemDynamoTable, TableNameUtil tableNameUtil,
          IServerListener serverListener) {
    m_putItemDynamoTable = putItemDynamoTable;
    m_tableNameUtil = tableNameUtil;
    m_serverListener = serverListener;
  }

  public IFuture<HashMap<String, AttributeValue>, ErrorException> putDbTable(String tablename,
          HashMap<String, AttributeValue> attributeValues) {
    Preconditions.validate(Strings.notEmpty(tablename), "Table Name is Empty");
    Preconditions.validate(attributeValues.size() != 0, "Data is Empty");
    PutTableCF cf = new PutTableCF(tablename, attributeValues, m_putItemDynamoTable,
            m_tableNameUtil, m_serverListener);
    cf.addLogObjects(tablename);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
