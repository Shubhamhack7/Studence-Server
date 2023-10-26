package com.tiwari.studence.server.organisationCreateAndCampus.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateRespPb;
import com.tiwari.studence.server.organisationCreateAndCampus.controlFlow.OrganisationCreateAndCampusCreate;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OrganisationCreateAndCampusCreateService
        implements IOrganisationCreateAndCampusCreate {

  OrganisationCreateAndCampusCreate m_organisationCreateAndCampusCreate;

  @Inject
  OrganisationCreateAndCampusCreateService(
          OrganisationCreateAndCampusCreate organisationCreateAndCampusCreate) {
    m_organisationCreateAndCampusCreate = organisationCreateAndCampusCreate;
  }

  @Override
  public IFuture<OrganisationCreateAndCampusCreateRespPb, ErrorException> executeService(
          OrganisationCreateAndCampusCreateReqPb pb) {
    return m_organisationCreateAndCampusCreate.organisationCreateAndCampusCreate(pb);
  }
}
