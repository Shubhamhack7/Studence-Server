package com.tiwari.studence.server.organisationCreateAndCampus.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.server.organisationCreateAndCampus.service.IOrganisationCreateAndCampusCreate;
import com.tiwari.studence.server.organisationCreateAndCampus.service.OrganisationCreateAndCampusCreateService;

public class OrganisationCreateAndCampusModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IOrganisationCreateAndCampusCreate.class).to(
            OrganisationCreateAndCampusCreateService.class);
  }
}
