package com.tiwari.studence.organisation.convertor;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.service.v1.convertor.AEntityConvertor;
import com.tiwari.studence.organisation.provider.OrganisationPbProvider;
import com.tiwari.studence.organisation.provider.OrganisationSearchPbProvider;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

@Singleton
public class OrganisationConvertor
        extends AEntityConvertor<OrganisationPb, OrganisationPb.Builder, OrganisationPbProvider, OrganisationSearchReqPb,OrganisationSearchReqPb.Builder,OrganisationSearchRespPb,OrganisationSearchRespPb.Builder, OrganisationSearchPbProvider> {

  @Inject
  public OrganisationConvertor(OrganisationPbProvider builderProvider,
          JsonBaseEncoderDecoder jsonBaseEncoderDecoder,
          OrganisationSearchPbProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
