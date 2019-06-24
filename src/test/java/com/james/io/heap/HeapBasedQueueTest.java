package com.james.io.heap;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class HeapBasedQueueTest {

    @Test
    public void testQueueOk() {
        HeapBasedQueue stack = new HeapBasedQueue();

        stack.add(3);
        stack.add(4);
        stack.add(5);

        assertEquals(3, stack.remove());
        assertEquals(4, stack.remove());
        assertEquals(5, stack.remove());
    }

    @Test
    public void testQueueOneElement() {
        HeapBasedQueue stack = new HeapBasedQueue();

        stack.add(3);

        assertEquals(3, stack.remove());
    }

    @Test(expected = NoSuchElementException.class)
    public void testQueueEmpty() {
        HeapBasedQueue stack = new HeapBasedQueue();

        stack.remove();
    }

    @Test
    public void testQueueIsEmptyTrue() {
        HeapBasedQueue stack = new HeapBasedQueue();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testQueueIsEmptyFalse() {
        HeapBasedQueue stack = new HeapBasedQueue();

        stack.add(5);

        assertFalse(stack.isEmpty());
    }

}