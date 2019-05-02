package com.james.io.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CircularSortedArraySolutionTest {

    @Test
    public void testGetSmallestIndex() {
        List<Integer> list = Arrays.asList(378, 478, 550, 631, 103, 203, 220, 234, 279, 368);
        Assert.assertEquals(4, CircularSortedArraySolution.getSmallestIndex(list));
    }

    @Test
    public void testSearchGreatestInMiddle() {
        List<Integer> list = Arrays.asList(20, 30, 60, 5, 3);
        Assert.assertEquals(2, CircularSortedArraySolution.searchGreatest(list));
    }

    @Test
    public void testSearchGreatestInRight() {
        List<Integer> list = Arrays.asList(100, 200, 500, 1000);
        Assert.assertEquals(3, CircularSortedArraySolution.searchGreatest(list));
    }

    @Test
    public void testSearchGreatestInLeft() {
        List<Integer> list = Arrays.asList(2000, 3000, 100, 60, 59, 53, 50, 40, 30, 20, 1);
        Assert.assertEquals(1, CircularSortedArraySolution.searchGreatest(list));
    }

    @Test
    public void testSearchGreatestSingleton() {
        List<Integer> list = Collections.singletonList(10);
        Assert.assertEquals(0, CircularSortedArraySolution.searchGreatest(list));
    }
}
