package com.james.io.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Custom implementation for problem 9.1 in EPI
 */
public class MaxStack {

  private final Deque<ListNode> linkedMaximums;
  private ListNode head;

  public MaxStack() {
    linkedMaximums = new LinkedList<>();
  }

  public static class ListNode implements Comparable<ListNode> {

    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
      this(val, null, null);
    }

    ListNode(int val, ListNode prev, ListNode next) {
      this.val = val;
      this.prev = prev;
      this.next = next;
    }

    @Override
    public int compareTo(ListNode other) {
      return Integer.compare(val, other.val);
    }

    @Override
    public boolean equals(Object other) {
      if (other == null) {
        return false;
      }

      if (!(other instanceof ListNode)) {
        return false;
      }
      ListNode otherNode = (ListNode) other;

      return prev == otherNode.prev && val == otherNode.val && next == otherNode.next;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, prev, next);
    }
  }

  public void push(int val) {
    ListNode listNode = new ListNode(val);

    if (head == null) {
      linkedMaximums.addFirst(listNode);
      head = listNode;
    } else {
      if (listNode.val > linkedMaximums.peek().val) {
        linkedMaximums.addFirst(listNode);
      }
      head.prev = listNode;
      listNode.next = head;
      head = listNode;
    }
  }

  public int pop() {
    if (head == null) {
      throw new IllegalStateException("Cannot remove element from empty stack");
    }
    if (head.equals(linkedMaximums.peekFirst())) {
      linkedMaximums.removeFirst();
    }
    ListNode temp = head;
    head = head.next;
    head.prev = null;
    temp.next = null;
    return temp.val;
  }

  public int getMax() {
    if (head == null) {
      throw new IllegalStateException("Cannot get maximal element from empty stack");
    }

    return linkedMaximums.peekFirst().val;
  }
}
