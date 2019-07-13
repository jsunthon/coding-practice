package com.james.io.graph.model;

public enum Direction {
  LEFT(0, -1),
  RIGHT(0, 1),
  UP(-1, 0),
  DOWN(1, 0);

  Direction(int shiftX, int shiftY) {
    this.shift = new Coordinate(shiftX, shiftY);
  }

  private Coordinate shift;

  public Coordinate getShift() {
    return shift;
  }
}
