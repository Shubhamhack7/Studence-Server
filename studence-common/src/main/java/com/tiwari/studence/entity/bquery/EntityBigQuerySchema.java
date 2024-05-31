package com.tiwari.studence.entity.bquery;

import java.util.List;

import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.common.collect.Lists;
import com.tiwari.studence.bquery.database.enamuration.BQueryUtilityEnum;

public class EntityBigQuerySchema {

	public List<TableFieldSchema> getEntitySchema() {
		List<TableFieldSchema> fields = Lists.newArrayList();
		fields.add(new TableFieldSchema().setName("id").setType(BQueryUtilityEnum.STRING.getStringValue())
				.setMode(BQueryUtilityEnum.NULLABLE.getStringValue()));
		fields.add(new TableFieldSchema().setName("lifetime").setType(BQueryUtilityEnum.STRING.getStringValue())
				.setMode(BQueryUtilityEnum.NULLABLE.getStringValue()));
		return fields;
	}

}
