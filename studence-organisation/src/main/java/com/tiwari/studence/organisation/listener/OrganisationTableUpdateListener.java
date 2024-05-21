package com.tiwari.studence.organisation.listener;

import com.tiwari.studence.common.executor.BackgroundExecutor;
import com.tiwari.studence.common.service.v2.interfaces.IChangeHandler;
import com.tiwari.studence.common.service.v2.listener.ACompositeTableUpdateListener;
import com.tiwari.studence.organisation.convertor.OrganisationConvertor;
import com.tiwari.studence.organisation.convertor.OrganisationUiPbConvertor;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationUiPb;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OrganisationTableUpdateListener extends
        ACompositeTableUpdateListener<OrganisationPb, OrganisationUiPb, OrganisationUiPbConvertor> {

  @Inject
  public OrganisationTableUpdateListener(OrganisationUiPbConvertor converter,
          BackgroundExecutor backExec) {
    super(converter, backExec);
  }
}