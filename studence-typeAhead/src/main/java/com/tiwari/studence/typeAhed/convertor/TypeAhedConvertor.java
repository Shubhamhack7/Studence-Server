package com.tiwari.studence.typeAhed.convertor;

import com.tiwari.studence.common.convertor.AEntityConvertor;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchReqPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchRespPb;
import com.tiwari.studence.typeAhed.provider.TypeAheadSearchReqRespProvider;
import com.tiwari.studence.typeAhed.provider.TypeAhedProvider;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TypeAhedConvertor extends
        AEntityConvertor<TypeAheadPb, TypeAheadPb.Builder, TypeAhedProvider, TypeAheadSearchReqPb, TypeAheadSearchReqPb.Builder, TypeAheadSearchRespPb, TypeAheadSearchRespPb.Builder, TypeAheadSearchReqRespProvider> {

  @Inject
  public TypeAhedConvertor(TypeAhedProvider builderProvider,
          JsonBaseEncoderDecoder jsonBaseEncoderDecoder,
          TypeAheadSearchReqRespProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
