package com.tiwari.studence.common.controlflow;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.dynamodb.database.table.GetItemFromDynamodbTable;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.serverConfig.IServerListener;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@Singleton
public class GetItemFroomDynamoTable implements IDynamoGetEntityTable {

  private GetItemFromDynamodbTable m_getItemFromDynamodbTable;
  private TableNameUtil m_tableNameUtil;
  private IServerListener m_ServerListener;

  @Inject
  public GetItemFroomDynamoTable(GetItemFromDynamodbTable getItemFromDynamodbTable,
          TableNameUtil tableNameUtil, IServerListener ServerListener) {
    m_getItemFromDynamodbTable = getItemFromDynamodbTable;
    m_tableNameUtil = tableNameUtil;
    m_ServerListener = ServerListener;
  }

  @Override
  public IFuture<Map<String, AttributeValue>, ErrorException> getEntityDbTable(String tablename,
          String entity_id) {
    Preconditions.validate(entity_id.contains(StudenceSpecialCharecterEnum.EXCLAMATION.getSign()),
            "Invalid id combination");
    GetItemEntityTableCF cf = new GetItemEntityTableCF(tablename, entity_id,
            m_getItemFromDynamodbTable, m_tableNameUtil, m_ServerListener);
    cf.addLogObjects(tablename);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

}
