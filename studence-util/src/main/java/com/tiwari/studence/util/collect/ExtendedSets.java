package com.tiwari.studence.util.collect;

import java.util.Set;

import com.google.common.collect.Sets;

public class ExtendedSets {
  public static <V> Set<V> newConcurrentSet() {
    return Sets.newConcurrentHashSet();
  }
}
