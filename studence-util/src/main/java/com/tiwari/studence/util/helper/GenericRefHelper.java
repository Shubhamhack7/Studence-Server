package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.genericRef.GenericRefPb;
import com.tiwari.studence.util.Strings;

import javax.inject.Inject;

public class GenericRefHelper {
  @Inject
  GenericRefHelper() {
  }

  public void updateGenricRefHelper(GenericRefPb.Builder refBuilder, GenericRefPb ref) {
    if (Strings.notEmpty(ref.getDbInfoId())) {
      refBuilder.setDbInfoId(ref.getDbInfoId());
    }
    if (Strings.notEmpty(ref.getName())) {
      refBuilder.setName(ref.getName());
    }
  }
}
