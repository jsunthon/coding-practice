package com.james.io.search;

import com.james.io.search.model.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntervalSearchSolutionTest {

    private static final List<Integer> variedList = Arrays.asList(1, 2, 2, 4, 4, 4, 7, 11, 11, 13);
    private static final List<Integer> nCopies = Collections.nCopies(10, 100);
    private static final List<Integer> singleton = Collections.singletonList(10);

    @Test
    public void testGetInterval() {
        Interval expectedInterval = new Interval(7, 8);
        Interval actualInterval = IntervalSearchSolution.getInterval(variedList, 11);
        assertEquals(expectedInterval, actualInterval);
    }

    @Test
    public void testGetIntervalAllEqual() {
        Interval expectedInterval = new Interval(0, nCopies.size() - 1);
        Interval actualInterval = IntervalSearchSolution.getInterval(nCopies, 100);
        assertEquals(expectedInterval, actualInterval);
    }

    @Test
    public void testGetIntervalAllEqualNotFound() {
        Interval expectedInterval = new Interval(-1, -1);
        Interval actualInterval = IntervalSearchSolution.getInterval(nCopies, 1001);
        assertEquals(expectedInterval, actualInterval);
    }

    @Test
    public void testGetIntervalEmpty() {
        List<Integer> list = Collections.emptyList();
        Interval expectedInterval = new Interval(-1, -1);
        Interval actualInterval = IntervalSearchSolution.getInterval(list, 1001);
        assertEquals(expectedInterval, actualInterval);
    }

    @Test
    public void testGetIntervalSingleton() {
        Interval expectedInterval = new Interval(0, 0);
        Interval actualInterval = IntervalSearchSolution.getInterval(singleton, 10);
        assertEquals(expectedInterval, actualInterval);
    }

    @Test
    public void testGetIntervalSingletonNotFound() {
        Interval expectedInterval = new Interval(-1, -1);
        Interval actualInterval = IntervalSearchSolution.getInterval(singleton, 11);
        assertEquals(expectedInterval, actualInterval);
    }
}
