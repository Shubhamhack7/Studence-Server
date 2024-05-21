package com.tiwari.studence.common.service.v2.dynamodb;

import com.tiwari.studence.common.service.v2.aws.AwsDynamoDbAsyncClient;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.regex.Pattern;

@Singleton
public class DynamoDbTableInfo<T extends ITables> {
  private final AwsDynamoDbAsyncClient m_awsDynamoDbAsyncClient;
  private final T m_tables;

  @Inject
  public DynamoDbTableInfo(T tables, AwsDynamoDbAsyncClient simpleDbClient,
          AwsDynamoDbAsyncClient awsDynamoDbAsyncClient) {
    m_awsDynamoDbAsyncClient = awsDynamoDbAsyncClient;
    m_tables = tables;
  }

  public Pair<AwsDynamoDbAsyncClient, String> getDbClientAndTableName(String id) {
    String tablename = m_tables.getDbTableName(id);
    Preconditions.check(Pattern.matches("[a-zA-Z0-9_]+", tablename));
    return new Pair<AwsDynamoDbAsyncClient, String>(m_awsDynamoDbAsyncClient, tablename);
  }

  public Pair<AwsDynamoDbAsyncClient, String> getDbClientAndTableNameWithTablePartitionKey(
          String tablePartitionKey) {
    String tablename = m_tables.getDbTableNameWithTablePartitionKey(tablePartitionKey);
    Preconditions.check(Pattern.matches("[a-zA-Z0-9_]+", tablename));
    return new Pair<AwsDynamoDbAsyncClient, String>(m_awsDynamoDbAsyncClient, tablename);
  }

}
