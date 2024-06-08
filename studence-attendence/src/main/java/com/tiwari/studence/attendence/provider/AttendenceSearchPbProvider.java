package com.tiwari.studence.attendence.provider;


import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.attendence.AttendenceSearchReqPb;
import com.tiwari.studence.proto.attendence.AttendenceSearchRespPb;

import javax.inject.Inject;

public class AttendenceSearchPbProvider implements
        IReqRespPbBuilderProvider<AttendenceSearchReqPb, AttendenceSearchReqPb.Builder, AttendenceSearchRespPb, AttendenceSearchRespPb.Builder> {

  @Inject
  AttendenceSearchPbProvider() {

  }

  @Override
  public AttendenceSearchReqPb.Builder getReqBuilder() {
    return AttendenceSearchReqPb.newBuilder();
  }

  @Override
  public AttendenceSearchReqPb.Builder getReqBuilder(AttendenceSearchReqPb builder) {
    return AttendenceSearchReqPb.newBuilder(builder);
  }

  @Override
  public AttendenceSearchRespPb.Builder getRespBuilder() {
    return AttendenceSearchRespPb.newBuilder();
  }

  @Override
  public AttendenceSearchRespPb.Builder getRespBuilder(AttendenceSearchRespPb builder) {
    return AttendenceSearchRespPb.newBuilder(builder);
  }
}
