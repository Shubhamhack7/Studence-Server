package com.tiwari.studence.organisation.indexer;

public enum OrganisationBigQueryIndexerEnum {
	ID("dbInfo.id"),
	LIFETIME("dbInfo.lifetime"), 
	NAME("name");

	private String m_value;

	OrganisationBigQueryIndexerEnum(String value) {
		this.m_value = value;
	}

	public String getStringValue() {
		return m_value;
	}
}
