package com.tiwari.studence.campus.converter;

import com.tiwari.studence.campus.provider.CampusProvider;
import com.tiwari.studence.campus.provider.CampusSearchReqRespProvider;

import com.tiwari.studence.common.convertor.AEntityConvertor;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.campus.CampusSearchReqPb;
import com.tiwari.studence.proto.campus.CampusSearchRespPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CampusConverter extends
        AEntityConvertor<CampusPb, CampusPb.Builder, CampusProvider, CampusSearchReqPb, CampusSearchReqPb.Builder, CampusSearchRespPb, CampusSearchRespPb.Builder, CampusSearchReqRespProvider> {
  @Inject
  public CampusConverter(CampusProvider builderProvider,
          JsonBaseEncoderDecoder jsonBaseEncoderDecoder, CampusSearchReqRespProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }


}
