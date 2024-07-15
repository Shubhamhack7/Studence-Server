package com.tiwari.studence.common.refUpdater;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.refConvertor.IRefConvetor;
import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

public class RefUpdaterCF extends AControlFlow<RefUpdaterCF.State, Void, ErrorException> {

  IEntityService m_service;
  IRefConvetor m_convertor;
  GeneratedMessageV3.Builder m_builder;
  GeneratedMessageV3 m_pb;
  String m_id;

  public RefUpdaterCF(IEntityService service, IRefConvetor convertor,
          GeneratedMessageV3.Builder builder, String id) {
    super(State.GET_PB, State.DONE);
    m_service = service;
    m_convertor = convertor;
    m_builder = builder;
    m_id = id;
    addStateHandler(State.GET_PB, new GetPB());
    addStateHandler(State.CONVERT_REF, new ConvertRef());
  }

  enum State {
    GET_PB,
    CONVERT_REF,
    DONE,
  }

  public class GetPB implements StateHandler<State> {
    IFuture<GeneratedMessageV3, ErrorException> pb;

    @Override
    public void registerCalls() {
      pb = m_service.get(m_id);
    }

    @Override
    public State handleState() {
      try {
        if (pb.get() != null) {
          m_pb = pb.get();
          return State.CONVERT_REF;
        }
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
      return State.DONE;
    }
  }

  public class ConvertRef implements StateHandler<State> {
    IFuture<GeneratedMessageV3, ErrorException> pb;

    @Override
    public void registerCalls() {
      pb = m_service.get(m_id);
    }

    @Override
    public State handleState() {
      m_builder.mergeFrom(m_convertor.refUpdater(m_pb));
      return State.DONE;
    }
  }

}
