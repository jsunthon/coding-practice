package com.james.io.greedy.invariant;

import java.util.Collections;
import java.util.List;

/**
 * Solution to 18.4 of EPI
 */
public class ThreeSum {

  public static boolean threeSum(List<Integer> nums, int value) {
    Collections.sort(nums);
    for (Integer num : nums) {
      if (TwoSum.twoSum(nums, value - num)) {
        return true;
      }
    }
    return false;
  }
}
