package com.tiwari.studence.attendence.provider;


import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.proto.attendence.AttendencePb.Builder;

import javax.inject.Singleton;

@Singleton
public class AttendencePbProvider
        implements IPbBuilderProvider<AttendencePb, Builder> {

  @Override
  public Builder getBuilder() {
    return AttendencePb.newBuilder();
  }

  @Override
  public Builder getBuilder(AttendencePb builder) {
    return AttendencePb.newBuilder(builder);
  }

}
