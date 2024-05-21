package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.tiwari.studence.common.service.v2.interfaces.IAlarm;
import com.tiwari.studence.common.util.AlarmServer;

import javax.inject.Singleton;

@Singleton
public class AlarmServerModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IAlarm.class).to(AlarmServer.class);
   // expose(IAlarm.class);
  }

}
