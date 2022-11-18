package com.tiwari.studence.common.searcher;

import com.google.protobuf.GeneratedMessageV3;

public interface ISearcher<Req extends GeneratedMessageV3,Resp extends GeneratedMessageV3> {
  public Resp searcher(Req builder);
}