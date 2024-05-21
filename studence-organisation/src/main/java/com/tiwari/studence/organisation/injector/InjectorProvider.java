package com.tiwari.studence.organisation.injector;

import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tiwari.studence.common.module.AlarmServerModule;
import com.tiwari.studence.common.module.AwsDynamoDbRangeModule;
import com.tiwari.studence.common.module.IdProtoPbModule;
import com.tiwari.studence.common.module.PaginationTokenUiPbModule;
import com.tiwari.studence.common.service.v2.aws.AwsCredentialsModule;
import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClientModule;
import com.tiwari.studence.organisation.module.OrganisationModule;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.module.ExecutorModule;
import com.tiwari.studence.util.module.ServerExceptionModule;
import com.tiwari.studence.util.module.ServerListnerModule;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;
import com.tiwari.studence.util.serverConfig.ServerListener;

public class InjectorProvider {

  public static Injector createInjector() {
    Injector injector = Guice.createInjector(getModules());
    // injector.getInstance(ServiceModule.class);
    ServerListener env = injector.getInstance(ServerListener.class);
    env.setEnvironmentType(ServerEnvironmentType.DEVELOPMENT);

    return injector;
  }

  public static List<AbstractModule> getModules() {
    List<AbstractModule> modulesList = Lists.newArrayList();
    modulesList.addAll(com.tiwari.studence.common.injector.InjectorProvider.getModules());
    modulesList.add(new ServerEnvironmentType.ServerEnvironmentTypeModule());
    modulesList.add(new ExecutorModule());
    modulesList.add(new AwsDynamoDbRangeModule());
    modulesList.add(new AwsCredentialsModule());
    modulesList.add(new AwsDynamoDbAsyncClientModule());
    modulesList.add(new ServerExceptionModule());
    modulesList.add(new PaginationTokenUiPbModule());
    modulesList.add(new AlarmServerModule());
    modulesList.add(new IdProtoPbModule());
    modulesList.add(new OrganisationModule());
    modulesList.add(new ServerListnerModule());
    return modulesList;
  }

}