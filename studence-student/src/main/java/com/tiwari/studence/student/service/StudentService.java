package com.tiwari.studence.student.service;

import com.tiwari.studence.campus.converter.CampusConverter;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.services.AEntityService;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.student.StudentPb;
import com.tiwari.studence.proto.student.StudentSearchReqPb;
import com.tiwari.studence.proto.student.StudentSearchRespPb;
import com.tiwari.studence.student.converter.StudentConverter;
import com.tiwari.studence.student.indexer.StudentIndexer;
import com.tiwari.studence.student.provider.StudentProvider;
import com.tiwari.studence.student.provider.StudentSearchReqRespProvider;
import com.tiwari.studence.student.provider.StudentTableNameProvider;
import com.tiwari.studence.student.searcher.StudentSearcher;
import com.tiwari.studence.student.updater.StudentUpdater;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StudentService extends AEntityService<StudentPb, StudentSearchReqPb, StudentSearchReqPb.Builder, StudentSearchRespPb, StudentPb.Builder, StudentProvider, StudentSearchRespPb.Builder, StudentSearchReqRespProvider, StudentIndexer, StudentUpdater, StudentConverter, StudentSearcher, StudentTableNameProvider>
        implements IStudentService {

  @Inject
  public StudentService(StudentSearcher searcher, StudentUpdater updator, StudentConverter convertor,
                        StudentProvider builderProvder, StudentSearchReqRespProvider requestBuilderprovider,
                        StudentTableNameProvider tableNameProvider, IGetEntityId getNewId,
                        IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
                        IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<StudentPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<StudentPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<StudentPb, ErrorException> create(StudentPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<StudentPb, ErrorException> delete(String entity) {
    return null;
  }

  @Override
  public IFuture<StudentPb, ErrorException> update(String id, StudentPb entity) {
    return null;
  }

  @Override
  public IFuture<StudentSearchRespPb, ErrorException> search(StudentSearchReqPb entity) {
    return super.searchEntity(entity);
  }
}
