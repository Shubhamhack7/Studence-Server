package com.tiwari.studence.util.module;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.tiwari.studence.util.serverConfig.IServerListener;
import com.tiwari.studence.util.serverConfig.ServerListener;

public class ServerListnerModule extends AbstractModule{

  @Override
  protected void configure() {
    bind(IServerListener.class).to(ServerListener.class);
  }

}
