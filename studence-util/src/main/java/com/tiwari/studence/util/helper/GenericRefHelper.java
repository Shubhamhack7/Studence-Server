package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.genericRef.GenericRefPb;
import com.tiwari.studence.proto.genericRef.OrganisationCampusGenericRefPb;
import com.tiwari.studence.util.common.Strings;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GenericRefHelper {
  @Inject
  public GenericRefHelper() {
  }

  public void updateGenricRefHelper(GenericRefPb.Builder refBuilder, GenericRefPb ref) {
    if (Strings.notEmpty(ref.getDbInfoId())) {
      refBuilder.setDbInfoId(ref.getDbInfoId());
    }
    if (Strings.notEmpty(ref.getName())) {
      refBuilder.setName(ref.getName());
    }
  }

  public void updateCampusAndOrganisationGenericRef(
          OrganisationCampusGenericRefPb.Builder refBuilder, OrganisationCampusGenericRefPb ref) {
    if (Strings.notEmpty(ref.getCampusDbInfoId())) {
      refBuilder.setCampusDbInfoId(ref.getCampusDbInfoId());
    }
    if (Strings.notEmpty(ref.getCampusName())) {
      refBuilder.setCampusName(ref.getCampusName());
    }
    if (Strings.notEmpty(ref.getOrganistionRef().getDbInfoId())) {
      refBuilder.getOrganistionRefBuilder().setDbInfoId(ref.getOrganistionRef().getDbInfoId());
    }
    if (Strings.notEmpty(ref.getOrganistionRef().getName())) {
      refBuilder.getOrganistionRefBuilder().setName(ref.getOrganistionRef().getName());
    }
  }
}
