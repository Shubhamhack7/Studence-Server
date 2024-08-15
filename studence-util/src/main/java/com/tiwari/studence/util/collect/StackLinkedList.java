package com.tiwari.studence.util.collect;

import java.util.EmptyStackException;

public class StackLinkedList<E> {
  private Node<E> top;

  private static class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
      this.data = data;
    }
  }

  public void push(E item) {
    Node<E> newNode = new Node<>(item);
    newNode.next = top;
    top = newNode;
  }

  public E pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    E item = top.data;
    top = top.next;
    return item;
  }

  public E peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
