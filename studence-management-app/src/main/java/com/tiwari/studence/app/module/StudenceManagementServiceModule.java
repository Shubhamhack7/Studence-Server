package com.tiwari.studence.app.module;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.servlet.ServletModule;
import com.thetransactioncompany.cors.CORSFilter;
import com.tiwari.studence.app.servlet.MyServlet;
import com.tiwari.studence.common.module.GetAndUpdateEntityIdModule;
import com.tiwari.studence.common.module.GetItemFroomDynamoTableModule;
import com.tiwari.studence.common.module.PutItemDynamoTableModule;
import com.tiwari.studence.dynamodb.database.module.CreateDynamoDbTableModule;
import com.tiwari.studence.organisation.module.OrganisationModule;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.module.ServerExceptionModule;
import com.tiwari.studence.util.module.ServerListnerModule;

@Singleton
public class StudenceManagementServiceModule extends ServletModule {

    @Inject
    public StudenceManagementServiceModule(@Named("ModulesSet") Set<AbstractModule> moduleSet, ServerExceptionModule serverExceptionModule ,ServerListnerModule serverListnerModule, GetItemFroomDynamoTableModule getItemFroomDynamoTableModule, GetAndUpdateEntityIdModule getAndUpdateEntityIdModule, CreateDynamoDbTableModule createDynamoDbTableModule,
                                           PutItemDynamoTableModule putItemDynamoTableModule, OrganisationModule orgnisationModule) {
        moduleSet.add(this);
        moduleSet.add(serverExceptionModule);
        moduleSet.add(serverListnerModule);
        moduleSet.add(getItemFroomDynamoTableModule);
        moduleSet.add(getAndUpdateEntityIdModule);
        moduleSet.add(putItemDynamoTableModule);
        moduleSet.add(createDynamoDbTableModule);
        moduleSet.add(orgnisationModule);
    }

    @Override
    protected void configureServlets() {
        bind(com.thetransactioncompany.cors.CORSFilter.class).in(Singleton.class);
        Map<String, String> corsSupportedMethods = Maps.newHashMap();
        corsSupportedMethods.put("cors.supportedMethods", "PUT,DELETE,GET,POST,HEAD");
        corsSupportedMethods.put("cors.allowOrigin", "*");
        corsSupportedMethods.put("cors.supportedHeaders", "Content-Type");
        filter("/*").through(CORSFilter.class, corsSupportedMethods);
        bind(MyServlet.class).toInstance(new MyServlet());
        //serve("/myservlet*").with(MyServlet.class);
       // serve("/organisation*").with(OrganisationServlet.class);
    }

}
