package com.tiwari.studence.util.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sets {

  public static <V> Set<V> newHashSet() {
    return new HashSet<V>();
  }

  public static <V> Set<V> newHashSet(V... initializers) {
    return new HashSet<V>(Arrays.asList(initializers));
  }

  public static <V> Set<V> newHashSet(Collection<V> collection) {
    return new HashSet<V>(collection);
  }

  public static <V> SortedSet<V> newTreeSet() {
    return new TreeSet<V>();
  }
  
  public static <V> LinkedHashSet<V> newLinkedHashSet() {
    return new LinkedHashSet<V>();
  }

  public static <V> SortedSet<V> newTreeSet(Comparator<? super V> comparator) {
    return new TreeSet<V>(comparator);
  }
}
