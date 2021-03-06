package com.james.io.binarytree;

import static org.junit.Assert.assertEquals;

import com.james.io.binarytree.model.BinaryTreeNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class IterativeInOrderTest {

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
  public void inorder() {
    ONE.left = TWO;
    ONE.right = THREE;
    TWO.right = FOUR;

    List<Integer> expectedRes = Arrays.asList(2, 4, 1, 3);

    assertEquals(expectedRes, IterativeInOrder.inorder(ONE));
  }

  @Test
  public void inorderSingleton() {
    List<Integer> expectedRes = Collections.singletonList(1);

    assertEquals(expectedRes, IterativeInOrder.inorder(ONE));
  }

  @Test
  public void inorderLeftSkewed() {
    ONE.left = TWO;
    TWO.left = THREE;
    THREE.left = FOUR;

    List<Integer> expectedRes = Arrays.asList(4, 3, 2, 1);

    assertEquals(expectedRes, IterativeInOrder.inorder(ONE));
  }

  @Test
  public void inorderRightSkewed() {
    ONE.right = TWO;
    TWO.right = THREE;
    THREE.right = FOUR;

    List<Integer> expectedRes = Arrays.asList(1, 2, 3, 4);

    assertEquals(expectedRes, IterativeInOrder.inorder(ONE));
  }

  @Test
  public void inorderEmpty() {
    assertEquals(Collections.emptyList(), IterativeInOrder.inorder(null));
  }
}