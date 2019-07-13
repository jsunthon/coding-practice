package com.james.io.binarytree;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IterativePreorderTest {


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
    public void preorder() {
        ONE.left = TWO;
        TWO.right = FOUR;
        ONE.right = THREE;
        List<Integer> expectedRes = Arrays.asList(1, 2, 4, 3);

        assertEquals(expectedRes, IterativePreorder.preorder(ONE));
    }

    @Test
    public void preorderSingleton() {
        List<Integer> expectedRes = Collections.singletonList(1);

        assertEquals(expectedRes, IterativePreorder.preorder(ONE));
    }

    @Test
    public void preorderLeftSkewed() {
        ONE.left = TWO;
        TWO.left = THREE;
        THREE.left = FOUR;

        List<Integer> expectedRes = Arrays.asList(1, 2, 3, 4);

        assertEquals(expectedRes, IterativePreorder.preorder(ONE));
    }

    @Test
    public void preorderRightSkewed() {
        ONE.right = TWO;
        TWO.right = THREE;
        THREE.right = FOUR;

        List<Integer> expectedRes = Arrays.asList(1, 2, 3, 4);

        assertEquals(expectedRes, IterativePreorder.preorder(ONE));
    }

    @Test
    public void preorderEmpty() {
        assertEquals(Collections.emptyList(), IterativePreorder.preorder(null));
    }
}