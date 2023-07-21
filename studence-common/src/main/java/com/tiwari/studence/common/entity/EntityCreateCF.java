package com.tiwari.studence.common.entity;

import java.util.HashMap;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.IConvertor;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class EntityCreateCF<P extends GeneratedMessageV3,Lresp extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder<?>, BP extends IPbBuilderProvider<P, BU>, U extends AEntityUpdater<P, BU, IPbBuilderProvider<P, BU>, AEntityIndexer<P>>, C extends IConvertor<P,Lresp>, T extends ITableNameProvider>
        extends AControlFlow<EntityCreateCF.State, P, ErrorException> {
  private U m_updater;
  private C m_convertor;
  private IGetEntityId m_getNewId;
  private IDynamoPutTable m_dynamoPutTable;
  private P m_request;
  private BP m_builderProvider;
  private T m_tableNameProvider;
  private EntityGet<P,Lresp, BU, BP, C, T> m_getEntity;
  private EntityPbBuilderProvider m_entityProvider;
  com.tiwari.studence.proto.entity.EntityPb.Builder entity;
  private Pair<Integer, String> new_id;
  private HashMap<String, AttributeValue> attrMap = new HashMap<String, AttributeValue>();

  protected EntityCreateCF(P request, U updater, C convertor, BP builderProvider,
          T tableNameProvider, IGetEntityId getNewId, IDynamoPutTable dynamoPutTable,
          EntityPbBuilderProvider entityProvider, EntityGet<P, Lresp,BU, BP, C, T> getEntity) {
    super(State.GET_AND_SET_ENTITY_ID, State.DONE);
    m_updater = updater;
    m_convertor = convertor;
    m_getNewId = getNewId;
    m_dynamoPutTable = dynamoPutTable;
    m_request = request;
    m_entityProvider = entityProvider;
    m_builderProvider = builderProvider;
    m_tableNameProvider = tableNameProvider;
    m_getEntity = getEntity;
    addStateHandler(State.GET_AND_SET_ENTITY_ID, new GetAndSetEntityId());
    addStateHandler(State.CREATE_ENTITY, new CreateEntity());
    addStateHandler(State.GET_ENTITY, new GetEntity());
    attrMap.clear();
  }

  enum State {
    GET_AND_SET_ENTITY_ID,
    CREATE_ENTITY,
    GET_ENTITY,
    DONE
  }

  public class GetAndSetEntityId implements StateHandler<State> {
    IFuture<Pair<Integer, String>, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_getNewId.getNewEntityId();
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        Pair<Integer, String> new_id = m_future.get();
        BU builder = m_builderProvider.getBuilder(m_request);
        entity = m_entityProvider.getBuilder();
        entity.clear();
        entity.setHashId(new_id.getSecond());
        entity.setRangeId(String.valueOf(new_id.getFirst()));
        entity.setLifetime(LifeTimeEnum.ACTIVE);
        // builder.getDbInfo().mergeFrom(entity.build());
        attrMap = m_updater.updater((P) builder.build(), entity.build());
        m_updater.getIndexer().getGenricEntityIndexer(attrMap, entity.build());
        // getAsyncCallback().set(0, m_future.item());
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.CREATE_ENTITY;
    }

  }

  public class CreateEntity implements StateHandler<State> {
    IFuture<HashMap<String, AttributeValue>, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_dynamoPutTable.putDbTable(m_tableNameProvider.getTableName(), attrMap);
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        m_future.get();
        // getAsyncCallback().set(0, resp);
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.GET_ENTITY;
    }

  }

  public class GetEntity implements StateHandler<State> {
    IFuture<P, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_getEntity.getEntityFromEntityProto(entity.build());
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        P resp = m_future.get();
        getAsyncCallback().set(0, resp);
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }

  }

}
