package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.name.NamePb;
import com.tiwari.studence.proto.name.NamePbOrBuilder;
import com.tiwari.studence.util.StudenceSpecialCharecterEnum;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NameHelper {
    
    @Inject
    public NameHelper(){
        
    }

    public void updateNamePb(NamePb name, NamePb.Builder nameBuilder) {
        StringBuilder canonicalNameBuilder =  new StringBuilder(name.getFirstName().toLowerCase());
        nameBuilder.setFirstName(name.getFirstName().toLowerCase());
        name.getMiddleNameList().forEach(mid_name -> {
            nameBuilder.addMiddleName(mid_name.toLowerCase());
            canonicalNameBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
            canonicalNameBuilder.append(mid_name.toLowerCase());
        });
        nameBuilder.setLastName(name.getLastName().toLowerCase());
        canonicalNameBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        canonicalNameBuilder.append(name.getLastName().toLowerCase());
        nameBuilder.setCanonicalName(canonicalNameBuilder.toString().toLowerCase());
    }
}
