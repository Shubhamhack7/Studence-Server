package com.tiwari.studence.common.entity;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.IConvertor;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.util.exception.ErrorException;

@Singleton
public class EntityCreate<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder,Lresp extends GeneratedMessageV3, BP extends IPbBuilderProvider<P, BU>, U extends AEntityUpdater<P, BU, IPbBuilderProvider<P, BU>, AEntityIndexer<P>>, C extends IConvertor<P,Lresp>, T extends ITableNameProvider> {

  private U m_updater;
  private C m_convertor;
  private IGetEntityId m_getNewId;
  private IDynamoPutTable m_dynamoPutTable;
  private BP m_builderProvider;
  private T m_tableNameProvider;
  private EntityGet<P,Lresp, BU, BP, C, T> m_getEntity;

  @Inject
  public EntityCreate(U updater, C convertor, BP builderProvider, T tableNameProvider,
          IGetEntityId getNewId, IDynamoPutTable dynamoPutTable,EntityGet<P, Lresp,BU, BP, C, T> getEntity) {
    m_updater = updater;
    m_convertor = convertor;
    m_getNewId = getNewId;
    m_dynamoPutTable = dynamoPutTable;
    m_builderProvider = builderProvider;
    m_tableNameProvider = tableNameProvider;
    m_getEntity = getEntity;
  }

  public IFuture<P, ErrorException> createEntity(P request) {
    EntityCreateCF cf = new EntityCreateCF (request,
            m_updater, m_convertor, m_builderProvider, m_tableNameProvider, m_getNewId,
            m_dynamoPutTable, new EntityPbBuilderProvider(),m_getEntity);
    cf.addLogObjects(request);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
