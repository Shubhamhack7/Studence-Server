package com.tiwari.studence.dynamodb.database.table;

import java.util.HashMap;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

public interface ISearchItemTable {
	public ScanResponse putItem(String tableName, HashMap<String, AttributeValue> attrValues, String filterExpression)
			throws Exception;
}
