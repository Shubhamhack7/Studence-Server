package com.tiwari.studence.organisation.indexer;

import java.util.Map;

import com.google.inject.Inject;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.entity.EntityUtilHelper;

public class OrganisationBigQueryIndexer {

	@Inject
	public OrganisationBigQueryIndexer() {

	}

	public Map<String, Object> getBigQueryIndex(OrganisationPb pb) {
		Map<String, Object> indexRow = Maps.newHashMap();
		indexRow.put(OrganisationBigQueryIndexerEnum.ID.getStringValue(), EntityUtilHelper
				.getDbInfoIdWithSpecialCharecter(pb.getDbInfo().getHashId(), pb.getDbInfo().getRangeId()));
		indexRow.put(OrganisationBigQueryIndexerEnum.LIFETIME.getStringValue(), pb.getDbInfo().getLifetime());
		indexRow.put(OrganisationBigQueryIndexerEnum.NAME.getStringValue(), pb.getName());
		return indexRow;
	}
}
