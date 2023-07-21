package com.tiwari.studence.common.entity;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.IConvertor;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.exception.ErrorException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEntityCF<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>, Lresp extends GeneratedMessageV3, C extends IConvertor<P, Lresp>, T extends ITableNameProvider>
        extends AControlFlow<SearchEntityCF.State, Lresp, ErrorException> {
  private C m_convertor;
  private T m_tableNameProvider;

  private BP m_builderProvider;

  private IDynamoSearchTable m_searchDynamoDb;
  private SearchRequestsPb m_request;

  public SearchEntityCF(SearchRequestsPb request, C convertor, T tableNameProvider,
          IDynamoSearchTable searchDynamoDb) {
    super(State.SEARCH, State.DONE);
    m_request = request;
    m_convertor = convertor;
    m_tableNameProvider = tableNameProvider;
    m_searchDynamoDb = searchDynamoDb;
    addStateHandler(State.SEARCH, new SearchHandler());
  }

  enum State {
    SEARCH,
    DONE,
  }

  public class SearchHandler implements StateHandler<State> {
    IFuture<List<Map<String, AttributeValue>>, ErrorException> m_future = null;

    @Override
    public void registerCalls() {
      m_future = m_searchDynamoDb.searchDbTable(m_tableNameProvider.getTableName(), m_request);
    }

    @Override
    public State handleState() {
      try {
        List<HashMap<String, AttributeValue>> m_resp = Lists.newArrayList();
        GeneratedMessageV3 resp = null;
        if (m_future.get().size() != 0) {
          m_future.get().forEach(future -> {
            m_resp.add(new HashMap<String, AttributeValue>(future));
          });
          resp = m_convertor.searchRespConvert(m_resp);
          getAsyncCallback().set(0, (Lresp) resp);
        } else {
          getAsyncCallback().set(0, (Lresp) resp);
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return State.DONE;
    }

  }

}
