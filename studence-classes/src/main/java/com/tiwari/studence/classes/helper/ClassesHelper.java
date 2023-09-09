package com.tiwari.studence.classes.helper;

import com.tiwari.studence.proto.campus.CampusRefPb;
import com.tiwari.studence.proto.classes.ClassesRefPb;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;

import javax.inject.Inject;

public class ClassesHelper {
    @Inject
    ClassesHelper(){}
    private NameHelper m_nameHelper;
    private ContactDetailsHelper m_contactDetailsHelper;

    public void updateClassesRef(ClassesRefPb pb, ClassesRefPb.Builder builder ){
        if(Strings.notEmpty(pb.getDbInfoId())){
            builder.setDbInfoId(pb.getDbInfoId());
        }


    }
}
