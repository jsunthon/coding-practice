package com.james.io.binarytree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.james.io.binarytree.SymmetricTree.BinaryTreeNode;
import org.junit.Test;

public class SymmetricTreeTest {

  @Test
  public void isSymmetricEmpty() {
    assertTrue(SymmetricTree.isSymmetric(null));
  }

  @Test
  public void isSymmetricRootOnly() {
    BinaryTreeNode root = new BinaryTreeNode(314);

    assertTrue(SymmetricTree.isSymmetric(root));
  }

  @Test
  public void isSymmetricLeftSkew() {
    BinaryTreeNode root = new BinaryTreeNode(314);

    root.left = new BinaryTreeNode(300);

    assertFalse(SymmetricTree.isSymmetric(root));
  }

  @Test
  public void isSymmetricRightSkew() {
    BinaryTreeNode root = new BinaryTreeNode(314);

    root.right = new BinaryTreeNode(300);

    assertFalse(SymmetricTree.isSymmetric(root));
  }

  @Test
  public void isSymmetricStructural() {
    BinaryTreeNode root = new BinaryTreeNode(314);

    root.left = new BinaryTreeNode(299);
    root.right = new BinaryTreeNode(300);

    assertFalse(SymmetricTree.isSymmetric(root));
  }

  @Test
  public void isSymmetric() {
    BinaryTreeNode root = new BinaryTreeNode(314);

    root.left = new BinaryTreeNode(299);
    root.right = new BinaryTreeNode(299);

    assertTrue(SymmetricTree.isSymmetric(root));
  }

  @Test
  public void isSymmetricLowerLevelsNot() {
    BinaryTreeNode root = new BinaryTreeNode(314);

    BinaryTreeNode leftOfLeft = new BinaryTreeNode(1);
    BinaryTreeNode rightOfLeft = new BinaryTreeNode(2);

    root.left = new BinaryTreeNode(299, leftOfLeft, rightOfLeft);

    BinaryTreeNode leftOfRight = new BinaryTreeNode(1);
    BinaryTreeNode rightOfRight = new BinaryTreeNode(1);

    root.right = new BinaryTreeNode(299, leftOfRight, rightOfRight);

    assertFalse(SymmetricTree.isSymmetric(root));
  }

  @Test
  public void isSymmetricLowerLevels() {
    BinaryTreeNode root = new BinaryTreeNode(314);

    BinaryTreeNode leftOfLeft = new BinaryTreeNode(3);
    BinaryTreeNode rightOfLeft = new BinaryTreeNode(2);

    root.left = new BinaryTreeNode(299, leftOfLeft, rightOfLeft);

    BinaryTreeNode leftOfRight = new BinaryTreeNode(2);
    BinaryTreeNode rightOfRight = new BinaryTreeNode(3);

    root.right = new BinaryTreeNode(299, leftOfRight, rightOfRight);

    assertTrue(SymmetricTree.isSymmetric(root));
  }
}