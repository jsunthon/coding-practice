package com.james.io.binarytree.searchtree;

import com.james.io.binarytree.model.BinaryTreeNode;

/**
 * 10.4 of EPI
 */
public class LowestCommonAncestor {

    public static BinaryTreeNode getLca(BinaryTreeNode root,
                                        BinaryTreeNode node0,
                                        BinaryTreeNode node1) {
        // assume that node0 < node1
        if (node0.value >= node1.value) {
            throw new IllegalArgumentException("node0 must be less than node1");
        }

        while (root != null) {
            if (root.value >= node0.value && root.value <= node1.value) {
                return root;
            } else if (root.value <= node0.value) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return root;
    }

    public static BinaryTreeNode getLcaEpi(BinaryTreeNode root,
                                           BinaryTreeNode node0,
                                           BinaryTreeNode node1) {
        BinaryTreeNode curr = root;

        while (curr.value < node0.value || curr.value > node1.value) {
            while (curr.value < node0.value) {
                curr = curr.right;
            }

            while (curr.value > node1.value) {
                curr = curr.left;
            }
        }

        return curr;
    }
}
