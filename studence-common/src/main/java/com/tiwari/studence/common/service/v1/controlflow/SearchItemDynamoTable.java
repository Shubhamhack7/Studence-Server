package com.tiwari.studence.common.service.v1.controlflow;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.dynamodb.database.helper.DynamoDBSearchHelper;
import com.tiwari.studence.dynamodb.database.table.SearchItemInDynamoDbTable;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.serverConfig.IServerListener;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Singleton
public class SearchItemDynamoTable implements IDynamoSearchTable {

  private SearchItemInDynamoDbTable m_searchItemInDynamoDbTable;
  private TableNameUtil m_tableNameUtil;
  private IServerListener m_ServerListener;
  private DynamoDBSearchHelper m_helper;

  @Inject
  SearchItemDynamoTable(SearchItemInDynamoDbTable searchItemInDynamoDbTable,
          TableNameUtil tableNameUtil, IServerListener ServerListener,
          DynamoDBSearchHelper helper) {
    m_helper = helper;
    m_tableNameUtil = tableNameUtil;
    m_ServerListener = ServerListener;
    m_searchItemInDynamoDbTable = searchItemInDynamoDbTable;
  }

  @Override
  public IFuture<Pair<Set<Map.Entry<String, AttributeValue>>, List<Map<String, AttributeValue>>>, ErrorException> searchDbTable(
          String tablename, SearchRequestsPb build) {
    Preconditions.validate(Strings.notEmpty(tablename), "Table Name is Empty");
    Preconditions.validate(build.getRequestsList().size() != 0, "Data is Empty");
    SearchItemCF cf = new SearchItemCF(tablename, build, m_searchItemInDynamoDbTable, m_helper,
            m_tableNameUtil, m_ServerListener);
    cf.addLogObjects(tablename);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
