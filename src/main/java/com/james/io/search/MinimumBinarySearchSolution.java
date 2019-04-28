package com.james.io.search;

import java.util.List;

/**
 * Solution to problem 12.1 of EPI
 */
public class MinimumBinarySearchSolution {

    // my custom solution, which i think is still O(log n ) time complexity, O(1) space
    public static int customBinarySearch(List<Integer> list, int key) {
        int low = 0;
        int high = list.size() - 1;
        int midValue;
        int midIndex;
        while (low <= high) {
            midIndex = low + (high - low) / 2;
            midValue = list.get(midIndex);
            if (key > midValue) {
                low = midIndex + 1;
                continue;
            }
            if (key < midValue) {
                high = midIndex - 1;
                continue;
            }
            if (midIndex > 0 && list.get(midIndex - 1) == midValue) {
                high = midIndex - 1;
                continue;
            }
            return midIndex;
        }
        return -1;
    }
}
