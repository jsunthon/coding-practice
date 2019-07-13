package com.james.io.stackandqueue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxQueueTest {

  @Test
  public void testDequeue() {
    MaxQueue maxQueue = new MaxQueue();
    maxQueue.enqueue(10);
    maxQueue.enqueue(150);
    maxQueue.enqueue(3);
    maxQueue.enqueue(100);

    assertEquals(Integer.valueOf(10), maxQueue.dequeue());
  }

  @Test
  public void testMaxDequeueTillLastMax() {
    MaxQueue maxQueue = new MaxQueue();
    maxQueue.enqueue(10);
    maxQueue.enqueue(150);
    maxQueue.enqueue(3);
    maxQueue.enqueue(100);

    maxQueue.dequeue();
    maxQueue.dequeue();
    maxQueue.dequeue();

    assertEquals(Integer.valueOf(100), maxQueue.max());
  }

  @Test
  public void testMaxMaxDeuqueTillIntermediateMax() {
    MaxQueue maxQueue = new MaxQueue();
    maxQueue.enqueue(10);
    maxQueue.enqueue(150);
    maxQueue.enqueue(3);
    maxQueue.enqueue(100);

    maxQueue.dequeue();
    maxQueue.dequeue();

    assertEquals(Integer.valueOf(100), maxQueue.max());
  }

  @Test(expected = IllegalStateException.class)
  public void testMaxQueueIsEmpty() {
    MaxQueue maxQueue = new MaxQueue();
    maxQueue.dequeue();
  }

  @Test
  public void testMaxEnqueueAscending() {
    MaxQueue maxQueue = new MaxQueue();
    maxQueue.enqueue(1);
    maxQueue.enqueue(2);
    maxQueue.enqueue(3);

    assertEquals(Integer.valueOf(3), maxQueue.max());
  }

  @Test
  public void testMaxEnqueueDescending() {
    MaxQueue maxQueue = new MaxQueue();
    maxQueue.enqueue(3);
    maxQueue.enqueue(2);
    maxQueue.enqueue(1);

    assertEquals(Integer.valueOf(3), maxQueue.max());
  }
}
