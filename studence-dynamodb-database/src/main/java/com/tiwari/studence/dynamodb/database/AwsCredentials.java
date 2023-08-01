package com.tiwari.studence.dynamodb.database;

abstract class AwsCredentials {

	private String ACCESS_KEY_ID = "DUMMYIDEXAMPLE";
	private String SECRET_ACCESS_KEY = "DUMMYEXAMPLEKEY";
	private String REMOTE_URL = "http://192.168.29.191:8000";
	private String LOCAL_URL = "http://localhost:8000";

	public String getREMOTE_URL() {
		return REMOTE_URL;
	}

	public String getLOCAL_URL() {
		return LOCAL_URL;
	}



	public String getACCESS_KEY_ID() {
		return ACCESS_KEY_ID;
	}

	public String getSECRET_ACCESS_KEY() {
		return SECRET_ACCESS_KEY;
	}
}
