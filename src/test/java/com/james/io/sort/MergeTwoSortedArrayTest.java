package com.james.io.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MergeTwoSortedArrayTest {

    @Test
    public void testMerge() {
        List<Integer> list1 = Stream.of(2, 3, 3, 5, 5, 6, 7, 7, 8, 12).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(5, 5, 6, 8, 8, 9, 10, 10).collect(Collectors.toList());
        assertEquals(Stream.of(5, 6, 8).collect(Collectors.toList()), MergeTwoSortedArray.merge(list1, list2));
    }
}
