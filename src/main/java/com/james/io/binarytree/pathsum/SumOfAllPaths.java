package com.james.io.binarytree.pathsum;

import com.james.io.binarytree.model.BinaryTreeNode;

// a personal, useful variant
public class SumOfAllPaths {

    public int sumPath(BinaryTreeNode node) {
        return sumAllPathsHelper(node, 0);
    }

    private int sumAllPathsHelper(BinaryTreeNode node, int partialPathSum) {
        if (node == null) {
            return partialPathSum;
        }

        partialPathSum += node.value;

        if (node.left != null) {
            partialPathSum = sumAllPathsHelper(node.left, partialPathSum);
        }

        if (node.right != null) {
            partialPathSum = sumAllPathsHelper(node.right, partialPathSum);
        }

        return partialPathSum;
    }
}
