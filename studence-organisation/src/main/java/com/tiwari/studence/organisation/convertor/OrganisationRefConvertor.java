package com.tiwari.studence.organisation.convertor;

import com.tiwari.studence.common.refConvertor.IRefConvetor;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationRefPb;
import com.tiwari.studence.util.entity.EntityUtilHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OrganisationRefConvertor implements IRefConvetor<OrganisationRefPb, OrganisationPb> {

  @Inject
  public OrganisationRefConvertor() {

  }

  @Override
  public OrganisationRefPb refUpdater(OrganisationPb pb) {
    OrganisationRefPb.Builder builder = OrganisationRefPb.newBuilder();
    builder.setDbInfoId(pb.getDbInfo());
    builder.setName(pb.getName().getCanonicalName());
    return builder.build();
  }
}
