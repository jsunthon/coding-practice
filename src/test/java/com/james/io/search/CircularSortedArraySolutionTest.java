package com.james.io.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CircularSortedArraySolutionTest {

    @Test
    public void testGetSmallestIndex() {
        List<Integer> list = Arrays.asList(378, 478, 550, 631, 103, 203, 220, 234, 279, 368);
        Assert.assertEquals(4, CircularSortedArraySolution.getSmallestIndex(list));
    }
}
