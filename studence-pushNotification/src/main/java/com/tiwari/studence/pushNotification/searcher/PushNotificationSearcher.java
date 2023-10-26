package com.tiwari.studence.pushNotification.searcher;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchReqPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchRespPb;
import com.tiwari.studence.proto.search.ComparisonOperatorEnum;
import com.tiwari.studence.proto.search.DynamoDBValue;
import com.tiwari.studence.proto.search.SearchPb;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.pushNotification.convertor.PushNotificationConvertor;
import com.tiwari.studence.pushNotification.indexer.PushNotificationIndexer;
import com.tiwari.studence.pushNotification.indexer.PushNotificationIndexerEnum;
import com.tiwari.studence.pushNotification.provider.PushNotificationProvider;
import com.tiwari.studence.pushNotification.provider.PushNotificationSearchPbProvider;
import com.tiwari.studence.pushNotification.provider.PushNotificationTableNameProvider;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;

public class PushNotificationSearcher extends
        AEntitySearcher<PushNotificationPb, PushNotificationPb.Builder, PushNotificationProvider, PushNotificationSearchReqPb, PushNotificationSearchReqPb.Builder, PushNotificationSearchRespPb, PushNotificationSearchRespPb.Builder, PushNotificationSearchPbProvider, PushNotificationConvertor, PushNotificationIndexer, PushNotificationTableNameProvider> {

  @Inject
  public PushNotificationSearcher(PushNotificationConvertor convertor,
          IDynamoSearchTable dyamodbSearchTable,
          PushNotificationTableNameProvider tableNameProvider,
          PushNotificationSearchPbProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }

  @Override
  public IFuture<PushNotificationSearchRespPb, ErrorException> searcher(
          PushNotificationSearchReqPb builder) {
    SearchRequestsPb.Builder requestBuilder = getSearchRequestBuilderProvider().getBuilder();
    if (Strings.notEmpty(builder.getToken())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getToken(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_TOKEN.name(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_TOKEN.isLowerCase());
    }
    if (Strings.notEmpty(builder.getOrgRefId())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getOrgRefId(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_ORGANISATION_REF_ID.name(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_ORGANISATION_REF_ID.isLowerCase());
    }
    if (Strings.notEmpty(builder.getCampusRefId())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getCampusRefId(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_CAMPUS_REF_ID.name(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_CAMPUS_REF_ID.isLowerCase());
    }
    if (Strings.notEmpty(builder.getDeviceRefId())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getDeviceRefId(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_DEVICE_REF_ID.name(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_DEVICE_REF_ID.isLowerCase());
    }
    if (Strings.notEmpty(builder.getLoginRefId())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getLoginRefId(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_LOGIN_REF_ID.name(),
              PushNotificationIndexerEnum.PUSH_NOTIFICATION_LOGIN_REF_ID.isLowerCase());
    }
    return super.performsearcher(requestBuilder.build());
  }
}
