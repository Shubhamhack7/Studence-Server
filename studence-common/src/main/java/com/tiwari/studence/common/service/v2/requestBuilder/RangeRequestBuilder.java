package com.tiwari.studence.common.service.v2.requestBuilder;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.tiwari.studence.common.service.v2.helper.DynamoDbNextTokenWithTablePartitionHelper;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.interfaces.ISecondaryIndexEntity;
import com.tiwari.studence.util.common.Strings;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RangeRequestBuilder {
  private final DynamoDbNextTokenWithTablePartitionHelper m_nextTokenHelper;

  @Inject
  public RangeRequestBuilder(DynamoDbNextTokenWithTablePartitionHelper nextTokenHelper) {
    m_nextTokenHelper = nextTokenHelper;
  }

  public QueryRequest createRangeRequest(String tableName,
          ISecondaryIndexEntity secondaryIndexEntity, String id, String startKey, String endKey,
          boolean asending, String startToken, int limit) {
    QueryRequest req = new QueryRequest(tableName);
    if (Strings.notEmpty(secondaryIndexEntity.getEntityFullName())) {
      req.setIndexName(secondaryIndexEntity.getEntityFullName());
      req.addKeyConditionsEntry(secondaryIndexEntity.getItemIdName(),
              new Condition().withComparisonOperator(ComparisonOperator.EQ)
                      .withAttributeValueList(new AttributeValue().withS(id)));
      if (Strings.notEmpty(startKey) && Strings.notEmpty(endKey)) {
        req.addKeyConditionsEntry(secondaryIndexEntity.getRangeKeyName(),
                new Condition().withComparisonOperator(ComparisonOperator.BETWEEN)
                        .withAttributeValueList(new AttributeValue().withS(startKey),
                                new AttributeValue().withS(endKey)));
      } else if (Strings.notEmpty(startKey)) {
        req.addKeyConditionsEntry(secondaryIndexEntity.getRangeKeyName(),
                new Condition().withComparisonOperator(ComparisonOperator.GE)
                        .withAttributeValueList(new AttributeValue().withS(startKey)));
      } else if (Strings.notEmpty(endKey)) {
        req.addKeyConditionsEntry(secondaryIndexEntity.getRangeKeyName(),
                new Condition().withComparisonOperator(ComparisonOperator.LE)
                        .withAttributeValueList(new AttributeValue().withS(endKey)));
      }
    } else {
      req.addKeyConditionsEntry(EntityIndexAttributes.ITEM_ID.name(),
              new Condition().withComparisonOperator(ComparisonOperator.EQ)
                      .withAttributeValueList(new AttributeValue().withS(id)));
      if (Strings.notEmpty(startKey) && Strings.notEmpty(endKey)) {
        req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
                new Condition().withComparisonOperator(ComparisonOperator.BETWEEN)
                        .withAttributeValueList(new AttributeValue().withS(startKey),
                                new AttributeValue().withS(endKey)));
      } else if (Strings.notEmpty(startKey)) {
        req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
                new Condition().withComparisonOperator(ComparisonOperator.GE)
                        .withAttributeValueList(new AttributeValue().withS(startKey)));
      } else if (Strings.notEmpty(endKey)) {
        req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
                new Condition().withComparisonOperator(ComparisonOperator.LE)
                        .withAttributeValueList(new AttributeValue().withS(endKey)));
      }
    }
    req.setExclusiveStartKey(m_nextTokenHelper.getStartKey(secondaryIndexEntity, startToken));
    if (limit > 0) {
      req.setLimit(limit);
    }
    if (!asending) {
      req.setScanIndexForward(false);
    }

    return req;
  }

  public QueryRequest createPrefixRequest(String tableName,
          ISecondaryIndexEntity secondaryIndexEntity, String id, String startKey, boolean ascending,
          String startToken, int limit) {
    QueryRequest req = new QueryRequest(tableName);
    if (Strings.notEmpty(secondaryIndexEntity.getEntityFullName())) {
      req.setIndexName(secondaryIndexEntity.getEntityFullName());
      req.addKeyConditionsEntry(secondaryIndexEntity.getItemIdName(),
              new Condition().withComparisonOperator(ComparisonOperator.EQ)
                      .withAttributeValueList(new AttributeValue().withS(id)));
      if (Strings.notEmpty(startKey)) {
        req.addKeyConditionsEntry(secondaryIndexEntity.getRangeKeyName(),
                new Condition().withComparisonOperator(ComparisonOperator.BEGINS_WITH)
                        .withAttributeValueList(new AttributeValue().withS(startKey)));
      }
    } else {
      req.addKeyConditionsEntry(EntityIndexAttributes.ITEM_ID.name(),
              new Condition().withComparisonOperator(ComparisonOperator.EQ)
                      .withAttributeValueList(new AttributeValue().withS(id)));
      if (Strings.notEmpty(startKey)) {
        req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
                new Condition().withComparisonOperator(ComparisonOperator.BEGINS_WITH)
                        .withAttributeValueList(new AttributeValue().withS(startKey)));
      }
    }
    req.setExclusiveStartKey(m_nextTokenHelper.getStartKey(secondaryIndexEntity, startToken));
    if (limit > 0) {
      req.setLimit(limit);
    }
    if (!ascending) {
      req.setScanIndexForward(false);
    }

    return req;
  }

  public QueryRequest createGetRequest(String tableName, String id, String rangeKey) {
    QueryRequest req = new QueryRequest(tableName);
    req.addKeyConditionsEntry(EntityIndexAttributes.ITEM_ID.name(),
            new Condition().withComparisonOperator(ComparisonOperator.EQ)
                    .withAttributeValueList(new AttributeValue().withS(id)));
    req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
            new Condition().withComparisonOperator(ComparisonOperator.EQ)
                    .withAttributeValueList(new AttributeValue().withS(rangeKey)));
    req.setLimit(1);
    return req;
  }

  public QueryRequest createSmallestRequest(String tableName,
          ISecondaryIndexEntity secondaryIndexEntity, String id, String rangeKey,
          boolean includeMatch, String startToken, int limit) {
    QueryRequest req = new QueryRequest(tableName);
    if (Strings.notEmpty(secondaryIndexEntity.getEntityFullName())) {
      req.setIndexName(secondaryIndexEntity.getEntityFullName());
      req.addKeyConditionsEntry(secondaryIndexEntity.getItemIdName(),
              new Condition().withComparisonOperator(ComparisonOperator.EQ)
                      .withAttributeValueList(new AttributeValue().withS(id)));
      if (Strings.notEmpty(rangeKey) && includeMatch) {
        req.addKeyConditionsEntry(secondaryIndexEntity.getRangeKeyName(),
                new Condition().withComparisonOperator(ComparisonOperator.GE)
                        .withAttributeValueList(new AttributeValue().withS(rangeKey)));
      } else if (Strings.notEmpty(rangeKey)) {
        req.addKeyConditionsEntry(secondaryIndexEntity.getRangeKeyName(),
                new Condition().withComparisonOperator(ComparisonOperator.GT)
                        .withAttributeValueList(new AttributeValue().withS(rangeKey)));
      }
    } else {
      req.addKeyConditionsEntry(EntityIndexAttributes.ITEM_ID.name(),
              new Condition().withComparisonOperator(ComparisonOperator.EQ)
                      .withAttributeValueList(new AttributeValue().withS(id)));
      if (Strings.notEmpty(rangeKey) && includeMatch) {
        req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
                new Condition().withComparisonOperator(ComparisonOperator.GE)
                        .withAttributeValueList(new AttributeValue().withS(rangeKey)));
      } else if (Strings.notEmpty(rangeKey)) {
        req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
                new Condition().withComparisonOperator(ComparisonOperator.GT)
                        .withAttributeValueList(new AttributeValue().withS(rangeKey)));
      }
    }
    req.setExclusiveStartKey(m_nextTokenHelper.getStartKey(secondaryIndexEntity, startToken));
    if (limit > 0) {
      req.setLimit(limit);
    }

    return req;
  }

  public QueryRequest createLargestRequest(String tableName,
          ISecondaryIndexEntity secondaryIndexEntity, String id, String rangeKey,
          boolean includeMatch, String startToken, int limit) {
    QueryRequest req = new QueryRequest(tableName);
    if (Strings.notEmpty(secondaryIndexEntity.getEntityFullName())) {
      req.setIndexName(secondaryIndexEntity.getEntityFullName());
      req.addKeyConditionsEntry(secondaryIndexEntity.getItemIdName(),
              new Condition().withComparisonOperator(ComparisonOperator.EQ)
                      .withAttributeValueList(new AttributeValue().withS(id)));
      if (Strings.notEmpty(rangeKey) && includeMatch) {
        req.addKeyConditionsEntry(secondaryIndexEntity.getRangeKeyName(),
                new Condition().withComparisonOperator(ComparisonOperator.LE)
                        .withAttributeValueList(new AttributeValue().withS(rangeKey)));
      } else if (Strings.notEmpty(rangeKey)) {
        req.addKeyConditionsEntry(secondaryIndexEntity.getRangeKeyName(),
                new Condition().withComparisonOperator(ComparisonOperator.LT)
                        .withAttributeValueList(new AttributeValue().withS(rangeKey)));
      }
    } else {
      req.addKeyConditionsEntry(EntityIndexAttributes.ITEM_ID.name(),
              new Condition().withComparisonOperator(ComparisonOperator.EQ)
                      .withAttributeValueList(new AttributeValue().withS(id)));
      if (Strings.notEmpty(rangeKey) && includeMatch) {
        req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
                new Condition().withComparisonOperator(ComparisonOperator.LE)
                        .withAttributeValueList(new AttributeValue().withS(rangeKey)));
      } else if (Strings.notEmpty(rangeKey)) {
        req.addKeyConditionsEntry(EntityIndexAttributes.RANGE_KEY.name(),
                new Condition().withComparisonOperator(ComparisonOperator.LT)
                        .withAttributeValueList(new AttributeValue().withS(rangeKey)));
      }
    }
    req.setExclusiveStartKey(m_nextTokenHelper.getStartKey(secondaryIndexEntity, startToken));
    if (limit > 0) {
      req.setLimit(limit);
    }
    req.setScanIndexForward(false);

    return req;
  }

}
