package com.tiwari.studence.util.collect;

import java.util.EmptyStackException;

public class StackArray<E> {
  private E[] data;
  private int top;

  public StackArray(int capacity) {
    data = (E[]) new Object[capacity];
    top = -1;
  }

  public void push(E item) {
    if (isFull()) {
      throw new IllegalStateException("Stack overflow");
    }
    data[++top] = item;
  }

  public E pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return data[top--];
  }

  public E peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return data[top];
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean isFull() {
    return top == data.length - 1;
  }
}
