package com.tiwari.studence.common.searcher;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.exception.ErrorException;

public interface ISearcher<Req extends GeneratedMessageV3,Resp extends GeneratedMessageV3> {
  public IFuture<Resp, ErrorException> searcher(Req builder);
}