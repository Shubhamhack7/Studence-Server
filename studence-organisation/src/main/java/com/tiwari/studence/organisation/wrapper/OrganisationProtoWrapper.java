package com.tiwari.studence.organisation.wrapper;

import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.proto.entity.EntityProtoPb;
import com.tiwari.studence.proto.organisation.OrganisationPb;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OrganisationProtoWrapper implements IEntityProtoWrapper<OrganisationPb> {

  @Inject
  OrganisationProtoWrapper(){}
  @Override
  public EntityProtoPb getEntityProto(OrganisationPb entity) {
    return entity.getEntity();
  }

  @Override
  public OrganisationPb setEntityProto(OrganisationPb entity, EntityProtoPb entityProto) {
    return OrganisationPb.newBuilder(entity).setEntity(entityProto).build();
  }
}
