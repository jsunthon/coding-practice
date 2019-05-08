package com.james.io.search;

import com.james.io.search.model.MinMax;

import java.util.List;

/**
 * Solution to problem 12.7 of EPI
 */
public class SimultaneousMinMaxSearchSolution {

    /**
     * Searches an unordered, duplicate containing list for the minimal
     * and maximal element in O(n) time and O(1) space using at most
     * 3n/2 - 2 comparisons (n/2 to divide, and n/2-1 to find min and max
     * respectively
     *
     * @param list
     * @return
     */
    public static MinMax searchMinMax(List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Cannot search for min and max element in an empty list");
        }

        if (list.size() == 1) {
            return new MinMax(list.get(0), list.get(0));
        }

        MinMax globalMinMax = MinMax.getInstance(list.get(0), list.get(1));
        MinMax localMinMax;

        for (int i = 2; i < list.size() - 1; i += 2) {
            localMinMax = MinMax.getInstance(list.get(i), list.get(i + 1));
            globalMinMax = new MinMax(Math.min(globalMinMax.getMin(), localMinMax.getMin()),
                    Math.max(globalMinMax.getMax(), localMinMax.getMax()));
        }

        if (list.size() % 2 != 0) {
            globalMinMax = new MinMax(Math.min(globalMinMax.getMin(), list.get(list.size() - 1)),
                    Math.max(globalMinMax.getMax(), list.get(list.size() - 1)));
        }

        return globalMinMax;
    }
}
