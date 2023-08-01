package com.tiwari.studence.util.database;

import javax.inject.Inject;

import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;

public class TableNameUtil {
  
  @Inject
  public TableNameUtil() {
    // TODO Auto-generated constructor stub
  }

  public String getDynamoProd(String name) {
    return name + "_PROD";
  }

  public String getDynamoDevel(String name) {
    return name + "_DEVEL";
  }

  public String getTableOverServerEnvironmentType(ServerEnvironmentType type, String name) {
    if (type == ServerEnvironmentType.PRODUCTION) {
      return getDynamoProd(name);
    } else if (type == ServerEnvironmentType.DEVELOPMENT) {
      return getDynamoDevel(name);
    } else {
      return "";
    }
  }

}
