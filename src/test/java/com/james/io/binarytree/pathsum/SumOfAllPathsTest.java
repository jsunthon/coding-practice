package com.james.io.binarytree.pathsum;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfAllPathsTest {

    private BinaryTreeNode ONE;
    private BinaryTreeNode TWO;
    private BinaryTreeNode THREE;
    private BinaryTreeNode FOUR;

    @Before
    public void setUp() {
        ONE = new BinaryTreeNode(1);
        TWO = new BinaryTreeNode(2);
        THREE = new BinaryTreeNode(3);
        FOUR = new BinaryTreeNode(4);
    }

    @Test
    public void sumPath() {
        ONE.left = TWO;
        ONE.right = THREE;

        Assert.assertEquals(6, new SumOfAllPaths().sumPath(ONE));
    }

    @Test
    public void sumPathSingleton() {
        Assert.assertEquals(1, new SumOfAllPaths().sumPath(ONE));
    }
}