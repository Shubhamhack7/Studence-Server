package com.tiwari.studence.server.organisationCreateAndCampus.service;

import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateRespPb;
import com.tiwari.studence.util.exception.ErrorException;

public class OrganisationCreateAndCampusCreateService implements IOrganisationCreateAndCampusCreate{
  private IOrganisationService m_organisationService;
  private ICampusService m_campusService;

  @Override
  public IFuture<OrganisationCreateAndCampusCreateRespPb, ErrorException> executeService(
          OrganisationCreateAndCampusCreateReqPb pb) {
    return null;
  }
}
