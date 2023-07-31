package com.tiwari.studence.common.entity;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.IConvertor;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.util.exception.ErrorException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class EntityGetAndUpdate<P extends GeneratedMessageV3, Lresp extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder<?>, BP extends IPbBuilderProvider<P, BU>, U extends AEntityUpdater<P, BU, IPbBuilderProvider<P, BU>, AEntityIndexer<P>>, C extends IConvertor<P, Lresp>, T extends ITableNameProvider> {

  private C m_convertor;

  private U m_updater;

  private IDynamoGetEntityTable m_dynamoGetTable;
  private BP m_builderProvider;
  private T m_tableNameProvider;

  private IDynamoUpdateTable m_dyIDynamoUpdateTable;

  private boolean m_isToBeDelete = false;

  @Inject
  public EntityGetAndUpdate(U updater, C convertor, BP builderProvider, T tableNameProvider,
          IDynamoGetEntityTable dynamoGetTable, IDynamoUpdateTable dyIDynamoUpdateTable,
          boolean isToBeDelete) {
    m_updater = updater;
    m_convertor = convertor;
    m_builderProvider = builderProvider;
    m_tableNameProvider = tableNameProvider;
    m_dynamoGetTable = dynamoGetTable;
    m_dyIDynamoUpdateTable = dyIDynamoUpdateTable;
    m_isToBeDelete = isToBeDelete;
  }

  public IFuture<P, ErrorException> updateEntity(String id, P request) {
    EntityGetAndUpdateCF cf = new EntityGetAndUpdateCF(id, request, m_updater, m_convertor,
            m_builderProvider, m_tableNameProvider, m_dynamoGetTable, m_dyIDynamoUpdateTable,
            m_isToBeDelete);
    cf.addLogObjects(request);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
