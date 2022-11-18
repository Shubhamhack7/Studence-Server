package com.tiwari.studence.util.serverConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServerListener implements IServerListener {

  private ServerEnvironmentType m_environment;

  @Inject
  public ServerListener() {

  }

  @Override
  public ServerEnvironmentType getEnvironmentType() {
    return m_environment;
  }

  @Override
  public void setEnvironmentType(ServerEnvironmentType m_environment) {
    this.m_environment = m_environment;
  }

}
