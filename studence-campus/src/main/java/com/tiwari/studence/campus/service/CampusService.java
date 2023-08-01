package com.tiwari.studence.campus.service;

import com.tiwari.studence.campus.converter.CampusConverter;
import com.tiwari.studence.campus.indexer.CampusIndexer;
import com.tiwari.studence.campus.provider.CampusProvider;
import com.tiwari.studence.campus.provider.CampusSearchReqRespProvider;
import com.tiwari.studence.campus.provider.CampusTableNameProvider;
import com.tiwari.studence.campus.searcher.CampusSearcher;
import com.tiwari.studence.campus.updater.CampusUpdater;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.services.AEntityService;
import com.tiwari.studence.proto.campus.*;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CampusService extends AEntityService<CampusPb, CampusSearchReqPb, CampusSearchReqPb.Builder, CampusSearchRespPb, CampusPb.Builder, CampusProvider, CampusSearchRespPb.Builder, CampusSearchReqRespProvider, CampusIndexer, CampusUpdater, CampusConverter, CampusSearcher, CampusTableNameProvider>
        implements ICampusService {
  @Inject
  public CampusService(CampusSearcher searcher, CampusUpdater updator, CampusConverter convertor,
          CampusProvider builderProvder, CampusSearchReqRespProvider requestBuilderprovider,
          CampusTableNameProvider tableNameProvider, IGetEntityId getNewId,
          IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable);
  }

  @Override
  public IFuture<CampusPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<CampusPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<CampusPb, ErrorException> create(CampusPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<CampusPb, ErrorException> delete(CampusPb entity) {
    return null;
  }

  @Override
  public IFuture<CampusPb, ErrorException> update(CampusPb entity) {
    return null;
  }

  @Override
  public IFuture<CampusSearchRespPb, ErrorException> search(CampusSearchReqPb entity) {
    return super.searchEntity(entity);
  }
}
