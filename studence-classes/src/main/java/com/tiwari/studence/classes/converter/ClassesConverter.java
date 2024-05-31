package com.tiwari.studence.classes.converter;

import com.tiwari.studence.classes.provider.ClassesProvider;
import com.tiwari.studence.classes.provider.ClassesSearchReqRespProvider;
import com.tiwari.studence.common.service.v1.convertor.AEntityConvertor;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.proto.classes.ClassesSearchReqPb;
import com.tiwari.studence.proto.classes.ClassesSearchRespPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ClassesConverter extends
        AEntityConvertor<ClassesPb, ClassesPb.Builder, ClassesProvider, ClassesSearchReqPb, ClassesSearchReqPb.Builder, ClassesSearchRespPb, ClassesSearchRespPb.Builder, ClassesSearchReqRespProvider> {
  @Inject
  public ClassesConverter(ClassesProvider builderProvider,
                          JsonBaseEncoderDecoder jsonBaseEncoderDecoder, ClassesSearchReqRespProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
