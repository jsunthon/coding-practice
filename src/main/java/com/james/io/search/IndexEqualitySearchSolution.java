package com.james.io.search;

import java.util.List;

/**
 * Solution to problem 12.2 of EPI
 */
public class IndexEqualitySearchSolution {

  private IndexEqualitySearchSolution() {
  }

  public static int searchIndexEqualsWithNoDuplicate(List<Integer> list) {
    int low = 0;
    int high = list.size() - 1;
    int mid;
    int midValue;

    while (low <= high) {
      mid = low + (high - low) / 2;
      midValue = list.get(mid);

      if (midValue > mid) {
        high = mid - 1;
      } else if (midValue == mid) {
        return mid;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

  public static int searchIndexEqualsWithDuplicate(List<Integer> list) {
    int low = 0;
    int high = list.size() - 1;
    int mid;
    int midValue;

    while (low <= high) {
      mid = low + (high - low) / 2;
      midValue = list.get(mid);

      if (midValue == mid) {
        return mid;
      } else if (midValue < mid || ((mid < list.size() - 1) && (midValue == list.get(mid + 1)))) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }
}
