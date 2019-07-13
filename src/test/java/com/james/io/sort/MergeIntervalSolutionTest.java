package com.james.io.sort;

import static org.junit.Assert.assertEquals;

import com.james.io.model.Interval;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class MergeIntervalSolutionTest {

  static final List<Interval> intervals = Arrays.asList(
      new Interval(-4, -1),
      new Interval(0, 2),
      new Interval(3, 6),
      new Interval(7, 9),
      new Interval(11, 12),
      new Interval(14, 17)
  );

  static final List<Interval> expectedIntervals = Arrays.asList(
      new Interval(-4, -1),
      new Interval(0, 9),
      new Interval(11, 12),
      new Interval(14, 17)
  );

  @Test
  public void testAddIntervalIntersection() {
    assertEquals(expectedIntervals,
        MergeIntervalSolution.addInterval(intervals, new Interval(1, 8)));
  }

  @Test
  public void testAddIntervalIntersection2() {
    final List<Interval> intervals = Arrays.asList(
        new Interval(1, 4),
        new Interval(5, 6)
    );
    final List<Interval> expectedIntervals = Collections
        .singletonList(new Interval(1, 6));

    assertEquals(expectedIntervals,
        MergeIntervalSolution
            .addInterval(intervals, new Interval(2, 6)));
  }

  @Test
  public void testAddIntervalUnionStrictlyGreaterInterval() {
    final List<Interval> intervals = Arrays.asList(
        new Interval(1, 4),
        new Interval(5, 6)
    );

    final Interval strictlyGreater = new Interval(7, 8);

    final List<Interval> expectedIntervals = Arrays.asList(
        new Interval(1, 4),
        new Interval(5, 6),
        strictlyGreater
    );

    assertEquals(expectedIntervals,
        MergeIntervalSolution
            .addInterval(intervals, strictlyGreater));
  }

  @Test
  public void testAddIntervalUnionStrictlyLesserInterval() {
    final List<Interval> intervals = Arrays.asList(
        new Interval(1, 4),
        new Interval(5, 6)
    );

    final Interval strictlyLesser = new Interval(-2, -1);

    final List<Interval> expectedIntervals = Arrays.asList(
        strictlyLesser,
        new Interval(1, 4),
        new Interval(5, 6)
    );

    assertEquals(expectedIntervals,
        MergeIntervalSolution
            .addInterval(intervals, strictlyLesser));
  }

  @Test
  public void testAddIntervalEmpty() {
    final List<Interval> intervals = Collections.emptyList();
    final List<Interval> expectedIntervals = Collections
        .singletonList(new Interval(1, 6));

    assertEquals(expectedIntervals,
        MergeIntervalSolution
            .addInterval(intervals, new Interval(1, 6)));
  }

  @Test
  public void testGetMergedIntervalIntersection() {
    assertEquals(expectedIntervals,
        MergeIntervalSolution.getMergedInterval(intervals, new Interval(1, 8)));
  }

  @Test
  public void testGetMergedIntervalIntersectionScenario2() {
    final List<Interval> intervals = Arrays.asList(
        new Interval(1, 4),
        new Interval(5, 6)
    );
    final List<Interval> expectedIntervals = Collections
        .singletonList(new Interval(1, 6));

    assertEquals(expectedIntervals,
        MergeIntervalSolution
            .getMergedInterval(intervals, new Interval(2, 6)));
  }

  @Ignore
  @Test
  public void testGetMergedIntervalUnionStrictlyGreaterInterval() {
    final List<Interval> intervals = Arrays.asList(
        new Interval(1, 4),
        new Interval(5, 6)
    );

    final Interval strictlyGreater = new Interval(7, 8);

    final List<Interval> expectedIntervals = Arrays.asList(
        new Interval(1, 4),
        new Interval(5, 6),
        strictlyGreater
    );

    assertEquals(expectedIntervals,
        MergeIntervalSolution
            .getMergedInterval(intervals, strictlyGreater));
  }

  @Ignore
  @Test
  public void testGetMergedIntervalEmpty() {
    final List<Interval> intervals = Collections.emptyList();
    final List<Interval> expectedIntervals = Collections
        .singletonList(new Interval(1, 6));

    assertEquals(expectedIntervals,
        MergeIntervalSolution
            .getMergedInterval(intervals, new Interval(1, 6)));
  }
}