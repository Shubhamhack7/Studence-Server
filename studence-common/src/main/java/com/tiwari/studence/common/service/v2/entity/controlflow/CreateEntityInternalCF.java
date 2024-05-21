package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncConverter;
import com.tiwari.studence.common.service.v2.interfaces.IEntityStore;
import com.tiwari.studence.util.exception.ErrorException;

public class CreateEntityInternalCF<PB extends GeneratedMessageV3, Resp extends GeneratedMessageV3, Store extends IEntityStore<PB>>
        extends AControlFlow<CreateEntityInternalCF.States, Resp, ErrorException> {

  private PB m_pb;
  private final Store m_store;
  private final IAsyncConverter<PB, Resp> m_converter;
  private final String m_requestId;

  public CreateEntityInternalCF(PB pb, Store store,
          IAsyncConverter<PB, Resp> converter, String requestId) {
    super(States.CREATE_ENTITY, States.DONE);
    addStateHandler(States.CREATE_ENTITY, new CreateEntityStateHandler());
    addStateHandler(States.CONVERT_ENTITY_TO_RESP,
            new ConvertEntityToResponseStateHandler());
    m_pb = pb;
    m_store = store;
    m_converter = converter;
    m_requestId = requestId;
  }

  public CreateEntityInternalCF(PB pb, Store store,
          IAsyncConverter<PB, Resp> converter) {
    this(pb, store, converter, null);
  }

  public enum States {
    CREATE_ENTITY, CONVERT_ENTITY_TO_RESP, DONE;
  }

  private class CreateEntityStateHandler implements StateHandler<States> {
    IFuture<PB, ErrorException> insertedPb;

    @Override
    public void registerCalls() {
      if (m_requestId != null) {
        insertedPb = m_store.insertEntity(m_requestId, m_pb);
      } else {
        insertedPb = m_store.insertEntity(m_pb);
      }
      registerFutures(insertedPb);
    }

    @Override
    public States handleState() {
      try {
        m_pb = insertedPb.get();
        return States.CONVERT_ENTITY_TO_RESP;
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return States.DONE;
    }
  }

  private class ConvertEntityToResponseStateHandler implements
          StateHandler<States> {
    IFuture<Resp, ErrorException> converted;

    @Override
    public void registerCalls() {
      converted = m_converter.convert(m_pb);
      registerFutures(converted);
    }

    @Override
    public States handleState() {
      try {
        getAsyncCallback().set(0, converted.get());
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
      }
      return States.DONE;
    }
  }
}
