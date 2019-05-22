package com.james.io.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * More optional than the 'MaxStack.java',
 * because the space complexity is O(1) in the best case,
 * though still O(n) in worse case
 */
public class MaxStackOptimalEpi implements EpiStack, MaxCollection {

    private static class MaxWithCount {
        private Integer max;
        private Integer count;

        private MaxWithCount(Integer max, Integer count) {
            this.max = max;
            this.count = count;
        }
    }

    private final Deque<Integer> elements;
    private final Deque<MaxWithCount> maxWithCounts;

    public MaxStackOptimalEpi() {
        elements = new LinkedList<>();
        maxWithCounts = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void push(Integer val) {
        elements.addFirst(val);

        if (maxWithCounts.isEmpty() || val.compareTo(maxWithCounts.peekFirst().max) > 0) {
            maxWithCounts.addFirst(new MaxWithCount(val, 1));
        } else if (val.compareTo(maxWithCounts.peekFirst().max) == 0) {
            maxWithCounts.peekFirst().count++;
        }
    }

    @Override
    public Integer pop() {
        if (isEmpty()) {
            throw new IllegalStateException("pop(): empty stack");
        }

        Integer topEle = elements.removeFirst();

        if (!maxWithCounts.isEmpty()) {
            MaxWithCount topMax = maxWithCounts.peekFirst();
            if (topEle.compareTo(topMax.max) == 0) {
                topMax.count--;
                if (topMax.count == 0) {
                    maxWithCounts.removeFirst();
                }
            }
        }

        return topEle;
    }

    @Override
    public Integer getMax() {
        if (maxWithCounts.isEmpty()) {
            throw new IllegalStateException("max(): empty stack");
        }

        return maxWithCounts.peekFirst().max;
    }
}
