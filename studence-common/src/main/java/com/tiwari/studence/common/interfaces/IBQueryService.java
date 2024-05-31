package com.tiwari.studence.common.interfaces;

import com.google.api.services.bigquery.model.Table;

public interface IBQueryService {
	public Table createTable(String tableName,String dataset);

}
