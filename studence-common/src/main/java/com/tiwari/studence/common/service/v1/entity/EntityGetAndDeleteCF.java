package com.tiwari.studence.common.service.v1.entity;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.convertor.IConvertor;
import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.common.service.v1.services.interfaces.ITableNameProvider;
import com.tiwari.studence.common.service.v1.updater.AEntityUpdater;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

public class EntityGetAndDeleteCF<P extends GeneratedMessageV3, Lresp extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder<?>, BP extends IPbBuilderProvider<P, BU>, U extends AEntityUpdater<P, BU, IPbBuilderProvider<P, BU>, AEntityIndexer<P>>, C extends IConvertor<P, Lresp>, T extends ITableNameProvider>
        extends AControlFlow<EntityGetAndDeleteCF.State, P, ErrorException> {

  private C m_convertor;

  private P m_pb;

  private U m_updater;
  private String m_id;
  private EntityGet m_get;
  private IDynamoGetEntityTable m_dynamoGetTable;
  private BP m_builderProvider;
  private T m_tableNameProvider;

  private IDynamoUpdateTable m_dyIDynamoUpdateTable;
  private EntityGetAndUpdate m_updateEntity;

  protected EntityGetAndDeleteCF(String id, U updater, C convertor, BP builderProvider,
          T tableNameProvider, IDynamoGetEntityTable dynamoGetTable,
          IDynamoUpdateTable dyIDynamoUpdateTable, boolean isToBeDelete) {
    super(State.UPDATE_PB_WITH_DELETE, State.DONE);
    m_id = id;
    m_updater = updater;
    m_convertor = convertor;
    m_builderProvider = builderProvider;
    m_tableNameProvider = tableNameProvider;
    m_dynamoGetTable = dynamoGetTable;
    m_dyIDynamoUpdateTable = dyIDynamoUpdateTable;
    addStateHandler(State.GET_UPDATED_PB, new GetUpdatedPb());
    addStateHandler(State.UPDATE_PB_WITH_DELETE, new UpdatePBWithDelete());
    m_updateEntity = new EntityGetAndUpdate<>(updater, convertor, builderProvider,
            tableNameProvider, dynamoGetTable, dyIDynamoUpdateTable, true);
    m_get = new EntityGet(convertor, builderProvider, tableNameProvider, dynamoGetTable);
  }

  enum State {
    GET_UPDATED_PB,
    UPDATE_PB_WITH_DELETE,
    DONE
  }

  public class GetUpdatedPb implements StateHandler<State> {
    IFuture<P, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_get.getEntityFromId(m_id);
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        if (m_future.get() != null) {
          m_pb = m_future.get();
          return State.UPDATE_PB_WITH_DELETE;
        } else {
          getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(
                  ErrorCategoryUiEnum.valueOf(ErrorCategoryUiEnum.ITEM_NOT_FOUND_VALUE)));
        }
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }
  }

  public class UpdatePBWithDelete implements StateHandler<State> {
    IFuture<P, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_updateEntity.updateEntity(m_id,m_pb);
      registerFutures(m_future);
    }

    @Override
    public State handleState() {
      try {
        if (m_future.get() != null) {
          m_pb = m_future.get();
          return State.DONE;
        } else {
          getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(
                  ErrorCategoryUiEnum.valueOf(ErrorCategoryUiEnum.ITEM_NOT_FOUND_VALUE)));
        }
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }
  }
}

