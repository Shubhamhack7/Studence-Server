package com.tiwari.studence.dynamodb.database;

import java.net.URI;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDbConnector extends AwsCredentials {

	public DynamoDbClient getDynamoDbClient() {
		return DynamoDbClient.builder().endpointOverride(URI.create("http://localhost:8000"))
				// The region is meaningless for local DynamoDb but required for client builder
				// validation
				.region(Region.US_WEST_2).credentialsProvider(StaticCredentialsProvider
						.create(AwsBasicCredentials.create(getACCESS_KEY_ID(), getSECRET_ACCESS_KEY())))
				.build();
	}
	
	public AmazonDynamoDB getAmazonDynamoDB() {
		AWSCredentials credentials = new BasicAWSCredentials(getACCESS_KEY_ID(), getSECRET_ACCESS_KEY());
		return AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", " us-west-2"))
				.build();
	}


}
