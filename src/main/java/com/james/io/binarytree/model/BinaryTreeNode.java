package com.james.io.binarytree.model;

public class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this(value, null, null);
        }

        public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }