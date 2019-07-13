package com.james.io.search;

public class IntegerSquareSolution {

  public static int searchIntegerSquareRoot(int k) {
    int i = 0;

    while (Math.pow((double) i, 2) < k) {
      if (Math.pow((double) i + 1, 2) > k) {
        break;
      }
      i++;
    }

    return i;
  }

  public static int searchIntegerSquareRootLogN(int k) {
    long low = 0;
    long high = k;
    long mid;
    long midValue;

    while (low <= high) {
      mid = low + (high - low) / 2;
      midValue = mid * mid;

      if (midValue > k) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return (int) low - 1;
  }
}
