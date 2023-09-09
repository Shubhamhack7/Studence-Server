package com.tiwari.studence.campus.helper;

import com.tiwari.studence.proto.campus.CampusRefPb;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;

import javax.inject.Inject;

public class CampusHelper {
    @Inject
    CampusHelper(){}
    private NameHelper m_nameHelper;
    private ContactDetailsHelper m_contactDetailsHelper;


    public void updateCampusRef(CampusRefPb pb, CampusRefPb.Builder builder ){
        if(Strings.notEmpty(pb.getDbInfoId())){
            builder.setDbInfoId(pb.getDbInfoId());
        }
        if (Strings.notEmpty(pb.getName())) {
            builder.setName(pb.getName());
        }

        if(Strings.notEmpty(pb.getOrganisationRef().getDbInfoId())){
            builder.setOrganisationRef(pb.getOrganisationRef());
        }
    }
}
