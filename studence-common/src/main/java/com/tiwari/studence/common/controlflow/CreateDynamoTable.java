package com.tiwari.studence.common.controlflow;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoCreateTable;
import com.tiwari.studence.database.table.CreateDynamoDbTable;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;

@Singleton
public class CreateDynamoTable implements IDynamoCreateTable{

  private CreateDynamoDbTable m_createDynamoDbTable;
  private TableNameUtil m_tableNameUtil;

  @Inject
  public CreateDynamoTable(CreateDynamoDbTable createDynamoDbTable, TableNameUtil tableNameUtil) {
    m_createDynamoDbTable = createDynamoDbTable;
    m_tableNameUtil = tableNameUtil;
  }

  public IFuture<String, ErrorException> createDbTable(String tablename) {
    Preconditions.validate(Strings.notEmpty(tablename), "Table Name is Empty");
    CreateTableCF cf = new CreateTableCF(tablename, m_createDynamoDbTable, m_tableNameUtil);
    cf.addLogObjects(tablename);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

}
