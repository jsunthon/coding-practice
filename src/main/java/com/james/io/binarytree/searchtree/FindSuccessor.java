package com.james.io.binarytree.searchtree;

import com.james.io.binarytree.model.BinaryTreeNode;

/**
 * 10.2 of EPI
 *
 * O(log n) time, O(1) space
 */
public class FindSuccessor {

  public static BinaryTreeNode getSuccessor(BinaryTreeNode root, int k) {
    BinaryTreeNode successor = null;
    while (root != null) {
      if (root.value > k) {
        successor = root;
        root = root.left;
      } else {
        root = root.right;
      }
    }

    return successor;
  }
}
