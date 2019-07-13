package com.james.io.graph.regioncolor;

import com.james.io.graph.constants.GraphConstants;
import com.james.io.graph.model.Coordinate;
import com.james.io.graph.model.Mark;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * CustomTransformStringSolution to the Compute Enclosed Region problem in Elements of Programming
 * Interviews in Java,
 * <p>
 * Problem 19.3 on page 365
 */
public class ColorEnclosedRegionSolution {

  private final List<List<Mark>> graph;
  private final Mark freeBoundaryMark;
  private final List<List<Boolean>> visited;

  public ColorEnclosedRegionSolution(List<List<Mark>> graph) {
    this.graph = graph;
    this.freeBoundaryMark = Mark.W;
    this.visited = new ArrayList<>();
  }

  /**
   * Colors regions that cannot reach the boundary.
   * <p>
   * The color to color with is fixed as 'B'
   */
  public void color() {
    if (!graph.isEmpty()) {
      graph.forEach(row -> visited.add(new ArrayList<>(Collections.nCopies(row.size(), false))));
      exploreBoundaryLeftRight();
      exploreBoundaryUpDown();
      colorEnclosed();
    }
  }

  public void reset() {
    graph.clear();
    visited.clear();
  }

  private void exploreBoundaryLeftRight() {
    Coordinate current;

    // explore fro the left side to the right side
    for (int i = 0; i < graph.size(); i++) {
      current = new Coordinate(i, 0);
      if (shouldVisit(current)) {
        exploreBoundaryCell(current);
      }
      current = new Coordinate(i, graph.get(i).size() - 1);
      if (shouldVisit(current)) {
        exploreBoundaryCell(current);
      }
    }
  }

  private void exploreBoundaryUpDown() {
    Coordinate current;

    // explore from up to down
    for (int j = 0; j < graph.get(0).size(); j++) {
      current = new Coordinate(0, j);
      if (shouldVisit(current)) {
        exploreBoundaryCell(current);
      }
      current = new Coordinate(graph.size() - 1, j);
      if (shouldVisit(current)) {
        exploreBoundaryCell(current);
      }
    }
  }

  private void colorEnclosed() {
    Coordinate current;

    for (int i = 1; i < graph.size() - 1; i++) {
      for (int j = 1; j < graph.get(i).size() - 1; j++) {
        current = new Coordinate(i, j);
        if (shouldVisit(current)) {
          graph.get(i).set(j, Mark.B);
        }
      }
    }
  }

  private void exploreBoundaryCell(Coordinate start) {
    final Queue<Coordinate> queue = new LinkedList<>();
    queue.offer(start);
    visited.get(start.getX()).set(start.getY(), true);

    Coordinate current;
    Coordinate next;
    while (!queue.isEmpty()) {
      current = queue.poll();
      for (Coordinate shift : GraphConstants.SHIFTS) {
        next = new Coordinate(current.getX() + shift.getX(), current.getY() + shift.getY());
        if (isValid(next)) {
          queue.offer(next);
          visited.get(next.getX()).set(next.getY(), true);
        }
      }
    }
  }

  private boolean isValid(Coordinate current) {
    return current.getX() >= 0 && current.getX() < graph.size()
        && current.getY() >= 0 && current.getY() < graph.get(current.getX()).size()
        && shouldVisit(current);
  }

  private boolean shouldVisit(Coordinate current) {
    return graph.get(current.getX()).get(current.getY()).equals(freeBoundaryMark)
        && !visited.get(current.getX()).get(current.getY());
  }
}
