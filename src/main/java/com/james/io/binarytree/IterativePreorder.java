package com.james.io.binarytree;

import com.james.io.binarytree.model.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 10.8 of EPI
 *
 * O(n) time
 *
 * O(h) space
 */
public class IterativePreorder {

  public static List<Integer> preorder(BinaryTreeNode root) {
    List<Integer> res = new ArrayList<>();

    Deque<BinaryTreeNode> queue = new LinkedList<>();
    queue.addLast(root);

    while (!queue.isEmpty()) {
      BinaryTreeNode curr = queue.removeFirst();

      if (curr != null) {
        res.add(curr.value);
        queue.addFirst(curr.right);
        queue.addFirst(curr.left);
      }
    }

    return res;
  }
}
