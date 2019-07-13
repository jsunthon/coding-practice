package com.james.io.binarytree;

/**
 * 10.1 of EPI
 */
public class HeightBalancedBinaryTree {

  private int heightDiff = 0;

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this(val, null, null);
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  static class BalancedStatusWithHeight {

    int height;
    boolean isBalanced;

    BalancedStatusWithHeight(int height, boolean isBalanced) {
      this.height = height;
      this.isBalanced = isBalanced;
    }
  }

  public boolean isHeightBalanced(TreeNode root) {
    postorder(root, 0);

    return heightDiff <= 1;
  }

  private int postorder(TreeNode node, int depth) {
    if (heightDiff <= 1 && node != null) {
      int heightLeft = postorder(node.left, depth + 1);
      int heightRight = postorder(node.right, depth + 1);

      heightDiff = Math.max(heightDiff, Math.abs(heightRight - heightLeft));

      return Math.max(heightRight, heightLeft) + depth;
    }

    return 0;
  }

  public static boolean isHeightBalancedEpi(TreeNode root) {
    return checkBalanced(root).isBalanced;
  }

  private static BalancedStatusWithHeight checkBalanced(TreeNode root) {
    if (root == null) {
      return new BalancedStatusWithHeight(-1, true);
    }

    BalancedStatusWithHeight leftStatus = checkBalanced(root.left);
    if (!leftStatus.isBalanced) {
      return leftStatus;
    }

    BalancedStatusWithHeight rightStatus = checkBalanced(root.right);
    if (!rightStatus.isBalanced) {
      return rightStatus;
    }

    int height = Math.max(leftStatus.height, rightStatus.height) + 1;
    int heightDiff = Math.abs(leftStatus.height - rightStatus.height);

    return new BalancedStatusWithHeight(height, heightDiff <= 1);
  }
}
