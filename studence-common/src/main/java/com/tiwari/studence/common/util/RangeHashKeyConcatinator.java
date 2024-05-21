package com.tiwari.studence.common.util;

import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Singleton;

@Singleton
public class RangeHashKeyConcatinator {

  public String joinHashRangeKeys(String hashKey, String rangeKey) {
    String s = hashKey + StudenceSpecialCharecterEnum.EXCLAMATION.getSign() + rangeKey;
    return s;
  }

  public String joinHashRangeKeysStrict(String hashKey, String rangeKey) {
    String s = hashKey + StudenceSpecialCharecterEnum.EXCLAMATION.getSign() + rangeKey.replace(
            StudenceSpecialCharecterEnum.EXCLAMATION.getSign(),
            StudenceSpecialCharecterEnum.AT_SIGN.getSign());
    return s;
  }

  public Pair<String, String> splitHashRangeKeys(String joinedKeys) {
    Preconditions.check(joinedKeys.contains(StudenceSpecialCharecterEnum.EXCLAMATION.getSign()),
            joinedKeys);
    int lastIndex = joinedKeys.lastIndexOf(StudenceSpecialCharecterEnum.EXCLAMATION.getSign());
    String hashKey = joinedKeys.substring(0, lastIndex);
    String rangeKey = joinedKeys.substring(lastIndex + 1);
    return new Pair<String, String>(hashKey, rangeKey);
  }

  public Pair<String, String> splitGeneratedIdHashRangeKeys(String joinedKeys) {
    Preconditions.check(joinedKeys.contains(StudenceSpecialCharecterEnum.EXCLAMATION.getSign()),
            joinedKeys);
    int firstIndex = joinedKeys.indexOf(StudenceSpecialCharecterEnum.EXCLAMATION.getSign());
    String hashKey = joinedKeys.substring(0, firstIndex);
    String rangeKey = joinedKeys.substring(firstIndex + 1);
    return new Pair<String, String>(hashKey, rangeKey);
  }
}
