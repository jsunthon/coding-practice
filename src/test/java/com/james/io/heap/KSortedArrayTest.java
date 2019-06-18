package com.james.io.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KSortedArrayTest {

    @Test
    public void sortKSorted() {
        List<Integer> list = Arrays.asList(3, -1, 2, 6, 4, 8, 5);
        List<Integer> expected = Arrays.asList(-1, 2, 3, 4, 5, 6, 8);
        assertEquals(expected, KSortedArray.sortKSorted(list, 2));
    }

    @Test
    public void sortKSortedKGreaterThanN() {
        List<Integer> list = Arrays.asList(3, -1, 100);
        List<Integer> expected = Arrays.asList(-1, 3, 100);
        Assert.assertEquals(expected, KSortedArray.sortKSorted(list, 6));
    }
}