package com.james.io.greedy.invariant;

import java.util.List;

public class TwoSum {

  // assume that nums is sorted
  public static boolean twoSum(List<Integer> nums, int value) {
    // maintain a sub array invariant
    int start = 0;
    int end = nums.size() - 1;
    int sum;
    while (start <= end) {
      sum = nums.get(start) + nums.get(end);
      if (sum > value) {
        end--;
      } else if (sum == value) {
        return true;
      } else {
        start++;
      }
    }
    return false;
  }
}
