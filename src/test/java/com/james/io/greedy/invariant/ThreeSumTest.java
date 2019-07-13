package com.james.io.greedy.invariant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class ThreeSumTest {

  @Test
  public void testThreeSumUniqueNumbersSolution() {
    List<Integer> nums = Stream.of(11, 2, 5, 7, 3).collect(Collectors.toList());
    assertTrue(ThreeSum.threeSum(nums, 21));
  }

  @Test
  public void testThreeSumDuplicateNumbersSolution() {
    List<Integer> nums = Stream.of(5, 2).collect(Collectors.toList());
    assertTrue(ThreeSum.threeSum(nums, 15));
  }

  @Test
  public void testThreeSumEmpty() {
    assertFalse(ThreeSum.threeSum(Collections.emptyList(), 15));
  }

  @Test
  public void testThreeSumOneNumberNoSolution() {
    assertFalse(ThreeSum.threeSum(Collections.singletonList(2), 15));
  }
}
