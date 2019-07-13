package com.james.io.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HeapBasedStackTest {

  @Test
  public void testStackOk() {
    HeapBasedStack stack = new HeapBasedStack();

    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertEquals(5, stack.pop());
    assertEquals(4, stack.pop());
    assertEquals(3, stack.pop());
  }

  @Test
  public void testStackOneElement() {
    HeapBasedStack stack = new HeapBasedStack();

    stack.push(3);

    assertEquals(3, stack.pop());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testStackEmpty() {
    HeapBasedStack stack = new HeapBasedStack();

    stack.pop();
  }

  @Test
  public void testStackIsEmptyTrue() {
    HeapBasedStack stack = new HeapBasedStack();

    assertTrue(stack.isEmpty());
  }

  @Test
  public void testStackIsEmptyFalse() {
    HeapBasedStack stack = new HeapBasedStack();

    stack.push(5);

    assertFalse(stack.isEmpty());
  }

}