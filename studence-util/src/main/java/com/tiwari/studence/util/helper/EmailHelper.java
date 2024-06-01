package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.contactDetails.EmailPb;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;

import javax.inject.Inject;

public class EmailHelper {

  @Inject
  EmailHelper() {

  }

  public void updateEmailPb(EmailPb email, EmailPb.Builder emailBuilder) {
    StringBuilder canonicalNameBuilder = new StringBuilder(email.getLocalPart().toLowerCase());
    emailBuilder.setLocalPart(email.getLocalPart().toLowerCase());
    emailBuilder.setDomainPart(email.getDomainPart().toLowerCase());
    canonicalNameBuilder.append(StudenceSpecialCharecterEnum.AT_SIGN.getSign());
    canonicalNameBuilder.append(email.getDomainPart().toLowerCase());
    emailBuilder.setCanonicalEmail(canonicalNameBuilder.toString().toLowerCase());
  }

  //Only For Test DO NOT USE in PROD
  public EmailPb getEmailPb(String email,String local) {
    String emailDomain = email.replace(" ", "") + ".com";
    EmailPb.Builder ebp = EmailPb.newBuilder();
    ebp.setLocalPart(local);
    ebp.setDomainPart(emailDomain);
    return ebp.build();
  }


}
