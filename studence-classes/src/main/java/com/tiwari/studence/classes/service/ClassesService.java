package com.tiwari.studence.classes.service;

import com.tiwari.studence.classes.converter.ClassesConverter;
import com.tiwari.studence.classes.indexer.ClassesIndexer;
import com.tiwari.studence.classes.provider.ClassesProvider;
import com.tiwari.studence.classes.provider.ClassesSearchReqRespProvider;
import com.tiwari.studence.classes.provider.ClassesTableNameProvider;
import com.tiwari.studence.classes.searcher.ClassesSearcher;
import com.tiwari.studence.classes.updater.ClassesUpdater;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.service.v1.services.AEntityService;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.proto.classes.ClassesSearchReqPb;
import com.tiwari.studence.proto.classes.ClassesSearchRespPb;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ClassesService extends AEntityService<ClassesPb, ClassesSearchReqPb, ClassesSearchReqPb.Builder, ClassesSearchRespPb, ClassesPb.Builder, ClassesProvider, ClassesSearchRespPb.Builder, ClassesSearchReqRespProvider, ClassesIndexer, ClassesUpdater, ClassesConverter, ClassesSearcher, ClassesTableNameProvider>
        implements IClassesService {

  @Inject
  public ClassesService(ClassesSearcher searcher, ClassesUpdater updator, ClassesConverter convertor,
                        ClassesProvider builderProvder, ClassesSearchReqRespProvider requestBuilderprovider,
                        ClassesTableNameProvider tableNameProvider, IGetEntityId getNewId,
                        IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
                        IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<ClassesPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<ClassesPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<ClassesPb, ErrorException> create(ClassesPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<ClassesPb, ErrorException> delete(String entity) {
    return null;
  }

  @Override
  public IFuture<ClassesPb, ErrorException> update(String id, ClassesPb entity) {
    return null;
  }

  @Override
  public IFuture<ClassesSearchRespPb, ErrorException> search(ClassesSearchReqPb entity) {
    return super.searchEntity(entity);
  }
}
