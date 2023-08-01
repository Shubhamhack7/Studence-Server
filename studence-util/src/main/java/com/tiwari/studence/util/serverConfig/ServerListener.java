package com.tiwari.studence.util.serverConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServerListener implements IServerListener {

  private ServerEnvironmentType m_environment;
  private ServerConfigUtility m_serServerConfigUtility;

  @Inject
  public ServerListener(ServerConfigUtility serServerConfigUtility) {
  m_serServerConfigUtility = serServerConfigUtility;
  this.setEnvironmentType(m_serServerConfigUtility.getServerEnvironment());
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
