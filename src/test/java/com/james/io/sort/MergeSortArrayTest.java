package com.james.io.sort;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MergeSortArrayTest {

    @Test
    public void testMerge() {
        List<Integer> list1 = Stream.of(5, 13, 17, null, null, null, null, null).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(3, 7, 11, 19).collect(Collectors.toList());
        List<Integer> expectedRes = Stream.of(3, 5, 7, 11, 13, 17, 19, null).collect(Collectors.toList());
        MergeSortArray.merge(list1, list2);
        assertEquals(expectedRes, list1);
    }

    @Ignore
    @Test
    public void testMergeEpi() {
        List<Integer> list1 = Stream.of(5, 13, 17, null, null, null, null, null).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(3, 7, 11, 19).collect(Collectors.toList());
        List<Integer> expectedRes = Stream.of(3, 5, 7, 11, 13, 17, 19, null).collect(Collectors.toList());
        MergeSortArray.mergeEpi(list1, list2);
        assertEquals(expectedRes, list1);
    }
}
