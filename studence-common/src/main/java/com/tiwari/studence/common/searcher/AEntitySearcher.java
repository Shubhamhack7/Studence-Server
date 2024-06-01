package com.tiwari.studence.common.searcher;

import javax.inject.Inject;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.AEntityConvertor;
import com.tiwari.studence.common.entity.SearchEntity;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.provider.SearchRequestPbProvider;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.proto.search.*;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.List;

public abstract class AEntitySearcher<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>, Lreq extends GeneratedMessageV3, LreqBU extends GeneratedMessageV3.Builder, Lresp extends GeneratedMessageV3, RBU extends GeneratedMessageV3.Builder, RBUP extends IReqRespPbBuilderProvider<Lreq, LreqBU, Lresp, RBU>, C extends AEntityConvertor<P, BU, BP, Lreq, LreqBU, Lresp, RBU, RBUP>, I extends AEntityIndexer<P>, T extends ITableNameProvider>
        implements ISearcher<Lreq, Lresp> {

  private SearchRequestPbProvider m_saerchRequest;
  private RBUP m_responseBuilderProvider;
  private C m_convertor;
  private SearchEntity m_searchEntity;
  private IDynamoSearchTable m_dyamodbSearchTable;

  public enum GenericSearchEnum {
    LIFETIME,
  }

  @Inject
  public AEntitySearcher(C convertor, IDynamoSearchTable dyamodbSearchTable, T tableNameProvider,
          RBUP responseBuilderProvider) {
    m_convertor = convertor;
    m_dyamodbSearchTable = dyamodbSearchTable;
    m_responseBuilderProvider = responseBuilderProvider;
    m_saerchRequest = new SearchRequestPbProvider();
    m_searchEntity = new SearchEntity(m_convertor, tableNameProvider, dyamodbSearchTable,
            m_responseBuilderProvider);
  }

  @Override
  public IFuture<Lresp, ErrorException> searcher(Lreq builder) {
    return null;
  }

  protected IFuture<Lresp, ErrorException> performsearcher(SearchRequestsPb builder) {

    SearchRequestsPb.Builder reqBu = getSearchRequestBuilderProvider().getBuilder(builder);
    reqBu.setMode(DynamoDBSearchMode.SCAN_FILTER_MODE);
    if (reqBu.getRequestsBuilderList().size() > 0) {
      reqBu.addOperators(DynamoDBLogicalOperators.AND);
    }
    reqBu.getRequestsBuilderList().forEach(builder1 -> {
      if (builder1.getType() == ComparisonOperatorEnum.EQUAL_TO) {
        addEqualToValue(builder1, DynamoDBValue.DYNAMODB_VALUE_STRING, LifeTimeEnum.ACTIVE.name(),
                GenericSearchEnum.LIFETIME.name(), false);
      } else {

      }
    });
    if (reqBu.getRequestsList().size() == 0) {
      SearchPb.Builder nameReq = reqBu.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, LifeTimeEnum.ACTIVE.name(),
              GenericSearchEnum.LIFETIME.name(), false);
    }
    return m_searchEntity.searchEntity(reqBu.build());
  }

  public SearchRequestPbProvider getSearchRequestBuilderProvider() {
    return m_saerchRequest;
  }

  protected void addEqualToValue(SearchPb.Builder addRequestsBuilder,
          DynamoDBValue dynamodbValueString, String data, String key, boolean lowerCase) {
    AttributeNameValuePair.Builder attr = addRequestsBuilder.addAttributesBuilder();
    attr.setType(dynamodbValueString);
    attr.setName(key);
    if (lowerCase) {
      attr.setStringValue(data.toLowerCase());
    } else {
      attr.setStringValue(data);
    }
  }

  protected void addEqualToValue(SearchPb.Builder addRequestsBuilder,
          DynamoDBValue dynamodbValueString, List<String> data, String key, boolean lowerCase) {
    AttributeNameValuePair.Builder attr = addRequestsBuilder.addAttributesBuilder();
    attr.setType(dynamodbValueString);
    attr.setName(key);
    if (lowerCase) {
      attr.setStringValue(Strings.join(data, ",", lowerCase));
    } else {
      attr.setStringValue(Strings.join(data, ","));
    }
  }

}