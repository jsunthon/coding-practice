package com.james.io.heap;

import java.util.*;

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

        final Queue<Integer> minHeap = new PriorityQueue<>(k);

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


    // from here on out, is the EPI solutionk
    private static class HeapValue implements Comparable<HeapValue> {
        int value;
        int index;

        HeapValue(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(HeapValue other) {
            return Integer.compare(value, other.value);
        }
    }

    // EPI solution using O(k lg k) time, O(k) space
    public static List<Integer> kLargestEpi(List<Integer> list,
                                            int k) {
        if (k <=0 ) {
            throw new IllegalArgumentException("k must be greater than or equal to 1");
        }

        final List<Integer> result = new ArrayList<>();
        final Queue<HeapValue> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        maxHeap.add(new HeapValue(list.get(0), 0));

        HeapValue heapValue;
        int leftIndex;
        int rightIndex;

        int i = 0;
        while (i++ < k) {
            heapValue = maxHeap.remove();
            result.add(heapValue.value);

            leftIndex = 2 * heapValue.index + 1;
            if (leftIndex < list.size()) {
                maxHeap.add(new HeapValue(list.get(leftIndex), leftIndex));
            }

            rightIndex = 2 * heapValue.index + 2;
            if (rightIndex < list.size()) {
                maxHeap.add(new HeapValue(list.get(rightIndex), rightIndex));
            }
        }

        return result;
    }
}
