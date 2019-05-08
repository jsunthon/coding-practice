package com.james.io.search;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MinimumBinarySearchSolutionTest {

    @Test
    public void testEpiBinarySearch() {
        List<Integer> list = Stream.of(-14, -10, 2, 108, 108,
                243, 285, 285, 285, 401)
                .collect(Collectors.toList());
        int index = MinimumBinarySearchSolution.epiBinarySearch(list, 285);
        assertEquals(6, index);
    }

    @Test
    public void testEpiBinarySearchAllIdentical() {
        List<Integer> list = Stream.of(285, 285, 285).collect(Collectors.toList());
        int index = MinimumBinarySearchSolution.epiBinarySearch(list, 285);
        assertEquals(0, index);
    }

    @Test
    public void testEpiBinarySearchEmpty() {
        assertEquals(-1,
                MinimumBinarySearchSolution
                        .epiBinarySearch(Collections.emptyList(), 285));
    }

    @Test
    public void testEpiBinarySearchNonEmptyNotFound() {
        List<Integer> list = Stream.of(-14, -10, 2, 108, 108,
                243, 285, 285, 285, 401)
                .collect(Collectors.toList());
        assertEquals(-1,
                MinimumBinarySearchSolution
                        .epiBinarySearch(list, 400));
    }

    @Test
    public void testEpiBinaryOneElementFound() {
        List<Integer> list = Collections.singletonList(1);
        assertEquals(0,
                MinimumBinarySearchSolution.epiBinarySearch(list, 1));
    }

    @Test
    public void testCustomBinarySearch() {
        List<Integer> list = Stream.of(-14, -10, 2, 108, 108,
                243, 285, 285, 285, 401)
                .collect(Collectors.toList());
        int index = MinimumBinarySearchSolution.customBinarySearch(list, 285);
        assertEquals(6, index);
    }

    @Test
    public void testCustomBinarySearchAllIdentical() {
        List<Integer> list = Stream.of(285, 285, 285).collect(Collectors.toList());
        int index = MinimumBinarySearchSolution.customBinarySearch(list, 285);
        assertEquals(0, index);
    }

    @Test
    public void testCustomBinarySearchEmpty() {
        assertEquals(-1,
                MinimumBinarySearchSolution
                        .customBinarySearch(Collections.emptyList(), 285));
    }

    @Test
    public void testCustomBinarySearchNonEmptyNotFound() {
        List<Integer> list = Stream.of(-14, -10, 2, 108, 108,
                243, 285, 285, 285, 401)
                .collect(Collectors.toList());
        assertEquals(-1,
                MinimumBinarySearchSolution
                        .customBinarySearch(list, 400));
    }

    @Test
    public void testCustomBinaryOneElementFound() {
        List<Integer> list = Collections.singletonList(1);
        assertEquals(0,
                MinimumBinarySearchSolution.customBinarySearch(list, 1));
    }
}
