package com.tiwari.studence.common.services;

import javax.inject.Inject;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.AEntityConvertor;
import com.tiwari.studence.common.entity.EntityCreate;
import com.tiwari.studence.common.entity.EntityCreateCF;
import com.tiwari.studence.common.entity.EntityGet;
import com.tiwari.studence.common.entity.IGetEntityId;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.prtovider.IPbBuilderProvider;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.common.services.interfaces.IService;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.exception.ErrorException;

public abstract class AEntityService<P extends GeneratedMessageV3, LReq extends GeneratedMessageV3, LResp extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>, RBU extends GeneratedMessageV3.Builder, RBUP extends IPbBuilderProvider<LResp, RBU>, I extends AEntityIndexer<P>, U extends AEntityUpdater<P, BU, BP, I>, C extends AEntityConvertor<P, BU, BP>, S extends AEntitySearcher<P, LReq, LResp, RBU, RBUP, I>, T extends ITableNameProvider>
        implements IService<P, LReq, LResp> {

  private S m_searcher;
  private U m_updator;
  private C m_convertor;
  private BP m_builderProvder;
  private RBUP m_requestBuilderprovider;
  private T m_tableNameProvider;
  private EntityCreate m_create;
  private EntityGet m_get;

  @Inject
  public AEntityService(S searcher, U updator, C convertor, BP builderProvder,
          RBUP requestBuilderprovider, T tableNameProvider, IGetEntityId getNewId,
          IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable) {
     m_searcher = searcher;
    m_updator = updator;
    m_convertor = convertor;
    m_builderProvder = builderProvder;
    m_requestBuilderprovider = requestBuilderprovider;
    m_tableNameProvider = tableNameProvider;
    m_get = new EntityGet(convertor, builderProvder, tableNameProvider, dynamoGetTable);
    m_create = new EntityCreate(m_updator, m_convertor, m_builderProvder, tableNameProvider,
            getNewId, dynamoPutTable, m_get);
  }

  @Override
  public IFuture<P, ErrorException> getEntity(EntityPb entity) {
    return m_get.getEntityFromEntityProto(entity);
  }

  @Override
  public IFuture<P, ErrorException> getEntity(String entity) {
    return m_get.getEntityFromId(entity);
  }

  @Override
  public IFuture<P, ErrorException> createEntity(P entity) {
    return m_create.createEntity(entity);
  }

  @Override
  public IFuture<LResp, ErrorException> searchEntity(LReq reqBuilder) {
    return m_searcher.searcher(reqBuilder);
  }

  @Override
  public IFuture<P, ErrorException> updateEntity(String id, P entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IFuture<P, ErrorException> deleteEntity(String entity) {
    // TODO Auto-generated method stub
    return null;
  }

}
