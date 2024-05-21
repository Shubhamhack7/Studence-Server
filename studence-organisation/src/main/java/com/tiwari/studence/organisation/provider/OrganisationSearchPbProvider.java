package com.tiwari.studence.organisation.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;

import javax.inject.Inject;

public class OrganisationSearchPbProvider implements
        IReqRespPbBuilderProvider<OrganisationSearchReqPb, OrganisationSearchReqPb.Builder, OrganisationSearchRespPb, OrganisationSearchRespPb.Builder> {

  @Inject
  OrganisationSearchPbProvider() {

  }

  @Override
  public OrganisationSearchReqPb.Builder getReqBuilder() {
    return OrganisationSearchReqPb.newBuilder();
  }

  @Override
  public OrganisationSearchReqPb.Builder getReqBuilder(OrganisationSearchReqPb builder) {
    return OrganisationSearchReqPb.newBuilder(builder);
  }

  @Override
  public OrganisationSearchRespPb.Builder getRespBuilder() {
    return OrganisationSearchRespPb.newBuilder();
  }

  @Override
  public OrganisationSearchRespPb.Builder getRespBuilder(OrganisationSearchRespPb builder) {
    return OrganisationSearchRespPb.newBuilder(builder);
  }
}
