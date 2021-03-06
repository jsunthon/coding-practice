package com.james.io.search;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class FirstGreatestBinarySearchSolutionTest {

  private static final List<Integer> sortedList1 = Arrays
      .asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401);

  @Test
  public void testSearchFirstOccurenceGreaterExists() {
    assertEquals(9,
        FirstGreatestBinarySearchSolution.searchFirstGreaterOccurence(sortedList1, 285));
  }

  @Test
  public void testSearchFirstOccurenceGreaterNotExists() {
    assertEquals(1,
        FirstGreatestBinarySearchSolution.searchFirstGreaterOccurence(sortedList1, -13));
  }
}
