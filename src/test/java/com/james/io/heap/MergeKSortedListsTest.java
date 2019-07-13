package com.james.io.heap;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MergeKSortedListsTest {

  @Test
  public void testMergeSortedLists() {
    List<Integer> list1 = Arrays.asList(3, 5, 7);
    List<Integer> list2 = Arrays.asList(0, 6);
    List<Integer> list3 = Arrays.asList(0, 6, 28);

    List<Integer> expected = Arrays.asList(0, 0, 3, 5, 6, 6, 7, 28);

    assertEquals(expected, MergedKSortedLists.mergeLists(Arrays.asList(list1, list2, list3)));
  }
}
