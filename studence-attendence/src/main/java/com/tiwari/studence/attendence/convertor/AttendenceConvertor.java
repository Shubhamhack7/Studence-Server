package com.tiwari.studence.attendence.convertor;

import com.tiwari.studence.attendence.provider.AttendencePbProvider;
import com.tiwari.studence.attendence.provider.AttendenceSearchPbProvider;
import com.tiwari.studence.common.service.v1.convertor.AEntityConvertor;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.proto.attendence.AttendenceSearchReqPb;
import com.tiwari.studence.proto.attendence.AttendenceSearchRespPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;

public class AttendenceConvertor
        extends AEntityConvertor<AttendencePb, AttendencePb.Builder, AttendencePbProvider, AttendenceSearchReqPb,AttendenceSearchReqPb.Builder, AttendenceSearchRespPb,AttendenceSearchRespPb.Builder, AttendenceSearchPbProvider> {

  @Inject
  public AttendenceConvertor(AttendencePbProvider builderProvider,
                             JsonBaseEncoderDecoder jsonBaseEncoderDecoder,
                             AttendenceSearchPbProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
