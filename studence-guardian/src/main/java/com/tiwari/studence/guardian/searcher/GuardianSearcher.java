package com.tiwari.studence.guardian.searcher;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.guardian.convertor.GuardianConvertor;
import com.tiwari.studence.guardian.indexer.GuardianIndexer;
import com.tiwari.studence.guardian.indexer.GuardianIndexerEnum;
import com.tiwari.studence.guardian.provider.GuardianPbProvider;
import com.tiwari.studence.guardian.provider.GuardianSearchPbProvider;
import com.tiwari.studence.guardian.provider.GuardianTableNameProvider;
import com.tiwari.studence.proto.guardian.GuardianPb;
import com.tiwari.studence.proto.guardian.GuardianSearchReqPb;
import com.tiwari.studence.proto.guardian.GuardianSearchRespPb;
import com.tiwari.studence.proto.search.ComparisonOperatorEnum;
import com.tiwari.studence.proto.search.DynamoDBValue;
import com.tiwari.studence.proto.search.SearchPb;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GuardianSearcher extends AEntitySearcher<GuardianPb,GuardianPb.Builder, GuardianPbProvider, GuardianSearchReqPb,GuardianSearchReqPb.Builder, GuardianSearchRespPb,GuardianSearchRespPb.Builder, GuardianSearchPbProvider, GuardianConvertor, GuardianIndexer, GuardianTableNameProvider> {

  @Inject
  public GuardianSearcher(GuardianConvertor convertor, IDynamoSearchTable dyamodbSearchTable,
          GuardianTableNameProvider tableNameProvider,
          GuardianSearchPbProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }

  @Override
  public IFuture<GuardianSearchRespPb, ErrorException> searcher(GuardianSearchReqPb builder) {
    SearchRequestsPb.Builder requestBuilder = getSearchRequestBuilderProvider().getBuilder();
   // requestBuilder.setNextToken(builder.getNextToken());
    if (Strings.notEmpty(builder.getName())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getName(),
              GuardianIndexerEnum.GUARDIAN_FATHER_NAME.name(),
              GuardianIndexerEnum.GUARDIAN_FATHER_NAME.isLowerCase());
    }
    return super.performsearcher(requestBuilder.build());
  }
}
