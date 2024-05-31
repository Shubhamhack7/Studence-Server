package com.tiwari.studence.bquery.database.interfaces;

import java.util.ArrayList;

import com.google.api.services.bigquery.model.TableFieldSchema;

public interface IBQuerySchemaTable {
	public ArrayList<TableFieldSchema> getSchema();
}
