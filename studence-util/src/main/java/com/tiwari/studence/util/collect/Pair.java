package com.tiwari.studence.util.collect;

public class Pair<F, S> {
  private F m_first;
  private S m_second;

  public Pair(F first, S second) {
    m_first = first;
    m_second = second;
  }

  public F getFirst() {
    return m_first;
  }

  public S getSecond() {
    return m_second;
  }

  @Override
  public String toString() {
    return m_first + " " + m_second;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Pair<?, ?>)) {
      return super.equals(obj);
    }
    Pair<F, S> other = (Pair<F, S>) obj;
    return m_first.equals(other.getFirst()) && m_second.equals(other.getSecond());
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

}
