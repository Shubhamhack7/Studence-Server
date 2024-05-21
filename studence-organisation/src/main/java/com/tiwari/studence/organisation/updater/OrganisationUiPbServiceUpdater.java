package com.tiwari.studence.organisation.updater;

import com.google.protobuf.Message;
import com.tiwari.studence.common.service.v2.handler.AUpdateHandler;
import com.tiwari.studence.common.service.v2.interfaces.IUpdater;
import com.tiwari.studence.common.service.v2.updater.BaseEntityUpdater;
import com.tiwari.studence.common.service.v2.updater.StringParserConfigUiPbUpdater;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationUiPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;

public class OrganisationUiPbServiceUpdater implements IUpdater<OrganisationPb, OrganisationUiPb> {
  private final BaseEntityUpdater m_baseEntityUpdater;
  private final StringParserConfigUiPbUpdater m_stringConfigUiPbToPbHelper;

  @Inject
  public OrganisationUiPbServiceUpdater(BaseEntityUpdater baseEntityUpdater,
          StringParserConfigUiPbUpdater stringConfigUiPbToPbHelper) {
    m_baseEntityUpdater = baseEntityUpdater;
    m_stringConfigUiPbToPbHelper = stringConfigUiPbToPbHelper;
  }

  @Override
  public OrganisationPb update(OrganisationPb current, OrganisationUiPb updateInfo)
          throws ErrorException {
    OrganisationUiPBToPbUpdateHandler h = new OrganisationUiPBToPbUpdateHandler(current);
    h.update(updateInfo);
    return h.hasUpdates() ? h.getUpdated() : null;
  }

  @Override
  public OrganisationPb create(OrganisationUiPb info) throws ErrorException {
    OrganisationUiPBToPbUpdateHandler h = new OrganisationUiPBToPbUpdateHandler();
    h.update(info);
    return h.hasUpdates() ? h.getUpdated() : null;
  }

  private class OrganisationUiPBToPbUpdateHandler
          extends AUpdateHandler<OrganisationPb, OrganisationUiPb> {

    private OrganisationUiPBToPbUpdateHandler(OrganisationPb current) {
      super(current);
    }

    OrganisationUiPBToPbUpdateHandler() {

    }

    @Override
    protected OrganisationPb.Builder createUpdateBuilder() {
      return OrganisationPb.newBuilder();
    }

    @Override
    public void update(OrganisationUiPb updateInfo) throws ErrorException {
      OrganisationPb.Builder pbBuilder = (OrganisationPb.Builder) getUpdateBuilder();

      if (!isForUpdate()) {

      }

      markChanged();
    }
  }
}
