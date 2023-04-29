package com.tiwari.studence.dynamodb.database.table;

import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

public interface ISearchItemTable {
	public ScanResponse searchItemsScanSpec(String tableName, ScanSpec request)
			throws Exception;
}
