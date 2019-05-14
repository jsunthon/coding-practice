package com.james.io.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A problem like 14.6 of EPI , but the leetcode version
 */
public class MergeIntervalLeetcode {

    public static int[][] merge (int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][] {};
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        final List<int[]> res = new ArrayList<>();
        int[] current = intervals[0];
        res.add(current);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[0] = Math.min(intervals[i][0], current[0]);
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                current = intervals[i];
                res.add(current);
            }
        }

        return res.toArray(new int[][] {});
    }
}
