package com.james.io.binarytree.searchtree;

import com.james.io.binarytree.model.BinaryTreeNode;

/**
 * Variant of 10.2 in EPI
 *
 * Time: O(h), h = height of the tree O(1) space
 */
public class FindMatchingNode {

  public static BinaryTreeNode findFirstMatching(BinaryTreeNode root, int k) {
    while (root != null) {
      if (root.value == k) {
        return root;
      } else if (root.value < k) {
        root = root.right;
      } else {
        root = root.left;
      }
    }

    return null;
  }
}
