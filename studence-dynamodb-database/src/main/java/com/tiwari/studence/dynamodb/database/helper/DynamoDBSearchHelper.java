package com.tiwari.studence.dynamodb.database.helper;

import com.tiwari.studence.proto.search.*;
import com.tiwari.studence.util.StudenceSpecialCharecterEnum;
import org.apache.commons.text.StringEscapeUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DynamoDBSearchHelper {

  int COUNTER = 0;

  @Inject
  public DynamoDBSearchHelper() {

  }

  public DynamoDbSearchPb getAttributesToQuery(DynamoDbSearchPb.Builder dynamoDbSearchPb,
          SearchRequestsPb mAttributeValues) {
    COUNTER = 0;
    System.out.println(mAttributeValues);
    StringBuilder expressionString = new StringBuilder();
    mAttributeValues.getRequestsList().forEach(request -> {
      createRequestOnComparesionType(dynamoDbSearchPb, request);
    });
    dynamoDbSearchPb.getExpressionAttributeList().forEach(attribute -> {
      expressionString.append(attribute.getExpression());
      expressionString.append(StudenceSpecialCharecterEnum.SPACE.getSign());
      if (COUNTER < mAttributeValues.getOperatorsCount()) {
        expressionString.append(mAttributeValues.getOperatorsList().get(COUNTER).name());
      }
      expressionString.append(StudenceSpecialCharecterEnum.SPACE.getSign());
      COUNTER++;
    });
    dynamoDbSearchPb.setFilterExpression(expressionString.toString());
    return dynamoDbSearchPb.build();
  }

  private void createRequestOnComparesionType(DynamoDbSearchPb.Builder dynamoDbSearchPb,
          SearchPb request) {
    switch (request.getType()) {
    case UNKNOWN:
    case UNRECOGNIZED:
      throw new IllegalStateException("Unexpected value: type Cannot be " + request.getType());
    case EQUAL_TO:
      equal_to(dynamoDbSearchPb, request);
      break;
    case NOT_EQUAL_TO:
      break;
    case GREATER_THAN:
      break;
    case LESS_THAN:
      break;
    case GREATER_THAN_OR_EQUAL_TO:
      break;
    case LESS_THAN_OR_EQUAL_TO:
      break;
    case BETWEEN:
      break;
    case IN:
      break;
    case NOT_NULL:
      break;
    case NULL:
      break;
    case CONTAINS:
      break;
    case NOT_CONTAINS:
      break;
    case BEGINS_WITH:
      begins_with(dynamoDbSearchPb, request);
    }
  }

  private void begins_with(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.LEFT_PARENTHESIS.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append("begins_with");
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.RIGHT_PARENTHESIS.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private void equal_to(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StringEscapeUtils.unescapeJava("\\u003d"));
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private AttributeNameValuePair createRequestOnDynamoDbValueType(
          AttributeNameValuePair attribute) {
    switch (attribute.getType()) {

    case DYNAMODB_VALUE_UNSPECIFIED:
    case UNRECOGNIZED:
      throw new IllegalStateException("Unexpected value: type Cannot be " + attribute.getType());
    case DYNAMODB_VALUE_STRING:
      return createRequestForString(attribute);
    case DYNAMODB_VALUE_INT:
      break;
    case DYNAMODB_VALUE_BINARY:
      break;
    case DYNAMODB_VALUE_FLOAT:
      break;
    }
    return attribute;
  }

  private AttributeNameValuePair createRequestForString(AttributeNameValuePair attribute) {
    String nameAlias = getNameAlias(attribute.getName());
    String valueAlias = getValueAlias(attribute.getStringValue());
    AttributeNameValuePair.Builder pair = AttributeNameValuePair.newBuilder(attribute);
    pair.setAttributeNameAlias(nameAlias);
    pair.setAttributeValueAlias(valueAlias);
    //dynamoDbSearchPb.addExpressionAttributeNames(pair.build());
    return pair.build();
  }

  private String getValueAlias(String stringValue) {
    return StudenceSpecialCharecterEnum.HASH_SIGN.getSign() + stringValue.toLowerCase() + StudenceSpecialCharecterEnum.UNDERSCORE.getSign() + "value";
  }

  private String getNameAlias(String name) {
    return StudenceSpecialCharecterEnum.COLON.getSign() + name.toLowerCase() + StudenceSpecialCharecterEnum.UNDERSCORE.getSign() + "name";
  }
}