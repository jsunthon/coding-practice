package com.james.io.sort;

import static org.junit.Assert.assertEquals;

import com.james.io.sort.FastSortArraySolution.ListNode;
import org.junit.Test;

public class FastSortArraySolutionTest {

  @Test
  public void testSortMixedList() {
    ListNode<Integer> node10 = new ListNode<>(10);
    ListNode<Integer> node3 = new ListNode<>(3, node10);
    ListNode<Integer> node6 = new ListNode<>(6, node3);
    ListNode<Integer> node4 = new ListNode<>(4, node6);
    ListNode<Integer> node5 = new ListNode<>(5, node4);

    ListNode<Integer> expectedNode6 = new ListNode<>(6, node10);
    ListNode<Integer> expectedNode5 = new ListNode<>(5, expectedNode6);
    ListNode<Integer> expectedNode4 = new ListNode<>(4, expectedNode5);
    ListNode<Integer> expectedNode3 = new ListNode<>(3, expectedNode4);

    assertEquals(expectedNode3, FastSortArraySolution.sort(node5));
  }
}
