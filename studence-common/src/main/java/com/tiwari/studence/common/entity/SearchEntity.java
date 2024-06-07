package com.tiwari.studence.common.entity;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.IConvertor;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class SearchEntity<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>,Lreq extends GeneratedMessageV3, Lresp extends GeneratedMessageV3,LreqBu extends GeneratedMessageV3.Builder, LrespBu extends GeneratedMessageV3.Builder, ReqRespBU extends IReqRespPbBuilderProvider<Lreq,LreqBu,Lresp,LrespBu>, C extends IConvertor<P, Lresp>, T extends ITableNameProvider> {
  private C m_convertor;
  private T m_tableNameProvider;

  private ReqRespBU m_responseBuilderProvider;

  private BP m_builderProvider;

  private IDynamoSearchTable m_searchDynamoDb;

  @Inject
  public SearchEntity(C convertor, T tableNameProvider, IDynamoSearchTable searchDynamoDb,ReqRespBU responseBuilderProvider) {
    m_convertor = convertor;
    m_tableNameProvider = tableNameProvider;
    m_searchDynamoDb = searchDynamoDb;
    m_responseBuilderProvider = responseBuilderProvider;
  }

  public IFuture<Lresp, ErrorException> searchEntity(SearchRequestsPb request) {
    SearchEntityCF cf = new SearchEntityCF(request, m_convertor, m_tableNameProvider,
            m_searchDynamoDb,m_responseBuilderProvider);
    cf.addLogObjects(request);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
