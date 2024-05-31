package com.tiwari.studence.attendence.indexer;

import com.google.inject.Inject;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.entity.EntityUtilHelper;

import java.util.Map;

public class AttendenceBigQueryIndexer {

	@Inject
	public AttendenceBigQueryIndexer() {

	}

	public Map<String, Object> getBigQueryIndex(AttendencePb pb) {
		Map<String, Object> indexRow = Maps.newHashMap();
		indexRow.put(AttendenceBigQueryIndexerEnum.ID.getStringValue(), EntityUtilHelper
				.getDbInfoIdWithSpecialCharecter(pb.getDbInfo().getHashId(), pb.getDbInfo().getRangeId()));
		indexRow.put(AttendenceBigQueryIndexerEnum.LIFETIME.getStringValue(), pb.getDbInfo().getLifetime());
		indexRow.put(AttendenceBigQueryIndexerEnum.NAME.getStringValue(), pb.getName());
		return indexRow;
	}
}
