package com.tiwari.studence.common.searcher;

import javax.inject.Inject;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.indexer.IIndexer;
import com.tiwari.studence.common.prtovider.IPbBuilderProvider;

public abstract class AEntitySearcher<P extends GeneratedMessageV3, Lreq extends GeneratedMessageV3, Lresp extends GeneratedMessageV3, RBU extends GeneratedMessageV3.Builder, RBUP extends IPbBuilderProvider<Lresp, RBU>, I extends AEntityIndexer<P>>
        implements ISearcher<Lreq, Lresp> {

  @Inject
  public AEntitySearcher() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Lresp searcher(Lreq builder) {
    return null;
  }

}