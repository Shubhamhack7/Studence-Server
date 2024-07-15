package com.tiwari.studence.organisation.updateListener;

import com.tiwari.studence.common.listener.ATableUpdateListener;
import com.tiwari.studence.proto.organisation.OrganisationPb;

import javax.inject.Inject;

public class OrganisationTableUpdateListener extends ATableUpdateListener<OrganisationPb> {

  @Inject
  public OrganisationTableUpdateListener() {
      super();
  }
}
