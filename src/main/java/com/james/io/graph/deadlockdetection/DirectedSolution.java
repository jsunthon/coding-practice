package com.james.io.graph.deadlockdetection;

import com.james.io.graph.deadlockdetection.model.GraphVertex;
import com.james.io.graph.deadlockdetection.model.GraphVertex.Color;
import java.util.List;

/**
 * CustomTransformStringSolution for problem 19.4 on page 368 of Elements of Programming Interviews
 * in Java
 */
public class DirectedSolution {

  /**
   * Determines if the given graph has a deadlock
   *
   * @param graphVertices the graph
   * @return whether or not the graph has a deadlock
   */
  public boolean isDeadlock(List<GraphVertex> graphVertices) {
    if (graphVertices != null) {
      for (GraphVertex graphVertex : graphVertices) {
        if (graphVertex.color.equals(Color.WHITE) && hasCycle(graphVertex, null)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean hasCycle(GraphVertex curr, GraphVertex prev) {
    if (curr == prev || curr.color.equals(Color.GRAY)) {
      return true;
    }
    curr.color = Color.GRAY;
    for (GraphVertex graphVertex : curr.edges) {
      if (graphVertex.color != Color.BLACK && hasCycle(graphVertex, curr)) {
        return true;
      }
    }
    curr.color = Color.BLACK;
    return false;
  }
}
