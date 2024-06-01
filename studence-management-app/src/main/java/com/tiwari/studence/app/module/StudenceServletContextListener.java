package com.tiwari.studence.app.module;

import com.google.inject.*;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.tiwari.studence.common.injector.StaticInjectorProvider;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;
import com.tiwari.studence.util.serverConfig.SystemPropertyUtility;

import javax.servlet.ServletContextEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class StudenceServletContextListener extends GuiceServletContextListener {
  private static final Logger LOGGER = Logger.getLogger(
          GuiceServletContextListener.class.getCanonicalName());

  @Singleton
  private static class EnvironmentModule extends PrivateModule {
    @Override
    protected void configure() {
      TypeLiteral<Set<AbstractModule>> moduleSet = new TypeLiteral<Set<AbstractModule>>() {
      };
      bind(moduleSet).annotatedWith(Names.named("ModulesSet"))
              .toInstance(Collections.synchronizedSet(new HashSet<AbstractModule>()));
      expose(moduleSet).annotatedWith(Names.named("ModulesSet"));
      bind(ServerEnvironmentType.class).toInstance(getServerEnvironment());
      expose(ServerEnvironmentType.class);
    }

    public ServerEnvironmentType getServerEnvironment() {
      final String serverEnv = SystemPropertyUtility.getSERVER_ENV();
      if (serverEnv.equals(SystemPropertyUtility.SERVER_ENV_VALUE_PROD)) {
        return ServerEnvironmentType.PRODUCTION;
      }
      if (serverEnv.equals(SystemPropertyUtility.SERVER_ENV_VALUE_DEVEL)) {
        return ServerEnvironmentType.DEVELOPMENT;
      }
      return ServerEnvironmentType.UNKNOWN_SERVER;
    }
  }

  private final Injector m_injector;
  private Thread myThread;

  public StudenceServletContextListener() {
    System.out.println("StudenceServletContextListener");
  /*  try {
      Injector injector = Guice.createInjector(new EnvironmentModule());
      injector.getInstance(StudenceManagementServiceModule.class);

      TypeLiteral<Set<AbstractModule>> moduleSet = new TypeLiteral<Set<AbstractModule>>() {
      };
      Set<AbstractModule> modules = injector.getInstance(Key.get(moduleSet, Names.named("ModulesSet")));
      injector.createChildInjector(modules.toArray(new AbstractModule[0]));
    }catch (Exception e){
      e.printStackTrace();
      LOGGER.warning(e.getMessage());
    }*/
    Injector injector = Guice.createInjector(new EnvironmentModule());
    injector.getInstance(StudenceManagementServiceModule.class);

    TypeLiteral<Set<AbstractModule>> moduleSet = new TypeLiteral<Set<AbstractModule>>() {
    };
    Set<AbstractModule> modules = injector.getInstance(Key.get(moduleSet, Names.named("ModulesSet")));
    injector.createChildInjector(modules.toArray(new AbstractModule[0]));
    m_injector = injector.createChildInjector(modules.toArray(new AbstractModule[0]));
    StaticInjectorProvider.setInjector(m_injector);

  }

  @Override
  public void contextInitialized(ServletContextEvent event) {
    // Start any background tasks or threads here
    Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
      // Log the uncaught exception here
      throwable.printStackTrace();
    });
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    super.contextDestroyed(servletContextEvent);
    if (myThread != null && myThread.isAlive()) {
      myThread.interrupt();
      try {
        myThread.join();
      } catch (InterruptedException e) {
        // ignore
      }
    }
  }

  @Override
  protected Injector getInjector() {
    return m_injector;
  }

}
