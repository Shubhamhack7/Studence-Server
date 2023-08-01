package com.tiwari.studence.common.http.converter;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.googlecode.protobuf.format.JsonFormat;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

@Singleton
public class JsonStringToPbConverter<Pb, PbBuProvider extends IPbBuilderProvider<?,?>> {
  private final PbBuProvider m_builderProvider;

  @Inject
  public JsonStringToPbConverter(PbBuProvider builderProvider) {
    m_builderProvider = builderProvider;
  }

  public Pb convert(String value) {
	  GeneratedMessageV3.Builder<?> builder = (GeneratedMessageV3.Builder<?>) m_builderProvider
            .getBuilder();
    try {
      new JsonFormat().merge(value,ExtensionRegistry.getEmptyRegistry(), builder);
    } catch (com.googlecode.protobuf.format.JsonFormat.ParseException e) {
      throw new LoggedRuntimeException(ErrorCategoryUiEnum.INPUT_VALIDATION_ERROR, e, value);
    }
    return (Pb) builder.build();
  }
}