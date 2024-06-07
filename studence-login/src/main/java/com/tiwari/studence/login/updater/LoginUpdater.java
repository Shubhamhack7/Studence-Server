package com.tiwari.studence.login.updater;

import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.login.indexer.LoginIndexer;
import com.tiwari.studence.login.provider.LoginPbProvider;
import com.tiwari.studence.proto.login.LoginPb;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginUpdater extends AEntityUpdater<LoginPb,LoginPb.Builder, LoginPbProvider, LoginIndexer> {

  @Inject
  public LoginUpdater(LoginIndexer indexer, LoginPbProvider builderProvider) {
    super(indexer, builderProvider);
  }
}
