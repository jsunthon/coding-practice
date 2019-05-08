package com.james.io.search;

import com.james.io.model.Interval;

import java.util.List;

/**
 * Soluition to the 3rd variant of problem 12.1 in EPI
 */
public class IntervalSearchSolution {

    // my custom solution
    public static Interval getInterval(List<Integer> list,
                                       int key) {
        int low = 0;
        int high = list.size() - 1;
        int midIndex;
        int midValue;

        while (low <= high) {
            midIndex = low + (high - low) / 2;
            midValue = list.get(midIndex);

            if (key > midValue) {
                low = midIndex + 1;
            } else if (key == midValue) {
                return explore(list, midIndex, key);
            } else {
                high = midIndex - 1;
            }
        }

        return new Interval(-1, -1);
    }

    private static Interval explore(List<Integer> list,
                                    int midIndex,
                                    int key) {
        final int leftInd = exploreLeft(list, midIndex, key);
        final int rightInd = exploreRight(list, midIndex, key);

        return new Interval(leftInd, rightInd);
    }

    private static int exploreLeft(List<Integer> list,
                                   int midIndex,
                                   int key) {
        int res = midIndex;
        while (midIndex >= 0) {
            if (list.get(midIndex) == key) {
                res = midIndex;
                midIndex--;
            } else {
                return res;
            }
        }

        return res;
    }

    private static int exploreRight(List<Integer> list,
                                    int midIndex,
                                    int key) {
        int res = midIndex;
        while (midIndex <= list.size() - 1) {
            if (list.get(midIndex) == key) {
                res = midIndex;
                midIndex++;
            } else {
                return res;
            }
        }

        return res;
    }
}
