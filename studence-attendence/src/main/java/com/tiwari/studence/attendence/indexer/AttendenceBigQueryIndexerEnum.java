package com.tiwari.studence.attendence.indexer;

public enum AttendenceBigQueryIndexerEnum {
	ID("dbInfo.id"),
	LIFETIME("dbInfo.lifetime"), 
	NAME("name");


	private String m_value;

	AttendenceBigQueryIndexerEnum(String value) {
		this.m_value = value;
	}

	public String getStringValue() {
		return m_value;
	}
}
