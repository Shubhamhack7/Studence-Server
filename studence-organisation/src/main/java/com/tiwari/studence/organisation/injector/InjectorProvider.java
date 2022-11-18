package com.tiwari.studence.organisation.injector;

import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tiwari.studence.organisation.module.OrganisationModule;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;
import com.tiwari.studence.util.serverConfig.ServerListener;

public class InjectorProvider {

  public static Injector createInjector() {
    Injector injector = Guice.createInjector(getModules());
    // injector.getInstance(ServiceModule.class);
    ServerListener env = injector.getInstance(ServerListener.class);
    env.setEnvironmentType(ServerEnvironmentType.DEVELOPEMENT);
    return injector;
  }

  public static List<AbstractModule> getModules() {
    List<AbstractModule> modulesList = Lists.newArrayList();
    modulesList.addAll(com.tiwari.studence.common.injector.InjectorProvider.getModules());
    modulesList.add(new OrganisationModule());
    return modulesList;
  }

}