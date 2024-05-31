package com.tiwari.studence.typeAhed.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.services.AEntityService;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchReqPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchRespPb;
import com.tiwari.studence.typeAhed.convertor.TypeAhedConvertor;
import com.tiwari.studence.typeAhed.indexer.TypeAhedIndexer;
import com.tiwari.studence.typeAhed.provider.TypeAheadSearchReqRespProvider;
import com.tiwari.studence.typeAhed.provider.TypeAheadTableNameProvider;
import com.tiwari.studence.typeAhed.provider.TypeAhedProvider;
import com.tiwari.studence.typeAhed.searcher.TypeAhedSearcher;
import com.tiwari.studence.typeAhed.updater.TypeAhedUpdater;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TypeAhedService extends
        AEntityService<TypeAheadPb, TypeAheadSearchReqPb, TypeAheadSearchReqPb.Builder, TypeAheadSearchRespPb, TypeAheadPb.Builder, TypeAhedProvider, TypeAheadSearchRespPb.Builder, TypeAheadSearchReqRespProvider, TypeAhedIndexer, TypeAhedUpdater, TypeAhedConvertor, TypeAhedSearcher, TypeAheadTableNameProvider>
        implements ITypeAheadService {

  @Inject
  public TypeAhedService(TypeAhedSearcher searcher, TypeAhedUpdater updator,
          TypeAhedConvertor convertor, TypeAhedProvider builderProvder,
          TypeAheadSearchReqRespProvider requestBuilderprovider,
          TypeAheadTableNameProvider tableNameProvider, IGetEntityId getNewId,
          IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
          IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<TypeAheadPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<TypeAheadPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<TypeAheadPb, ErrorException> create(TypeAheadPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<TypeAheadPb, ErrorException> delete(String entity) {
    return super.deleteEntity(entity);
  }

  @Override
  public IFuture<TypeAheadPb, ErrorException> update(String id, TypeAheadPb entity) {
    return super.updateEntity(id, entity);
  }

  @Override
  public IFuture<TypeAheadSearchRespPb, ErrorException> search(TypeAheadSearchReqPb entity) {
    return super.searchEntity(entity);
  }
}
