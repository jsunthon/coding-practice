package com.james.io.greedy.minwaitingtime;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class MinimumWaitingTimeSolutionTest {

  @Test
  public void testGetMinimumWaitingTimeAlreadySorted() {
    final List<Integer> list = Stream.of(1, 2, 3).collect(Collectors.toList());
    Assert.assertEquals(4, MinimumWaitingTimeSolution.getMinimumWaitingTime(list));
  }

  @Test
  public void testGetMinimumWaitingTimeNotAlreadySorted() {
    final List<Integer> list = Stream.of(2, 1, 3).collect(Collectors.toList());
    Assert.assertEquals(4, MinimumWaitingTimeSolution.getMinimumWaitingTime(list));
  }

  @Test
  public void testGetMinimumWaitingTimeMoreNumbersNotAlreadySorted() {
    final List<Integer> list = Stream.of(2, 5, 3, 1).collect(Collectors.toList());
    Assert.assertEquals(10, MinimumWaitingTimeSolution.getMinimumWaitingTime(list));
  }

  @Test
  public void testGetMinimumWaitingTimeEmptyList() {
    Assert
        .assertEquals(0, MinimumWaitingTimeSolution.getMinimumWaitingTime(Collections.emptyList()));
  }

  @Test
  public void testGetMinimumWaitingTimeOneElement() {
    Assert.assertEquals(0,
        MinimumWaitingTimeSolution.getMinimumWaitingTime(Collections.singletonList(10000)));
  }
}
