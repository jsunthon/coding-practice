package com.james.io.stackandqueue;

import static org.junit.Assert.assertEquals;

import com.james.io.stackandqueue.PostingList.Posting;
import org.junit.Test;

public class PostingListTest {

  @Test
  public void testSetOrder() {
    Posting zero = new Posting();
    Posting first = new Posting();
    Posting second = new Posting();
    Posting third = new Posting();

    zero.next = second;
    zero.jump = first;

    first.next = third;
    first.jump = second;

    second.next = first;

    PostingList.setOrder(zero);

    assertEquals(0, zero.order);
    assertEquals(1, first.order);
    assertEquals(2, second.order);
    assertEquals(3, third.order);
  }
}
