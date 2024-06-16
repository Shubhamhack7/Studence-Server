package com.tiwari.studence.attendence.service;

import com.tiwari.studence.attendence.convertor.AttendenceConvertor;
import com.tiwari.studence.attendence.indexer.AttendenceIndexer;
import com.tiwari.studence.attendence.provider.AttendencePbProvider;
import com.tiwari.studence.attendence.provider.AttendenceSearchPbProvider;
import com.tiwari.studence.attendence.provider.AttendenceTableNameProvider;
import com.tiwari.studence.attendence.searcher.AttendenceSearcher;
import com.tiwari.studence.attendence.updater.AttendenceUpdater;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.services.AEntityService;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.proto.attendence.AttendenceSearchReqPb;
import com.tiwari.studence.proto.attendence.AttendenceSearchRespPb;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AttendenceService extends AEntityService<AttendencePb, AttendenceSearchReqPb,AttendenceSearchReqPb.Builder, AttendenceSearchRespPb, AttendencePb.Builder, AttendencePbProvider, AttendenceSearchRespPb.Builder, AttendenceSearchPbProvider, AttendenceIndexer, AttendenceUpdater, AttendenceConvertor, AttendenceSearcher, AttendenceTableNameProvider>
        implements IAttendenceService {

  @Inject
  public AttendenceService(AttendenceSearcher searcher, AttendenceUpdater updator,
                           AttendenceConvertor convertor, AttendencePbProvider builderProvder,
                           AttendenceSearchPbProvider requestBuilderprovider,
                           AttendenceTableNameProvider tableNameProvider, IGetEntityId getNewId,
                           IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
                           IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }


  @Override
  public IFuture<AttendencePb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<AttendencePb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<AttendencePb, ErrorException> create(AttendencePb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<AttendencePb, ErrorException> delete(String entity) {
    return null;
  }

  @Override
  public IFuture<AttendencePb, ErrorException> update(String id, AttendencePb entity) {
    return null;
  }

  @Override
  public IFuture<AttendenceSearchRespPb, ErrorException> search(AttendenceSearchReqPb entity) {
    return super.searchEntity(entity);
  }
}
