package com.tiwari.studence.student.helper;

import com.tiwari.studence.proto.classes.ClassType;
import com.tiwari.studence.proto.student.StudentRefPb;
import com.tiwari.studence.util.common.Strings;

import javax.inject.Inject;

public class StudentHelper {
    @Inject
    StudentHelper(){}



    public void updateStudentRef(StudentRefPb pb,StudentRefPb.Builder builder ){
        if(Strings.notEmpty(pb.getDbInfoId())){
            builder.setDbInfoId(pb.getDbInfoId());
        }
        if(Strings.notEmpty(pb.getName())){
            builder.setName(pb.getName());
        }
        if(pb.getClassType()!= ClassType.CLASS_UNKNOWN){
            builder.setClassType(pb.getClassType());
        }
        if(Strings.notEmpty(pb.getCampusRef().getDbInfoId())){
            builder.setCampusRef((pb.getCampusRef()));
        }
        if(Strings.notEmpty(pb.getClassRollNo())) {
            builder.setClassRollNo(pb.getClassRollNo());
        }
        if(Strings.notEmpty(pb.getParentRef().getDbInfoId())){
            builder.setParentRef(pb.getParentRef());
        }

    }
}
