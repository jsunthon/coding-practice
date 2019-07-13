package com.james.io.sort;

import java.util.List;

/**
 * Custom, non-efficient solution to problem 14.2 of EPI
 */
public class MergeSortArray {

  // O(m * n) time complexity, O(1) space complexity
  public static void merge(List<Integer> list1, List<Integer> list2) {
    for (int i = 0; i < list2.size(); i++) {
      int curr = list2.get(i);
      int index = getIndex(curr, list1);
      fill(curr, index, list1);
    }
  }

  // EPI solution: O(m + n) time complexity, O(1) space complexity
  public static void mergeEpi(List<Integer> list1,
      List<Integer> list2) {
    int a = list1.size() - 1;
    int b = list2.size() - 1;
    int writeIdx = list1.size() + list2.size() - 1;
    while (a >= 0 && b >= 0) {
      list1.set(writeIdx--, list1.get(a) > list2.get(b) ? list1.get(a--) : list2.get(b--));
    }
    while (b >= 0) {
      list1.set(writeIdx--, list2.get(b--));
    }
  }

  private static int getIndex(int value, List<Integer> list) {
    int i = 0;

    while (i < list.size() && list.get(i) != null) {
      if (value <= list.get(i)) {
        return i;
      }
      i++;
    }

    return i;
  }

  private static void fill(int value, int index, List<Integer> list) {
    Integer curr = value;
    Integer temp;
    for (int i = index; i < list.size() && curr != null; i++) {
      temp = list.get(i);
      list.set(i, curr);
      curr = temp;
    }
  }
}
