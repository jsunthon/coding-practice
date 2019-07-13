package com.james.io.greedy.intervalcovering;

import static junit.framework.TestCase.assertTrue;

import com.james.io.greedy.interalcovering.Interval;
import com.james.io.greedy.interalcovering.IntervalCoveringProblemSolution;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class IntervalCoveringProblemTest {

  private Interval interval1;
  private Interval interval2;
  private Interval interval3;
  private Interval interval4;

  private Integer[] interval1_1;
  private Integer[] interval2_1;
  private Integer[] interval3_1;
  private Integer[] interval4_1;

  @Before
  public void setup() {
    interval1 = new Interval(6, 9);
    interval2 = new Interval(3, 4);
    interval3 = new Interval(0, 3);
    interval4 = new Interval(2, 6);

    interval1_1 = new Integer[]{interval1.start, interval1.end};
    interval2_1 = new Integer[]{interval2.start, interval2.end};
    interval3_1 = new Integer[]{interval3.start, interval3.end};
    interval4_1 = new Integer[]{interval4.start, interval4.end};
  }

  @Test
  public void testGetCoverTimesEpi() {
    final List<Interval> intervals = Stream.of(interval1, interval2, interval3, interval4)
        .collect(Collectors.toList());
    final List<Integer> times = Stream.of(3, 6, 9).collect(Collectors.toList());

    IntervalCoveringProblemSolution.getCoverTimes(intervals).forEach(time -> {
      assertTrue(times.contains(time));
    });
  }
}
