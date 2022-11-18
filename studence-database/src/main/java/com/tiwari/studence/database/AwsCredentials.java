package com.tiwari.studence.database;

abstract class AwsCredentials {

	private String ACCESS_KEY_ID = "DUMMYIDEXAMPLE";
	private String SECRET_ACCESS_KEY = "DUMMYEXAMPLEKEY";

	public String getACCESS_KEY_ID() {
		return ACCESS_KEY_ID;
	}

	public String getSECRET_ACCESS_KEY() {
		return SECRET_ACCESS_KEY;
	}
}
