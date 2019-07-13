package com.james.io.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import org.junit.Test;

public class HeapBasedQueueTest {

  @Test
  public void testQueueOk() {
    HeapBasedQueue stack = new HeapBasedQueue();

    stack.add(3);
    stack.add(4);
    stack.add(5);

    assertEquals(3, stack.remove());
    assertEquals(4, stack.remove());
    assertEquals(5, stack.remove());
  }

  @Test
  public void testQueueOneElement() {
    HeapBasedQueue stack = new HeapBasedQueue();

    stack.add(3);

    assertEquals(3, stack.remove());
  }

  @Test(expected = NoSuchElementException.class)
  public void testQueueEmpty() {
    HeapBasedQueue stack = new HeapBasedQueue();

    stack.remove();
  }

  @Test
  public void testQueueIsEmptyTrue() {
    HeapBasedQueue stack = new HeapBasedQueue();

    assertTrue(stack.isEmpty());
  }

  @Test
  public void testQueueIsEmptyFalse() {
    HeapBasedQueue stack = new HeapBasedQueue();

    stack.add(5);

    assertFalse(stack.isEmpty());
  }

}