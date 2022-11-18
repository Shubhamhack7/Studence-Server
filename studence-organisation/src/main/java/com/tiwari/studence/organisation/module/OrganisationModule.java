package com.tiwari.studence.organisation.module;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.organisation.service.OrgansationService;

public class OrganisationModule  extends AbstractModule{

  @Override
  protected void configure() {
    bind(IOrganisationService.class).to(OrgansationService.class);
  }

}
