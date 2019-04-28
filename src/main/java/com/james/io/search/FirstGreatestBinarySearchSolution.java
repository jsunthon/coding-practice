package com.james.io.search;

import java.util.List;

/**
 * First variant of problem 12.1 of EPI
 */
public class FirstGreatestBinarySearchSolution {

    public static int searchFirstGreaterOccurence(List<Integer> list,
                                                  int key) {
        int low = 0;
        int high = list.size() - 1;
        int result = - 1;
        int mid;
        int midValue;

        while (low <= high) {
            mid = low + (high - low) / 2;
            midValue = list.get(mid);

            if (key > midValue || key == midValue) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }
}
