package com.james.io.binarytree;

import com.james.io.binarytree.model.BinaryTreeNode;

/**
 * 10.3 of EPI
 *
 *  O(n) time, O(h) space, where n = # of nodes, h = height of tree
 */
public class LowestCommonAncestor {

    private static class Status {
        public int numOfTargetNodes;
        public BinaryTreeNode ancestor;

        public Status(int numOfTargetNodes, BinaryTreeNode ancestor) {
            this.numOfTargetNodes = numOfTargetNodes;
            this.ancestor = ancestor;
        }
    }

    public static BinaryTreeNode getLca(BinaryTreeNode root,
                                        BinaryTreeNode node0,
                                        BinaryTreeNode node1) {
        return lcaHelper(root, node0, node1).ancestor;
    }

    private static Status lcaHelper(BinaryTreeNode root,
                                    BinaryTreeNode node0,
                                    BinaryTreeNode node1) {
        if (root == null) {
            return new Status(0, null);
        }

        Status leftStatus = lcaHelper(root.left, node0, node1);
        if (leftStatus.numOfTargetNodes == 2) {
            return leftStatus;
        }

        Status rightStatus = lcaHelper(root.right, node0, node1);
        if (rightStatus.numOfTargetNodes == 2) {
            return rightStatus;
        }

        int numOfTargetNodes = leftStatus.numOfTargetNodes + rightStatus.numOfTargetNodes
                            + (root == node0 ? 1 : 0) + (root == node1 ? 1 : 0);
        return new Status(numOfTargetNodes, numOfTargetNodes == 2 ? root : null);
    }
}
