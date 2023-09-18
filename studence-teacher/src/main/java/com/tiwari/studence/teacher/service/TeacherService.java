package com.tiwari.studence.teacher.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.services.AEntityService;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.teacher.TeacherPb;
import com.tiwari.studence.proto.teacher.TeacherSearchReqPb;
import com.tiwari.studence.proto.teacher.TeacherSearchRespPb;
import com.tiwari.studence.teacher.converter.TeacherConverter;
import com.tiwari.studence.teacher.indexer.TeacherIndexer;
import com.tiwari.studence.teacher.provider.TeacherProvider;
import com.tiwari.studence.teacher.provider.TeacherSearchReqRespProvider;
import com.tiwari.studence.teacher.provider.TeacherTableNameProvider;
import com.tiwari.studence.teacher.searcher.TeacherSearcher;
import com.tiwari.studence.teacher.updater.TeacherUpdater;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TeacherService extends AEntityService<TeacherPb, TeacherSearchReqPb, TeacherSearchReqPb.Builder, TeacherSearchRespPb, TeacherPb.Builder, TeacherProvider, TeacherSearchRespPb.Builder, TeacherSearchReqRespProvider, TeacherIndexer, TeacherUpdater, TeacherConverter, TeacherSearcher, TeacherTableNameProvider>
        implements ITeacherService {

  @Inject
  public TeacherService(TeacherSearcher searcher, TeacherUpdater updator, TeacherConverter convertor,
                        TeacherProvider builderProvder, TeacherSearchReqRespProvider requestBuilderprovider,
                        TeacherTableNameProvider tableNameProvider, IGetEntityId getNewId,
                        IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
                        IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<TeacherPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<TeacherPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<TeacherPb, ErrorException> create(TeacherPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<TeacherPb, ErrorException> delete(String entity) {
    return null;
  }

  @Override
  public IFuture<TeacherPb, ErrorException> update(String id, TeacherPb entity) {
    return null;
  }

  @Override
  public IFuture<TeacherSearchRespPb, ErrorException> search(TeacherSearchReqPb entity) {
    return super.searchEntity(entity);
  }
}
