package com.tiwari.studence.util.serverConfig;

import com.google.inject.AbstractModule;

import javax.inject.Inject;

public enum ServerEnvironmentType {


    UNKNOWN_SERVER,
    PRODUCTION,
    QA,
    PRODUCTION_TEST,
    DEVELOPMENT;


    @Inject
    ServerEnvironmentType() {

    }


    //For Developent only do not add in mian module class
    public static class ServerEnvironmentTypeModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(ServerEnvironmentType.class).toInstance(ServerEnvironmentType.DEVELOPMENT);
        }
    }

}
