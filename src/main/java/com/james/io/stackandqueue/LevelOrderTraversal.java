package com.james.io.stackandqueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * EPI 9.7 Problem
 */
public class LevelOrderTraversal {

  static class BinaryTreeNode {

    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
      this(val, null, null);
    }

    BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static List<List<Integer>> traverse(BinaryTreeNode root) {
    final List<List<Integer>> res = new ArrayList<>();
    final Deque<BinaryTreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    int size = queue.size();
    BinaryTreeNode curr;
    List<Integer> subList;
    while (!queue.isEmpty()) {
      subList = new ArrayList<>();
      while (size-- > 0) {
        curr = queue.removeFirst();
        subList.add(curr.val);
        if (curr.left != null) {
          queue.addLast(curr.left);
        }
        if (curr.right != null) {
          queue.addLast(curr.right);
        }
      }
      res.add(subList);
      size = queue.size();
    }
    return res;
  }
}
