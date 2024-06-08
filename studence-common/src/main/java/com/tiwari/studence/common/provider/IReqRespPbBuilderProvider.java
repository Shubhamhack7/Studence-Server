package com.tiwari.studence.common.provider;

import com.google.protobuf.GeneratedMessageV3;

public interface IReqRespPbBuilderProvider <LREQ extends GeneratedMessageV3,LREQB extends GeneratedMessageV3.Builder,LRESP extends GeneratedMessageV3,LRESPB extends GeneratedMessageV3.Builder> {
  public LREQB getReqBuilder();
  public LREQB getReqBuilder(LREQ builder);
  public LRESPB getRespBuilder();
  public LRESPB getRespBuilder(LRESP builder);
}
