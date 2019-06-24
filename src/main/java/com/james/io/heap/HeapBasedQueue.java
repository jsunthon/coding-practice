package com.james.io.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Variant of 11.7 of EPI
 */
public class HeapBasedQueue {

    private static class HeapValue implements Comparable<HeapValue> {
        int value;
        int position;

        HeapValue(int value, int position) {
            this.value = value;
            this.position = position;
        }

        @Override
        public int compareTo(HeapValue other) {
            return value - other.value;
        }
    }

    private static final int DEF_CAP = 16;

    private final Queue<HeapValue> minHeap;

    public HeapBasedQueue() {
        minHeap = new PriorityQueue<>(DEF_CAP);
    }

    public void add(int value) {
        minHeap.add(new HeapValue(value, minHeap.size()));
    }

    public int remove() {
        return minHeap.remove().value;
    }

    public int peek() {
        return minHeap.peek().value;
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}
