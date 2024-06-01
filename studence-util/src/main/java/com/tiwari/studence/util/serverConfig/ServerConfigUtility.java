package com.tiwari.studence.util.serverConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServerConfigUtility {
  private final ServerEnvironmentType m_ServerEnvironmentType;


  public ServerConfigUtility(ServerEnvironmentType ServerEnvironmentType) {
    m_ServerEnvironmentType = ServerEnvironmentType;
  }


  @Inject
  public ServerConfigUtility() {
    m_ServerEnvironmentType = ServerEnvironmentType.DEVELOPMENT;
  }

  public boolean validateServerConfig() {
    final String serverEnv = SystemPropertyUtility.getSERVER_ENV();
    if (serverEnv.equals(SystemPropertyUtility.SERVER_ENV_VALUE_PROD)) {
      return m_ServerEnvironmentType == ServerEnvironmentType.PRODUCTION;
    }
    if (serverEnv.equals(SystemPropertyUtility.SERVER_ENV_VALUE_DEVEL)) {
      return m_ServerEnvironmentType == ServerEnvironmentType.DEVELOPMENT;
    }
    return false;
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

  public boolean canRunAlerts() {
    final String serverEnv = SystemPropertyUtility.getSERVER_ENV();
    return validateServerConfig() && (serverEnv.equals(SystemPropertyUtility.SERVER_ENV_VALUE_PROD)
            || serverEnv.equals(SystemPropertyUtility.SERVER_ENV_VALUE_DEVEL));
  }

}