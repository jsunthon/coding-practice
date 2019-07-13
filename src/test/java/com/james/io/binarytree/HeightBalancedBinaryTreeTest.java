package com.james.io.binarytree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.james.io.binarytree.HeightBalancedBinaryTree.TreeNode;
import org.junit.Test;

public class HeightBalancedBinaryTreeTest {

  @Test
  public void testIsHeightBalancedSimple() {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);

    TreeNode node0 = new TreeNode(0, node1, node2);

    HeightBalancedBinaryTree tree = new HeightBalancedBinaryTree();

    assertTrue(tree.isHeightBalanced(node0));
  }

  @Test
  public void testIsHeightBalancedLeftSkewedNoBalance() {
    TreeNode node2 = new TreeNode(2);

    TreeNode node1 = new TreeNode(1, node2, null);

    TreeNode node0 = new TreeNode(0, node1, null);

    HeightBalancedBinaryTree tree = new HeightBalancedBinaryTree();

    assertFalse(tree.isHeightBalanced(node0));
  }

  @Test
  public void testIsHeightBalancedRightSkewedNoBalance() {
    TreeNode node2 = new TreeNode(2);

    TreeNode node1 = new TreeNode(1, null, node2);

    TreeNode node0 = new TreeNode(0, null, node1);

    HeightBalancedBinaryTree tree = new HeightBalancedBinaryTree();

    assertFalse(tree.isHeightBalanced(node0));
  }


  @Test
  public void testIsHeightBalancedEpiSimple() {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);

    TreeNode node0 = new TreeNode(0, node1, node2);

    HeightBalancedBinaryTree tree = new HeightBalancedBinaryTree();

    assertTrue(HeightBalancedBinaryTree.isHeightBalancedEpi(node0));
  }

  @Test
  public void testIsHeightBalancedEpiLeftSkewedNoBalance() {
    TreeNode node2 = new TreeNode(2);

    TreeNode node1 = new TreeNode(1, node2, null);

    TreeNode node0 = new TreeNode(0, node1, null);

    assertFalse(HeightBalancedBinaryTree.isHeightBalancedEpi(node0));
  }

  @Test
  public void testIsHeightBalancedEpiRightSkewedNoBalance() {
    TreeNode node2 = new TreeNode(2);

    TreeNode node1 = new TreeNode(1, null, node2);

    TreeNode node0 = new TreeNode(0, null, node1);

    assertFalse(HeightBalancedBinaryTree.isHeightBalancedEpi(node0));
  }

}