package com.tiwari.studence.common.error;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.proto.error.ErrorProtoPb;
import com.tiwari.studence.util.encoder.IConverter;
import com.tiwari.studence.util.exception.ParsedErrorProto;

@Singleton
public class ErrorProtoUiConverter implements IConverter<ParsedErrorProto, ErrorProtoPb> {

  @Inject
  public ErrorProtoUiConverter(){

  }
  public ErrorProtoPb convert(ParsedErrorProto pb) {
    return ErrorProtoPb.newBuilder(pb.getErrorProto()).build();
  }
}