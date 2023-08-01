package com.tiwari.studence.organisation;

import com.google.inject.Injector;
import com.google.protobuf.InvalidProtocolBufferException;
import com.googlecode.protobuf.format.JsonFormat;
import com.tiwari.studence.organisation.injector.InjectorProvider;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.protobuf.ProtobufToJson;

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
      OrganisationSearchReqPb.Builder builder = OrganisationSearchReqPb.newBuilder();
      builder.setName("ram shyam");
      System.out.print(ProtobufToJson.protobufToJsonString(builder.build()));
        //System.out.println(a.search(builder.build()).get());


    }
}
