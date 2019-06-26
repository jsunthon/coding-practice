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
}
