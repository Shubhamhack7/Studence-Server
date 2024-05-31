package com.tiwari.studence.common.http.converter;

import com.google.inject.Inject;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.googlecode.protobuf.format.JsonFormat;
import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class JsonStringToReqPbConverter<Req, PbBuProvider extends IReqRespPbBuilderProvider<?, ?, ?, ?>> {
  private final PbBuProvider m_builderProvider;

  @Inject
  public JsonStringToReqPbConverter(PbBuProvider builderProvider) {
    m_builderProvider = builderProvider;
  }

  public Req convert(String value) {

    GeneratedMessageV3.Builder<?> builder = (GeneratedMessageV3.Builder<?>) m_builderProvider.getReqBuilder();
    try {
      try {
        new JsonFormat().merge(URLDecoder.decode(value, "UTF-8"),
                ExtensionRegistry.getEmptyRegistry(), builder);
      } catch (UnsupportedEncodingException e) {
        throw new LoggedRuntimeException(ErrorCategoryUiEnum.INPUT_VALIDATION_ERROR, e, value);
      }
    } catch (com.googlecode.protobuf.format.JsonFormat.ParseException e) {
      throw new LoggedRuntimeException(ErrorCategoryUiEnum.INPUT_VALIDATION_ERROR, e, value);
    }
    return (Req) builder.build();
  }
}
