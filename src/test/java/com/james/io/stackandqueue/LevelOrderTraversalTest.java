package com.james.io.stackandqueue;

import com.james.io.stackandqueue.LevelOrderTraversal.BinaryTreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LevelOrderTraversalTest {

    @Test
    public void testTraversalOriginalInput() {
        BinaryTreeNode n314 = new BinaryTreeNode(314);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);

        n314.left = n6;
        n314.right = n7;

        List<List<Integer>> res = LevelOrderTraversal.traverse(n314);

        List<List<Integer>> expected = Arrays.asList(Collections.singletonList(314), Arrays.asList(6, 7));

        assertEquals(expected, res);
    }
}
