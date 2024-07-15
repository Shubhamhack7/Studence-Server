package com.tiwari.studence.util.collect;

public class Triplets<T, U, V> { // Cool class name with generics

  private final T first;
  private final U middle;
  private final V last;

  public Triplets(T first, U Middle, V last) {
    this.first = first;
    this.middle = Middle;
    this.last = last;
  }

  // Separate functions for accessing each variable (using descriptive names)
  public T getFirstValue() {
    return first;
  }

  public U getMiddleValue() {
    return middle;
  }

  public V getLastValue() {
    return last;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + middle + ", " + last + ")"; // Clear and concise format
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Triplets<?, ?, ?> other = (Triplets<?, ?, ?>) obj;
    return (first == null ? other.first == null : first.equals(other.first)) &&
            (middle == null ? other.middle == null : middle.equals(other.middle)) &&
            (last == null ? other.last == null : last.equals(other.last));
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (first != null ? first.hashCode() : 0);
    result = 31 * result + (middle != null ? middle.hashCode() : 0);
    result = 31 * result + (last != null ? last.hashCode() : 0);
    return result;
  }
}
