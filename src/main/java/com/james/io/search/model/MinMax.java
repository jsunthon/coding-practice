package com.james.io.search.model;

import java.util.Objects;

public final class MinMax {

  private final int min;
  private final int max;

  public MinMax(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public static MinMax getInstance(int a, int b) {
    return Integer.compare(a, b) < 0
        ? new MinMax(a, b)
        : new MinMax(b, a);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MinMax minMax = (MinMax) o;
    return min == minMax.min &&
        max == minMax.max;
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, max);
  }
}
