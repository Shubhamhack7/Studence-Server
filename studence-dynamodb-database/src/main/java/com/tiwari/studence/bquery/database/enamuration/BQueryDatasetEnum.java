package com.tiwari.studence.bquery.database.enamuration;

public enum BQueryDatasetEnum {
	STUDENCE_DEV_PROD("studence_dev_prod"), 
	STUDENCE_DEV_DEVEL("studence_dev_devel");

	private String m_value;

	BQueryDatasetEnum(String value) {
		this.m_value = value;
	}

	public String getStringValue() {
		return m_value;
	}
}
