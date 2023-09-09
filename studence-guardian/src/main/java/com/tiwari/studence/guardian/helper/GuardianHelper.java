package com.tiwari.studence.guardian.helper;

import com.tiwari.studence.proto.guardian.GuardianRefPb;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;

import javax.inject.Inject;

public class GuardianHelper {
    @Inject
    GuardianHelper(){}
    private NameHelper m_nameHelper;
    private ContactDetailsHelper m_contactDetailsHelper;



    public void updateGuardianRef(GuardianRefPb pb, GuardianRefPb.Builder builder ){
        if(Strings.notEmpty(pb.getDbInfoId())){
            builder.setDbInfoId(pb.getDbInfoId());
        }
        if(Strings.notEmpty(pb.getFatherName())){
            builder.setFatherName(pb.getFatherName());
        }
        if(Strings.notEmpty(pb.getMotherName())){
            builder.setFatherName(pb.getMotherName());
        }


    }
}
