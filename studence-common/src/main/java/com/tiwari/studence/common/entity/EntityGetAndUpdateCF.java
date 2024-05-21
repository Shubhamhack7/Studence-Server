package com.tiwari.studence.common.entity;

import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.convertor.IConvertor;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.util.common.CommonUtil;
import com.tiwari.studence.util.entity.EntityUtilHelper;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.protobuf.ProtobufToJson;
import org.json.JSONObject;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;

public class EntityGetAndUpdateCF<P extends GeneratedMessageV3, Lresp extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder<?>, BP extends IPbBuilderProvider<P, BU>, U extends AEntityUpdater<P, BU, IPbBuilderProvider<P, BU>, AEntityIndexer<P>>, C extends IConvertor<P, Lresp>, T extends ITableNameProvider>
        extends AControlFlow<EntityGetAndUpdateCF.State, P, ErrorException> {
  private EntityGet m_get;
  private C m_convertor;

  private U m_updater;

  private IDynamoGetEntityTable m_dynamoGetTable;
  private BP m_builderProvider;
  private T m_tableNameProvider;

  private P m_pb;
  private P m_request;

  private P m_updatedPb;
  private String m_id;

  private IDynamoUpdateTable m_dyIDynamoUpdateTable;
  private boolean m_isToBeDelete = false;

  private HashMap<String, AttributeValue> attrMap = new HashMap<String, AttributeValue>();
  private HashMap<String, AttributeValue> keyMap = new HashMap<String, AttributeValue>();

  protected EntityGetAndUpdateCF(String id, P request, U updater, C convertor, BP builderProvider,
          T tableNameProvider, IDynamoGetEntityTable dynamoGetTable,
          IDynamoUpdateTable dyIDynamoUpdateTable, boolean isToBeDelete) {
    super(State.GET_PB, State.DONE);
    m_id = id;
    m_request = request;
    m_updater = updater;
    m_convertor = convertor;
    m_builderProvider = builderProvider;
    m_tableNameProvider = tableNameProvider;
    m_dynamoGetTable = dynamoGetTable;
    m_dyIDynamoUpdateTable = dyIDynamoUpdateTable;
    m_isToBeDelete = isToBeDelete;
    addStateHandler(State.GET_PB, new GetEntityPb());
    addStateHandler(State.PROCESS_PB_WITH_NEW, new ProcessPbWithNew());
    addStateHandler(State.UPDATE_PB, new UpdatedPb());
    m_get = new EntityGet(convertor, builderProvider, tableNameProvider, dynamoGetTable);

  }

  enum State {
    GET_PB,
    PROCESS_PB_WITH_NEW,
    UPDATE_PB,
    DONE
  }

  public class GetEntityPb implements StateHandler<State> {
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
          return State.PROCESS_PB_WITH_NEW;
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

  public class ProcessPbWithNew implements StateHandler<State> {
    IFuture<P, ErrorException> m_future;

    @Override
    public void registerCalls() {
    }

    @Override
    public State handleState() {
      try {

        String oldJson = JsonFormat.printer().print(m_pb);
        String newJson = JsonFormat.printer().print(m_request);
        String mergedJson = mergeJson(oldJson, newJson);
        BU bu = m_builderProvider.getBuilder();
        ProtobufToJson.jsonStringToProtobuf(mergedJson, bu);
        m_updatedPb = (P) bu.build();
        return State.UPDATE_PB;
      } catch (InvalidProtocolBufferException e) {
        getAsyncCallback().handleUnexpectedException(
                new LoggedRuntimeException(ErrorCategoryUiEnum.CONVERSION_ERROR));
      }
      return State.DONE;
    }

    private String mergeJson(String oldJson, String newJson) {
      try {
        JSONObject olderObject = new JSONObject(oldJson);
        JSONObject updatedObject = new JSONObject(newJson);
        CommonUtil.mergeJSONObjects(olderObject, updatedObject);
        Descriptors.Descriptor descriptor = m_pb.getDescriptorForType();
        DynamicMessage.Builder builder = DynamicMessage.newBuilder(descriptor);
        JsonFormat.parser().merge(olderObject.toString(), builder);
        //JsonFormat.parser().merge(oldJson, builder);
        //JsonFormat.parser().merge(newJson, builder);
        return JsonFormat.printer().print(builder.build());
      } catch (InvalidProtocolBufferException e) {
        throw new LoggedRuntimeException(ErrorCategoryUiEnum.INPUT_VALIDATION_ERROR);
      }
    }

  }

  public class UpdatedPb implements StateHandler<State> {
    IFuture<HashMap<String, AttributeValue>, ErrorException> m_future;

    @Override
    public void registerCalls() {
      Descriptors.Descriptor descriptor = m_updatedPb.getDescriptorForType();
      Descriptors.FieldDescriptor fieldDescriptor = descriptor.findFieldByNumber(1);
      if (!m_isToBeDelete) {
        EntityPb entityPb = EntityUtilHelper.updateEntityWithVersion(
                (EntityPb) m_updatedPb.getField(fieldDescriptor));
        attrMap.putAll(m_updater.updater((P) m_updatedPb, entityPb));
        m_updater.getIndexer().getGenricEntityIndexer(attrMap, entityPb);
      } else {
        EntityPb entityPb = EntityUtilHelper.deleteEntity(
                (EntityPb) m_updatedPb.getField(fieldDescriptor));
        attrMap.putAll(m_updater.updater((P) m_updatedPb, entityPb));
        m_updater.getIndexer().getGenricEntityIndexer(attrMap, entityPb);
      }
      for (AEntityIndexer.GenericIndexerEnum index : AEntityIndexer.GenericIndexerEnum.values()) {
        AttributeValue value = attrMap.get(index.name());
        if ((index == AEntityIndexer.GenericIndexerEnum.ID || index == AEntityIndexer.GenericIndexerEnum.RANGE) && value != null) {
          keyMap.put(index.name(), value);
          attrMap.remove(index.name());
        }
      }
      m_future = m_dyIDynamoUpdateTable.updateDbTable(m_tableNameProvider.getTableName(), keyMap,
              attrMap);
    }

    @Override
    public State handleState() {
      try {
        if (m_future.get().size() != 0) {
          P proto = m_convertor.convert(m_future.get());
          getAsyncCallback().set(0, proto);
          return State.DONE;
        }
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
      }
      return State.DONE;
    }
  }
}
