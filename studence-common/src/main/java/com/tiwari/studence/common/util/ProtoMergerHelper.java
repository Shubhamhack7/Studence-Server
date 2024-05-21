package com.tiwari.studence.common.util;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ProtoMergerHelper {
  private final ProtoHelper m_protoHelper;

  @Inject
  public ProtoMergerHelper(ProtoHelper protoHelper) {
    m_protoHelper = protoHelper;
  }

  public List<String> getMergerTokenSet(GeneratedMessageV3 proto, int protoIndex,
          List<List<Integer>> listOfIntPath) {
    List<String> mergeTokenList = Lists.newArrayList();
    for (List<Integer> tokenPath : listOfIntPath) {
      mergeTokenList.add(getMergeToken(proto, tokenPath, protoIndex));
    }

    return mergeTokenList;
  }

  private String getMergeToken(GeneratedMessageV3 proto, List<Integer> tokenPath, int protoIndex) {
    if (tokenPath.size() == 1) {
      if (tokenPath.get(0) == 0) {
        return Integer.toString(protoIndex);
      }
      Object value = m_protoHelper.getFieldByNumber(proto, tokenPath.get(0));
      Preconditions.check(!(value instanceof GeneratedMessageV3), proto, tokenPath.get(0), value);
      return value.toString();
    }
    GeneratedMessageV3 next = m_protoHelper.getFieldByNumber(proto, tokenPath.get(0));
    return getMergeToken(next, tokenPath.subList(1, tokenPath.size()), protoIndex);
  }

  private List<Integer> getMergeTokenIntPath(String stringPath) {
    String tokenele[] = stringPath.split("\\.");
    List<Integer> tokenPath = Lists.newArrayList();

    for (int i = 0; i < tokenele.length; i++) {
      tokenPath.add(Integer.parseInt(tokenele[i]));
    }
    return tokenPath;
  }

  public List<List<Integer>> getListOfIntTokenPath(List<String> listOfStringPath) {
    List<List<Integer>> listOfIntegerPath = Lists.newArrayList();

    for (String stringPath : listOfStringPath) {
      listOfIntegerPath.add(getMergeTokenIntPath(stringPath));
    }

    return listOfIntegerPath;
  }

}
