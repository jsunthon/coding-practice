package com.james.io.greedy.invariant;

import java.util.List;

/**
 * 18.6 Gas Summing Problem
 * <p>
 * Reduce from O(n^2) time complexity to O(n)
 */
public class SumGas {

  private static final int MPG = 20;

  private static class CityAndGas {

    int city;
    int gallons;

    CityAndGas(int city, int gallons) {
      this.city = city;
      this.gallons = gallons;
    }
  }

  public static int getAmple(List<Integer> gallons,
      List<Integer> distances) {
    CityAndGas min = new CityAndGas(0, 0);
    int remainingGallons = 0;
    for (int i = 1; i < gallons.size(); i++) {
      remainingGallons += gallons.get(i - 1) - distances.get(i - 1) / MPG;
      if (remainingGallons < min.gallons) {
        min = new CityAndGas(i, remainingGallons);
      }
    }
    return min.city;
  }
}
