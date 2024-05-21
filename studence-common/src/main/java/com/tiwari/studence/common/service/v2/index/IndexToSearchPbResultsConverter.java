package com.tiwari.studence.common.service.v2.index;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.encoders.Base64PbDecoder;
import com.tiwari.studence.common.util.ProtoHelper;
import com.tiwari.studence.proto.entity.EntityProtoUiPb;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.proto.index.IndexPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class IndexToSearchPbResultsConverter<Pb extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>> {
  private final Base64PbDecoder<Pb, B> m_decoder;
  private final ProtoHelper m_helper;

  @Inject
  public IndexToSearchPbResultsConverter(Base64PbDecoder<Pb, B> decoder, ProtoHelper helper) {
    m_decoder = decoder;
    m_helper = helper;
  }

  public Pair<SearchResultSummaryUiPb, List<Pb>> getResults(
          Pair<SearchResultSummaryUiPb, List<IndexPb>> indexPbResults) {
    List<Pb> results = Lists.newArrayList();
    for (IndexPb indexPb : indexPbResults.getSecond()) {
      if (filterDeleted()) {
        EntityProtoUiPb pb = m_helper
                .getFieldByNumber(m_decoder.convert(indexPb.getActualSearchPb()), 1);
        if (pb.getLifeTime() != LifeTimeEnum.DELETED) {
          results.add(m_decoder.convert(indexPb.getActualSearchPb()));
        }
      } else {
        results.add(m_decoder.convert(indexPb.getActualSearchPb()));
      }
    }
    return new Pair<SearchResultSummaryUiPb, List<Pb>>(indexPbResults.getFirst(), results);
  }

  protected boolean filterDeleted() {
    return false;
  }

  public Pb getPb(IndexPb indexPb) {
    return m_decoder.convert(indexPb.getActualSearchPb());
  }

  public EntityProtoUiPb getEntityProtoFromPb(GeneratedMessageV3 pb) {
    EntityProtoUiPb entityProto = m_helper
            .getFieldByNumber(m_decoder.convert(((IndexPb) pb).getActualSearchPb()), 1);
    if (entityProto == null) {
      throw new LoggedRuntimeException(ErrorCategoryUiEnum.SELF_CODE_ERROR, pb);
    } else {
      return entityProto;
    }
  }

}
