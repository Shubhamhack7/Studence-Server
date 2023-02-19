package com.tiwari.studence.organisation.bquery;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.common.collect.Lists;
import com.tiwari.studence.bquery.database.enamuration.BQueryUtilityEnum;
import com.tiwari.studence.bquery.database.interfaces.IBQuerySchemaTable;
import com.tiwari.studence.entity.bquery.EntityBigQuerySchema;

public class OrganisationBigQuerySchema implements IBQuerySchemaTable {

	private EntityBigQuerySchema m_entityBigQuerySchema;

	@Inject
	public OrganisationBigQuerySchema(EntityBigQuerySchema entityBigQuerySchema) {
		m_entityBigQuerySchema = entityBigQuerySchema;
	}

	@Override
	public ArrayList<TableFieldSchema> getSchema() {
		List<TableFieldSchema> fields = Lists.newArrayList();
		fields.add(new TableFieldSchema().setName("dbInfo").setType(BQueryUtilityEnum.RECORD.getStringValue())
				.setMode(BQueryUtilityEnum.NULLABLE.getStringValue())
				.setFields(m_entityBigQuerySchema.getEntitySchema()));
		fields.add(new TableFieldSchema().setName("name").setType(BQueryUtilityEnum.STRING.getStringValue())
				.setMode(BQueryUtilityEnum.NULLABLE.getStringValue()));
		return (ArrayList<TableFieldSchema>) fields;
	}

}
