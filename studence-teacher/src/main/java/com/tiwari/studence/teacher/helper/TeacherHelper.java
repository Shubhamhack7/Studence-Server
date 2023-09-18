package com.tiwari.studence.teacher.helper;

import com.tiwari.studence.proto.classes.ClassType;
import com.tiwari.studence.proto.teacher.TeacherRefPb;
import com.tiwari.studence.util.Strings;

import javax.inject.Inject;

public class TeacherHelper {
    @Inject
    TeacherHelper(){}



    public void updateTeacherRef(TeacherRefPb pb, TeacherRefPb.Builder builder ){
        if(Strings.notEmpty(pb.getDbInfoId())){
            builder.setDbInfoId(pb.getDbInfoId());
        }
        if(Strings.notEmpty(pb.getName())){
            builder.setName(pb.getName());
        }
        if(Strings.notEmpty(pb.getCampusRefId())){
            builder.setCampusRefId(pb.getCampusRefId());
        }
        if(Strings.notEmpty(pb.getClassRef())){
            builder.setClassRef(pb.getClassRef());
        }
    }
}
