package com.tiwari.studence.organisation.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.services.AEntityService;
import com.tiwari.studence.organisation.convertor.OrganisationConvertor;
import com.tiwari.studence.organisation.indexer.OrganisationIndexer;
import com.tiwari.studence.organisation.provider.OraganisationTableNameProvider;
import com.tiwari.studence.organisation.provider.OrganisationPbProvider;
import com.tiwari.studence.organisation.provider.OrganisationSearchPbProvider;
import com.tiwari.studence.organisation.searcher.OrganisationSearcher;
import com.tiwari.studence.organisation.updater.OrganisationUpdater;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;
import com.tiwari.studence.util.exception.ErrorException;

@Singleton
public class OrgansationService extends
        AEntityService<OrganisationPb, OrganisationSearchReqPb,OrganisationSearchReqPb.Builder, OrganisationSearchRespPb, OrganisationPb.Builder, OrganisationPbProvider, OrganisationSearchRespPb.Builder, OrganisationSearchPbProvider, OrganisationIndexer, OrganisationUpdater, OrganisationConvertor, OrganisationSearcher, OraganisationTableNameProvider>
        implements IOrganisationService {

  @Inject
  public OrgansationService(OrganisationSearcher searcher, OrganisationUpdater updator,
          OrganisationConvertor convertor, OrganisationPbProvider builderProvder,
          OrganisationSearchPbProvider requestBuilderprovider,
          OraganisationTableNameProvider tableNameProvider, IGetEntityId getNewId,
          IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
          IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<OrganisationPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<OrganisationPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<OrganisationPb, ErrorException> create(OrganisationPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<OrganisationPb, ErrorException> delete(String entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IFuture<OrganisationPb, ErrorException> update(String id,OrganisationPb entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IFuture<OrganisationSearchRespPb, ErrorException> search(OrganisationSearchReqPb entity) {
    return super.searchEntity(entity);
  }

}
