package com.tiwari.studence.organisation;

import com.google.inject.Injector;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.tiwari.studence.organisation.injector.InjectorProvider;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.util.exception.ErrorException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ErrorException, InvalidProtocolBufferException
    {
      Injector inj = InjectorProvider.createInjector();
      IOrganisationService a  = inj.getInstance(IOrganisationService.class);
      OrganisationPb.Builder builder = OrganisationPb.newBuilder();
      builder.getDbInfoBuilder().setLifetime(LifeTimeEnum.ACTIVE);
      builder.setName("Demo School");
     // System.out.println(JsonFormat.printer().print(builder.build()));
      System.out.println(a.get("4!56").get());
    }
}
