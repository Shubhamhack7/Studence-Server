package com.tiwari.studence.common.entity;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.controlflow.CreateTableCF;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.encoder.Base64IntegerEncoder;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.serverConfig.IServerListener;

@Singleton
public class GetAndUpdateEntity implements IGetEntityId {

  private IDynamoGetEntityTable m_dynamoGetEntityTable;
  private IDynamoPutTable m_dynamoPutTable;
  private Base64IntegerEncoder m_base64IntegerEncoder;
  private IServerListener m_serverListener;
  private TableNameUtil m_tableNameUtil;

  @Inject
  public GetAndUpdateEntity(IDynamoGetEntityTable dynamoGetEntityTable,
          IDynamoPutTable dynamoPutTable, Base64IntegerEncoder base64IntegerEncoder,
          IServerListener serverListener, TableNameUtil tableNameUtil) {
    m_dynamoGetEntityTable = dynamoGetEntityTable;
    m_dynamoPutTable = dynamoPutTable;
    m_base64IntegerEncoder = base64IntegerEncoder;
    m_serverListener = serverListener;
    m_tableNameUtil = tableNameUtil;
  }

  @Override
  public IFuture<Pair<Integer, String>, ErrorException> getNewEntityId() {
    GetAndUpdateEntityCF cf = new GetAndUpdateEntityCF(m_dynamoGetEntityTable, m_dynamoPutTable,
            m_base64IntegerEncoder, m_serverListener, m_tableNameUtil);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

}
