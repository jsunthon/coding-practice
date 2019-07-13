package com.james.io.binarytree;

/**
 * 10.9 of EPI
 *
 * O(h) time complexity, where h is the height of three O(1) space complexity
 */
public class KthNodeInorder {

  public static class TreeSizeAwareBinaryTreeNode {

    private int size = 1;
    public final int value;
    private TreeSizeAwareBinaryTreeNode left;
    private TreeSizeAwareBinaryTreeNode right;

    public TreeSizeAwareBinaryTreeNode(int value) {
      this.value = value;
    }

    public void setLeft(TreeSizeAwareBinaryTreeNode node) {
      size += node.size;
      this.left = node;
    }

    public void setRight(TreeSizeAwareBinaryTreeNode node) {
      size += node.size;
      this.right = node;
    }
  }

  public static TreeSizeAwareBinaryTreeNode getKthNodeInOrder(
      TreeSizeAwareBinaryTreeNode root, int k) {
    TreeSizeAwareBinaryTreeNode curr = root;

    int leftSize;
    while (curr != null) {
      leftSize = curr.left != null ? curr.left.size : 0;

      if (leftSize + 1 < k) {
        // go right
        curr = curr.right;
        k -= (leftSize + 1);
      } else if (leftSize + 1 == k) {
        return curr;
      } else {
        curr = curr.left;
      }
    }

    return null;
  }
}
