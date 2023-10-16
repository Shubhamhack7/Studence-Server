package com.tiwari.studence.organisation.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.organisation.bquery.IOrganisationBigQueryService;
import com.tiwari.studence.organisation.bquery.OrganisationBigQueryService;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.organisation.service.OrgansationService;

public class OrganisationModule  extends AbstractModule{

  @Override
  protected void configure() {
    bind(IOrganisationService.class).to(OrgansationService.class);
    bind(IOrganisationBigQueryService.class).to(OrganisationBigQueryService.class);
  }

}
