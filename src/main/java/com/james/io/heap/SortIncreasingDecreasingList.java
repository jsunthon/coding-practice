package com.james.io.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * EPI 11.2
 */
public class SortIncreasingDecreasingList {

  private enum SubArrayDirection {
    INCREASING, DECREASING;

    private SubArrayDirection getReversal() {
      return this.equals(INCREASING) ? DECREASING : INCREASING;
    }
  }

  // O(n log k) time complexity
  public static List<Integer> sortIncDec(List<Integer> list) {
    // break into sub arrays, and sort the decreasing arrays
    SubArrayDirection dir = SubArrayDirection.INCREASING;

    List<List<Integer>> subArrays = new ArrayList<>();
    int startIdx = 0;
    List<Integer> currList;
    for (int i = 1; i <= list.size(); i++) {
      if (reachedEnd(list, i)
          || startIncr(list, i, dir)
          || startDecr(list, i, dir)) {
        currList = list.subList(startIdx, i);
        if (dir.equals(SubArrayDirection.DECREASING)) {
          Collections.reverse(currList);
        }
        subArrays.add(currList);
        startIdx = i;

        dir = dir.getReversal();
      }
    }

    return MergedKSortedLists.mergeLists(subArrays);
  }

  private static boolean startIncr(List<Integer> list, int i, SubArrayDirection currDir) {
    return currDir.equals(SubArrayDirection.DECREASING)
        && (Integer.compare(list.get(i - 1), list.get(i)) < 0);
  }

  private static boolean startDecr(List<Integer> list, int i, SubArrayDirection currDir) {
    return currDir.equals(SubArrayDirection.INCREASING)
        && (Integer.compare(list.get(i - 1), list.get(i)) > 0);
  }

  private static boolean reachedEnd(List<Integer> list, int i) {
    return list.size() == i;
  }
}
