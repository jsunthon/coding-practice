package com.james.io.model;

public final class Interval {

  private final int left;
  private final int right;

  public Interval(int left, int right) {
    this.left = left;
    this.right = right;
  }

  public int getLeft() {
    return left;
  }

  public int getRight() {
    return right;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof Interval)) {
      return false;
    }

    final Interval otherInterval = (Interval) other;

    final boolean leftEquals = left == otherInterval.getLeft();
    final boolean rightEquals = right == otherInterval.getRight();

    return leftEquals && rightEquals;
  }

  @Override
  public String toString() {
    return "[" + left + ", " + right + "]";
  }
}
