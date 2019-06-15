package com.james.io.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KLongestStringTest {

    @Test
    public void testGetKLongest() {
        String first = "a";
        String second = "bc";
        String third = "abc";
        String fourth = "abcd";
        List<String> expected = Arrays.asList(second, third, fourth);

        List<String> original = Arrays.asList(second, fourth, third, first);

        List<String> actual = KLongestString.getKLongest(3, original.iterator());

        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}
