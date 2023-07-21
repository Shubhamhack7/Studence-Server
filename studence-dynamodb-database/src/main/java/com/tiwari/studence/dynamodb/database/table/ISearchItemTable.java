package com.tiwari.studence.dynamodb.database.table;

import java.util.List;
import java.util.Map;

import com.tiwari.studence.proto.search.DynamoDbSearchPb;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public interface ISearchItemTable {
	public List<Map<String, AttributeValue>> searchItemsScanSpec(DynamoDbSearchPb request)
			throws Exception;
}
