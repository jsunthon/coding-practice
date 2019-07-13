package com.james.io.heap;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class RunningMedianTest {

  @Test
  public void genMedians() {
    List<Integer> list = Arrays.asList(1, 0, 3, 5, 2, 0, 1);
    List<Double> actualMedians = RunningMedian.genMedians(list.iterator());
    List<Double> expectedMedians = Arrays.asList(1.0, 0.5, 1.0, 2.0, 2.0, 1.5, 1.0);
    assertEquals(expectedMedians, actualMedians);
  }

  @Test
  public void getMediansOneNum() {
    assertEquals(Collections.singletonList(1.0),
        RunningMedian.genMedians(Collections.singletonList(1).iterator()));
  }
}