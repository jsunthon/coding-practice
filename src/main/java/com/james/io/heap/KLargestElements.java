package com.james.io.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 11.6
 */
public class KLargestElements {

    // my solution
    // O(n log k) time, O(k) space
    public static List<Integer> kLargest(List<Integer> maxHeap,
                                         int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k must be greater than or equal to 1");
        }

        Queue<Integer> minHeap = new PriorityQueue<>(k);

        for (Integer i : maxHeap) {
            if (minHeap.size() < k) {
                minHeap.add(i);
            } else if (minHeap.peek() < i) {
                minHeap.remove();
                minHeap.add(i);
            }
        }

        return new ArrayList<>(minHeap);
    }
}
