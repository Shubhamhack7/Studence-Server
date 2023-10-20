package com.tiwari.studence.server.organisationCreateAndCampus.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreatePb;
import com.tiwari.studence.server.organisationCreateAndCampus.controlFlow.OrganisationCreateAndCampusCreate;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;

public class OrganisationCreateAndCampusCreateService
        implements IOrganisationCreateAndCampusCreate {

  OrganisationCreateAndCampusCreate m_organisationCreateAndCampusCreate;

  @Inject
  OrganisationCreateAndCampusCreateService(
          OrganisationCreateAndCampusCreate organisationCreateAndCampusCreate) {
    m_organisationCreateAndCampusCreate = organisationCreateAndCampusCreate;
  }

  @Override
  public IFuture<OrganisationCreateAndCampusCreatePb, ErrorException> executeService(
          OrganisationCreateAndCampusCreatePb pb) {
    return m_organisationCreateAndCampusCreate.organisationCreateAndCampusCreate(pb);
  }
}
