package com.james.io.binarytree.pathsum;

import com.james.io.binarytree.model.BinaryTreeNode;

/**
 * 10.5 of EPI
 */
public class SumOfAllBinaryNumberPaths implements PathSummable {

  public int sumPath(BinaryTreeNode node) {
    return sumAllPathsHelper(node, 0);
  }

  private int sumAllPathsHelper(BinaryTreeNode node, int partialPathSum) {
    if (node == null) {
      return 0;
    }

    partialPathSum = partialPathSum * 2 + node.value;

    if (node.left == null && node.right == null) {
      return partialPathSum;
    }

    return sumAllPathsHelper(node.left, partialPathSum) +
        sumAllPathsHelper(node.right, partialPathSum);
  }
}
