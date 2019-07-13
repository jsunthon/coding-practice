package com.james.io.stackandqueue;

/**
 * Custom solution to problem 9.8 of EPI
 */
public class CircularQueueCustom {

  private Integer[] entries;
  private static final float LOAD_FACTOR = 0.75f;
  private int head = 0;
  private int tail = head - 1;

  public CircularQueueCustom(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Invalid initial capacity: " + initialCapacity);
    }
    entries = new Integer[initialCapacity];
  }

  public void enqueue(Integer val) {
    resize();
    entries[++tail] = val;
  }

  public Integer dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Dequeue is empty!");
    }
    return entries[head++];
  }

  public Integer size() {
    return tail - head + 1;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  private void resize() {
    if (size() >= entries.length * LOAD_FACTOR) {
      Integer[] newEntries = new Integer[entries.length * 2];
      int newIndex = 0;
      for (int i = head; i <= tail; i++) {
        newEntries[newIndex++] = entries[i];
      }
      head = 0;
      tail = head = -1;
      entries = newEntries;
    }
  }
}
