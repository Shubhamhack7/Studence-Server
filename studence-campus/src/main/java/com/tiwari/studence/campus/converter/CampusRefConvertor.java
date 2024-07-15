package com.tiwari.studence.campus.converter;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.refConvertor.IRefConvetor;
import com.tiwari.studence.common.refUpdater.AEntityRefUpdator;
import com.tiwari.studence.organisation.convertor.OrganisationRefConvertor;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.campus.CampusRefPb;
import com.tiwari.studence.util.entity.EntityUtilHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CampusRefConvertor implements IRefConvetor<CampusRefPb, CampusPb> {
  private OrganisationRefConvertor m_organisationRefConvertor;
  @Inject
  public CampusRefConvertor(OrganisationRefConvertor organisationRefConvertor) {
    m_organisationRefConvertor = organisationRefConvertor;
  }

  @Override
  public CampusRefPb refUpdater(CampusPb pb) {
    CampusRefPb.Builder builder = CampusRefPb.newBuilder();
    builder.setDbInfoId(
            EntityUtilHelper.getDbInfoIdWithSpecialCharecterUsingEntityPb(pb.getDbInfo()));
    builder.setName(pb.getName().getCanonicalName());
    return builder.build();
  }
}
