package com.tiwari.studence.server.organisationCreateAndCampus.provider;

import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateRespPb;

public class OrganisationCreateAndCampusProvider implements
        IReqRespPbBuilderProvider<OrganisationCreateAndCampusCreateReqPb, OrganisationCreateAndCampusCreateReqPb.Builder, OrganisationCreateAndCampusCreateRespPb, OrganisationCreateAndCampusCreateRespPb.Builder> {

  @Override
  public OrganisationCreateAndCampusCreateReqPb.Builder getReqBuilder() {
    return OrganisationCreateAndCampusCreateReqPb.newBuilder();
  }

  @Override
  public OrganisationCreateAndCampusCreateReqPb.Builder getReqBuilder(
          OrganisationCreateAndCampusCreateReqPb builder) {
    return OrganisationCreateAndCampusCreateReqPb.newBuilder(builder);
  }

  @Override
  public OrganisationCreateAndCampusCreateRespPb.Builder getRespBuilder() {
    return OrganisationCreateAndCampusCreateRespPb.newBuilder();
  }

  @Override
  public OrganisationCreateAndCampusCreateRespPb.Builder getRespBuilder(
          OrganisationCreateAndCampusCreateRespPb builder) {
    return OrganisationCreateAndCampusCreateRespPb.newBuilder();
  }
}
