package com.tiwari.studence.server.organisationCreateAndCampus.controlFlow;

import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateRespPb;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.util.entity.EntityUtilHelper;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

public class OrganisationCreateAndCampusCreateCF extends
        AControlFlow<OrganisationCreateAndCampusCreateCF.State, OrganisationCreateAndCampusCreateRespPb, ErrorException> {

  private IOrganisationService m_organisationService;
  private ICampusService m_campusService;
  private OrganisationCreateAndCampusCreateReqPb m_request;
  private OrganisationCreateAndCampusCreateRespPb.Builder m_response;

  public OrganisationCreateAndCampusCreateCF(OrganisationCreateAndCampusCreateReqPb request,
          IOrganisationService organisationService, ICampusService campusService) {
    super(State.CREATE_ORGANISATION, State.DONE);
    m_request = request;
    m_response = OrganisationCreateAndCampusCreateRespPb.newBuilder();
    m_organisationService = organisationService;
    m_campusService = campusService;
    addStateHandler(State.CREATE_ORGANISATION, new CreateOrganisation());
    addStateHandler(State.CREATE_CAMPUS, new CreateCampus());
  }

  enum State {
    CREATE_ORGANISATION,
    CREATE_CAMPUS,
    DONE
  }

  public class CreateOrganisation implements StateHandler<State> {
    IFuture<OrganisationPb, ErrorException> m_future;

    @Override
    public void registerCalls() {
      m_future = m_organisationService.create(m_request.getOrganisation());
    }

    @Override
    public State handleState() {
      try {
        if (EntityUtilHelper.isDbEntityNotEmpty(m_future.get().getDbInfo())) {
          m_response.setOrganisation(m_future.get());
          return State.CREATE_CAMPUS;
        } else {
          getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException("", "", null));
          return State.DONE;
        }
        //getAsyncCallback().set(0, m_future.item());
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
      }
      return State.DONE;
    }

  }

  public class CreateCampus implements StateHandler<State> {
    IFuture<CampusPb, ErrorException> m_future;

    @Override
    public void registerCalls() {
      CampusPb.Builder builer = CampusPb.newBuilder(m_request.getCampus());
      builer.getOrganisationRefBuilder().setDbInfoId(
              EntityUtilHelper.getDbInfoIdWithSpecialCharecterUsingEntityPb(
                      m_response.getOrganisation().getDbInfo()));
      m_future = m_campusService.create(builer.build());
    }

    @Override
    public State handleState() {
      try {
        if (EntityUtilHelper.isDbEntityNotEmpty(m_future.get().getDbInfo())) {
          m_response.setCampus(m_future.get());
          getAsyncCallback().set(0, m_response.build());
          return State.DONE;
        } else {
          getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException("", "", null));
          return State.DONE;
        }
        //getAsyncCallback().set(0, m_future.item());
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
      }
      return State.DONE;
    }

  }
}
