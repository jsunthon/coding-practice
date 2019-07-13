package com.james.io.binarytree;

/**
 * 10.2 of EPI
 */
public class SymmetricTree {

  static class BinaryTreeNode {

    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int value) {
      this(value, null, null);
    }

    BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  public static boolean isSymmetric(BinaryTreeNode root) {
    if (root == null) {
      return true;
    }

    return isSymmetric(root.left, root.right);
  }

  private static boolean isSymmetric(BinaryTreeNode left,
      BinaryTreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left != null && right != null) {
      return left.value == right.value
          && isSymmetric(left.left, right.right)
          && isSymmetric(left.right, right.left);
    }

    return false;
  }
}
