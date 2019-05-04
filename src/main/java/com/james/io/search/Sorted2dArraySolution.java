package com.james.io.search;

import java.util.List;

/**
 * O(m + n) solution to problem 12.6 of EPI
 *
 * This is a general search algorithm.
 */
public class Sorted2dArraySolution {

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
