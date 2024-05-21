package com.tiwari.studence.student.converter;

import com.tiwari.studence.common.service.v1.convertor.AEntityConvertor;
import com.tiwari.studence.proto.student.StudentPb;
import com.tiwari.studence.proto.student.StudentSearchReqPb;
import com.tiwari.studence.proto.student.StudentSearchRespPb;
import com.tiwari.studence.student.provider.StudentProvider;
import com.tiwari.studence.student.provider.StudentSearchReqRespProvider;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StudentConverter extends
        AEntityConvertor<StudentPb, StudentPb.Builder, StudentProvider, StudentSearchReqPb, StudentSearchReqPb.Builder, StudentSearchRespPb, StudentSearchRespPb.Builder, StudentSearchReqRespProvider> {
  @Inject
  public StudentConverter(StudentProvider builderProvider,
                          JsonBaseEncoderDecoder jsonBaseEncoderDecoder, StudentSearchReqRespProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
