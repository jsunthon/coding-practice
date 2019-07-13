package com.james.io.heap;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

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
