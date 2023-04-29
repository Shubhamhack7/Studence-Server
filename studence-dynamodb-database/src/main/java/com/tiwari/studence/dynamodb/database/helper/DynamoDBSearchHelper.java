package com.tiwari.studence.dynamodb.database.helper;

import com.amazonaws.services.dynamodbv2.document.ScanFilter;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.mgn.model.ListTemplateActionsRequest;
import com.google.protobuf.ByteString;
import com.tiwari.studence.proto.search.AttributeNameValuePair;
import com.tiwari.studence.proto.search.ComparisonOperatorEnum;
import com.tiwari.studence.proto.search.DynamoDBValue;
import com.tiwari.studence.proto.search.SearchPb;
import com.tiwari.studence.util.StudenceSpecialCharecterEnum;

import javax.inject.Singleton;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class DynamoDBSearchHelper {

  DynamoDBSearchHelper() {
    Map<String, Condition> conditions = new HashMap<>();
    Condition condition2 = new Condition().withComparisonOperator(ComparisonOperator.BEGINS_WITH)
            .withAttributeValueList(new AttributeValue().withS("John"));
    conditions.put("name", condition2);
    ScanSpec scanSpec = new ScanSpec().withScanFilters()
            // .withFilterExpression("#attr1 = :value1 and #attr2 >= :value2")
            .withNameMap(new NameMap().with("#attr1", "NAME").with("#attr2", "LIFETIME"))
            .withValueMap(new ValueMap().with(":value1", "demo school")
                    .with(":value2", "UNKNOWN_LIFETIME"));

  }

  public ScanSpec getAttributesToQuery(List<SearchPb> mAttributeValues) {
    ScanSpec scanSpec = new ScanSpec();
    Map<String, String> name = new HashMap<>();
    Map<String, Object> value = new HashMap<>();
    List<ScanFilter> filters = new ArrayList<>();
    List<SearchPb.Builder> mAttributeValuesBuilder = new ArrayList<>();
    mAttributeValues.forEach(searchPbAttribute -> {
      SearchPb.Builder builder = SearchPb.newBuilder(searchPbAttribute);
      mAttributeValuesBuilder.add(builder);
      try {
        createSacnRequest(builder, name, value, filters);
      } catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e);
      }
    });
    scanSpec.withNameMap(name).withValueMap(value).withScanFilters((ScanFilter) filters);
    return scanSpec;
  }

  private void createSacnRequest(SearchPb.Builder searchPbAttribute, Map<String, String> name,
          Map<String, Object> value, List<ScanFilter> filters) throws UnsupportedEncodingException {
    switch (searchPbAttribute.getType()) {
    case UNKNOWN:
      throw new IllegalStateException(
              "Unexpected value: type Cannot be " + searchPbAttribute.getType());
    case EQUAL_TO:
    case NOT_EQUAL_TO:
    case GREATER_THAN:
    case LESS_THAN:
    case GREATER_THAN_OR_EQUAL_TO:
    case LESS_THAN_OR_EQUAL_TO:
    case CONTAINS:
    case NOT_CONTAINS:
    case BEGINS_WITH:
      getEq_Nq_Gt_Lt_Gtoet_LtoetReq(searchPbAttribute, name, value, filters);
      break;
    case BETWEEN:
      getBetweenReq(searchPbAttribute, name, value, filters);
      break;
    case IN:
      getINReq(searchPbAttribute, name, value, filters);
      break;
    case NOT_NULL:
      break;
    case NULL:
      break;
    case UNRECOGNIZED:
      break;
    }
  }

  private void getINReq(SearchPb.Builder searchPbAttribute, Map<String, String> name,
          Map<String, Object> value, List<ScanFilter> filters) throws UnsupportedEncodingException {
    if(searchPbAttribute.getAttributesList().size()>0){
      searchPbAttribute.getAttributesBuilderList().forEach(item -> {
        try {
          createRequestAndAdd(item, name, value, filters);
        } catch (UnsupportedEncodingException e) {
          throw new RuntimeException(e);
        }
      });

      ScanFilter stringFilter = new ScanFilter(
              searchPbAttribute.getAttributeFirstBuilder().getAttributeNameAlias());
      addFilterValue(searchPbAttribute.getAttributeFirstBuilder().getType(),
              searchPbAttribute.getType(), stringFilter, searchPbAttribute);
      filters.add(stringFilter);
    }
  }

  private void getBetweenReq(SearchPb.Builder searchPbAttribute, Map<String, String> name,
          Map<String, Object> value, List<ScanFilter> filters) throws UnsupportedEncodingException {
    if (searchPbAttribute.getAttributeFirst()
            .getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED && searchPbAttribute.getAttributeSecond()
            .getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
      createRequestAndAdd(searchPbAttribute.getAttributeFirstBuilder(), name, value, filters);
      createRequestAndAdd(searchPbAttribute.getAttributeSecondBuilder(), name, value, filters);
      ScanFilter stringFilter = new ScanFilter(
              searchPbAttribute.getAttributeFirstBuilder().getAttributeNameAlias());
      addFilterValue(searchPbAttribute.getAttributeFirstBuilder().getType(),
              searchPbAttribute.getType(), stringFilter, searchPbAttribute);
      filters.add(stringFilter);
    }
  }

  private void getEq_Nq_Gt_Lt_Gtoet_LtoetReq(SearchPb.Builder searchPbAttribute,
          Map<String, String> name, Map<String, Object> value, List<ScanFilter> filters)
          throws UnsupportedEncodingException {
    if (searchPbAttribute.getAttributeFirst()
            .getType() != DynamoDBValue.DYNAMODB_VALUE_UNSPECIFIED) {
      createRequestAndAdd(searchPbAttribute.getAttributeFirstBuilder(), name, value, filters);
      ScanFilter stringFilter = new ScanFilter(
              searchPbAttribute.getAttributeFirstBuilder().getAttributeNameAlias());
      addFilterValue(searchPbAttribute.getAttributeFirstBuilder().getType(),
              searchPbAttribute.getType(), stringFilter, searchPbAttribute);
      filters.add(stringFilter);
    }
  }

  private void addFilterValue(DynamoDBValue type, ComparisonOperatorEnum type1,
          ScanFilter stringFilter, SearchPb.Builder searchPbAttribute)
          throws UnsupportedEncodingException {
    switch (type1) {
    case UNKNOWN:
      break;
    case EQUAL_TO:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.eq(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.eq(searchPbAttribute.getAttributeFirst().getIntValue());
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.eq(searchPbAttribute.getAttributeFirst().getBinaryValue().toByteArray());
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.eq(searchPbAttribute.getAttributeFirst().getFloatValue());
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case NOT_EQUAL_TO:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.ne(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.ne(searchPbAttribute.getAttributeFirst().getIntValue());
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.ne(searchPbAttribute.getAttributeFirst().getBinaryValue().toByteArray());
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.ne(searchPbAttribute.getAttributeFirst().getFloatValue());
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case GREATER_THAN:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.gt(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.gt(searchPbAttribute.getAttributeFirst().getIntValue());
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.gt(searchPbAttribute.getAttributeFirst().getBinaryValue().toByteArray());
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.gt(searchPbAttribute.getAttributeFirst().getFloatValue());
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case LESS_THAN:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.lt(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.lt(searchPbAttribute.getAttributeFirst().getIntValue());
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.lt(searchPbAttribute.getAttributeFirst().getBinaryValue().toByteArray());
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.lt(searchPbAttribute.getAttributeFirst().getFloatValue());
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case GREATER_THAN_OR_EQUAL_TO:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.ge(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.ge(searchPbAttribute.getAttributeFirst().getIntValue());
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.ge(searchPbAttribute.getAttributeFirst().getBinaryValue().toByteArray());
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.ge(searchPbAttribute.getAttributeFirst().getFloatValue());
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case LESS_THAN_OR_EQUAL_TO:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.le(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.le(searchPbAttribute.getAttributeFirst().getIntValue());
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.le(searchPbAttribute.getAttributeFirst().getBinaryValue().toByteArray());
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.le(searchPbAttribute.getAttributeFirst().getFloatValue());
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case BETWEEN:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.between(searchPbAttribute.getAttributeFirst().getStringValue(),
                searchPbAttribute.getAttributeSecond().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.between(searchPbAttribute.getAttributeFirst().getIntValue(),
                searchPbAttribute.getAttributeSecond().getIntValue());
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.between(searchPbAttribute.getAttributeFirst().getBinaryValue().toByteArray(),
                searchPbAttribute.getAttributeSecond().getBinaryValue().toByteArray());
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.between(searchPbAttribute.getAttributeFirst().getFloatValue(),
                searchPbAttribute.getAttributeSecond().getFloatValue());
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case IN:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
      case DYNAMODB_VALUE_FLOAT:
      case DYNAMODB_VALUE_INT:
      case DYNAMODB_VALUE_BINARY:
        stringFilter.in(getStringValueList(searchPbAttribute.getAttributesList()));
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case NOT_NULL:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
      case DYNAMODB_VALUE_FLOAT:
      case DYNAMODB_VALUE_BINARY:
      case DYNAMODB_VALUE_INT:
        stringFilter.exists();
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case NULL:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
      case DYNAMODB_VALUE_BINARY:
      case DYNAMODB_VALUE_INT:
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.notExist();
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case CONTAINS:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.contains(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.contains(searchPbAttribute.getAttributeFirst().getIntValue());
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.contains(searchPbAttribute.getAttributeFirst().getBinaryValue().toByteArray());
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.contains(searchPbAttribute.getAttributeFirst().getFloatValue());
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case NOT_CONTAINS:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.notContains(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.notContains(
                String.valueOf(searchPbAttribute.getAttributeFirst().getIntValue()));
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.notContains(
                searchPbAttribute.getAttributeFirst().getBinaryValue().toString("US-ASCII"));
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.notContains(
                Float.toString(searchPbAttribute.getAttributeFirst().getFloatValue()));
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case BEGINS_WITH:
      switch (type) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        stringFilter.beginsWith(searchPbAttribute.getAttributeFirst().getStringValue());
        break;
      case DYNAMODB_VALUE_INT:
        stringFilter.beginsWith(
                String.valueOf(searchPbAttribute.getAttributeFirst().getIntValue()));
        break;
      case DYNAMODB_VALUE_BINARY:
        stringFilter.beginsWith(
                searchPbAttribute.getAttributeFirst().getBinaryValue().toString("US-ASCII"));
        break;
      case DYNAMODB_VALUE_FLOAT:
        stringFilter.beginsWith(
                Float.toString(searchPbAttribute.getAttributeFirst().getFloatValue()));
        break;
      case UNRECOGNIZED:
        break;
      }
      break;
    case UNRECOGNIZED:
      break;
    }
  }

  private Object[] getStringValueList(List<AttributeNameValuePair> attributesList) {
    Object[] value = new Object[attributesList.size()];
    int i = 0;
    for (AttributeNameValuePair attributeNameValuePair : attributesList) {
      switch (attributeNameValuePair.getType()) {
      case DYNAMODB_VALUE_UNSPECIFIED:
        value[i] = attributeNameValuePair.getStringValue();
        i++;
        break;
      case DYNAMODB_VALUE_INT:
        value[i] = attributeNameValuePair.getIntValue();
        i++;
        break;
      case DYNAMODB_VALUE_BINARY:
        value[i] = attributeNameValuePair.getBinaryValue();
        i++;
        break;
      case DYNAMODB_VALUE_FLOAT:
        value[i] = attributeNameValuePair.getFloatValue();
        i++;
        break;
      case UNRECOGNIZED:
        break;
      }
    }
    return value;
  }

  private void createRequestAndAdd(AttributeNameValuePair.Builder attributeFirstBuilder,
          Map<String, String> name, Map<String, Object> value, List<ScanFilter> filters)
          throws UnsupportedEncodingException {
    addNameToList(attributeFirstBuilder, name);
    switch (attributeFirstBuilder.getType()) {
    case DYNAMODB_VALUE_STRING:
      addStringValueToList(attributeFirstBuilder, value);
      break;
    case DYNAMODB_VALUE_INT:
      addIntValueToList(attributeFirstBuilder, value);
      break;
    case DYNAMODB_VALUE_BINARY:
      addBinaryValueToList(attributeFirstBuilder, value);
      break;
    case DYNAMODB_VALUE_FLOAT:
      addFloatValueToList(attributeFirstBuilder, value);
      break;
    case UNRECOGNIZED:
      break;

    default:
      throw new IllegalStateException("Unexpected value: " + attributeFirstBuilder.getType());
    }
  }

  private void addFloatValueToList(AttributeNameValuePair.Builder attributeFirstBuilder,
          Map<String, Object> value) {
    ValueMap newValue = new ValueMap();
    String valueAlias = StudenceSpecialCharecterEnum.HASH_SIGN.getSign() + Float.toString(
            attributeFirstBuilder.getFloatValue()).replace(Character.toString('.'), "");
    value.put(valueAlias, attributeFirstBuilder.getFloatValue());
    attributeFirstBuilder.setAttributeValueAlias(valueAlias);
  }

  private void addBinaryValueToList(AttributeNameValuePair.Builder attributeFirstBuilder,
          Map<String, Object> value) throws UnsupportedEncodingException {
    String valueAlias = StudenceSpecialCharecterEnum.HASH_SIGN.getSign() + getBinaryString(
            attributeFirstBuilder.getBinaryValue());
    value.put(valueAlias, attributeFirstBuilder.getBinaryValue().toByteArray());
    attributeFirstBuilder.setAttributeValueAlias(valueAlias);
  }

  private String getBinaryString(ByteString binaryValue) throws UnsupportedEncodingException {
    byte[] bytes = binaryValue.toByteArray(); // convert ByteString to byte array
    return new String(bytes, "US-ASCII");
  }

  private void addIntValueToList(AttributeNameValuePair.Builder attributeFirstBuilder,
          Map<String, Object> value) {
    String valueAlias = StudenceSpecialCharecterEnum.HASH_SIGN.getSign() + attributeFirstBuilder.getIntValue();
    value.put(valueAlias, attributeFirstBuilder.getIntValue());
    attributeFirstBuilder.setAttributeValueAlias(valueAlias);
  }

  private void addStringValueToList(AttributeNameValuePair.Builder attributeFirstBuilder,
          Map<String, Object> value) {
    String valueAlias = StudenceSpecialCharecterEnum.HASH_SIGN.getSign() + attributeFirstBuilder.getStringValue();
    value.put(valueAlias, attributeFirstBuilder.getStringValue());
    attributeFirstBuilder.setAttributeValueAlias(valueAlias);
  }

  private void addNameToList(AttributeNameValuePair.Builder searchPbAttribute,
          Map<String, String> name) {
    String nameAlias = StudenceSpecialCharecterEnum.HASH_SIGN.getSign() + searchPbAttribute.getName();
    name.put(nameAlias, searchPbAttribute.getName());
    searchPbAttribute.setAttributeValueAlias(nameAlias);
  }
}
