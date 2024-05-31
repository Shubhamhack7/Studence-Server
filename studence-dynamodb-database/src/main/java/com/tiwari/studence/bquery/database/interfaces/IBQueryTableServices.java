package com.tiwari.studence.bquery.database.interfaces;

import java.util.Map;

import com.google.api.services.bigquery.model.Table;

public interface IBQueryTableServices extends IBQueryTable {

	public Table createTable(String tableName,String dataset);

	public void insertingDataTypes(String tableName, Map<String, Object> rowContent);

	public void simpleQuery(String query);

}
