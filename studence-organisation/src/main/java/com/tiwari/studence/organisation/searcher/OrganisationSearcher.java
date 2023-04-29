package com.tiwari.studence.organisation.searcher;

import javax.inject.Inject;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.organisation.indexer.OrganisationIndexer;
import com.tiwari.studence.organisation.provider.OrganisationSearchPbProvider;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;
import com.tiwari.studence.util.exception.ErrorException;

public class OrganisationSearcher extends AEntitySearcher<OrganisationPb, OrganisationSearchReqPb, OrganisationSearchRespPb, OrganisationSearchRespPb.Builder, OrganisationSearchPbProvider, OrganisationIndexer>{

  @Inject
  public OrganisationSearcher() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public IFuture<OrganisationSearchRespPb, ErrorException> searcher(
          OrganisationSearchReqPb builder) {
    return super.searcher(builder);
  }
}
