package com.tiwari.studence.dynamodb.database.helper;

import com.tiwari.studence.proto.search.*;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;
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
      not_equal_to(dynamoDbSearchPb, request);
      break;
    case GREATER_THAN:
      greater_then(dynamoDbSearchPb, request);
      break;
    case LESS_THAN:
      less_then(dynamoDbSearchPb, request);
      break;
    case GREATER_THAN_OR_EQUAL_TO:
      greater_then_equal_to(dynamoDbSearchPb, request);
      break;
    case LESS_THAN_OR_EQUAL_TO:
      less_then_equal_to(dynamoDbSearchPb, request);
      break;
    case BETWEEN:
      between(dynamoDbSearchPb, request);
      break;
    case IN:
      in(dynamoDbSearchPb, request);
      break;
    case NOT_NULL:
      not_null(dynamoDbSearchPb, request);
      break;
    case NULL:
      nullArg(dynamoDbSearchPb, request);
      break;
    case CONTAINS:
      contains(dynamoDbSearchPb, request);
      break;
    case NOT_CONTAINS:
      throw new IllegalStateException("Unexpected value: type Cannot be " + request.getType());
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
        attrPair.setCompareType(ComparisonOperatorEnum.BEGINS_WITH);
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.LEFT_PARENTHESIS.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append("begins_with");
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.LEFT_PARENTHESIS.getSign());
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.COMMA.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        stringBuilder.append(StudenceSpecialCharecterEnum.RIGHT_PARENTHESIS.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.RIGHT_PARENTHESIS.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private void in(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.IN);
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append("IN");
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.LEFT_PARENTHESIS.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        stringBuilder.append(StudenceSpecialCharecterEnum.RIGHT_PARENTHESIS.getSign());
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
        attrPair.setCompareType(ComparisonOperatorEnum.EQUAL_TO);
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

  private void not_null(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.NOT_NULL);
        stringBuilder.append("attribute_exists");
        stringBuilder.append(StudenceSpecialCharecterEnum.LEFT_PARENTHESIS.getSign());
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.RIGHT_PARENTHESIS.getSign());

        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private void contains(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.CONTAINS);
        stringBuilder.append("contains");
        stringBuilder.append(StudenceSpecialCharecterEnum.LEFT_PARENTHESIS.getSign());
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.COMMA.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        stringBuilder.append(StudenceSpecialCharecterEnum.RIGHT_PARENTHESIS.getSign());
        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private void nullArg(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.NULL);
        stringBuilder.append("attribute_not_exists");
        stringBuilder.append(StudenceSpecialCharecterEnum.LEFT_PARENTHESIS.getSign());
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.RIGHT_PARENTHESIS.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(DynamoDBLogicalOperators.OR.name());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
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

  private void between(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {

    StringBuilder stringBuilder = new StringBuilder();
    AttributeNameValuePair.Builder attrPair1 = AttributeNameValuePair.newBuilder(
            createRequestOnDynamoDbValueType(request.getAttributes(0)));
    attrPair1.setCompareType(ComparisonOperatorEnum.BETWEEN);
    AttributeNameValuePair.Builder attrPair2 = AttributeNameValuePair.newBuilder(
            createRequestOnDynamoDbValueType(request.getAttributes(1)));
    attrPair2.setCompareType(ComparisonOperatorEnum.BETWEEN);
    stringBuilder.append(attrPair1.getName());
    stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
    stringBuilder.append("BETWEEN");
    stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
    stringBuilder.append(attrPair1.getAttributeNameAlias());
    stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
    stringBuilder.append(DynamoDBLogicalOperators.AND.name());
    stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
    stringBuilder.append(attrPair2.getAttributeNameAlias());
    attrPair1.setExpression(stringBuilder.toString());
    attrPair2.setExpression(stringBuilder.toString());
    dynamoDbSearchPb.addExpressionAttribute(attrPair1);
    dynamoDbSearchPb.addExpressionAttribute(attrPair2);
  }

  private void greater_then_equal_to(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.GREATER_THAN_OR_EQUAL_TO);
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(">=");
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private void less_then_equal_to(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.LESS_THAN_OR_EQUAL_TO);
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append("<=");
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private void not_equal_to(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.NOT_EQUAL_TO);
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append("<>");
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private void greater_then(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.GREATER_THAN);
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.GREATER_THEN.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(attrPair.getAttributeNameAlias());
        attrPair.setExpression(stringBuilder.toString());
        dynamoDbSearchPb.addExpressionAttribute(attrPair);
      }
    });

  }

  private void less_then(DynamoDbSearchPb.Builder dynamoDbSearchPb, SearchPb request) {
    request.getAttributesList().forEach(attribute -> {
      if (attribute.getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
        StringBuilder stringBuilder = new StringBuilder();
        AttributeNameValuePair.Builder attrPair = AttributeNameValuePair.newBuilder(
                createRequestOnDynamoDbValueType(attribute));
        attrPair.setCompareType(ComparisonOperatorEnum.LESS_THAN);
        stringBuilder.append(attrPair.getName());
        stringBuilder.append(StudenceSpecialCharecterEnum.SPACE.getSign());
        stringBuilder.append(StudenceSpecialCharecterEnum.LESS_THEN.getSign());
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