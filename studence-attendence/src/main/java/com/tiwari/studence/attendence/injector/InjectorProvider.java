package com.tiwari.studence.attendence.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tiwari.studence.attendence.module.AttendenceModule;
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
    modulesList.addAll(com.tiwari.studence.common.injector.InjectorProvider.getModules());
    modulesList.add(new ServerEnvironmentType.ServerEnvironmentTypeModule());
    modulesList.add(new AttendenceModule());
    modulesList.add(new ServerListnerModule());
    return modulesList;
  }

}