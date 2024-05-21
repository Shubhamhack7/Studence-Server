package com.tiwari.studence.common.service.v1.entity;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.convertor.IConvertor;
import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.common.service.v1.updater.AEntityUpdater;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EntityGetAndDelete<P extends GeneratedMessageV3, Lresp extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder<?>, BP extends IPbBuilderProvider<P, BU>, U extends AEntityUpdater<P, BU, IPbBuilderProvider<P, BU>, AEntityIndexer<P>>, C extends IConvertor<P, Lresp>, T extends ITableNameProvider> {
  private C m_convertor;

  private P m_pb;

  private U m_updater;
  private String m_id;
  private EntityGet m_get;
  private IDynamoGetEntityTable m_dynamoGetTable;
  private BP m_builderProvider;
  private T m_tableNameProvider;

  private IDynamoUpdateTable m_dyIDynamoUpdateTable;

  @Inject
  public EntityGetAndDelete(U updater, C convertor, BP builderProvider, T tableNameProvider,
          IDynamoGetEntityTable dynamoGetTable, IDynamoUpdateTable dyIDynamoUpdateTable) {
    m_updater = updater;
    m_convertor = convertor;
    m_builderProvider = builderProvider;
    m_tableNameProvider = tableNameProvider;
    m_dynamoGetTable = dynamoGetTable;
    m_dyIDynamoUpdateTable = dyIDynamoUpdateTable;
  }

  public IFuture<P, ErrorException> deleteEntity(String id) {
    EntityGetAndDeleteCF cf = new EntityGetAndDeleteCF(id, m_updater, m_convertor,
            m_builderProvider, m_tableNameProvider, m_dynamoGetTable, m_dyIDynamoUpdateTable, true);
    cf.addLogObjects(id);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
