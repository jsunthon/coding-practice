package com.james.io.binarytree;

import com.james.io.binarytree.model.BinaryTreeNode;

/**
 * 10.6 of EPI, brute force
 *
 * O(n) time, O(h) space, where n = # of nodes and h is the height of the tree
 */
public class RootToLeafPathSum {

    public static boolean hasPathSum(BinaryTreeNode binaryTreeNode, int pathSum) {
        return hasPathSum(binaryTreeNode, pathSum, 0);
    }

    private static boolean hasPathSum(BinaryTreeNode node, int pathSum, int partialPathSum) {
        if (node != null) {
            partialPathSum += node.value;

            if (node.left != null || node.right != null) {
                return hasPathSum(node.left, pathSum, partialPathSum)
                        || hasPathSum(node.right, pathSum, partialPathSum);
            }
        }

        return partialPathSum == pathSum;
    }
}
