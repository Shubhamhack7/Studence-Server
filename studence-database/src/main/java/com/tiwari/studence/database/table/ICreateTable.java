package com.tiwari.studence.database.table;

import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;

public interface ICreateTable {
	public CreateTableResponse createTable(String tableName) throws Exception;
		
}
