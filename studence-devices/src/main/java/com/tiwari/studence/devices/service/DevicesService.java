package com.tiwari.studence.devices.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.service.v1.services.AEntityService;
import com.tiwari.studence.devices.convertor.DevicesConvertor;
import com.tiwari.studence.devices.indexer.DevicesIndexer;
import com.tiwari.studence.devices.provider.DevicesProvider;
import com.tiwari.studence.devices.provider.DevicesSearchPbProvider;
import com.tiwari.studence.devices.provider.DevicesTableNameProvider;
import com.tiwari.studence.devices.searcher.DevicesSearcher;
import com.tiwari.studence.devices.updater.DevicesUpdater;
import com.tiwari.studence.proto.devices.DeviceDetailsPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchReqPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchRespPb;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DevicesService extends AEntityService<DeviceDetailsPb, DeviceDetailsSearchReqPb,DeviceDetailsSearchReqPb.Builder, DeviceDetailsSearchRespPb,DeviceDetailsPb.Builder, DevicesProvider,DeviceDetailsSearchRespPb.Builder, DevicesSearchPbProvider, DevicesIndexer, DevicesUpdater, DevicesConvertor, DevicesSearcher, DevicesTableNameProvider> implements IDevicesService {

  @Inject
  public DevicesService(DevicesSearcher searcher, DevicesUpdater updator,
          DevicesConvertor convertor, DevicesProvider builderProvder,
          DevicesSearchPbProvider requestBuilderprovider,
          DevicesTableNameProvider tableNameProvider, IGetEntityId getNewId,
          IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
          IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<DeviceDetailsPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<DeviceDetailsPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<DeviceDetailsPb, ErrorException> create(DeviceDetailsPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<DeviceDetailsPb, ErrorException> delete(String entity) {
    return super.deleteEntity(entity);
  }

  @Override
  public IFuture<DeviceDetailsPb, ErrorException> update(String id, DeviceDetailsPb entity) {
    return super.updateEntity(id,entity);
  }

  @Override
  public IFuture<DeviceDetailsSearchRespPb, ErrorException> search(
          DeviceDetailsSearchReqPb entity) {
    return super.searchEntity(entity);
  }
}
