package com.james.io.stackandqueue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxStackOptimalEpiTest {

  @Test
  public void testMaxStackGetMax() {
    MaxStackOptimalEpi maxStack = new MaxStackOptimalEpi();
    maxStack.push(100);
    maxStack.push(1000);
    assertEquals(Integer.valueOf(1000), maxStack.getMax());
  }

  @Test
  public void testMaxStackPop() {
    MaxStackOptimalEpi maxStack = new MaxStackOptimalEpi();
    maxStack.push(100);
    maxStack.push(1000);
    assertEquals(Integer.valueOf(1000), maxStack.pop());
  }


  @Test
  public void testMaxStackPopMax() {
    MaxStackOptimalEpi maxStack = new MaxStackOptimalEpi();
    maxStack.push(3);
    maxStack.push(4);
    maxStack.push(1);
    maxStack.push(100);
    assertEquals(Integer.valueOf(100), maxStack.getMax());
    assertEquals(Integer.valueOf(100), maxStack.pop());
    assertEquals(Integer.valueOf(4), maxStack.getMax());
  }

  @Test(expected = IllegalStateException.class)
  public void testMaxStackPopWhenEmpty() {
    MaxStackOptimalEpi maxStack = new MaxStackOptimalEpi();
    maxStack.pop();
  }

  @Test(expected = IllegalStateException.class)
  public void testMaxStackGetMaxWhenEmpty() {
    MaxStackOptimalEpi maxStack = new MaxStackOptimalEpi();
    maxStack.getMax();
  }
}
