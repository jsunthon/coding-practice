package com.james.io.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 11.7 of EPI
 *
 * O(log n) for push and pop operations, O(1) space
 *
 *
 * O(n log n) for n total operations, O(n) space
 *
 */
public class HeapBasedStack {

    private static final int INIT_CAPACITY = 16;

    private static class HeapValue implements Comparable<HeapValue> {
        int value;
        int position;

        HeapValue(int value, int position) {
            this.value = value;
            this.position = position;
        }

        @Override
        public int compareTo(HeapValue other) {
            return position - other.position;
        }
    }

    private final Queue<HeapValue> maxHeap;

    public HeapBasedStack() {
        maxHeap = new PriorityQueue<>(INIT_CAPACITY, Collections.reverseOrder());
    }

    public void push(int value) {
        maxHeap.offer(new HeapValue(value, maxHeap.size()));
    }

    public int pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Stack is empty");
        }
        return maxHeap.remove().value;
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public int size() {
        return maxHeap.size();
    }

}
