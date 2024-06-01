package com.tiwari.studence.util.serverConfig;

import javax.inject.Singleton;

@Singleton
public class SystemPropertyUtility {
  public static final String SERVER_URL_OR_IP_KEY = "SERVER_URL_OR_IP";
  public static final String SERVER_ENV_KEY = "SERVER_ENV";

  public static final String SERVER_ENV_VALUE_PROD = ServerEnvironmentType.PRODUCTION.name();
  public static final String SERVER_ENV_VALUE_DEVEL = ServerEnvironmentType.DEVELOPMENT.name();

  public static String getSERVER_URL_OR_IP() {
    return getProperty(SERVER_URL_OR_IP_KEY);
  }

  public static String getSERVER_ENV() {
    return getProperty(SERVER_ENV_KEY);
  }

  private static String getProperty(String key) {
    String property = System.getProperty(key);
    return property == null ? "" : property;
  }

}