package com.james.io.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution to problem 9.9 of EPI
 */
public class StackedQueue<T> {

  private final Deque<T> enq;
  private final Deque<T> deq;

  public StackedQueue() {
    enq = new LinkedList<>();
    deq = new LinkedList<>();
  }

  public void enqueue(T val) {
    enq.addLast(val);
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Empty queue");
    }

    if (deq.isEmpty()) {
      while (!enq.isEmpty()) {
        deq.addLast(enq.removeLast());
      }
    }

    return deq.removeLast();
  }

  public int size() {
    return enq.size() + deq.size();
  }

  public boolean isEmpty() {
    return size() == 0;
  }
}
