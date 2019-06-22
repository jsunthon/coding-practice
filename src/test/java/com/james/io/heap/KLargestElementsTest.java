package com.james.io.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class KLargestElementsTest {

    @Test
    public void kLargest() {
        List<Integer> maxHeap = Arrays.asList(561, 314, 401, 28, 156, 359, 271, 11, 3);
        List<Integer> kLargest = KLargestElements.kLargest(maxHeap, 4);

        assertEquals(Stream.of(561, 314, 401, 359).collect(Collectors.toSet()), new HashSet<>(kLargest));
    }

    @Test
    public void kLargestEpi() {
        List<Integer> maxHeap = Arrays.asList(561, 314, 401, 28, 156, 359, 271, 11, 3);
        List<Integer> kLargest = KLargestElements.kLargestEpi(maxHeap, 4);

        assertEquals(Arrays.asList(561, 401, 359, 314), kLargest);
    }
}