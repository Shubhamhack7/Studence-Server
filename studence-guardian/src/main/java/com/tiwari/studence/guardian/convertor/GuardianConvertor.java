package com.tiwari.studence.guardian.convertor;

import com.tiwari.studence.common.service.v1.convertor.AEntityConvertor;
import com.tiwari.studence.guardian.provider.GuardianPbProvider;
import com.tiwari.studence.guardian.provider.GuardianSearchPbProvider;
import com.tiwari.studence.proto.guardian.GuardianPb;
import com.tiwari.studence.proto.guardian.GuardianSearchReqPb;
import com.tiwari.studence.proto.guardian.GuardianSearchRespPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GuardianConvertor extends
        AEntityConvertor<GuardianPb, GuardianPb.Builder, GuardianPbProvider, GuardianSearchReqPb, GuardianSearchReqPb.Builder, GuardianSearchRespPb, GuardianSearchRespPb.Builder, GuardianSearchPbProvider> {

  @Inject
  public GuardianConvertor(GuardianPbProvider builderProvider,
          JsonBaseEncoderDecoder jsonBaseEncoderDecoder, GuardianSearchPbProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
