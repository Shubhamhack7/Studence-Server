package com.tiwari.studence.organisation.provider;

import com.tiwari.studence.common.service.v2.interfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.organisation.OrganisationPb;

public class OrganisationPbBuilderProvider implements IPbBuilderProvider<OrganisationPb.Builder> {

  @Override
  public OrganisationPb.Builder getPbBuilder() {
    return OrganisationPb.newBuilder();

  }

}
