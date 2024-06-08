package com.tiwari.studence.dump.organisation;

import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.contactDetails.*;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;
import com.tiwari.studence.util.entity.EntityUtilHelper;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.helper.EmailHelper;
import com.tiwari.studence.util.helper.NameHelper;
import org.apache.commons.csv.CSVRecord;

public class CreateOrgAndCampusForDumpCF
        extends AControlFlow<CreateOrgAndCampusForDumpCF.State, String, ErrorException> {

  private IOrganisationService m_organisatonService;
  private ICampusService m_campusService;
  private CSVRecord m_record;
  private OrganisationPb m_organisationPb;
  private NameHelper m_nameHelper;
  private EmailHelper m_emailHelper;

  enum State {
    CHK_ORG,
    CREATE_ORG,
    CREATE_CAMPUS,
    DONE;
  }

  public CreateOrgAndCampusForDumpCF(IOrganisationService organisatonService, CSVRecord record,
          NameHelper nameHelper, EmailHelper emailHelper, ICampusService campusService) {
    super(State.CHK_ORG, State.DONE);
    addStateHandler(State.CHK_ORG, new CheckOrg());
    addStateHandler(State.CREATE_ORG, new CreateOrg());
    addStateHandler(State.CREATE_CAMPUS, new CreateCampus());
    m_organisatonService = organisatonService;
    m_record = record;
    m_nameHelper = nameHelper;
    m_emailHelper = emailHelper;
    m_campusService = campusService;
  }

  public class CheckOrg implements StateHandler<State> {
    IFuture<OrganisationSearchRespPb, ErrorException> m_future;

    @Override
    public void registerCalls() {
      OrganisationSearchReqPb.Builder bu = OrganisationSearchReqPb.newBuilder();
      bu.setName(m_record.get(1));
      m_future = m_organisatonService.search(bu.build());

    }

    @Override
    public State handleState() {
      try {
        if (m_future.get().getSummary().getResultsCount() > 0) {
          m_organisationPb = m_future.get().getResults(0);
          return State.CREATE_CAMPUS;
        } else {
          return State.CREATE_ORG;
        }
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
    }

  }

  public class CreateOrg implements StateHandler<State> {
    IFuture<OrganisationPb, ErrorException> m_future;

    @Override
    public void registerCalls() {

      OrganisationPb.Builder bu = OrganisationPb.newBuilder();
      bu.setName(m_nameHelper.getNamePb(m_record.get(1)));
      bu.getContactDetailsBuilder().getEmailsBuilder()
              .setPrimary(m_emailHelper.getEmailPb(m_record.get(1), "organisation"));
      MobileNumberPb.Builder mobileNumberPb = MobileNumberPb.newBuilder();
      mobileNumberPb.setNumber(m_record.get(6));
      mobileNumberPb.setCode(ISDCode.ISD_NINETY_ONE);
      bu.getContactDetailsBuilder().getMobileNumbersBuilder().setPrimary(mobileNumberPb.build());
      m_future = m_organisatonService.create(bu.build());

    }

    @Override
    public State handleState() {
      try {
        if (m_future.get() != null) {
          m_organisationPb = m_future.get();
          return State.CREATE_CAMPUS;
        } else {
          getAsyncCallback().set(0, m_record.toString());
          return State.DONE;
        }
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
    }

  }

  public class CreateCampus implements StateHandler<State> {
    IFuture<CampusPb, ErrorException> m_future;

    @Override
    public void registerCalls() {

      CampusPb.Builder bu = CampusPb.newBuilder();
      bu.setName(m_nameHelper.getNamePb(m_record.get(2)));
      bu.getContactDetailsBuilder().getEmailsBuilder()
              .setPrimary(m_emailHelper.getEmailPb(m_record.get(2), "campus"));
      MobileNumberPb.Builder mobileNumberPb = MobileNumberPb.newBuilder();
      mobileNumberPb.setNumber(m_record.get(6));
      mobileNumberPb.setCode(ISDCode.ISD_NINETY_ONE);
      bu.getContactDetailsBuilder().getMobileNumbersBuilder().setPrimary(mobileNumberPb.build());
      bu.getOrganisationRefBuilder().setDbInfoId(
              EntityUtilHelper.getDbInfoIdWithSpecialCharecterUsingEntityPb(
                      m_organisationPb.getDbInfo()));
      bu.getOrganisationRefBuilder().setName(m_organisationPb.getName().getCanonicalName());
      bu.setCampusCode(m_record.get(4));
      m_future = m_campusService.create(bu.build());

    }

    @Override
    public State handleState() {
      try {
        if (m_future.get() != null) {
          return State.DONE;
        } else {
          getAsyncCallback().set(0, m_record.toString());
          return State.DONE;
        }
      } catch (ErrorException e) {
        getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
        return State.DONE;
      }
    }

  }

}
