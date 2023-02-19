package com.tiwari.studence.bquery.database.enamuration;

public enum BQueryUtilityEnum {
	NULL("NULL"),
	TRUE("TRUE"), 
	FALSE("FALSE"),
	NULLABLE("NULLABLE"), 
	REPEATED("REPEATED"), 
	STRING("STRING"), 
	INTEGER("INTEGER"), 
	BOOLEAN("BOOLEAN"), 
	RECORD("RECORD");

	private String m_value;

	BQueryUtilityEnum(String value) {
		this.m_value = value;
	}

	public String getStringValue() {
		return m_value;
	}
}
