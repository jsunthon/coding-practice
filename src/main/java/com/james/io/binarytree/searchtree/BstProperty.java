package com.james.io.binarytree.searchtree;

import com.james.io.binarytree.model.BinaryTreeNode;

/**
 * 15.1 of EPI.
 *
 */
public class BstProperty {

    // O(n) time, O(h) space, where n = # of nodes and h = height of tree
    public static boolean isBst(BinaryTreeNode root) {
        if (root != null) {
            boolean isLeftSatisfied = root.left == null || root.left.value <= root.value;
            boolean isRightSatisfied = root.right == null || root.right.value >= root.value;

            return isLeftSatisfied
                    && isRightSatisfied
                    && isBst(root.left)
                    && isBst(root.right);
        }

        return true;
    }
}
