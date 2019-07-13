package com.james.io.binarytree.pathsum;

import static org.junit.Assert.assertEquals;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

public class SumOfAllBinaryNumberPathsTest {

  private BinaryTreeNode ONE;
  private BinaryTreeNode TWO;
  private BinaryTreeNode THREE;
  private BinaryTreeNode FOUR;

  @Before
  public void setUp() {
    ONE = new BinaryTreeNode(1);
    TWO = new BinaryTreeNode(1);
    THREE = new BinaryTreeNode(0);
  }

  @Test
  public void sumPath() {
    ONE.left = TWO;
    ONE.right = THREE;

    assertEquals(5, new SumOfAllBinaryNumberPaths().sumPath(ONE));
  }

  @Test
  public void sumPathRightSkew() {
    ONE.right = THREE;

    assertEquals(2, new SumOfAllBinaryNumberPaths().sumPath(ONE));
  }

  @Test
  public void sumPathLeftSkew() {
    ONE.right = THREE;
    THREE.right = TWO;

    assertEquals(5, new SumOfAllBinaryNumberPaths().sumPath(ONE));
  }
}