package com.tiwari.studence.server.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tiwari.studence.campus.module.CampusModule;
import com.tiwari.studence.firebase.initializer.FirebaseInitializer;
import com.tiwari.studence.firebase.module.FirebaseServiceModule;
import com.tiwari.studence.login.module.LoginModule;
import com.tiwari.studence.organisation.module.OrganisationModule;
import com.tiwari.studence.server.createLogin.module.CreateLoginModule;
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
    FirebaseInitializer.init();
    return injector;
  }

  public static List<AbstractModule> getModules() {
    List<AbstractModule> modulesList = Lists.newArrayList();
    modulesList.addAll(com.tiwari.studence.common.injector.InjectorProvider.getModules());
    modulesList.add(new ServerEnvironmentType.ServerEnvironmentTypeModule());
    modulesList.add(new OrganisationModule());
    modulesList.add(new CampusModule());
    modulesList.add(new CreateLoginModule());
    modulesList.add(new LoginModule());
    modulesList.add(new FirebaseServiceModule());
    modulesList.add(new ServerListnerModule());
    return modulesList;
  }

}