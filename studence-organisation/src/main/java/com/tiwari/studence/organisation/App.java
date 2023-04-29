package com.tiwari.studence.organisation;

import com.google.inject.Injector;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tiwari.studence.organisation.bquery.OrganisationBigQueryService;
import com.tiwari.studence.organisation.injector.InjectorProvider;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.contactDetails.AddressPb;
import com.tiwari.studence.proto.contactDetails.EmailPb;
import com.tiwari.studence.proto.contactDetails.ISDCode;
import com.tiwari.studence.proto.contactDetails.MobileNumberPb;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
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
      OrganisationPb.Builder builder = OrganisationPb.newBuilder();
      builder.getNameBuilder().setFirstName("ABC");
      builder.getNameBuilder().addMiddleName("Senior");
      builder.getNameBuilder().addMiddleName("Secondary");
      builder.getNameBuilder().setLastName("School");
      builder.getContactDetailsBuilder().getEmailsBuilder().getPrimaryBuilder().setLocalPart("abc");
        builder.getContactDetailsBuilder().getEmailsBuilder().getPrimaryBuilder().setLocalPart("gmail.com");
        EmailPb.Builder bu = builder.getContactDetailsBuilder().getEmailsBuilder().addOthersBuilder();
        bu.setLocalPart("abc123");
        bu.setDomainPart("hotmail.com");
        EmailPb.Builder bu1 = builder.getContactDetailsBuilder().getEmailsBuilder().addOthersBuilder();
        bu1.setLocalPart("abc123efg");
        bu1.setDomainPart("outlook.com");
    builder.getContactDetailsBuilder().getMobileNumbersBuilder().getPrimaryBuilder().setCode(ISDCode.ISD_NINETY_ONE).setNumber("9999999999");
    MobileNumberPb.Builder mbu = builder.getContactDetailsBuilder().getMobileNumbersBuilder().addOthersBuilder();
    mbu.setNumber("9999999998").setCode(ISDCode.ISD_NINETY_ONE);
        MobileNumberPb.Builder mbu2 = builder.getContactDetailsBuilder().getMobileNumbersBuilder().addOthersBuilder();
        mbu2.setNumber("9999999997").setCode(ISDCode.ISD_ONE);
        builder.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder().setStreet("123 jugal vihar").setArea("faizullaganj")
                .setLandmark("near watertank").setCity("Lucknow").setPincode("226020").setState("Uttar pradesh").setCountry("India");
        AddressPb.Builder adbu = builder.getContactDetailsBuilder().getAddressBuilder().addOthersBuilder();
        adbu.setStreet("123 jugal vihar").setArea("faizullaganj")
            .setLandmark("near watertank").setCity("Lucknow").setPincode("226020").setState("New York").setCountry("USA");
        System.out.println(a.get("D!3").get());

    }
}
