package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.name.NamePb;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NameHelper {

  @Inject
  public NameHelper() {

  }

  public void updateNamePb(NamePb name, NamePb.Builder nameBuilder) {
    StringBuilder canonicalNameBuilder = new StringBuilder(name.getFirstName().toLowerCase());
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

  public NamePb getNamePb(String name) {
    String[] names = name.split(" ");
    NamePb.Builder namePb = NamePb.newBuilder();
    namePb.setFirstName(names[0]);
    namePb.setLastName(names[names.length - 1]);
    for (int i = 1; i < names.length - 1; i++) {
      namePb.addMiddleName(names[i]);
    }
    return namePb.build();
  }
}
