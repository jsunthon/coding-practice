package com.james.io.search;

import java.util.List;

/**
 * Problem 12.3 of EPI
 */
public class CircularSortedArraySolution {

  // original, epi solution
  public static int getSmallestIndex(List<Integer> list) {
    int low = 0;
    int high = list.size() - 1;
    int mid;

    while (low < high) {
      mid = low + (high - low) / 2;
      if (list.get(mid) > list.get(high)) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return low;
  }

  // custom solution to variant 1
  public static int searchGreatest(List<Integer> list) {
    int low = 0;
    int high = list.size() - 1;
    int mid;
    int midValue;

    while (low <= high) {
      mid = low + (high - low) / 2;
      midValue = list.get(mid);

      if (midValue > list.get(low)) {
        low = mid;
        continue;
      }

      if (midValue < list.get(low)) {
        high = mid - 1;
        continue;
      }

      if (midValue < list.get(high)) {
        low = mid + 1;
        continue;
      }

      return mid;
    }

    return -1;
  }

}
