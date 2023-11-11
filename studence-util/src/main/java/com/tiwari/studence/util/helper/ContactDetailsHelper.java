package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.contactDetails.*;
import com.tiwari.studence.util.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.formatter.ISDCodeFormatter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ContactDetailsHelper {

    private ISDCodeFormatter m_isdCodeFormatter;

    @Inject
    ContactDetailsHelper(ISDCodeFormatter isdCodeFormatter) {
        m_isdCodeFormatter=isdCodeFormatter;
    }

    public void updateContactDetails(ContactDetailsPb contactDetails, ContactDetailsPb.Builder contactDetailsBuilder) {
        if (contactDetails.getAddress().hasPrimary()) {
            updateAddreses(contactDetails.getAddress(), contactDetailsBuilder.getAddressBuilder());
        }
        if (contactDetails.getEmails().hasPrimary()) {
            updateEmails(contactDetails.getEmails(), contactDetailsBuilder.getEmailsBuilder());
        }
        if (contactDetails.getMobileNumbers().hasPrimary()) {
            updateMobiles(contactDetails.getMobileNumbers(), contactDetailsBuilder.getMobileNumbersBuilder());
        }
    }

    private void updateMobiles(MobileNumbersPb mobileNumbers, MobileNumbersPb.Builder mobileNumbersBuilder) {
        updateMobile(mobileNumbers.getPrimary(),mobileNumbersBuilder.getPrimaryBuilder());
        mobileNumbers.getOthersList().forEach(mobileNumber_others -> {
            updateMobile(mobileNumber_others, mobileNumbersBuilder.addOthersBuilder());
        });
    }

    public void updateMobile(MobileNumberPb primary, MobileNumberPb.Builder primaryBuilder) {
        primaryBuilder.setCode(primary.getCode());
        primaryBuilder.setNumber(primary.getNumber());
        primaryBuilder.setCanonicalNumber(m_isdCodeFormatter.getStringValue(primary.getCode())+primary.getNumber());
    }

    private void updateEmails(EmailsPb emails, EmailsPb.Builder emailsBuilder) {
        updateEmail(emails.getPrimary(), emailsBuilder.getPrimaryBuilder());
        emails.getOthersList().forEach(emails_others -> {
            updateEmail(emails_others, emailsBuilder.addOthersBuilder());
        });
    }

    public void updateEmail(EmailPb primary, EmailPb.Builder primaryBuilder) {
        primaryBuilder.setLocalPart(primary.getLocalPart());
        primaryBuilder.setDomainPart(primary.getDomainPart());
        primaryBuilder.setCanonicalEmail(primary.getLocalPart() + StudenceSpecialCharecterEnum.AT_SIGN.getSign() + primary.getDomainPart());
    }

    private void updateAddreses(AddressesPb address, AddressesPb.Builder addressBuilder) {
        updateAddress(address.getPrimary(), addressBuilder.getPrimaryBuilder());
        address.getOthersList().forEach(add_others -> {
            updateAddress(add_others, addressBuilder.addOthersBuilder());
        });

    }

    private void updateAddress(AddressPb primary, AddressPb.Builder primaryBuilder) {
        StringBuilder canonicalAddress = new StringBuilder();
        primaryBuilder.setStreet(primary.getStreet().toLowerCase());
        canonicalAddress.append(primary.getStreet().toLowerCase());
        primaryBuilder.setArea(primary.getArea().toLowerCase());
        canonicalAddress.append(StudenceSpecialCharecterEnum.COMMA.getSign());
        canonicalAddress.append(primary.getArea().toLowerCase());
        primaryBuilder.setLandmark(primary.getLandmark().toLowerCase());
        canonicalAddress.append(StudenceSpecialCharecterEnum.COMMA.getSign());
        canonicalAddress.append(primary.getLandmark().toLowerCase());
        primaryBuilder.setCity(primary.getCity().toLowerCase());
        canonicalAddress.append(StudenceSpecialCharecterEnum.COMMA.getSign());
        canonicalAddress.append(primary.getCity().toLowerCase());
        primaryBuilder.setPincode(primary.getPincode());
        canonicalAddress.append(StudenceSpecialCharecterEnum.COMMA.getSign());
        canonicalAddress.append(primary.getPincode());
        primaryBuilder.setState(primary.getState().toLowerCase());
        canonicalAddress.append(StudenceSpecialCharecterEnum.COMMA.getSign());
        canonicalAddress.append(primary.getState().toLowerCase());
        primaryBuilder.setCountry(primary.getCountry().toLowerCase());
        primaryBuilder.setCanonicalAddress(canonicalAddress.toString().toLowerCase());
    }
}
