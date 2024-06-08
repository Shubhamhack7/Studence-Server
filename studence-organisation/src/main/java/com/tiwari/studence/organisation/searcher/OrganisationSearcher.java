package com.tiwari.studence.organisation.searcher;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.organisation.convertor.OrganisationConvertor;
import com.tiwari.studence.organisation.indexer.OrganisationIndexer;
import com.tiwari.studence.organisation.indexer.OrganisationIndexerEnum;
import com.tiwari.studence.organisation.provider.OraganisationTableNameProvider;
import com.tiwari.studence.organisation.provider.OrganisationPbProvider;
import com.tiwari.studence.organisation.provider.OrganisationSearchPbProvider;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;
import com.tiwari.studence.proto.search.ComparisonOperatorEnum;
import com.tiwari.studence.proto.search.DynamoDBValue;
import com.tiwari.studence.proto.search.SearchPb;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OrganisationSearcher extends
        AEntitySearcher<OrganisationPb, OrganisationPb.Builder, OrganisationPbProvider, OrganisationSearchReqPb,OrganisationSearchReqPb.Builder, OrganisationSearchRespPb, OrganisationSearchRespPb.Builder, OrganisationSearchPbProvider, OrganisationConvertor, OrganisationIndexer, OraganisationTableNameProvider> {

  @Inject
  public OrganisationSearcher(OrganisationConvertor convertor,
          IDynamoSearchTable dyamodbSearchTable, OraganisationTableNameProvider tableNameProvider,
          OrganisationSearchPbProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }

  @Override
  public IFuture<OrganisationSearchRespPb, ErrorException> searcher(
          OrganisationSearchReqPb builder) {
    SearchRequestsPb.Builder requestBuilder = getSearchRequestBuilderProvider().getBuilder();
    if (Strings.notEmpty(builder.getName())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getName(),
              OrganisationIndexerEnum.ORGANISATION_NAME.name(),OrganisationIndexerEnum.ORGANISATION_NAME.isLowerCase());
    }
    return super.performsearcher(requestBuilder.build());
  }

}
