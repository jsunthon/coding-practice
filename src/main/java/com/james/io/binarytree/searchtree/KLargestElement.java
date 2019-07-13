package com.james.io.binarytree.searchtree;

import com.james.io.binarytree.model.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 10.3 of EPI, custom implementation
 *
 * Time: O(n), n is the number of nodes in the tree Space: O(h), h is the height of the tree
 */
public class KLargestElement {

  public static List<Integer> getKLargestElements(BinaryTreeNode root,
      int k) {
    Deque<Integer> resultStack = new LinkedList<>();
    Deque<BinaryTreeNode> inorderStack = new LinkedList<>();

    while (!inorderStack.isEmpty() || root != null) {
      if (root != null) {
        inorderStack.addFirst(root);
        root = root.left;
      } else {
        BinaryTreeNode curr = inorderStack.removeFirst();
        if (resultStack.size() == k) {
          resultStack.removeFirst();
        }
        resultStack.addLast(curr.value);
        root = curr.right;
      }
    }

    List<Integer> kLargest = new ArrayList<>();

    while (!resultStack.isEmpty()) {
      kLargest.add(resultStack.removeLast());
    }

    return kLargest;
  }

  // O(h + k) time
  public static List<Integer> getKLargestElementsEpi(BinaryTreeNode root,
      int k) {
    List<Integer> kLargest = new ArrayList<>();
    Deque<BinaryTreeNode> stack = new LinkedList<>();

    while ((!stack.isEmpty() || root != null)
        && kLargest.size() < k) {
      if (root != null) {
        stack.addLast(root);
        root = root.right;
      } else {
        BinaryTreeNode curr = stack.removeLast();
        kLargest.add(curr.value);
        root = curr.left;
      }
    }

    return kLargest;
  }

  public static List<Integer> getKLargestElementsEpiRecursive(BinaryTreeNode root,
      int k) {
    List<Integer> kLargest = new ArrayList<>();
    recursiveHelper(root, kLargest, k);

    return kLargest;
  }

  private static void recursiveHelper(BinaryTreeNode root,
      List<Integer> kLargest,
      int k) {
    if (root != null && kLargest.size() < k) {
      recursiveHelper(root.right, kLargest, k);
      if (kLargest.size() < k) {
        kLargest.add(root.value);
      }
      recursiveHelper(root.left, kLargest, k);
    }
  }
}
