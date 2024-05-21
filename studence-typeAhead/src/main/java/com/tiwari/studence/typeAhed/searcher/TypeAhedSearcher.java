package com.tiwari.studence.typeAhed.searcher;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.proto.login.ProfileTypeEnum;
import com.tiwari.studence.proto.search.*;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchReqPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchRespPb;
import com.tiwari.studence.typeAhed.convertor.TypeAhedConvertor;
import com.tiwari.studence.typeAhed.indexer.TypeAheadIndexerEnum;
import com.tiwari.studence.typeAhed.indexer.TypeAhedIndexer;
import com.tiwari.studence.typeAhed.provider.TypeAheadSearchReqRespProvider;
import com.tiwari.studence.typeAhed.provider.TypeAheadTableNameProvider;
import com.tiwari.studence.typeAhed.provider.TypeAhedProvider;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TypeAhedSearcher extends
        AEntitySearcher<TypeAheadPb, TypeAheadPb.Builder, TypeAhedProvider, TypeAheadSearchReqPb, TypeAheadSearchReqPb.Builder, TypeAheadSearchRespPb, TypeAheadSearchRespPb.Builder, TypeAheadSearchReqRespProvider, TypeAhedConvertor, TypeAhedIndexer, TypeAheadTableNameProvider> {

  @Inject
  public TypeAhedSearcher(TypeAhedConvertor convertor, IDynamoSearchTable dyamodbSearchTable,
          TypeAheadTableNameProvider tableNameProvider,
          TypeAheadSearchReqRespProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }

  @Override
  public IFuture<TypeAheadSearchRespPb, ErrorException> searcher(TypeAheadSearchReqPb builder) {
    SearchRequestsPb.Builder requestBuilder = getSearchRequestBuilderProvider().getBuilder();
    requestBuilder.addOperators(DynamoDBLogicalOperators.AND);
    if (Strings.notEmpty(builder.getContext())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.BEGINS_WITH);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getContext(),
              TypeAheadIndexerEnum.TYPE_AHEAD_CONTEXT_NAME.name(),
              TypeAheadIndexerEnum.TYPE_AHEAD_CONTEXT_NAME.isLowerCase());
    }
    if (builder.getTypeAheadType() != ProfileTypeEnum.UNKNOWN_LOGIN_TYPE) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING,
              builder.getTypeAheadType().name(), TypeAheadIndexerEnum.TYPE_AHEAD_TYPE.name(),
              TypeAheadIndexerEnum.TYPE_AHEAD_TYPE.isLowerCase());
    }
    return super.performsearcher(requestBuilder.build());
  }
}
