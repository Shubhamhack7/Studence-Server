package com.tiwari.studence.campus.searcher;

import com.tiwari.studence.campus.converter.CampusConverter;
import com.tiwari.studence.campus.indexer.CampusIndexer;
import com.tiwari.studence.campus.provider.CampusProvider;
import com.tiwari.studence.campus.provider.CampusSearchReqRespProvider;
import com.tiwari.studence.campus.provider.CampusTableNameProvider;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.campus.CampusSearchReqPb;
import com.tiwari.studence.proto.campus.CampusSearchRespPb;

public class CampusSearcher extends
        AEntitySearcher<CampusPb, CampusPb.Builder, CampusProvider, CampusSearchReqPb, CampusSearchReqPb.Builder, CampusSearchRespPb, CampusSearchRespPb.Builder, CampusSearchReqRespProvider, CampusConverter, CampusIndexer, CampusTableNameProvider> {
}
