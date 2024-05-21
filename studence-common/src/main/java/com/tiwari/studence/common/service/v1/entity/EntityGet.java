package com.tiwari.studence.common.service.v1.entity;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.convertor.IConvertor;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.exception.ErrorException;

@Singleton
public class EntityGet<P extends GeneratedMessageV3, Lresp extends GeneratedMessageV3,BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>, C extends IConvertor<P,Lresp>, T extends ITableNameProvider> {

  private C m_convertor;
  private IDynamoGetEntityTable m_dynamoGetTable;
  private BP m_builderProvider;
  private T m_tableNameProvider;

  @Inject
  public EntityGet(C convertor, BP builderProvider, T tableNameProvider,
          IDynamoGetEntityTable dynamoGetTable) {
    m_convertor = convertor;
    m_builderProvider = builderProvider;
    m_tableNameProvider = tableNameProvider;
    m_dynamoGetTable = dynamoGetTable;
  }

  public IFuture<P, ErrorException> getEntityFromId(String request) {
    EntityGetCF<P,Lresp, BU, BP, C, T> cf = new EntityGetCF<P,Lresp, BU, BP, C, T>(request, m_convertor,
            m_builderProvider, m_tableNameProvider, m_dynamoGetTable);
    cf.addLogObjects(request);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  public IFuture<P, ErrorException> getEntityFromEntityProto(EntityPb pb) {
    String request = pb.getHashId() + StudenceSpecialCharecterEnum.EXCLAMATION.getSign()
            + pb.getRangeId();
    EntityGetCF<P,Lresp, BU, BP, C, T> cf = new EntityGetCF<P,Lresp, BU, BP, C, T>(request, m_convertor,
             m_builderProvider, m_tableNameProvider, m_dynamoGetTable);
    cf.addLogObjects(request);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

}
