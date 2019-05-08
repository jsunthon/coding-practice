package com.james.io.search;

import java.util.List;

/**
 * Solution to problem 12.6 of EPI
 * <p>
 * This is a general search algorithm.
 * <p>
 * All O(1) space
 * time varies depending on the algorithm
 */
public class Sorted2dArraySolution {

    // O(m * n)
    public static boolean searchBrute(List<List<Integer>> lists, int key) {
        for (int row = 0; row < lists.size(); row++) {
            for (int col = 0; col < lists.get(row).size(); col++) {
                if (lists.get(row).get(col).equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(m * log n)
    public static boolean searchBinary(List<List<Integer>> lists, int key) {
        for (int row = 0; row < lists.size(); row++) {
            if (searchBinaryHelper(lists.get(row), key)) {
                return true;
            }
        }
        return false;
    }

    private static boolean searchBinaryHelper(List<Integer> list, int key) {
        int low = 0;
        int high = list.size() - 1;
        int mid;
        int midValue;

        while (low <= high) {
            mid = low + (high - low) / 2;
            midValue = list.get(mid);

            if (key > midValue) {
                low = mid + 1;
            } else if (key == midValue) {
                return true;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    // O (m + n), since we perform at most m + n - 1 iterations in the while loop
    public static boolean search(List<List<Integer>> lists, int key) {
        int row = 0;
        int col = lists.get(row).size() - 1;
        int value;

        while (row < lists.size() && col >= 0) {
            value = lists.get(row).get(col);

            if (key > value) {
                row++;
            } else if (value == key) {
                return true;
            } else {
                col--;
            }
        }
        return false;
    }
}
