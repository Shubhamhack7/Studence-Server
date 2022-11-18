package com.tiwari.studence.util.collect;

import java.util.concurrent.ConcurrentMap;

public class ExtendedMaps extends Maps {

  public static <K, V> ConcurrentMap<K, V> newConcurrentHashMap() {
    return com.google.common.collect.Maps.newConcurrentMap();
  }

}
