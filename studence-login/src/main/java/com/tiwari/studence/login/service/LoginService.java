package com.tiwari.studence.login.service;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.entity.IGetEntityId;
import com.tiwari.studence.common.interfaces.IDynamoGetEntityTable;
import com.tiwari.studence.common.interfaces.IDynamoPutTable;
import com.tiwari.studence.common.interfaces.IDynamoUpdateTable;
import com.tiwari.studence.common.service.v1.services.AEntityService;
import com.tiwari.studence.login.convertor.LoginConvertor;
import com.tiwari.studence.login.indexer.LoginIndexer;
import com.tiwari.studence.login.provider.LoginPbProvider;
import com.tiwari.studence.login.provider.LoginSearchPbProvider;
import com.tiwari.studence.login.provider.LoginTableNameProvider;
import com.tiwari.studence.login.searcher.LoginSearcher;
import com.tiwari.studence.login.updater.LoginUpdater;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.proto.login.LoginSearchReqPb;
import com.tiwari.studence.proto.login.LoginSearchRespPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginService extends
        AEntityService<LoginPb, LoginSearchReqPb, LoginSearchReqPb.Builder, LoginSearchRespPb, LoginPb.Builder, LoginPbProvider, LoginSearchRespPb.Builder, LoginSearchPbProvider, LoginIndexer, LoginUpdater, LoginConvertor, LoginSearcher, LoginTableNameProvider>
        implements ILoginService {

  @Inject
  public LoginService(LoginSearcher searcher, LoginUpdater updator, LoginConvertor convertor,
          LoginPbProvider builderProvder, LoginSearchPbProvider requestBuilderprovider,
          LoginTableNameProvider tableNameProvider, IGetEntityId getNewId,
          IDynamoPutTable dynamoPutTable, IDynamoGetEntityTable dynamoGetTable,
          IDynamoUpdateTable dynamoUpdateTable) {
    super(searcher, updator, convertor, builderProvder, requestBuilderprovider, tableNameProvider,
            getNewId, dynamoPutTable, dynamoGetTable, dynamoUpdateTable);
  }

  @Override
  public IFuture<LoginPb, ErrorException> get(String entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<LoginPb, ErrorException> get(EntityPb entity) {
    return super.getEntity(entity);
  }

  @Override
  public IFuture<LoginPb, ErrorException> create(LoginPb entity) {
    return super.createEntity(entity);
  }

  @Override
  public IFuture<LoginPb, ErrorException> delete(String entity) {
    return null;
  }

  @Override
  public IFuture<LoginPb, ErrorException> update(String id, LoginPb entity) {
    return super.updateEntity(id,entity);
  }

  @Override
  public IFuture<LoginSearchRespPb, ErrorException> search(LoginSearchReqPb entity) {
    return super.searchEntity(entity);
  }

  // TODO: Implement LoginService

}
