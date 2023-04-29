package com.tiwari.studence.util.module;

import com.google.inject.AbstractModule;

import com.tiwari.studence.util.serverConfig.IServerListener;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;
import com.tiwari.studence.util.serverConfig.ServerListener;

import javax.inject.Provider;

public class ServerListnerModule extends AbstractModule{

  @Override
  protected void configure() {
    bind(IServerListener.class).to(ServerListener.class);
  }

}
