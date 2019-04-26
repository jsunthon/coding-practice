package com.james.io.sort;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CommonIntersectionArrayTest {

    @Test
    public void testGetIntersectionCustom() {
        List<Integer> list1 = Stream.of(2, 3, 3, 5, 5, 6, 7, 7, 8, 12).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(5, 5, 6, 8, 8, 9, 10, 10).collect(Collectors.toList());
        assertEquals(Stream.of(5, 6, 8).collect(Collectors.toList()), CommonIntersectionArray.getIntersection(list1, list2));
    }

    @Test
    public void testGetIntersectionCustomNoCommonElements() {
        List<Integer> list1 = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(4, 5, 6).collect(Collectors.toList());
        assertEquals(Collections.emptyList(), CommonIntersectionArray.getIntersection(list1, list2));
    }

    @Test
    public void testGetIntersectionEpiEpi() {
        List<Integer> list1 = Stream.of(2, 3, 3, 5, 5, 6, 7, 7, 8, 12).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(5, 5, 6, 8, 8, 9, 10, 10).collect(Collectors.toList());
        assertEquals(Stream.of(5, 6, 8).collect(Collectors.toList()), CommonIntersectionArray.getIntersectionEpi(list1, list2));
    }

    @Test
    public void testGetIntersectionEpiNoCommonElements() {
        List<Integer> list1 = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(4, 5, 6).collect(Collectors.toList());
        assertEquals(Collections.emptyList(), CommonIntersectionArray.getIntersectionEpi(list1, list2));
    }
}
