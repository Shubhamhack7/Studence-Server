package com.tiwari.studence.dynamodb.database.table;

import java.util.HashMap;

import javax.inject.Inject;

import com.tiwari.studence.dynamodb.database.DynamoDbConnector;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

public class SearchItemInDynamoDbTable implements ISearchItemTable {

	private DynamoDbConnector m_dynamoDbConnector;

	@Inject
	public SearchItemInDynamoDbTable(DynamoDbConnector dynamoDbConnector) {
		m_dynamoDbConnector = dynamoDbConnector;
	}

	@Override
	public ScanResponse putItem(String tableName, HashMap<String, AttributeValue> attrValues, String filterExpression)
			throws Exception {
		HashMap<String, String> attrNameAlias = new HashMap<String, String>();
		attrNameAlias.put("#lifetime", "LIFETIME");

//	      HashMap<String, AttributeValue> attrValues = new HashMap<>();
//
//	      attrValues.put(":"+"lifetime", AttributeValue.builder()
//	          .s("UNKNOWN_LIFETIME")
//	          .build());

		try {
			ScanRequest scanRequest = ScanRequest.builder().tableName(tableName)
					// .attributesToGet("RAW_DATA,LIFETIME")
					.filterExpression(filterExpression)
					// .expressionAttributeNames(attrNameAlias)
					.expressionAttributeValues(attrValues).build();

			return m_dynamoDbConnector.getDynamoDbClient().scan(scanRequest);

		} catch (DynamoDbException e) {
			throw new ErrorException(e);
		}
	}

}
