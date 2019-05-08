package com.james.io.sort;

import com.james.io.model.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution to problem 14.5 of EPI
 */
public class MergeIntervalSolution {

    // overly long and possibly shit slution
    // still O(n) time, O(n) space
    public static List<Interval> getMergedInterval(List<Interval> intervals,
                                                   Interval interval) {
        final List<Interval> result = new ArrayList<>();

        int start = findStart(intervals, interval);

        for (int i = 0; i < start; i++) {
            result.add(intervals.get(i));
        }

        final Interval mergedIntermediate = mergeHelper(intervals, start, interval);

        result.add(mergedIntermediate);

        int end = findEnd(intervals, mergedIntermediate);

        for (int i = end; i < intervals.size(); i++) {
            result.add(intervals.get(i));
        }

        return result;
    }

    private static int findStart(List<Interval> intervals,
                                Interval interval) {
        int start = 0;

        while (start < intervals.size()
            && interval.getLeft() > intervals.get(start).getRight()) {
            start++;
        }

        return start;
    }

    private static Interval mergeHelper(List<Interval> intervals,
                                       int start,
                                       Interval interval) {
        int pos = start;
        final int startRes = Math.min(intervals.get(pos).getLeft(),
                                interval.getLeft());
        int endRes = 0;
        while (pos < intervals.size()
                && interval.getRight() >= intervals.get(pos).getLeft()) {
            endRes = Math.max(intervals.get(pos).getRight(), interval.getRight());
            pos++;
        }
        return new Interval(startRes, endRes);
    }

    private static int findEnd(List<Interval> intervals,
                              Interval interval) {
        int end = 0;

        while (end < intervals.size()
                && intervals.get(end).getLeft() < interval.getRight()) {
            end++;
        }

        return end;
    }
}
