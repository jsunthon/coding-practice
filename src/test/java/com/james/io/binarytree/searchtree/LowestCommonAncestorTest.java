package com.james.io.binarytree.searchtree;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {

    private BinaryTreeNode ONE;
    private BinaryTreeNode TWO;
    private BinaryTreeNode THREE;
    private BinaryTreeNode FOUR;
    private BinaryTreeNode FIVE;

    @Before
    public void setUp() {
        ONE = new BinaryTreeNode(1);
        TWO = new BinaryTreeNode(2);
        THREE = new BinaryTreeNode(3);
        FOUR = new BinaryTreeNode(4);
        FIVE = new BinaryTreeNode(5);

        TWO.left = ONE;
        TWO.right = FOUR;
        FOUR.left = THREE;
        FOUR.right = FIVE;
    }

    @Test
    public void getLca() {
        assertEquals(FOUR, LowestCommonAncestor.getLca(TWO, THREE, FIVE));
    }

    @Test
    public void getLcaEpi() {
        assertEquals(FOUR, LowestCommonAncestor.getLcaEpi(TWO, THREE, FIVE));
    }
}