package com.tiwari.studence.classes.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tiwari.studence.classes.module.ClassesModule;
import com.tiwari.studence.common.module.*;
import com.tiwari.studence.dynamodb.database.module.CreateDynamoDbTableModule;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.module.ServerListnerModule;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;
import com.tiwari.studence.util.serverConfig.ServerListener;

import java.util.List;

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
    modulesList.add(new ServerListnerModule());
    modulesList.add(new CreateDynamoDbTableModule());
    modulesList.add(new PutItemDynamoTableModule());
    modulesList.add(new GetAndUpdateEntityIdModule());
    modulesList.add(new GetItemFroomDynamoTableModule());
    modulesList.add(new SearchItemDynamoTableModule());
    modulesList.add(new UpdateItemDynamoDbModule());
    modulesList.add(new ClassesModule());
    return modulesList;
  }

}
