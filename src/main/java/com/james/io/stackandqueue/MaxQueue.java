package com.james.io.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution to 9.10 EPI
 *
 * over N enqueues and dequeues, the amortized time complexity is O(n)
 */
public class MaxQueue {
    private final Queue<Integer> queue;
    private final Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public void enqueue(Integer val) {
        queue.add(val);
        purgeDeque(val);
    }

    public Integer dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty queue");
        }
        Integer res = queue.remove();
        if (res.equals(deque.peekFirst())) {
            deque.removeFirst();
        }
        return res;
    }

    public Integer max() {
        return deque.peekFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    private void purgeDeque(Integer val) {
        while (!deque.isEmpty() && deque.peekLast() < val) {
            deque.removeLast();
        }
        deque.addLast(val);
    }
}
