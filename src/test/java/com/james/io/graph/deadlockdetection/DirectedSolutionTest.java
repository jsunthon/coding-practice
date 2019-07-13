package com.james.io.graph.deadlockdetection;

import com.james.io.graph.deadlockdetection.model.GraphVertex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectedSolutionTest {

  private DirectedSolution directedSolution;

  @Before
  public void setup() {
    directedSolution = new DirectedSolution();
  }

  @Test
  public void testIsDeadlockNoCycle() {
    GraphVertex graphVertex4 = new GraphVertex(Collections.emptyList());
    GraphVertex graphVertex3 = new GraphVertex(Collections.singletonList(graphVertex4));
    GraphVertex graphVertex2 = new GraphVertex(Collections.singletonList(graphVertex3));
    GraphVertex graphVertex1 = new GraphVertex(Collections.singletonList(graphVertex2));

    boolean isDeadlock = directedSolution
        .isDeadlock(Stream.of(graphVertex1).collect(Collectors.toList()));
    Assert.assertFalse(isDeadlock);
  }

  @Test
  public void testIsDeadlockOneNodeAway() {
    GraphVertex graphVertex3 = new GraphVertex(new ArrayList<>());
    GraphVertex graphVertex4 = new GraphVertex(Collections.singletonList(graphVertex3));
    graphVertex3.edges.add(graphVertex4);
    GraphVertex graphVertex2 = new GraphVertex(Collections.singletonList(graphVertex3));
    GraphVertex graphVertex1 = new GraphVertex(Collections.singletonList(graphVertex2));

    boolean isDeadlock = directedSolution
        .isDeadlock(Stream.of(graphVertex1).collect(Collectors.toList()));
    Assert.assertTrue(isDeadlock);
  }

  @Test
  public void testIsDeadlockTwoNodeAway() {
    GraphVertex graphVertex3 = new GraphVertex(new ArrayList<>());
    GraphVertex graphVertex2 = new GraphVertex(Collections.singletonList(graphVertex3));
    GraphVertex graphVertex1 = new GraphVertex(Collections.singletonList(graphVertex2));
    GraphVertex graphVertex4 = new GraphVertex(Collections.singletonList(graphVertex2));
    graphVertex3.edges.add(graphVertex4);

    boolean isDeadlock = directedSolution
        .isDeadlock(Stream.of(graphVertex1).collect(Collectors.toList()));
    Assert.assertTrue(isDeadlock);
  }

  @Test
  public void testIsDeadlockEmptyGraph() {
    directedSolution.isDeadlock(Collections.emptyList());
  }

  @Test
  public void testIsDeadlockNullGraph() {
    directedSolution.isDeadlock(null);
  }
}
