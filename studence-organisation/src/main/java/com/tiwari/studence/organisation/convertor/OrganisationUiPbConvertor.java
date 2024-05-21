package com.tiwari.studence.organisation.convertor;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.convertor.AAsyncConverter;
import com.tiwari.studence.common.util.GNormalizedProto;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationUiPb;
import com.tiwari.studence.util.callable.ALoggableCallable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class OrganisationUiPbConvertor extends AAsyncConverter<OrganisationPb, OrganisationUiPb> {

  @Inject
  public OrganisationUiPbConvertor(GNormalizedProto protoNormalizer) {
    super(protoNormalizer);
  }

  @Override
  protected GeneratedMessageV3.Builder<?> convertIntenal(OrganisationPb value,
          List<IFuture<?, ?>> futures, List<ALoggableCallable<?>> callables) {
    return null;
  }
}
