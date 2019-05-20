package com.james.io.stackandqueue;

import org.junit.Assert;
import org.junit.Test;

public class MaxStackTest {

    @Test
    public void testMaxStackGetMax() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(100);
        maxStack.push(1000);
        Assert.assertEquals(1000, maxStack.getMax());
    }

    @Test
    public void testMaxStackPop() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(100);
        maxStack.push(1000);
        Assert.assertEquals(1000, maxStack.pop());
    }


    @Test
    public void testMaxStackPopMax() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(3);
        maxStack.push(4);
        maxStack.push(1);
        maxStack.push(100);
        Assert.assertEquals(100, maxStack.getMax());
        Assert.assertEquals(100, maxStack.pop());
        Assert.assertEquals(4, maxStack.getMax());
    }
}
