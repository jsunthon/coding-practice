package com.james.io.binarytree;

/**
 * EPI 10.4
 */
public class LowestCommonAncestorWithParent {

    static class BinaryTreeNode {
        public char value;
        public BinaryTreeNode parent;

        public BinaryTreeNode(char value) {
            this(value, null);
        }

        public BinaryTreeNode(char value, BinaryTreeNode parent) {
            this.value = value;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "{" + " value: " + value + ", parent: " + parent + "}";
        }
    }

    private static int getDepth(BinaryTreeNode node) {
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    // assume that node0 and node1 are not null
    public static BinaryTreeNode getLca(BinaryTreeNode node0,
                                        BinaryTreeNode node1) {
        // get the depths of the two nodes
        // so that we can make node0 and node1 pt to a node with the same depth
        int depth0 = getDepth(node0);
        int depth1 = getDepth(node1);

        if (depth1 > depth0) {
            BinaryTreeNode temp = node0;
            node0 = node1;
            node1 = temp;
        }

        int diff = Math.abs(depth0 - depth1);

        while (diff-- > 0) {
            node0 = node0.parent;
        }

        // at this pt, node0 and node1 pt to a node at the same depth
        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }

        return node0;
    }
}
