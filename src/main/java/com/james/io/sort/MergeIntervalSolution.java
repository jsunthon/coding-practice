package com.james.io.sort;

import com.james.io.model.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution to problem 14.5 of EPI
 */
public class MergeIntervalSolution {

    /**
     * Add interval to disjoint intervals to get merged interval.
     * <p>
     * EPI solution
     *
     * @param disjointIntervals
     * @param newInterval
     * @return
     */
    public static List<Interval> addInterval(List<Interval> disjointIntervals,
                                             Interval newInterval) {
        final List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;

        // step 1
        while (i < disjointIntervals.size()
                && disjointIntervals.get(i).getRight() < newInterval.getLeft()) {
            mergedIntervals.add(disjointIntervals.get(i++));
        }

        // step 2
        while (i < disjointIntervals.size()
                && disjointIntervals.get(i).getLeft() < newInterval.getRight()) {
            newInterval = new Interval(Math.min(disjointIntervals.get(i).getLeft(), newInterval.getLeft()),
                    Math.max(disjointIntervals.get(i).getRight(), newInterval.getRight()));
            i++;
        }
        mergedIntervals.add(newInterval);

        // step 3
        mergedIntervals.addAll(disjointIntervals.subList(i, disjointIntervals.size()));

        return mergedIntervals;
    }

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
