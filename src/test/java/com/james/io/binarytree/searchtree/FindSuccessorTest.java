package com.james.io.binarytree.searchtree;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindSuccessorTest {

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
    public void getSuccessorRightSkewed() {
        ONE.right = TWO;
        TWO.right = THREE;
        THREE.right = FOUR;

        BinaryTreeNode successor = FindSuccessor.getSuccessor(ONE, TWO.value);
        assertEquals(3, successor.value);
    }

    @Test
    public void getSuccessor() {
        THREE.right = FOUR;
        THREE.left = TWO;
        TWO.left = ONE;

        BinaryTreeNode successor = FindSuccessor.getSuccessor(THREE, ONE.value);
        assertEquals(2, successor.value);
    }

    @Test
    public void getSuccessorNotExists() {
        THREE.right = FOUR;
        THREE.left = TWO;
        TWO.left = ONE;

        assertNull(FindSuccessor.getSuccessor(THREE, 5));
    }

    @Test
    public void getSuccessorEmptyTree() {
        assertNull(FindSuccessor.getSuccessor(null, 5));
    }
}