package com.tiwari.studence.dynamodb.database.table;

import java.util.HashMap;

import javax.inject.Inject;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.tiwari.studence.dynamodb.database.DynamoDbConnector;
import com.tiwari.studence.util.exception.ErrorException;

import software.amazon.awssdk.services.dynamodb.model.*;

public class SearchItemInDynamoDbTable implements ISearchItemTable {

    private DynamoDbConnector m_dynamoDbConnector;

    @Inject
    public SearchItemInDynamoDbTable(DynamoDbConnector dynamoDbConnector) {
        m_dynamoDbConnector = dynamoDbConnector;
    }

    @Override
    public ScanResponse searchItemsScanSpec(String tableName, ScanSpec request)
            throws Exception {
        HashMap<String, String> attrNameAlias = new HashMap<String, String>();
        attrNameAlias.put("#lifetime", "LIFETIME");

//	      HashMap<String, AttributeValue> attrValues = new HashMap<>();
//
//	      attrValues.put(":"+"lifetime", AttributeValue.builder()
//	          .s("UNKNOWN_LIFETIME")
//	          .build());

		/*try {
			ScanRequest scanRequest = ScanRequest.builder().tableName(tableName)
					// .attributesToGet("RAW_DATA,LIFETIME")
					.filterExpression(filterExpression)
					// .expressionAttributeNames(attrNameAlias)
					.expressionAttributeValues(attrValues).build();

			return m_dynamoDbConnector.getDynamoDbClient().scan(scanRequest);

		} catch (DynamoDbException e) {
			throw new ErrorException(e);
		}*/
        DynamoDB dynamoDB = new DynamoDB(m_dynamoDbConnector.getAmazonDynamoDB());
        Table table = dynamoDB.getTable(tableName);
        ItemCollection<ScanOutcome> outcome = table.scan(request);
        for (Item item : outcome) {
            System.out.println(item.toJSONPretty());
        }
        return null;
    }
}

