package com.james.io.binarytree.searchtree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

public class BstPropertyTest {

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
  public void isBstSingleton() {
    assertTrue(BstProperty.isBst(ONE));
  }

  @Test
  public void isBstLeftSkewed() {
    THREE.left = TWO;
    TWO.left = ONE;
    assertTrue(BstProperty.isBst(THREE));
  }

  @Test
  public void isBestLeftSkewedNotBst() {
    ONE.left = TWO;
    TWO.left = THREE;
    assertFalse(BstProperty.isBst(ONE));
  }

  @Test
  public void isBstNormalTree() {
    THREE.left = TWO;
    THREE.right = FOUR;
    TWO.left = ONE;
    assertTrue(BstProperty.isBst(THREE));
  }

  @Test
  public void isBstNormalTreeNotBstLowerNodeInvalid() {
    THREE.left = TWO;
    THREE.right = FOUR;
    TWO.right = ONE;
    assertFalse(BstProperty.isBst(THREE));
  }
}