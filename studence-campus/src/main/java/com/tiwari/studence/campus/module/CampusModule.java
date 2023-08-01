package com.tiwari.studence.campus.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.campus.service.CampusService;
import com.tiwari.studence.campus.service.ICampusService;

public class CampusModule extends AbstractModule {
  @Override
  protected void configure(){
    bind(ICampusService.class).to(CampusService.class);
  }
}
