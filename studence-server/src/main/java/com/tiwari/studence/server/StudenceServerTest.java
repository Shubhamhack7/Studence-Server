package com.tiwari.studence.server;

import com.google.inject.Injector;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.contactDetails.ISDCode;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.server.injector.InjectorProvider;
import com.tiwari.studence.server.organisationCreateAndCampus.service.IOrganisationCreateAndCampusCreate;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.Map;
import java.util.Set;

public class StudenceServerTest {
  public static void main(String[] args) throws ErrorException {
    Injector injector = InjectorProvider.createInjector();
    createOrgAndCampus(injector);

  }

  private static void createOrgAndCampus(Injector injector) throws ErrorException {
    IOrganisationCreateAndCampusCreate OCAC = injector.getInstance(
            IOrganisationCreateAndCampusCreate.class);
    OrganisationPb.Builder organisation = OrganisationPb.newBuilder();
    organisation.getNameBuilder().setFirstName("Rameshwaram");
    organisation.getNameBuilder().addMiddleName("International");
    organisation.getNameBuilder().setLastName("Academy");
    organisation.getContactDetailsBuilder().getEmailsBuilder().getPrimaryBuilder()
            .setLocalPart("rameshwaram");
    organisation.getContactDetailsBuilder().getEmailsBuilder().getPrimaryBuilder()
            .setDomainPart("gmail.com");
    organisation.getContactDetailsBuilder().getMobileNumbersBuilder().getPrimaryBuilder()
            .setCode(ISDCode.ISD_NINETY_ONE);
    organisation.getContactDetailsBuilder().getMobileNumbersBuilder().getPrimaryBuilder()
            .setNumber("9621019232");
    organisation.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder()
            .setArea("Fialzullagaj");
    organisation.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder()
            .setStreet("Jugal vihar colony");
    organisation.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder()
            .setLandmark("Near water tank");
    organisation.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder().setCity("LKO");
    organisation.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder()
            .setCountry("INDIA");
    organisation.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder()
            .setPincode("226020");

    CampusPb.Builder campus = CampusPb.newBuilder();
    campus.getNameBuilder().setFirstName("Rameshwaram");
    campus.getNameBuilder().addMiddleName("International");
    campus.getNameBuilder().setLastName("Academy");
    campus.getContactDetailsBuilder().getEmailsBuilder().getPrimaryBuilder()
            .setLocalPart("rameshwaram");
    campus.getContactDetailsBuilder().getEmailsBuilder().getPrimaryBuilder()
            .setDomainPart("gmail.com");
    campus.getContactDetailsBuilder().getMobileNumbersBuilder().getPrimaryBuilder()
            .setCode(ISDCode.ISD_NINETY_ONE);
    campus.getContactDetailsBuilder().getMobileNumbersBuilder().getPrimaryBuilder()
            .setNumber("9621019232");
    campus.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder()
            .setArea("Fialzullagaj");
    campus.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder()
            .setStreet("Jugal vihar colony");
    campus.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder()
            .setLandmark("Near water tank");
    campus.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder().setCity("LKO");
    campus.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder().setCountry("INDIA");
    campus.getContactDetailsBuilder().getAddressBuilder().getPrimaryBuilder().setPincode("226020");

    OrganisationCreateAndCampusCreateReqPb.Builder builder = OrganisationCreateAndCampusCreateReqPb.newBuilder();
    builder.setOrganisation(organisation.build());
    builder.setCampus(campus.build());
   // System.out.println(OCAC.executeService(builder.build()).get());
    System.out.println(encode(organisation.build()));
  }

  public static String encode(GeneratedMessageV3 message) {
    StringBuilder jsonBuilder = new StringBuilder();
    encodeMessage(message, jsonBuilder);
    return jsonBuilder.toString();
  }

  private static void encodeMessage(GeneratedMessageV3 message, StringBuilder jsonBuilder) {
    jsonBuilder.append("{");
    boolean hasContent = false;
    Set<Map.Entry<Descriptors.FieldDescriptor, Object>> a = message.getAllFields().entrySet();
    for (var entry : message.getAllFields().entrySet()) {
      int fieldName = entry.getKey().getNumber();
      Object fieldValue = entry.getValue();

      if (fieldValue instanceof GeneratedMessageV3) {
        encodeMessage((GeneratedMessageV3) fieldValue, jsonBuilder.append("\"" + fieldName + "\":"));
      } else if (fieldValue instanceof Number) {
        if (hasContent) {
          jsonBuilder.append(",");
        }
        jsonBuilder.append("\"" + fieldName + "\":" + fieldValue);
        hasContent = true;
      }
      // Optionally handle other numeric types here
    }
    jsonBuilder.append("}");
  }
}
