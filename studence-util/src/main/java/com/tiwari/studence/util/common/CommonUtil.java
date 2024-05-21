package com.tiwari.studence.util.common;

import com.tiwari.studence.proto.scheduler.IntervalType;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import org.json.JSONObject;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonUtil {
  public static void mergeJSONObjects(JSONObject older, JSONObject updated) {
    for (String key : updated.keySet()) {
      older.put(key, updated.get(key));
    }
  }

  public static String getNextToken(JsonBaseEncoderDecoder mJsonBaseEncoderDecoder,
          HashMap<String, AttributeValue> lastKey) {
    AtomicInteger counter = new AtomicInteger();
    int size = lastKey.size();
    StringBuilder nexttoken = new StringBuilder();
    lastKey.entrySet().forEach(value -> {
      nexttoken.append(value.getKey());
      nexttoken.append(StudenceSpecialCharecterEnum.HASH_SIGN.getSign());
      nexttoken.append(value.getValue().s());
      if (counter.get() != size - 1) {
        nexttoken.append(StudenceSpecialCharecterEnum.AT_SIGN.getSign());
        counter.getAndIncrement();
      }
    });
    return mJsonBaseEncoderDecoder.convert(nexttoken.toString());
  }

  public static void getKeyValueFromNextToken(Map<String, AttributeValue> exclusiveStartKey,
          String nextToken) {
    String[] splitAt = nextToken.split(StudenceSpecialCharecterEnum.AT_SIGN.getSign());
    for (String at : splitAt) {
      String[] keyValArr = at.split(StudenceSpecialCharecterEnum.HASH_SIGN.getSign());
      exclusiveStartKey.put(keyValArr[0], AttributeValue.builder().s(keyValArr[1]).build());
    }
  }
  public static long toMillis(IntervalType intervalType) {
    switch (intervalType) {
    case MILLI_SECONDS:
      return 1;
    case SECONDS:
      return 1000;
    case MINUTE:
      return 60 * 1000;
    case HOUR:
      return 60 * 60 * 1000;
    case DAY:
      return 24 * 60 * 60 * 1000;
    case WEEK:
      return 7 * 24 * 60 * 60 * 1000;
    default:
      throw new IllegalArgumentException("Unsupported IntervalType: " + intervalType);
    }
  }
}
