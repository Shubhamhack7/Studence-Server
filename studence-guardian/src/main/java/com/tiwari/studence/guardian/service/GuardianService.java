package com.tiwari.studence.guardian.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.service.v1.services.AEntityService;
import com.tiwari.studence.guardian.convertor.GuardianConvertor;
import com.tiwari.studence.guardian.indexer.GuardianIndexer;
import com.tiwari.studence.guardian.provider.GuardianPbProvider;
import com.tiwari.studence.guardian.provider.GuardianSearchPbProvider;
import com.tiwari.studence.guardian.provider.GuardianTableNameProvider;
import com.tiwari.studence.guardian.searcher.GuardianSearcher;
import com.tiwari.studence.guardian.updater.GuardianUpdater;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.guardian.GuardianPb;
import com.tiwari.studence.proto.guardian.GuardianSearchReqPb;
import com.tiwari.studence.proto.guardian.GuardianSearchRespPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GuardianService extends
        AEntityService<GuardianPb, GuardianSearchReqPb, GuardianSearchReqPb.Builder, GuardianSearchRespPb, GuardianPb.Builder, GuardianPbProvider, GuardianSearchRespPb.Builder, GuardianSearchPbProvider, GuardianIndexer, GuardianUpdater, GuardianConvertor, GuardianSearcher, GuardianTableNameProvider>
        implements IGuardianService {

  @Inject
  public GuardianService(GuardianSearcher searcher, GuardianUpdater updator,
          GuardianConvertor convertor, GuardianPbProvider builderProvder,
          GuardianSearchPbProvider requestBuilderprovider,
          GuardianTableNameProvider tableNameProvider, IGetEntityId getNewId,
          IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
          IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<GuardianPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<GuardianPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<GuardianPb, ErrorException> create(GuardianPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<GuardianPb, ErrorException> delete(String entity) {
    return super.deleteEntity(entity);
  }

  @Override
  public IFuture<GuardianPb, ErrorException> update(String id, GuardianPb entity) {
    return super.updateEntity(id, entity);
  }

  @Override
  public IFuture<GuardianSearchRespPb, ErrorException> search(GuardianSearchReqPb entity) {
    return super.searchEntity(entity);
  }
}
