package com.tiwari.studence.organisation.provider;

import com.tiwari.studence.common.prtovider.IPbBuilderProvider;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb.Builder;

public class OrganisationSearchPbProvider
        implements IPbBuilderProvider<OrganisationSearchRespPb, OrganisationSearchRespPb.Builder> {

  @Override
  public Builder getBuilder() {
    return OrganisationSearchRespPb.newBuilder();
  }

  @Override
  public Builder getBuilder(OrganisationSearchRespPb builder) {
    return OrganisationSearchRespPb.newBuilder(builder);
  }

}
