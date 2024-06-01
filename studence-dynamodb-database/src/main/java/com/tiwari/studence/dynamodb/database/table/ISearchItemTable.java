package com.tiwari.studence.dynamodb.database.table;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tiwari.studence.proto.search.DynamoDbSearchPb;
import com.tiwari.studence.util.collect.Pair;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface ISearchItemTable {
	public Pair<Set<Map.Entry<String, AttributeValue>>, List<Map<String, AttributeValue>>> searchItemsScanSpec(DynamoDbSearchPb request)
			throws Exception;
}
