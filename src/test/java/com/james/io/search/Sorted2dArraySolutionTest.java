package com.james.io.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Sorted2dArraySolutionTest {

    private static final List<Integer> list1 = Arrays.asList(-1, 2, 4, 4, 6);
    private static final List<Integer> list2 = Arrays.asList(1, 5, 5, 9, 21);
    private static final List<Integer> list3 = Arrays.asList(3, 6, 6, 9, 22);
    private static final List<Integer> list4 = Arrays.asList(3, 6, 8, 10, 24);
    private static final List<Integer> list5 = Arrays.asList(6, 8, 9, 12, 25);
    private static final List<Integer> list6 = Arrays.asList(8, 10, 12, 13, 40);

    private static final List<List<Integer>> lists1 = Arrays.asList(list1, list2,
                                                    list3, list4, list5, list6);
    @Test
    public void searchMid() {
        Assert.assertTrue(Sorted2dArraySolution.search(lists1, 8));
    }

    @Test
    public void searchNotExistsLesser() {
        Assert.assertFalse(Sorted2dArraySolution.search(lists1, -2));
    }

    @Test
    public void searchNotExistsGreater() {
        Assert.assertFalse(Sorted2dArraySolution.search(lists1, 100));
    }

    @Test
    public void searchBruteMid() {
        Assert.assertTrue(Sorted2dArraySolution.searchBrute(lists1, 8));
    }

    @Test
    public void searchBruteNotExistsLesser() {
        Assert.assertFalse(Sorted2dArraySolution.searchBrute(lists1, -2));
    }

    @Test
    public void searchBruteNotExistsGreater() {
        Assert.assertFalse(Sorted2dArraySolution.searchBrute(lists1, 100));
    }

    @Test
    public void searchBinaryMid() {
        Assert.assertTrue(Sorted2dArraySolution.searchBinary(lists1, 8));
    }

    @Test
    public void searchBinaryNotExistsLesser() {
        Assert.assertFalse(Sorted2dArraySolution.searchBinary(lists1, -2));
    }

    @Test
    public void searchBinaryNotExistsGreater() {
        Assert.assertFalse(Sorted2dArraySolution.searchBinary(lists1, 100));
    }
}