package com.tiwari.studence.organisation.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.entity.create.GCreateEntity;
import com.tiwari.studence.organisation.convertor.OrganisationUiPbConvertor;
import com.tiwari.studence.organisation.store.OrganisationEntityStore;
import com.tiwari.studence.organisation.updater.OrganisationUiPbServiceUpdater;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationUiPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OrganisationUiPbService implements IOrganisationUiPbService {

  private final GCreateEntity<OrganisationPb, OrganisationUiPb, OrganisationEntityStore, OrganisationUiPbConvertor, OrganisationUiPbServiceUpdater> gCreate;

  @Inject
  OrganisationUiPbService(
          GCreateEntity<OrganisationPb, OrganisationUiPb, OrganisationEntityStore, OrganisationUiPbConvertor, OrganisationUiPbServiceUpdater> gCreate) {
    this.gCreate = gCreate;
  }

  @Override
  public IFuture<OrganisationUiPb, ErrorException> createEntity(OrganisationUiPb request) {
    return gCreate.createEntity(request);
  }
}
