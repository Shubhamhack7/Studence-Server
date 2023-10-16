package com.tiwari.studence.organisation.provider;

import javax.inject.Singleton;

import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationPb.Builder;

@Singleton
public class OrganisationPbProvider
        implements IPbBuilderProvider<OrganisationPb, Builder> {

  @Override
  public Builder getBuilder() {
    return OrganisationPb.newBuilder();
  }

  @Override
  public Builder getBuilder(OrganisationPb builder) {
    return OrganisationPb.newBuilder(builder);
  }

}
