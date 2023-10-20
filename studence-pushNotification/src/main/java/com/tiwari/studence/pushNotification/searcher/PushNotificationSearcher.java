package com.tiwari.studence.pushNotification.searcher;

import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchReqPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchRespPb;
import com.tiwari.studence.pushNotification.convertor.PushNotificationConvertor;
import com.tiwari.studence.pushNotification.indexer.PushNotificationIndexer;
import com.tiwari.studence.pushNotification.provider.PushNotificationProvider;
import com.tiwari.studence.pushNotification.provider.PushNotificationSearchPbProvider;
import com.tiwari.studence.pushNotification.provider.PushNotificationTableNameProvider;

import javax.inject.Inject;

public class PushNotificationSearcher extends AEntitySearcher<PushNotificationPb,PushNotificationPb.Builder, PushNotificationProvider, PushNotificationSearchReqPb,PushNotificationSearchReqPb.Builder, PushNotificationSearchRespPb,PushNotificationSearchRespPb.Builder, PushNotificationSearchPbProvider, PushNotificationConvertor, PushNotificationIndexer, PushNotificationTableNameProvider> {

  @Inject
  public PushNotificationSearcher(PushNotificationConvertor convertor,
          IDynamoSearchTable dyamodbSearchTable,
          PushNotificationTableNameProvider tableNameProvider,
          PushNotificationSearchPbProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }
}
