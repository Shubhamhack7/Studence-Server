package com.tiwari.studence.pushNotification.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.service.v1.services.AEntityService;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchReqPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchRespPb;
import com.tiwari.studence.pushNotification.convertor.PushNotificationConvertor;
import com.tiwari.studence.pushNotification.indexer.PushNotificationIndexer;
import com.tiwari.studence.pushNotification.provider.PushNotificationProvider;
import com.tiwari.studence.pushNotification.provider.PushNotificationSearchPbProvider;
import com.tiwari.studence.pushNotification.provider.PushNotificationTableNameProvider;
import com.tiwari.studence.pushNotification.searcher.PushNotificationSearcher;
import com.tiwari.studence.pushNotification.updater.PushNotificationUpdater;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;

public class PushNotificationService extends AEntityService<PushNotificationPb, PushNotificationSearchReqPb,PushNotificationSearchReqPb.Builder, PushNotificationSearchRespPb,PushNotificationPb.Builder, PushNotificationProvider,PushNotificationSearchRespPb.Builder, PushNotificationSearchPbProvider, PushNotificationIndexer, PushNotificationUpdater, PushNotificationConvertor, PushNotificationSearcher, PushNotificationTableNameProvider> implements IPushNotificationService{

  @Inject
  public PushNotificationService(PushNotificationSearcher searcher, PushNotificationUpdater updator,
          PushNotificationConvertor convertor, PushNotificationProvider builderProvder,
          PushNotificationSearchPbProvider requestBuilderprovider,
          PushNotificationTableNameProvider tableNameProvider, IGetEntityId getNewId,
          IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
          IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<PushNotificationPb, ErrorException> get(String entity) {
    return null;
  }

  @Override
  public IFuture<PushNotificationPb, ErrorException> get(EntityPb entity) {
    return null;
  }

  @Override
  public IFuture<PushNotificationPb, ErrorException> create(PushNotificationPb entity) {
    return null;
  }

  @Override
  public IFuture<PushNotificationPb, ErrorException> delete(String entity) {
    return null;
  }

  @Override
  public IFuture<PushNotificationPb, ErrorException> update(String id, PushNotificationPb entity) {
    return null;
  }

  @Override
  public IFuture<PushNotificationSearchRespPb, ErrorException> search(
          PushNotificationSearchReqPb entity) {
    return null;
  }
}
