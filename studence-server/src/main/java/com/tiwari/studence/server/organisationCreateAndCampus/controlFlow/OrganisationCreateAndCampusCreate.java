package com.tiwari.studence.server.organisationCreateAndCampus.controlFlow;

import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreatePb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;

public class OrganisationCreateAndCampusCreate {
  private IOrganisationService m_organisationService;
  private ICampusService m_campusService;

  @Inject
  OrganisationCreateAndCampusCreate() {

  }

  public IFuture<OrganisationCreateAndCampusCreatePb, ErrorException> organisationCreateAndCampusCreate(
          OrganisationCreateAndCampusCreatePb data) {
    OrganisationCreateAndCampusCreateCF cf = new OrganisationCreateAndCampusCreateCF(data);
    cf.addLogObjects(data);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
