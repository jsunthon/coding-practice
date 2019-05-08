package com.james.io.sort;

import com.james.io.model.Interval;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MergeIntervalSolutionTest {

    @Test
    public void testGetMergedInterval() {
        final List<Interval> intervals = Arrays.asList(
                new Interval(-4, -1),
                new Interval(0, 2),
                new Interval(3, 6),
                new Interval(7, 9),
                new Interval(11, 12),
                new Interval(14, 17)
        );
        final List<Interval> expectedIntervals = Arrays.asList(
                new Interval(-4, -1),
                new Interval(0, 9),
                new Interval(11, 12),
                new Interval(14, 17)
        );
        assertEquals(expectedIntervals,
                MergeIntervalSolution
                        .getMergedInterval(intervals, new Interval(1, 8)));
    }

    @Test
    public void testGetMergedIntervalScenario2() {
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

    @Test
    public void testGetMergedIntervalScenario3() {
        final List<Interval> intervals = Arrays.asList(
                new Interval(1, 4),
                new Interval(5, 6)
        );
        final List<Interval> expectedIntervals = Arrays.asList(
                new Interval(1, 4),
                new Interval(5, 6),
                new Interval(7, 8)
        );

        assertEquals(expectedIntervals,
                MergeIntervalSolution
                        .getMergedInterval(intervals, new Interval(7, 8)));
    }

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