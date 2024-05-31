package com.tiwari.studence.server.organisationCreateAndCampus.controlFlow;

import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateRespPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;

public class OrganisationCreateAndCampusCreate {
  private IOrganisationService m_organisationService;
  private ICampusService m_campusService;

  @Inject
  OrganisationCreateAndCampusCreate(IOrganisationService organisationService,
          ICampusService campusService) {
    m_organisationService = organisationService;
    m_campusService = campusService;
  }

  public IFuture<OrganisationCreateAndCampusCreateRespPb, ErrorException> organisationCreateAndCampusCreate(
          OrganisationCreateAndCampusCreateReqPb data) {
    OrganisationCreateAndCampusCreateCF cf = new OrganisationCreateAndCampusCreateCF(data,m_organisationService,m_campusService);
    cf.addLogObjects(data);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
