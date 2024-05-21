package com.tiwari.studence.teacher.converter;

import com.tiwari.studence.common.service.v1.convertor.AEntityConvertor;
import com.tiwari.studence.proto.teacher.TeacherPb;
import com.tiwari.studence.proto.teacher.TeacherSearchReqPb;
import com.tiwari.studence.proto.teacher.TeacherSearchRespPb;
import com.tiwari.studence.teacher.provider.TeacherProvider;
import com.tiwari.studence.teacher.provider.TeacherSearchReqRespProvider;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TeacherConverter extends
        AEntityConvertor<TeacherPb, TeacherPb.Builder, TeacherProvider, TeacherSearchReqPb, TeacherSearchReqPb.Builder, TeacherSearchRespPb, TeacherSearchRespPb.Builder, TeacherSearchReqRespProvider> {
  @Inject
  public TeacherConverter(TeacherProvider builderProvider,
                          JsonBaseEncoderDecoder jsonBaseEncoderDecoder, TeacherSearchReqRespProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
