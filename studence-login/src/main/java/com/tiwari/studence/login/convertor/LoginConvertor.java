package com.tiwari.studence.login.convertor;

import com.tiwari.studence.common.convertor.AEntityConvertor;
import com.tiwari.studence.login.provider.LoginPbProvider;
import com.tiwari.studence.login.provider.LoginSearchPbProvider;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.proto.login.LoginSearchReqPb;
import com.tiwari.studence.proto.login.LoginSearchRespPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginConvertor extends
        AEntityConvertor<LoginPb, LoginPb.Builder, LoginPbProvider, LoginSearchReqPb, LoginSearchReqPb.Builder, LoginSearchRespPb, LoginSearchRespPb.Builder, LoginSearchPbProvider> {

  @Inject
  public LoginConvertor(LoginPbProvider builderProvider,
          JsonBaseEncoderDecoder jsonBaseEncoderDecoder, LoginSearchPbProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
