package com.james.io.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeIntervalLeetcodeTest {

  @Test
  public void testMerge() {
    int[][] i = new int[][]{
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    };

    assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, MergeIntervalLeetcode.merge(i));
  }

  @Test
  public void testMergeAllEquals() {
    int[][] i = new int[][]{
        {1, 3},
        {1, 3}
    };

    assertArrayEquals(new int[][]{{1, 3}}, MergeIntervalLeetcode.merge(i));
  }

  @Test
  public void testMergeUnsorted() {
    int[][] i = new int[][]{
        {3, 3},
        {3, 5},
        {5, 10},
        {4, 11}
    };

    assertArrayEquals(new int[][]{{3, 11}}, MergeIntervalLeetcode.merge(i));
  }

  @Test
  public void testMergeAllIntersect() {
    int[][] i = new int[][]{
        {3, 4},
        {4, 10},
        {10, 103343},
        {103344, 110000000}
    };

    assertArrayEquals(new int[][]{{3, 103343}, {103344, 110000000}},
        MergeIntervalLeetcode.merge(i));
  }

  @Test
  public void testMergeEmpty() {
    assertArrayEquals(new int[][]{}, MergeIntervalLeetcode.merge(new int[][]{}));
  }
}
