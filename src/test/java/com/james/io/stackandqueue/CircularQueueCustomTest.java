package com.james.io.stackandqueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CircularQueueCustomTest {

    @Test
    public void testQueue() {
        CircularQueueCustom circularQueueCustom = new CircularQueueCustom(5);

        circularQueueCustom.enqueue(2);
        circularQueueCustom.enqueue(3);
        circularQueueCustom.enqueue(5);

        assertEquals(Integer.valueOf(2), circularQueueCustom.dequeue());
    }

    @Test
    public void testQueueResize() {
        CircularQueueCustom circularQueueCustom = new CircularQueueCustom(5);

        circularQueueCustom.enqueue(2);
        circularQueueCustom.enqueue(3);
        circularQueueCustom.enqueue(5);
        circularQueueCustom.enqueue(10);

        assertEquals(Integer.valueOf(2), circularQueueCustom.dequeue());
    }

    @Test
    public void testQueueGetSize() {
        CircularQueueCustom circularQueueCustom = new CircularQueueCustom(5);

        circularQueueCustom.enqueue(2);
        circularQueueCustom.enqueue(3);
        circularQueueCustom.enqueue(5);
        circularQueueCustom.enqueue(10);

        assertEquals(Integer.valueOf(4), circularQueueCustom.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testQueueUnderflow() {
        CircularQueueCustom circularQueueCustom = new CircularQueueCustom(2);

        circularQueueCustom.enqueue(2);
        circularQueueCustom.enqueue(3);
        circularQueueCustom.dequeue();
        circularQueueCustom.dequeue();
        circularQueueCustom.dequeue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQueueInvalidCapacityZero() {
        new CircularQueueCustom(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQueueInvalidCapacityNegative() {
        new CircularQueueCustom(-1);
    }

    @Test()
    public void testQueueEmpty() {
        CircularQueueCustom circularQueueCustom = new CircularQueueCustom(2);

        circularQueueCustom.enqueue(2);
        circularQueueCustom.enqueue(3);
        circularQueueCustom.dequeue();
        circularQueueCustom.dequeue();
        assertTrue(circularQueueCustom.isEmpty());
    }

    @Test
    public void testQueueRepeatedAddAndRemoval() {
        CircularQueueCustom circularQueueCustom = new CircularQueueCustom(2);

        circularQueueCustom.enqueue(2);
        assertEquals(Integer.valueOf(2), circularQueueCustom.dequeue());
        circularQueueCustom.enqueue(3);
        assertEquals(Integer.valueOf(3), circularQueueCustom.dequeue());
        assertTrue(circularQueueCustom.isEmpty());
    }
}
