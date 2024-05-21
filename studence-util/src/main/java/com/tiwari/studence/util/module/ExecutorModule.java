package com.tiwari.studence.util.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
public class ExecutorModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(ExecutorService.class).toInstance(Executors.newCachedThreadPool());
    bind(ScheduledExecutorService.class).toInstance(Executors.newScheduledThreadPool(0));
  }

}
