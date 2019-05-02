package com.james.io.search;

import java.util.List;

public class CircularSortedArraySolution {

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
}
