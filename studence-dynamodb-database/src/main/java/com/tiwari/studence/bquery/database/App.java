package com.tiwari.studence.bquery.database;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.common.collect.ImmutableSet;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ) throws IOException
    {
//    	GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("/home/tiwaritiwari/Downloads/studence-dev-e3a20deaa8c4.json")).createScoped(
//                ImmutableSet.of(
//                        "https://www.googleapis.com/auth/bigquery",
//                        "https://www.googleapis.com/auth/drive"));
//    	credentials.refreshIfExpired();
//    	AccessToken token = credentials.getAccessToken();
//    	System.out.println(credentials.getAccessToken());
//    	// OR
//    	//AccessToken token = credentials.refreshAccessToken();
//    	BigQuery bigquery =
//    		    BigQueryOptions.newBuilder().setCredentials(credentials).build().getService();
//    	String location = "US";
//
//        DatasetInfo datasetInfo = DatasetInfo.newBuilder("studence_dev_prod").setLocation(location).build();
//
//        Dataset newDataset = bigquery.create(datasetInfo);
//        String newDatasetName = newDataset.getDatasetId().getDataset();
//        System.out.println(newDatasetName + " created successfully");
    }
}
