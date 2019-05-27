package com.james.io.stackandqueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackedQueueTest {

    @Test
    public void testQueue() {
        StackedQueue<Integer> queue = new StackedQueue<>();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(5);

        assertEquals(Integer.valueOf(2), queue.dequeue());
    }

    @Test
    public void testQueueIsEmpty() {
        StackedQueue<Integer> queue = new StackedQueue<>();

        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueSize() {
        StackedQueue<Integer> queue = new StackedQueue<>();

        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(2, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testQueueUnderflow() {
        StackedQueue<Integer> queue = new StackedQueue<>();

        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
