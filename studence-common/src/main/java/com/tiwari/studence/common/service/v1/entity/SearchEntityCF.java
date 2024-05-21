package com.tiwari.studence.common.service.v1.entity;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.convertor.IConvertor;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchEntityCF<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>, Lreq extends GeneratedMessageV3, Lresp extends GeneratedMessageV3, LreqBu extends GeneratedMessageV3.Builder, LrespBu extends GeneratedMessageV3.Builder, ReqRespBU extends IReqRespPbBuilderProvider<Lreq, LreqBu, Lresp, LrespBu>, C extends IConvertor<P, Lresp>, T extends ITableNameProvider>
        extends AControlFlow<SearchEntityCF.State, Lresp, ErrorException> {
  private C m_convertor;
  private T m_tableNameProvider;

  private BP m_builderProvider;

  private ReqRespBU m_responseBuilderProvider;

  private IDynamoSearchTable m_searchDynamoDb;
  private SearchRequestsPb m_request;

  public SearchEntityCF(SearchRequestsPb request, C convertor, T tableNameProvider,
          IDynamoSearchTable searchDynamoDb, ReqRespBU responseBuilderProvider) {
    super(State.SEARCH, State.DONE);
    m_request = request;
    m_convertor = convertor;
    m_tableNameProvider = tableNameProvider;
    m_searchDynamoDb = searchDynamoDb;
    m_responseBuilderProvider = responseBuilderProvider;
    addStateHandler(State.SEARCH, new SearchHandler());
  }

  enum State {
    SEARCH,
    DONE,
  }

  public class SearchHandler implements StateHandler<State> {
    IFuture<Pair<Set<Map.Entry<String, AttributeValue>>, List<Map<String, AttributeValue>>>, ErrorException> m_future = null;

    @Override
    public void registerCalls() {
      m_future = m_searchDynamoDb.searchDbTable(m_tableNameProvider.getTableName(), m_request);
    }

    @Override
    public State handleState() {
      try {
        List<HashMap<String, AttributeValue>> m_resp = Lists.newArrayList();
        HashMap<String, AttributeValue> lastKey = new HashMap<>();
        if (m_future.get().getFirst().size() != 0) {
          Set<Map.Entry<String, AttributeValue>> lastKeyToken = m_future.get().getFirst();
          lastKeyToken.forEach(future -> {
            lastKey.put(future.getKey(), future.getValue());
          });
        }
        List<Map<String, AttributeValue>> resultsItem = m_future.get().getSecond();
        GeneratedMessageV3 resp = null;
        if (resultsItem.size() != 0) {
          resultsItem.forEach(future -> {
            m_resp.add(new HashMap<String, AttributeValue>(future));
          });
          resp = m_convertor.searchRespConvert(m_resp,lastKey);
          getAsyncCallback().set(0, (Lresp) resp);
        } else {
          getAsyncCallback().set(0, (Lresp) m_responseBuilderProvider.getRespBuilder().build());
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      return State.DONE;
    }

  }

}
