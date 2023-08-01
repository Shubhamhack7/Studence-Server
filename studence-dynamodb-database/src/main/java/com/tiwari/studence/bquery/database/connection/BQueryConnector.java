package com.tiwari.studence.bquery.database.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.BigqueryScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.ImmutableSet;

@Singleton
public class BQueryConnector {
	private final HttpTransport transport = new NetHttpTransport();
	private final JsonFactory jsonFactory = new JacksonFactory();

	@Inject
	public BQueryConnector() {

	}
	public Bigquery getConnection() throws FileNotFoundException, IOException {
		GoogleCredentials credentials = GoogleCredentials
				.fromStream(new FileInputStream("/home/tiwaritiwari/Downloads/studence-dev-e3a20deaa8c4.json"))
				.createScoped(ImmutableSet.of("https://www.googleapis.com/auth/bigquery",
						"https://www.googleapis.com/auth/drive"));
		if (credentials.createScopedRequired()) {
			credentials = credentials.createScoped(BigqueryScopes.all());
		}
		return new Bigquery.Builder(transport, jsonFactory,new HttpCredentialsAdapter(credentials))
				.setApplicationName("studence-dev").build();
	}
}
