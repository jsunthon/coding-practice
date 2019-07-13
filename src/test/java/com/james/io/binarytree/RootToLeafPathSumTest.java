package com.james.io.binarytree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

public class RootToLeafPathSumTest {

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
  public void hasPathSumWithSingletonTreeTrue() {
    assertTrue(RootToLeafPathSum.hasPathSum(ONE, 1));
  }

  @Test
  public void hasPathSumWithSingletonTreeFalse() {
    assertFalse(RootToLeafPathSum.hasPathSum(ONE, 3));
  }

  @Test
  public void hasPathSumWithTreeTrue() {
    ONE.left = TWO;
    ONE.right = THREE;
    TWO.left = FOUR;
    assertTrue(RootToLeafPathSum.hasPathSum(ONE, 7));
  }

  @Test
  public void hasPathSumWithTreeFalse() {
    ONE.left = TWO;
    ONE.right = THREE;
    TWO.left = FOUR;
    assertFalse(RootToLeafPathSum.hasPathSum(ONE, 9));
  }
}