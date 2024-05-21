package com.tiwari.studence.organisation.module;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.interfaces.IPbBuilderProvider;
import com.tiwari.studence.organisation.bquery.IOrganisationBigQueryService;
import com.tiwari.studence.organisation.bquery.OrganisationBigQueryService;
import com.tiwari.studence.organisation.provider.OrganisationPbBuilderProvider;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.organisation.service.IOrganisationUiPbService;
import com.tiwari.studence.organisation.service.OrganisationUiPbService;
import com.tiwari.studence.organisation.service.OrgansationService;
import com.tiwari.studence.organisation.wrapper.OrganisationProtoWrapper;
import com.tiwari.studence.proto.organisation.OrganisationPb;

public class OrganisationModule  extends AbstractModule{

  @Override
  protected void configure() {

    bind(IOrganisationService.class).to(OrgansationService.class);
    bind(IOrganisationBigQueryService.class).to(OrganisationBigQueryService.class);
    bind(IOrganisationUiPbService.class).to(OrganisationUiPbService.class);
    TypeLiteral<IPbBuilderProvider<OrganisationPb.Builder>> pbBuilderLiteral = new TypeLiteral<IPbBuilderProvider<OrganisationPb.Builder>>() {
    };
    bind(pbBuilderLiteral).to(OrganisationPbBuilderProvider.class);
    TypeLiteral<IEntityProtoWrapper<OrganisationPb>> pbProtoWrapperLiteral = new TypeLiteral<IEntityProtoWrapper<OrganisationPb>>() {
    };
    bind(pbProtoWrapperLiteral).to(OrganisationProtoWrapper.class);
   // bind(IEntityProtoWrapper.class).to(OrganisationProtoWrapper.class);

  }

}
