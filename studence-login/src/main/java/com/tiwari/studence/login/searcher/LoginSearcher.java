package com.tiwari.studence.login.searcher;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.login.convertor.LoginConvertor;
import com.tiwari.studence.login.indexer.LoginIndexer;
import com.tiwari.studence.login.indexer.LoginIndexerEnum;
import com.tiwari.studence.login.provider.LoginPbProvider;
import com.tiwari.studence.login.provider.LoginSearchPbProvider;
import com.tiwari.studence.login.provider.LoginTableNameProvider;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.proto.login.LoginSearchReqPb;
import com.tiwari.studence.proto.login.LoginSearchRespPb;
import com.tiwari.studence.proto.search.ComparisonOperatorEnum;
import com.tiwari.studence.proto.search.DynamoDBValue;
import com.tiwari.studence.proto.search.SearchPb;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginSearcher extends
        AEntitySearcher<LoginPb, LoginPb.Builder, LoginPbProvider, LoginSearchReqPb, LoginSearchReqPb.Builder, LoginSearchRespPb, LoginSearchRespPb.Builder, LoginSearchPbProvider, LoginConvertor, LoginIndexer, LoginTableNameProvider> {

  @Inject
  public LoginSearcher(LoginConvertor convertor, IDynamoSearchTable dyamodbSearchTable,
          LoginTableNameProvider tableNameProvider, LoginSearchPbProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }

  @Override
  public IFuture<LoginSearchRespPb, ErrorException> searcher(LoginSearchReqPb builder) {
    SearchRequestsPb.Builder requestBuilder = getSearchRequestBuilderProvider().getBuilder();
    if (Strings.notEmpty(builder.getEmailId())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getEmailId(),
              LoginIndexerEnum.LOGIN_EMAIL_ID.name(),
              LoginIndexerEnum.LOGIN_EMAIL_ID.isLowerCase());
    }
    if (Strings.notEmpty(builder.getMobileNo())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getMobileNo(),
              LoginIndexerEnum.LOGIN_MOBILE_NO.name(),
              LoginIndexerEnum.LOGIN_MOBILE_NO.isLowerCase());
    }
    return super.performsearcher(requestBuilder.build());
  }
}
