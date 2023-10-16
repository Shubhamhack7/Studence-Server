package com.tiwari.studence.firebase.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.firebase.service.FirebaseService;
import com.tiwari.studence.firebase.service.IFirebaseService;

public class FirebaseServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IFirebaseService.class).to(FirebaseService.class);
  }
}
