package com.james.io.graph.transformstring;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class CustomTransformStringSolutionTest {

  @Test
  public void testGetProductionSequence_ok() {
    final String s = "cat";
    final String t = "dog";
    Set<String> dict = Stream.of("bat", "cot", t, "dag", "dot", s).collect(Collectors.toSet());
    Assert.assertEquals(3, new CustomTransformStringSolution().getProductionSequence(dict, s, t));
  }

  @Test
  public void testGetProductionSequence_bad() {
    final String s = "cat";
    final String t = "dog";
    Set<String> dict = Stream.of("bat").collect(Collectors.toSet());
    Assert.assertEquals(-1, new CustomTransformStringSolution().getProductionSequence(dict, s, t));
  }

  @Test
  public void testGetProductionSequence_okTwo() {
    final String s = "cat";
    final String t = "dog";
    Set<String> dict = Stream.of(s, t).collect(Collectors.toSet());
    Assert.assertEquals(-1, new CustomTransformStringSolution().getProductionSequence(dict, s, t));
  }

  @Test
  public void testGetProductSequence_moreThanOnePath() {
    Set<String> dict = Stream.of("cat", "dat", "bat", "lat", "bot", "bog", "dot", "dog")
        .collect(Collectors.toSet());
    Assert.assertEquals(3,
        new CustomTransformStringSolution().getProductionSequence(dict, "cat", "dog"));
  }
}
