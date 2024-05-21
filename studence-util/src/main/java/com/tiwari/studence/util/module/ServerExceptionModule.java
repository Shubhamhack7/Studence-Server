package com.tiwari.studence.util.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.util.exception.ExceptionLogger;
import com.tiwari.studence.util.log.DebugLogger;
import com.tiwari.studence.util.log.IServerExceptionLogger;

public class ServerExceptionModule  extends AbstractModule {

    @Override
    protected void configure() {
        bind(IServerExceptionLogger.class).to(DebugLogger.class);
    }

}