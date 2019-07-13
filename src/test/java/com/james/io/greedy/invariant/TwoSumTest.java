package com.james.io.greedy.invariant;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class TwoSumTest {

  @Test
  public void testTwoSumTwoUnique() {
    List<Integer> list = Stream.of(1, 2, 3).collect(Collectors.toList());
    assertTrue(TwoSum.twoSum(list, 4));
  }

  @Test
  public void twoTwoSumTwoDuplicate() {
    List<Integer> list = Stream.of(2, 3).collect(Collectors.toList());
    assertTrue(TwoSum.twoSum(list, 6));
    assertTrue(TwoSum.twoSum(list, 4));
  }
}
