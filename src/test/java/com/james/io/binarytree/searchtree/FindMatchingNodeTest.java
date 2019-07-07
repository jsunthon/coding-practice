package com.james.io.binarytree.searchtree;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindMatchingNodeTest {

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
    public void findFirstMatchingWithDuplicates() {
        TWO.left = ONE;
        TWO.right = THREE;
        THREE.right = FOUR;

        BinaryTreeNode duplicateFour = new BinaryTreeNode(4);
        FOUR.right = duplicateFour;

        BinaryTreeNode matchingNode = FindMatchingNode.findFirstMatching(TWO, FOUR.value);

        assertNotEquals(duplicateFour, matchingNode);
        assertEquals(FOUR, matchingNode);
    }

    @Test
    public void findFirstMatchingNotExists() {
        TWO.left = ONE;
        TWO.right = THREE;
        THREE.right = FOUR;

        BinaryTreeNode matchingNode = FindMatchingNode.findFirstMatching(TWO, 5);

        assertNull(matchingNode);
    }

    @Test
    public void findFirstMatchingEmptyTree() {
        assertNull(FindMatchingNode.findFirstMatching(null, 5));
    }
}