package com.james.io.greedy.invariant;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MajorityElementTest {

    @Test
    public void findMajorityWithSpread() {
        List<String> seq = Stream.of("b", "a", "c", "a", "a", "a").collect(Collectors.toList());
        Assert.assertEquals("a", MajorityElement.findMajority(seq));
    }

    @Test
    public void findMajorityWithRightSpread() {
        List<String> seq = Stream.of("b", "c", "a", "a", "a", "a").collect(Collectors.toList());
        Assert.assertEquals("a", MajorityElement.findMajority(seq));
    }

    @Test
    public void findMAjorityWithLeftSpread() {
        List<String> seq = Stream.of("a", "a", "a", "a", "b", "c").collect(Collectors.toList());
        Assert.assertEquals("a", MajorityElement.findMajority(seq));
    }
}
