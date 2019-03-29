package com.james.io.graph.transformstring;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransformStringSolutionTest {
    
    @Test
    public void testshortestProductionSequence_ok() {
        final String s = "cat";
        final String t = "dog";
        Set<String> dict = Stream.of("bat", "cot", t, "dag", "dot", s).collect(Collectors.toSet());
        Assert.assertEquals(3, new TransformStringSolution().shortestProductionSequence(dict, s, t));
    }

    @Test
    public void testshortestProductionSequence_bad() {
        final String s = "cat";
        final String t = "dog";
        Set<String> dict = Stream.of("bat").collect(Collectors.toSet());
        Assert.assertEquals(-1, new TransformStringSolution().shortestProductionSequence(dict, s, t));
    }

    @Test
    public void testshortestProductionSequence_okTwo() {
        final String s = "cat";
        final String t = "dog";
        Set<String> dict = Stream.of(s, t).collect(Collectors.toSet());
        Assert.assertEquals(-1, new TransformStringSolution().shortestProductionSequence(dict, s, t));
    }

    @Test
    public void testGetProductSequence_moreThanOnePath() {
        Set<String> dict = Stream.of("cat", "dat", "bat", "lat", "bot", "bog", "dot", "dog").collect(Collectors.toSet());
        Assert.assertEquals(3, new TransformStringSolution().shortestProductionSequence(dict, "cat", "dog"));
    }
}
