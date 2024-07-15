package com.tiwari.studence.util.collect;


public class Quadlets<T, U, V,W> { // Cool class name with generics

  private final T first;
  private final U middle;
  private final V second_last;
  private final W last;

  public Quadlets(T first, U Middle, V second_last,W last) {
    this.first = first;
    this.middle = Middle;
    this.second_last = second_last;
    this.last = last;
  }

  // Separate functions for accessing each variable (using descriptive names)
  public T getFirstValue() {
    return first;
  }

  public U getMiddleValue() {
    return middle;
  }

  public V getSecondLastValue() {
    return second_last;
  }

  public W getLastValue() {
    return last;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + middle + ", " + second_last + ", " +last + ")"; // Clear and concise format
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Quadlets<?, ?, ?,?> other = (Quadlets<?, ?, ?,?>) obj;
    return (first == null ? other.first == null : first.equals(other.first)) &&
            (middle == null ? other.middle == null : middle.equals(other.middle)) &&
            (second_last == null ? other.second_last == null : second_last.equals(other.second_last)) &&
            (last == null ? other.last == null : last.equals(other.last));
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (first != null ? first.hashCode() : 0);
    result = 31 * result + (middle != null ? middle.hashCode() : 0);
    result = 31 * result + (second_last != null ? second_last.hashCode() : 0);
    result = 31 * result + (last != null ? last.hashCode() : 0);
    return result;
  }
}
